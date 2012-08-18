package nju.edu.auctionExp.action.administration;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.opensymphony.xwork2.Action;

import nju.edu.auctionExp.action.BaseAction;
import nju.edu.auctionExp.model.AuctionBid;
import nju.edu.auctionExp.model.AuctionGroup;
import nju.edu.auctionExp.model.ConditionGroup;
import nju.edu.auctionExp.model.Participant;
import nju.edu.auctionExp.service.AuctionBidManager;
import nju.edu.auctionExp.service.AuctionManager;
import nju.edu.auctionExp.service.GroupManager;
import nju.edu.auctionExp.service.ParticipantManager;
import nju.edu.auctionExp.common.algo.StringIDGenerator;
import nju.edu.auctionExp.common.constant.SessionKeys;

public class ConditionsAction extends BaseAction {

	private static final long serialVersionUID = -698723817267288784L;
	
	private String orderObject;
	private String queryParticipantsOrderBy;
	
	private AuctionManager auctionManager;
	private AuctionBidManager auctionBidManager;
	private ParticipantManager participantManager;
	private GroupManager groupManager;
	
	private ConditionGroup conditionGroup;
	private List<ConditionGroup> conditionGroups;
	private int groupNum;                         // The group number user inputs.
	private String grouping;                       // 24 integers indicate each of the condition-group is assigned to which real group.
	private String participants;                   // used when admin to delete the participant's info.
	private Map<String, Integer> labGroup = new HashMap<String, Integer>();
	private Map<String, Integer> singleGroup = new HashMap<String, Integer>();
	private String batchSerial;
	
	private Map<String, List<Participant>> participantMap = new HashMap<String, List<Participant>>();
	private List<Participant> participantList = new ArrayList<Participant>();
	
	public String deleteParticipants(){
		String[] delParticipant = this.participants.split(",");
		String idArray = "(";
		for(int i=0; i<delParticipant.length - 1; i++){
			idArray += "\'" + delParticipant[i] + "\',";
		}
		
		idArray += "\'" + delParticipant[delParticipant.length - 1] + "\')";
		
		String hql = "delete from Participant participant where participant.identifier in " + idArray;
		this.participantManager.deleteByHQL(hql);

		return Action.SUCCESS;
	}
	
	public String getPreviewParticipants(){
		participantList.clear();
		List<Participant> participants = new ArrayList<Participant>();
		
		if(this.queryParticipantsOrderBy == null ){
			participants = this.participantManager.findAll();
			for(Participant participant : participants){
				if(participant.getConditionGroup() == null){
					this.participantList.add(participant);
				}
			}
			for(Participant participant : participants){
				if(participant.getConditionGroup() != null){
					this.participantList.add(participant);
				}
			}
		}else if(this.orderObject.equals("participant")){
			//get all participants
			participants = participantManager.findByHql("from Participant participant order by " + this.queryParticipantsOrderBy, 0, Integer.MAX_VALUE);
			for(Participant participant : participants){
				this.participantList.add(participant);
			}
		}else{
			participants = this.participantManager.findByHql("from Participant participant order by " + this.queryParticipantsOrderBy, 0, Integer.MAX_VALUE);
			for(Participant p : participants){
				this.participantList.add(p);
			}
		}
		return Action.SUCCESS;
	}
	/**
	 * Randomly, and equally assign those participants to a corresponding condition group,
	 * and make the info. persistent by storing them in the database.
	 * @return
	 */
	public String randomizeParticipants(){
		
		participantList = this.participantManager.findAll();
		int participantSum = participantList.size();
		Random rd = new Random();
		ArrayList<Integer> visitedList = new ArrayList<Integer>();
		
		ArrayList<Integer> existList = new ArrayList<Integer>();
		
		getSession().put(SessionKeys.BATCH, this.batchSerial);
		
		int sumVisited = 0;
		for(int count = 0; count < participantList.size(); count++){
			if(participantList.get(count).getConditionGroup() != null){
				existList.add(new Integer(count));
				sumVisited++;
			}
		}
		
		int tmp;
		for(int i=0, j = sumVisited%24; i < participantSum; i++, j=(++j)%24){
			tmp = rd.nextInt(participantSum);
			if(existList.contains(new Integer(i))){
				continue;
			}
			while(visitedList.contains(new Integer(tmp))){
				tmp = rd.nextInt(participantSum);
			}
			visitedList.add(new Integer(tmp));
			String conditionGroupId = this.participantManager.getConditionGroupIdByNum(j);
			ConditionGroup theConditionGroup = this.groupManager.getConditionGroupById(conditionGroupId);
			participantList.get(i).setConditionGroup(theConditionGroup);
			participantList.get(i).setBatch(this.batchSerial);
			this.participantManager.saveParticipant(participantList.get(i));
		}
		setJsonModel(true);
		participantList.clear();
		List<Participant> tmpList = this.participantManager.findAll();
		for(Participant tmp1:tmpList){
			this.participantList.add(tmp1);
		}
		return Action.SUCCESS;
	}
	
	public String getTheParticipants(){
		return this.getPreviewParticipants();
	}
	
	public String getSingleGroups(){
		List<Participant> participantList = this.participantManager.findAll();
		singleGroup.clear();
		singleGroup.put("num", participantList.size());
		
		return Action.SUCCESS;
	}
	

	public String getLabGroups(){
		
		List<Participant> participantList = this.participantManager.findAll();
		
		labGroup.clear();
		
		for(int i=0; i<participantList.size(); i++){
			String key = participantList.get(i).getLabNo();
			if(!labGroup.containsKey(key)){
				labGroup.put(key, 1);
			}else{
				int count = labGroup.get(key);
				count++;
				labGroup.remove(key);
				labGroup.put(key, count);
			}
		}
		return Action.SUCCESS;
	}
	
	public String saveGroup(){
		
		ArrayList<ArrayList<Integer>> groupTable = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i<groupNum; i++){
			ArrayList<Integer> tmp = new ArrayList<Integer>();
			groupTable.add(tmp);
		}
		
		int[] groupings = new int[24];
		
		String[] groups = this.grouping.split(",");
		
		for(int j = 0; j<groups.length; ++j){
			groupings[j] = Integer.parseInt(groups[j]);
		}
		
		for(int i = 0; i < 24; ++i){
			//groupTable[groupings[i]][(groupTable[groupings[i]]).length] = i;
			groupTable.get(groupings[i]-1).add(i);
		}
		
		String[] auctionGroupIds = new String[groupNum];
		
		for(int i = 0; i<groupNum; i++){
			StringBuilder sd = new StringBuilder();
			for(int j = 0; j<groupTable.get(i).size(); j++){
				sd.append(this.participantManager.getConditionGroupIdByNum(groupTable.get(i).get(j)));
				sd.append(',');
			}
			if(sd.length() != 0){
				sd.deleteCharAt(sd.length()-1);
			}
			auctionGroupIds[i] = sd.toString();
		}
		
		deleteAndGenerateAuctionGroups(auctionGroupIds);
		//generateGroups(groupTable);
		
		return Action.SUCCESS;
	}
	
	public void deleteAndGenerateAuctionGroups(String[] auctionGroupIds){
		/*
		 * first check whether the auction_group table is empty or not.
		 * 
		 */
		if(!this.groupManager.isEmpty(7) & !this.groupManager.isEmpty(8) &!this.groupManager.isEmpty(9)){
			this.groupManager.deleteAll(7);
			this.groupManager.deleteAll(8);
			this.groupManager.deleteAll(9);
		}
		
		/*
		 * Create groups for auction round 7, 8, and 9, with the 
		 * generated id by the method getIdentifier.
		 * */
		for(int i = 7; i<=9; i++){
			for(int j = 0; j < groupNum; j++){
				AuctionGroup auctionGroup = new AuctionGroup(
						new Random().nextInt(122344), i, auctionGroupIds[j]);
				auctionGroup.setId(StringIDGenerator.getInstance().generate());
				this.groupManager.saveAuctionGroup(auctionGroup);			
			}
		}
	}
	
	public void deleteAndGenerateAuctionGroups(String[] auctionGroupIds, int round){
		/*
		 * first check whether the auction_group table is empty or not.
		 * 
		 */
		if(!this.groupManager.isEmpty(round)){
			this.groupManager.deleteAll(round);
		}
		
		/*
		 * Create groups for auction round 7, 8, and 9, with the 
		 * generated id by the method getIdentifier.
		 * */
		for(int j = 0; j < groupNum; j++){
				AuctionGroup auctionGroup = new AuctionGroup(
						new Random().nextInt(122344), round, auctionGroupIds[j]);
				auctionGroup.setId(StringIDGenerator.getInstance().generate());
				this.groupManager.saveAuctionGroup(auctionGroup);			
			}

	}
	
//	public void generateGroups(ArrayList<ArrayList<Integer>> groupTable){
//		// the arraylist is transmitted from the client side, with the length of groupNum.
//		
//		for(int i = 0; i < groupNum; ++i){
//			ArrayList<Integer> group = groupTable.get(i);
//			ArrayList<String> realGroup = new ArrayList<String>();
//			for(int j=0; j<group.size(); ++j){
//				realGroup.add(this.participantManager.getConditionGroupIdByNum(group.get(j)));
//			}
//			this.groupMap.put("group-" + (i+1), realGroup);
//		}
//	}
	
	public String findConditionGroups(){
		if(this.auctionManager.isEmptyConditionGroup()){
			this.auctionManager.assignReviewsToConditionGroup();
		}
		conditionGroups =  this.auctionManager.getConditionGroups();
		return Action.SUCCESS;
	}
	
	public String assignGroups(){
		if(groupManager.getAuctionGroupListByAuctionRound(1).size()>0) {
			return Action.SUCCESS;
		}
		//in 1,2,3 round, winner was determined by lab
		participantList = participantManager.findAll();
		Map<String,Object> savedLab = new HashMap<String, Object>();
		for(Participant participant : participantList){
			if(!savedLab.containsKey(participant.getLabNo())){
				for(int i=1;i<=3;i++){
					AuctionGroup group1 = new AuctionGroup((int)(Math.random()*1000+1000), i, participant.getLabNo());
					groupManager.saveAuctionGroup(group1);
					savedLab.put(participant.getLabNo(), null);
				}
			}
		}
		//in 4,5,6 round, winner was determined as whole
		for(int i=4;i<=6;i++){
			AuctionGroup group2 = new AuctionGroup((int)(Math.random()*1000+1000), i, "ALL");
			groupManager.saveAuctionGroup(group2);
		}
		return Action.SUCCESS;
	}
	
	
	public void setAuctionManager(AuctionManager auctionManager) {
		this.auctionManager = auctionManager;
	}
	public AuctionManager getAuctionManager() {
		return auctionManager;
	}
	public void setConditionGroup(ConditionGroup conditionGroup) {
		this.conditionGroup = conditionGroup;
	}
	public ConditionGroup getConditionGroup() {
		return conditionGroup;
	}
	public void setConditionGroups(List<ConditionGroup> conditionGroups) {
		this.conditionGroups = conditionGroups;
	}
	public List<ConditionGroup> getConditionGroups() {
		return conditionGroups;
	}


	public void setGroupNum(int groupNum) {
		this.groupNum = groupNum;
	}


	public int getGroupNum() {
		return groupNum;
	}

	public void setParticipantManager(ParticipantManager participantManager) {
		this.participantManager = participantManager;
	}

	public ParticipantManager getParticipantManager() {
		return participantManager;
	}

	public void setGrouping(String grouping) {
		this.grouping = grouping;
	}

	public String getGrouping() {
		return grouping;
	}

	public void setGroupManager(GroupManager groupManager) {
		this.groupManager = groupManager;
	}

	public GroupManager getGroupManager() {
		return groupManager;
	}


	public void setLabGroup(Map<String, Integer> labGroup) {
		this.labGroup = labGroup;
	}


	public Map<String, Integer> getLabGroup() {
		return labGroup;
	}

	public void setSingleGroup(Map<String, Integer> singleGroup) {
		this.singleGroup = singleGroup;
	}

	public Map<String, Integer> getSingleGroup() {
		return singleGroup;
	}


	public void setParticipantList(List<Participant> participantList) {
		this.participantList = participantList;
	}


	public List<Participant> getParticipantList() {
		return participantList;
	}

	public void setParticipantMap(Map<String, List<Participant>> participantMap) {
		this.participantMap = participantMap;
	}

	public Map<String, List<Participant>> getParticipantMap() {
		return participantMap;
	}
	public void setParticipants(String participants) {
		this.participants = participants;
	}
	public String getParticipants() {
		return participants;
	}

	public void setAuctionBidManager(AuctionBidManager auctionBidManager) {
		this.auctionBidManager = auctionBidManager;
	}

	public AuctionBidManager getAuctionBidManager() {
		return auctionBidManager;
	}

	public void setBatchSerial(String batchSerial) {
		this.batchSerial = batchSerial;
	}

	public String getBatchSerial() {
		return batchSerial;
	}

	public void setOrderObject(String orderObject) {
		this.orderObject = orderObject;
	}

	public String getOrderObject() {
		return orderObject;
	}

	public void setQueryParticipantsOrderBy(String queryParticipantsOrderBy) {
		this.queryParticipantsOrderBy = queryParticipantsOrderBy;
	}

	public String getQueryParticipantsOrderBy() {
		return queryParticipantsOrderBy;
	}

}

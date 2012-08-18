package nju.edu.auctionExp.action.administration;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Action;

import nju.edu.auctionExp.action.BaseAction;
import nju.edu.auctionExp.model.Auction;
import nju.edu.auctionExp.model.AuctionBid;
import nju.edu.auctionExp.model.AuctionGroup;
import nju.edu.auctionExp.model.AuctionStatus;
import nju.edu.auctionExp.model.AuctionType;
import nju.edu.auctionExp.model.ConditionGroup;
import nju.edu.auctionExp.model.Item;
import nju.edu.auctionExp.model.Participant;
import nju.edu.auctionExp.service.AuctionBidManager;
import nju.edu.auctionExp.service.AuctionManager;
import nju.edu.auctionExp.service.GroupManager;
import nju.edu.auctionExp.service.ItemManager;
import nju.edu.auctionExp.service.ParticipantManager;

public class AuctionAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1705749408386120102L;
	private AuctionManager auctionManager;
	private ItemManager itemManager;
	private AuctionBidManager auctionBidManager;
	private ParticipantManager participantManager;
	private GroupManager groupManager;
	private Auction auction;
	private List<Auction> auctionList;
	private List<ConditionGroup> conditionGroupList;
	private String groupedIdentifierList;
	private List<AuctionGroup> auctionGroupList;
	private AuctionType auctionType = AuctionType.SECOND_PRICE;
	private List<AuctionBid> auctionBidList;
	private String queryAuctionBidorderBy;
	
	/**
	 * get auction form
	 * @return
	 */
	public String getAuctionForm(){
		if(auction != null){
			this.setAuction(auctionManager.getAuctionByRound(auction.getRound()));
		}else{
			this.setAuction(auctionManager.getAuctionByRound(1));
		}
		this.setAuctionList(auctionManager.getAuctionList(0, 9));
		return Action.SUCCESS;
	}
	
	/**
	 * save an auction
	 * @return
	 */
	public String saveAuction(){
		Auction auctionInDb = auctionManager.getAuctionByRound(auction.getRound());
		auctionInDb.setShowReviews(auction.getShowReviews());
		auctionManager.saveAuction(auctionInDb);
		Item itemInDb = auctionInDb.getItem();
		itemInDb.setTitle(auction.getItem().getTitle());
		itemInDb.setImageUrl(auction.getItem().getImageUrl());
		itemManager.saveItem(itemInDb);
		this.setJsonModel(auctionInDb);
		return Action.SUCCESS;
	}
	
	/**
	 * manually start a auction
	 * @return
	 */
	public String startAuction(){
		auctionList = auctionManager.getAuctionList(0, Integer.MAX_VALUE);
		for(Auction tmpAuction : auctionList){
			if(tmpAuction.getStatus() == AuctionStatus.STARTED.getValue() && tmpAuction.getRound() != auction.getRound()){
				tmpAuction.setStatus(AuctionStatus.FINISHED);
				auctionManager.saveAuction(tmpAuction);
			}
		}
		auction = auctionManager.getAuctionByRound(auction.getRound());
		auction.setStatus(AuctionStatus.STARTED);
		auctionManager.saveAuction(auction);
		auctionList = auctionManager.getAuctionList(0, Integer.MAX_VALUE);
		this.setJsonModel(auction);
		return Action.SUCCESS;
	}
	
	/**
	 * preview results
	 * @return
	 */
	public String previewResult(){
		if(queryAuctionBidorderBy == null){
			queryAuctionBidorderBy = "participant.identifier";
		}
		if(queryAuctionBidorderBy.equals("bidPrice")){
			//order by price
			List<Participant> participantList = participantManager.findByHql("from Participant", 0, Integer.MAX_VALUE);
			auctionBidList = auctionBidManager.getAuctionBidsByHql("from AuctionBid where auctionRound = " + auction.getRound() + " order by bidPrice DESC", 0, Integer.MAX_VALUE);
			for(Participant participant : participantList){
				boolean exist = false;
				for(AuctionBid auctionBid : auctionBidList){
					if(auctionBid.getParticipant().getIdentifier().equals(participant.getIdentifier())){
						exist = true;
					}
				}
				if(!exist){
					auctionBidList.add(new AuctionBid(null, participant, auction.getRound(), 0));
				}
			}
		}else if(queryAuctionBidorderBy.equals("auctionGroup")){
			auctionBidList = new ArrayList<AuctionBid>();
			List<Participant> participantList = new ArrayList<Participant>();
			this.auctionGroupList = auctionManager.getAuctionGroupListByAuction(auction.getRound());
			for(AuctionGroup auctionGroup : auctionGroupList){
				String hql = "from Participant participant where participant.conditionGroup.id in(";
				for(String id : auctionGroup.getConditionGroupIdArray()){
					hql += "'"+id+"',";
				}
				hql += "'NO_SUCH_IDENTIFIER')";
				List<Participant> tmpParticipantList = participantManager.findByHql(hql, 0, Integer.MAX_VALUE);
				for(Participant participant : tmpParticipantList){
					ConditionGroup tempConditionGroup = participant.getConditionGroup();
					tempConditionGroup.setAuctionGroup(auctionGroup.getGroupSerial());
					participant.setConditionGroup(tempConditionGroup);
				}
				participantList.addAll(tmpParticipantList);
			}
			List<AuctionBid> tmpBidList = auctionBidManager.getAuctionBidsByHql("from AuctionBid where auctionRound = " + auction.getRound(), 0, Integer.MAX_VALUE);
			for(Participant participant : participantList){
				boolean exist = false;
				for(AuctionBid auctionBid : tmpBidList){
					if(auctionBid.getParticipant().getIdentifier().equals(participant.getIdentifier())){
						exist = true;
						auctionBid.setParticipant(participant);
						auctionBidList.add(auctionBid);
					}
				}
				if(!exist){
					auctionBidList.add(new AuctionBid(null, participant, auction.getRound(), 0));
				}
			}
		}else{
			//get all participants
			auctionBidList = new ArrayList<AuctionBid>();
			List<Participant> participantList = participantManager.findByHql("from Participant participant order by " + queryAuctionBidorderBy, 0, Integer.MAX_VALUE);
			List<AuctionBid> tmpBidList = auctionBidManager.getAuctionBidsByHql("from AuctionBid where auctionRound = " + auction.getRound(), 0, Integer.MAX_VALUE);
			for(Participant participant : participantList){
				boolean exist = false;
				for(AuctionBid auctionBid : tmpBidList){
					if(auctionBid.getParticipant().getIdentifier().equals(participant.getIdentifier())){
						exist = true;
						auctionBidList.add(auctionBid);
					}
				}
				if(!exist){
					auctionBidList.add(new AuctionBid(null, participant, auction.getRound(), 0));
				}
			}
		}
		return Action.SUCCESS;
	}
	
	/**
	 * calculate winners by defined groups
	 * @return
	 */
	public String calculateWinners(){
		if(auction == null) {
			return Action.ERROR;
		}
		this.setAuctionList(auctionManager.getAuctionList(0, 9));
		this.auction = auctionManager.getAuctionByRound(auction.getRound());
		this.auctionGroupList = auctionManager.getAuctionGroupListByAuction(auction.getRound());
		for(AuctionGroup auctionGroup : auctionGroupList){
			auctionManager.calculateWinners(auctionGroup, auctionType);
		}
		return Action.SUCCESS;
	}
	
	public String stopAuction(){
		if(auction == null) {
			return Action.ERROR;
		}
		//determin winners
		calculateWinners();
		
		auction = auctionManager.getAuctionByRound(auction.getRound());
		auction.setStatus(AuctionStatus.FINISHED);
		auctionManager.saveAuction(auction);
		auctionList = auctionManager.getAuctionList(0, Integer.MAX_VALUE);
		this.setJsonModel(auction);
		return Action.SUCCESS;
	}
	
	/**
	 * get final price, to determine win or lose
	 * @param round
	 * @param idenfifier
	 * @return
	 */
	public float getFinalPrice(int round, String labNo, String conditionGroupId){
		Participant participant = new Participant();
		participant.setLabNo(labNo);
		participant.setConditionGroup(new ConditionGroup(conditionGroupId));
		return groupManager.getAuctionGroupPrice(round, participant);
	}

	public Auction getAuction() {
		return auction;
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
	}

	public List<ConditionGroup> getConditionGroupList() {
		return conditionGroupList;
	}

	public void setConditionGroupList(List<ConditionGroup> conditionGroupList) {
		this.conditionGroupList = conditionGroupList;
	}

	public void setAuctionManager(AuctionManager auctionManager) {
		this.auctionManager = auctionManager;
	}

	public AuctionManager getAuctionManager() {
		return auctionManager;
	}

	public void setAuctionList(List<Auction> auctionList) {
		this.auctionList = auctionList;
	}

	public List<Auction> getAuctionList() {
		return auctionList;
	}
	public ItemManager getItemManager() {
		return itemManager;
	}

	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}

	public void setGroupedIdentifierList(String groupedIdentifierList) {
		this.groupedIdentifierList = groupedIdentifierList;
	}

	public String getGroupedIdentifierList() {
		return groupedIdentifierList;
	}

	public void setAuctionGroupList(List<AuctionGroup> auctionGroupList) {
		this.auctionGroupList = auctionGroupList;
	}

	public List<AuctionGroup> getAuctionGroupList() {
		return auctionGroupList;
	}

	public void setAuctionType(AuctionType auctionType) {
		this.auctionType = auctionType;
	}

	public AuctionType getAuctionType() {
		return auctionType;
	}

	public void setAuctionBidManager(AuctionBidManager auctionBidManager) {
		this.auctionBidManager = auctionBidManager;
	}

	public AuctionBidManager getAuctionBidManager() {
		return auctionBidManager;
	}

	public void setAuctionBidList(List<AuctionBid> auctionBidList) {
		this.auctionBidList = auctionBidList;
	}

	public List<AuctionBid> getAuctionBidList() {
		return auctionBidList;
	}

	public void setQueryAuctionBidorderBy(String queryAuctionBidorderBy) {
		this.queryAuctionBidorderBy = queryAuctionBidorderBy;
	}

	public String getQueryAuctionBidorderBy() {
		return queryAuctionBidorderBy;
	}

	public void setParticipantManager(ParticipantManager participantManager) {
		this.participantManager = participantManager;
	}

	public ParticipantManager getParticipantManager() {
		return participantManager;
	}

	public void setGroupManager(GroupManager groupManager) {
		this.groupManager = groupManager;
	}

	public GroupManager getGroupManager() {
		return groupManager;
	}
	
}
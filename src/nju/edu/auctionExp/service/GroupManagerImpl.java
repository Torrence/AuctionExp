package nju.edu.auctionExp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nju.edu.auctionExp.dao.AuctionGroupDAO;
import nju.edu.auctionExp.dao.ConditionGroupDAO;
import nju.edu.auctionExp.dao.ConditiongroupReviewDAO;
import nju.edu.auctionExp.dao.ReviewDAO;
import nju.edu.auctionExp.model.AuctionGroup;
import nju.edu.auctionExp.model.ConditionGroup;
import nju.edu.auctionExp.model.ConditiongroupReview;
import nju.edu.auctionExp.model.Participant;
import nju.edu.auctionExp.model.Review;

public class GroupManagerImpl implements GroupManager {

	private AuctionGroupDAO auctionGroupDAO;
	private ConditionGroupDAO conditionGroupDAO;
	private ReviewDAO reviewDAO;
	private ConditiongroupReviewDAO conditiongroupReviewDAO;
	private static Map<Integer, List<AuctionGroup>> auctionGroupListMap = new HashMap<Integer, List<AuctionGroup>>();
	
	@Override
	public void saveAuctionGroup(AuctionGroup auctionGroup) {
		this.auctionGroupDAO.save(auctionGroup);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AuctionGroup> getAuctionGroupListByAuctionRound(int auctionRound) {
		return this.auctionGroupDAO.findByProperty("auctionRound", auctionRound);
	}

	@Override
	public boolean isEmpty(int auctionRound) {
		return this.auctionGroupDAO.findByProperty("auctionRound", auctionRound).isEmpty();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteAll(int auctionRound) {
		//this.auctionGroupDAO.findByHQL("delete AuctionGroup auctionGroup", 0, Integer.MAX_VALUE);
		List<AuctionGroup> auctionGroupList = this.auctionGroupDAO.findByProperty("auctionRound", auctionRound);
		for(int i=0; i<auctionGroupList.size(); i++){
			this.auctionGroupDAO.delete(auctionGroupList.get(i));
		}
	}

	@Override
	public ConditionGroup getConditionGroupById(String conditionGorupId) {
		return this.conditionGroupDAO.findById(conditionGorupId);
		
	}
	
	@Override
	public List<Review> getReviewsByConditionGroupId(ConditionGroup conditionGroup){
		List<Review> reviews = new ArrayList<Review>();
		
		@SuppressWarnings("unchecked")
		List<ConditiongroupReview> relations = 
			this.conditiongroupReviewDAO.findByProperty(
					"conditionGroupId", conditionGroup.getId());
		
		String hql = "from Review where id in (";
		for(ConditiongroupReview relation : relations){
			hql += "'"+relation.getReviewId()+"',";
		}
		hql += "'NO_SUCH_ID')";
		reviews = this.reviewDAO.findByHQL(hql, 0, Integer.MAX_VALUE);
		
		Review tmp = new Review();
		int position = 0;
		tmp = reviews.get(0);
		if(conditionGroup.getDistinctReviewOrder()==1){
			//top
			position = 0;
		}else if(conditionGroup.getDistinctReviewOrder()==2){
			//middle
			position = conditionGroup.getReviewCount() / 2;
		}else{
			position = conditionGroup.getReviewCount() - 1;
		}
		
		if(conditionGroup.getAverageRating() < 3){
			// find the distinct review with the largest average rating, and if
			// multiple ones exist, the first one is viewed as the result.
			for(Review review:reviews){
				if(review.getRating() > tmp.getRating()){
					tmp = review;
				}
			}
			
			reviews.remove(tmp);
			reviews.add(position, tmp);
		}else{
			// the average rating is no less than 3, and the review with the smallest 
			// rating will be found.
			
			for(Review review:reviews){
				if(review.getRating() < tmp.getRating()){
					tmp = review;
				}
			}
			
			reviews.remove(tmp);
			reviews.add(position, tmp);
		}
		return reviews;
	}
	
	

	@SuppressWarnings("unchecked")
	@Override
	public float getAuctionGroupPrice(int round, Participant participant) {
		if(participant == null){
			//hard code, if participant equals null, reset cache
			auctionGroupListMap.remove(round);
			return 0f;
		}
		List<AuctionGroup> auctionGroupList = null;
		if(auctionGroupListMap.containsKey(round)){
			auctionGroupList = auctionGroupListMap.get(round);
		}else{
			auctionGroupList = auctionGroupDAO.findByProperty("auctionRound", round);
			auctionGroupListMap.put(round, auctionGroupList);
		}
		if(round>0 && round<3){
			for(AuctionGroup auctionGroup : auctionGroupList){
				if(auctionGroup.getConditionGroupIds().equals(participant.getLabNo())){
					return auctionGroup.getGroupPrice();
				}
			}
		}else if(round<7){
			return auctionGroupList.get(0).getGroupPrice();
		}else{
			for(AuctionGroup auctionGroup : auctionGroupList){
				String[] conditionGroupIds = auctionGroup.getConditionGroupIdArray();
				for(String conditionGroupId : conditionGroupIds){
					if(conditionGroupId != null && conditionGroupId.equals(participant.getConditionGroup().getId())){
						return auctionGroup.getGroupPrice();
					}
				}
			}
		}
		return 0.0f;
	}

	public ReviewDAO getReviewDAO() {
		return reviewDAO;
	}

	public void setReviewDAO(ReviewDAO reviewDAO) {
		this.reviewDAO = reviewDAO;
	}

	public ConditiongroupReviewDAO getConditiongroupReviewDAO() {
		return conditiongroupReviewDAO;
	}

	public void setConditiongroupReviewDAO(
			ConditiongroupReviewDAO conditiongroupReviewDAO) {
		this.conditiongroupReviewDAO = conditiongroupReviewDAO;
	}

	public void setAuctionGroupDAO(AuctionGroupDAO auctionGroupDAO) {
		this.auctionGroupDAO = auctionGroupDAO;
	}

	public AuctionGroupDAO getAuctionGroupDAO() {
		return auctionGroupDAO;
	}
	

	public void setConditionGroupDAO(ConditionGroupDAO conditionGroupDAO) {
		this.conditionGroupDAO = conditionGroupDAO;
	}

	public ConditionGroupDAO getConditionGroupDAO() {
		return conditionGroupDAO;
	}

	@Override
	public List findByHql(String hql) {
		return this.conditionGroupDAO.findByHQL(hql, 0, Integer.MAX_VALUE);
	}

}

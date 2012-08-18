package nju.edu.auctionExp.service;

import java.util.List;

import nju.edu.auctionExp.model.AuctionGroup;
import nju.edu.auctionExp.model.ConditionGroup;
import nju.edu.auctionExp.model.Participant;
import nju.edu.auctionExp.model.Review;

public interface GroupManager {
	public void saveAuctionGroup(AuctionGroup auctionGroup);
	
	public List<AuctionGroup> getAuctionGroupListByAuctionRound(int auctionRound);
	
	public boolean isEmpty(int auctionRound);
	
	public void deleteAll(int auctionRound);
	
	public ConditionGroup getConditionGroupById(String conditionGorupId);
	
	/**
	 * get reviews by given condition-group
	 * @param conditionGroupId
	 * @return
	 */
	public List<Review> getReviewsByConditionGroupId(ConditionGroup conditionGroup);
	
	/**
	 * @param round
	 * @param identifier
	 * @return
	 */
	public float getAuctionGroupPrice(int round, Participant participant);
	
	public List findByHql(String hql);
}
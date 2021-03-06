package nju.edu.auctionExp.service;

import java.util.List;

import nju.edu.auctionExp.model.Auction;
import nju.edu.auctionExp.model.AuctionGroup;
import nju.edu.auctionExp.model.AuctionType;
import nju.edu.auctionExp.model.ConditionGroup;

public interface AuctionManager {

	/**
	 * create/update an auction and specify the corresponding item.
	 * @param round
	 * @param title
	 * @param imageUrl
	 * @param showReview
	 */
	public void saveAuction(Auction auction);
	
	
	
	public Auction getAuctionByRound(int round);
	
	/**
	 * get next round auction
	 * get the only auction with status of "started"
	 * @return
	 */
	public Auction getCurrentAuction();
	
	public void delAuction(Auction auction);
	
	/**
	 * @param firstResult
	 * @param maxResults
	 * @return
	 */
	public List<Auction> getAuctionList(int firstResult, int maxResults);
	
	/**
	 * 
	 */
	public void assignReviewsToConditionGroup();
	
	/**
	 * @return
	 */
	public List<ConditionGroup> getConditionGroups();
	
	/**
	 * @return
	 */
	public boolean isEmptyConditionGroup();
	
	/**
	 * 根据auction取得分组信息
	 * @return
	 */
	public List<AuctionGroup> getAuctionGroupListByAuction(int round);
	
	public void calculateWinners(AuctionGroup auctionGroup, AuctionType auctionType);
	
}

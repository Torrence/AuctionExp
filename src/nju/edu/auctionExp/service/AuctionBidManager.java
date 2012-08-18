package nju.edu.auctionExp.service;

import java.util.List;

import nju.edu.auctionExp.model.AuctionBid;

public interface AuctionBidManager {
	
	/**
	 * 
	 * @param bid
	 */
	public void placeBid(AuctionBid bid);
	
	/**
	 * 
	 * @param participantId
	 * @return: all the auction bids the participant has submited.
	 */
	public List<AuctionBid> getHistoryBids(String participantId);
	
	/**
	 * @param auctionRound
	 * @return all bids in given round
	 */
	public List<AuctionBid> getAuctionBids(int auctionRound, String orderBy);
	
	public AuctionBid getAuctionBidById(String id);
	
	/**
	 * @param auctionRound
	 * @return
	 */
	public List<AuctionBid> getAuctionBidsByHql(String hql, int firstResult, int maxResults);

}

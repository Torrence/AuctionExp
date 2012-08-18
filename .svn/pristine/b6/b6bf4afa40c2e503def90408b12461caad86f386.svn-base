package nju.edu.auctionExp.service;

import java.util.ArrayList;
import java.util.List;

import nju.edu.auctionExp.dao.AuctionBidDAO;
import nju.edu.auctionExp.model.AuctionBid;

public class AuctionBidManagerImpl implements AuctionBidManager {

	private AuctionBidDAO auctionBidDAO;
	

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<AuctionBid> getHistoryBids(String participantId) {
		return (ArrayList<AuctionBid>) this.auctionBidDAO.findByProperty("participant.identifier", participantId);
	}
	
	@Override
	public List<AuctionBid> getAuctionBids(int auctionRound, String orderBy){
		return auctionBidDAO.findByHQL("from AuctionBid where auctionRound = " + auctionRound + " order by " + orderBy, 0, Integer.MAX_VALUE);
	}

	@Override
	public AuctionBid getAuctionBidById(String id) {
		return this.auctionBidDAO.findById(id);
	}

	@Override
	public List<AuctionBid> getAuctionBidsByHql(String hql, int firstResult, int maxResults) {
		return auctionBidDAO.findByHQL(hql, firstResult, maxResults);
	}

	public void placeBid(AuctionBid bid) {
		this.auctionBidDAO.save(bid);
	}

	public void setAuctionBidDAO(AuctionBidDAO auctionBidDAO) {
		this.auctionBidDAO = auctionBidDAO;
	}

	public AuctionBidDAO getAuctionBidDAO() {
		return auctionBidDAO;
	}


}

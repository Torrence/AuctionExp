package nju.edu.auctionExp.model;

import java.util.List;

import nju.edu.auctionExp.common.algo.StringIDGenerator;

/**
 * AuctionGroup entity. @author MyEclipse Persistence Tools
 */

public class AuctionGroup implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8321756498489079291L;
	private String id;
	private int groupSerial;
	private int auctionRound;
	private String conditionGroupIds;
	private float groupPrice;
	private List<AuctionBid> winnerBids;
	private List<ConditionGroup> conditionGroupList;
	private int totalBids;

	// Constructors

	/** default constructor */
	public AuctionGroup() {
	}

	/** minimal constructor */
	public AuctionGroup(int groupSerial, int auctionRound, String conditionGroupIds) {
		this.id = StringIDGenerator.getInstance().generate();
		this.setGroupSerial(groupSerial);
		this.auctionRound = auctionRound;
		this.setConditionGroupIds(conditionGroupIds);
	}

	public int getAuctionRound() {
		return this.auctionRound;
	}

	public void setAuctionRound(int auctionRound) {
		this.auctionRound = auctionRound;
	}

	public float getGroupPrice() {
		return this.groupPrice;
	}

	public void setGroupPrice(float groupPrice) {
		this.groupPrice = groupPrice;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setGroupSerial(int groupSerial) {
		this.groupSerial = groupSerial;
	}

	public int getGroupSerial() {
		return groupSerial;
	}

	public void setConditionGroupIds(String conditionGroupIds) {
		this.conditionGroupIds = conditionGroupIds;
	}

	public String getConditionGroupIds() {
		return conditionGroupIds;
	}
	
	public String[] getConditionGroupIdArray(){
		return this.conditionGroupIds == null ? null : this.conditionGroupIds.split(",");
	}

	public void setConditionGroupList(List<ConditionGroup> conditionGroupList) {
		this.conditionGroupList = conditionGroupList;
	}

	public List<ConditionGroup> getConditionGroupList() {
		return conditionGroupList;
	}

	public void setWinnerBids(List<AuctionBid> winnerBids) {
		this.winnerBids = winnerBids;
	}

	public List<AuctionBid> getWinnerBids() {
		return winnerBids;
	}

	public void setTotalBids(int totalBids) {
		this.totalBids = totalBids;
	}

	public int getTotalBids() {
		return totalBids;
	}

}
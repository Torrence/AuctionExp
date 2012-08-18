package nju.edu.auctionExp.model;

import java.util.List;

/**
 * ConditionGroup entity. @author MyEclipse Persistence Tools
 */

public class ConditionGroup implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String overview;
	private int distinctReviewOrder;
	private float averageRating;
	private int reviewCount;
	
	private List<Participant> participantList;
	private List<Review> reviewList;
	
	private int auctionGroup;

	// Constructors

	/** default constructor */
	public ConditionGroup() {
	}
	
	public ConditionGroup(String id) {
		this.id = id;
	}

	/** minimal constructor */
	public ConditionGroup(String id, int distinctReviewOrder) {
		this.id = id;
		this.distinctReviewOrder = distinctReviewOrder;
	}

	/** full constructor */
	public ConditionGroup(String id, String overview,
			int distinctReviewOrder, float averageRating,
			int reviewCount) {
		this.id = id;
		this.overview = overview;
		this.distinctReviewOrder = distinctReviewOrder;
		this.averageRating = averageRating;
		this.reviewCount = reviewCount;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOverview() {
		return this.overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public int getDistinctReviewOrder() {
		return this.distinctReviewOrder;
	}

	public void setDistinctReviewOrder(int distinctReviewOrder) {
		this.distinctReviewOrder = distinctReviewOrder;
	}

	public float getAverageRating() {
		return this.averageRating;
	}

	public void setAverageRating(float averageRating) {
		this.averageRating = averageRating;
	}

	public int getReviewCount() {
		return this.reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public void setParticipantList(List<Participant> participantList) {
		this.participantList = participantList;
	}

	public List<Participant> getParticipantList() {
		return participantList;
	}

	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}

	public List<Review> getReviewList() {
		return reviewList;
	}

	public void setAuctionGroup(int auctionGroup) {
		this.auctionGroup = auctionGroup;
	}

	public int getAuctionGroup() {
		return auctionGroup;
	}


}
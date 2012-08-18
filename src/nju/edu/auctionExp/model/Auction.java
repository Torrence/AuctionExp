package nju.edu.auctionExp.model;

/**
 * Auction entity. @author MyEclipse Persistence Tools
 */

public class Auction implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -2773139046068811527L;
	private int round;
	private Item item;
	private boolean showReviews;
	private AuctionStatus status;

	// Constructors

	/** default constructor */
	public Auction() {
	}

	/** minimal constructor */
	public Auction(int round) {
		this.round = round;
	}

	/** full constructor */
	public Auction(int round, boolean showReviews) {
		this.round = round;
		this.showReviews = showReviews;
	}

	// Property accessors

	public int getRound() {
		return this.round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public boolean getShowReviews() {
		return this.showReviews;
	}

	public void setShowReviews(boolean showReviews) {
		this.showReviews = showReviews;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return item;
	}
	
	public void setStatus(AuctionStatus status) {
		this.status = status;
	}

	public void setStatus(int status) {
		this.status = AuctionStatus.getValue(status);
	}

	public int getStatus() {
		return status.getValue();
	}

}
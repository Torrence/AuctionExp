package nju.edu.auctionExp.model;

import java.sql.Timestamp;

/**
 * ParticipantAction entity. @author MyEclipse Persistence Tools
 */

public class ParticipantAction implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8652789491798564382L;
	private String identifier;
	private Timestamp signInTime;
	private Timestamp bid1StartTime;
	private Timestamp bid1Time;
	private Timestamp bid2StartTime;
	private Timestamp bid2Time;
	private Timestamp bid3StartTime;
	private Timestamp bid3Time;
	private Timestamp bid4StartTime;
	private Timestamp bid4Time;
	private Timestamp bid5StartTime;
	private Timestamp bid5Time;
	private Timestamp bid6StartTime;
	private Timestamp bid6Time;
	private Timestamp bid7StartTime;
	private Timestamp bid7Time;
	private Timestamp bid8StartTime;
	private Timestamp bid8Time;
	private Timestamp bid9StartTime;
	private Timestamp bid9Time;
	private Timestamp review1StartTime;
	private Timestamp review2StartTime;
	private Timestamp review3StartTime;
	private Timestamp review4StartTime;
	private Timestamp review5StartTime;
	private Timestamp review6StartTime;
	private Timestamp review7StartTime;
	private Timestamp review8StartTime;
	private Timestamp review9StartTime;
	private Timestamp review10StartTime;
	private Timestamp review11StartTime;
	private Timestamp review12StartTime;
	private Timestamp review13StartTime;
	private Timestamp review14StartTime;
	private Timestamp reviewFinishTime;

	// Constructors

	/** default constructor */
	public ParticipantAction() {
	}

	/** minimal constructor */
	public ParticipantAction(String identifier) {
		this.identifier = identifier;
	}

	/** full constructor */
	public ParticipantAction(String identifier, Timestamp signInTime,
			Timestamp bid1StartTime, Timestamp bid1Time,
			Timestamp bid2StartTime, Timestamp bid2Time,
			Timestamp bid3StartTime, Timestamp bid3Time,
			Timestamp bid4StartTime, Timestamp bid4Time,
			Timestamp bid5StartTime, Timestamp bid5Time,
			Timestamp bid6StartTime, Timestamp bid6Time,
			Timestamp bid7StartTime, Timestamp bid7Time,
			Timestamp bid8StartTime, Timestamp bid8Time,
			Timestamp bid9StartTime, Timestamp bid9Time,
			Timestamp review1StartTime, Timestamp review2StartTime,
			Timestamp review3StartTime, Timestamp review4StartTime,
			Timestamp review5StartTime, Timestamp review6StartTime,
			Timestamp review7StartTime, Timestamp review8StartTime,
			Timestamp review9StartTime, Timestamp review10StartTime,
			Timestamp review11StartTime, Timestamp review12StartTime,
			Timestamp review13StartTime, Timestamp review14StartTime,
			Timestamp reviewFinishTime) {
		this.identifier = identifier;
		this.signInTime = signInTime;
		this.bid1StartTime = bid1StartTime;
		this.bid1Time = bid1Time;
		this.bid2StartTime = bid2StartTime;
		this.bid2Time = bid2Time;
		this.bid3StartTime = bid3StartTime;
		this.bid3Time = bid3Time;
		this.bid4StartTime = bid4StartTime;
		this.bid4Time = bid4Time;
		this.bid5StartTime = bid5StartTime;
		this.bid5Time = bid5Time;
		this.bid6StartTime = bid6StartTime;
		this.bid6Time = bid6Time;
		this.bid7StartTime = bid7StartTime;
		this.bid7Time = bid7Time;
		this.bid8StartTime = bid8StartTime;
		this.bid8Time = bid8Time;
		this.bid9StartTime = bid9StartTime;
		this.bid9Time = bid9Time;
		this.review1StartTime = review1StartTime;
		this.review2StartTime = review2StartTime;
		this.review3StartTime = review3StartTime;
		this.review4StartTime = review4StartTime;
		this.review5StartTime = review5StartTime;
		this.review6StartTime = review6StartTime;
		this.review7StartTime = review7StartTime;
		this.review8StartTime = review8StartTime;
		this.review9StartTime = review9StartTime;
		this.review10StartTime = review10StartTime;
		this.review11StartTime = review11StartTime;
		this.review12StartTime = review12StartTime;
		this.review13StartTime = review13StartTime;
		this.review14StartTime = review14StartTime;
		this.reviewFinishTime = reviewFinishTime;
	}

	// Property accessors

	public String getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public Timestamp getSignInTime() {
		return this.signInTime;
	}

	public void setSignInTime(Timestamp signInTime) {
		this.signInTime = signInTime;
	}

	public Timestamp getBid1StartTime() {
		return this.bid1StartTime;
	}

	public void setBid1StartTime(Timestamp bid1StartTime) {
		this.bid1StartTime = bid1StartTime;
	}

	public Timestamp getBid1Time() {
		return this.bid1Time;
	}

	public void setBid1Time(Timestamp bid1Time) {
		this.bid1Time = bid1Time;
	}

	public Timestamp getBid2StartTime() {
		return this.bid2StartTime;
	}

	public void setBid2StartTime(Timestamp bid2StartTime) {
		this.bid2StartTime = bid2StartTime;
	}

	public Timestamp getBid2Time() {
		return this.bid2Time;
	}

	public void setBid2Time(Timestamp bid2Time) {
		this.bid2Time = bid2Time;
	}

	public Timestamp getBid3StartTime() {
		return this.bid3StartTime;
	}

	public void setBid3StartTime(Timestamp bid3StartTime) {
		this.bid3StartTime = bid3StartTime;
	}

	public Timestamp getBid3Time() {
		return this.bid3Time;
	}

	public void setBid3Time(Timestamp bid3Time) {
		this.bid3Time = bid3Time;
	}

	public Timestamp getBid4StartTime() {
		return this.bid4StartTime;
	}

	public void setBid4StartTime(Timestamp bid4StartTime) {
		this.bid4StartTime = bid4StartTime;
	}

	public Timestamp getBid4Time() {
		return this.bid4Time;
	}

	public void setBid4Time(Timestamp bid4Time) {
		this.bid4Time = bid4Time;
	}

	public Timestamp getBid5StartTime() {
		return this.bid5StartTime;
	}

	public void setBid5StartTime(Timestamp bid5StartTime) {
		this.bid5StartTime = bid5StartTime;
	}

	public Timestamp getBid5Time() {
		return this.bid5Time;
	}

	public void setBid5Time(Timestamp bid5Time) {
		this.bid5Time = bid5Time;
	}

	public Timestamp getBid6StartTime() {
		return this.bid6StartTime;
	}

	public void setBid6StartTime(Timestamp bid6StartTime) {
		this.bid6StartTime = bid6StartTime;
	}

	public Timestamp getBid6Time() {
		return this.bid6Time;
	}

	public void setBid6Time(Timestamp bid6Time) {
		this.bid6Time = bid6Time;
	}

	public Timestamp getBid7StartTime() {
		return this.bid7StartTime;
	}

	public void setBid7StartTime(Timestamp bid7StartTime) {
		this.bid7StartTime = bid7StartTime;
	}

	public Timestamp getBid7Time() {
		return this.bid7Time;
	}

	public void setBid7Time(Timestamp bid7Time) {
		this.bid7Time = bid7Time;
	}

	public Timestamp getBid8StartTime() {
		return this.bid8StartTime;
	}

	public void setBid8StartTime(Timestamp bid8StartTime) {
		this.bid8StartTime = bid8StartTime;
	}

	public Timestamp getBid8Time() {
		return this.bid8Time;
	}

	public void setBid8Time(Timestamp bid8Time) {
		this.bid8Time = bid8Time;
	}

	public Timestamp getBid9StartTime() {
		return this.bid9StartTime;
	}

	public void setBid9StartTime(Timestamp bid9StartTime) {
		this.bid9StartTime = bid9StartTime;
	}

	public Timestamp getBid9Time() {
		return this.bid9Time;
	}

	public void setBid9Time(Timestamp bid9Time) {
		this.bid9Time = bid9Time;
	}

	public Timestamp getReview1StartTime() {
		return this.review1StartTime;
	}

	public void setReview1StartTime(Timestamp review1StartTime) {
		this.review1StartTime = review1StartTime;
	}

	public Timestamp getReview2StartTime() {
		return this.review2StartTime;
	}

	public void setReview2StartTime(Timestamp review2StartTime) {
		this.review2StartTime = review2StartTime;
	}

	public Timestamp getReview3StartTime() {
		return this.review3StartTime;
	}

	public void setReview3StartTime(Timestamp review3StartTime) {
		this.review3StartTime = review3StartTime;
	}

	public Timestamp getReview4StartTime() {
		return this.review4StartTime;
	}

	public void setReview4StartTime(Timestamp review4StartTime) {
		this.review4StartTime = review4StartTime;
	}

	public Timestamp getReview5StartTime() {
		return this.review5StartTime;
	}

	public void setReview5StartTime(Timestamp review5StartTime) {
		this.review5StartTime = review5StartTime;
	}

	public Timestamp getReview6StartTime() {
		return this.review6StartTime;
	}

	public void setReview6StartTime(Timestamp review6StartTime) {
		this.review6StartTime = review6StartTime;
	}

	public Timestamp getReview7StartTime() {
		return this.review7StartTime;
	}

	public void setReview7StartTime(Timestamp review7StartTime) {
		this.review7StartTime = review7StartTime;
	}

	public Timestamp getReview8StartTime() {
		return this.review8StartTime;
	}

	public void setReview8StartTime(Timestamp review8StartTime) {
		this.review8StartTime = review8StartTime;
	}

	public Timestamp getReview9StartTime() {
		return this.review9StartTime;
	}

	public void setReview9StartTime(Timestamp review9StartTime) {
		this.review9StartTime = review9StartTime;
	}

	public Timestamp getReview10StartTime() {
		return this.review10StartTime;
	}

	public void setReview10StartTime(Timestamp review10StartTime) {
		this.review10StartTime = review10StartTime;
	}

	public Timestamp getReview11StartTime() {
		return this.review11StartTime;
	}

	public void setReview11StartTime(Timestamp review11StartTime) {
		this.review11StartTime = review11StartTime;
	}

	public Timestamp getReview12StartTime() {
		return this.review12StartTime;
	}

	public void setReview12StartTime(Timestamp review12StartTime) {
		this.review12StartTime = review12StartTime;
	}

	public Timestamp getReview13StartTime() {
		return this.review13StartTime;
	}

	public void setReview13StartTime(Timestamp review13StartTime) {
		this.review13StartTime = review13StartTime;
	}

	public Timestamp getReview14StartTime() {
		return this.review14StartTime;
	}

	public void setReview14StartTime(Timestamp review14StartTime) {
		this.review14StartTime = review14StartTime;
	}

	public Timestamp getReviewFinishTime() {
		return this.reviewFinishTime;
	}

	public void setReviewFinishTime(Timestamp reviewFinishTime) {
		this.reviewFinishTime = reviewFinishTime;
	}

}
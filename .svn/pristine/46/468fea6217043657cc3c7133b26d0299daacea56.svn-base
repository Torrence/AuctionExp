package nju.edu.auctionExp.model;

public enum AuctionStatus {
	READY,
	STARTED,
	FINISHED;
	
	public int getValue(){
		if(this == AuctionStatus.READY) return 0;
		if(this == AuctionStatus.STARTED) return 1;
		if(this == AuctionStatus.FINISHED) return 2;
		return 0;
	}
	
	public static AuctionStatus getValue(int status){
		if(status == 0) return AuctionStatus.READY;
		if(status == 1) return AuctionStatus.STARTED;
		if(status == 2) return AuctionStatus.FINISHED;
		return AuctionStatus.READY;
	}
}

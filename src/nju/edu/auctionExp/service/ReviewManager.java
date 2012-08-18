package nju.edu.auctionExp.service;

import java.util.List;

import nju.edu.auctionExp.model.Review;

public interface ReviewManager {
	
	public boolean isEmpty();
	
	public List<Review> findAllReviews();
	
	public void saveReview(Review review);
	
	public Review getReviewById(String reviewId);
	
	public void generateEmptyReview();

}

package nju.edu.auctionExp.service;

import java.util.List;

import nju.edu.auctionExp.dao.ReviewDAO;
import nju.edu.auctionExp.model.Review;

public class ReviewManagerImpl implements ReviewManager {

	private ReviewDAO reviewDAO;
	
	public void saveReview(Review review) {
		this.reviewDAO.save(review);
	}

	public Review getReviewById(String reviewId) {
		return this.reviewDAO.findById(reviewId);
	}

	public void setReviewDAO(ReviewDAO reviewDAO) {
		this.reviewDAO = reviewDAO;
	}

	public ReviewDAO getReviewDAO() {
		return reviewDAO;
	}

	@Override
	public void generateEmptyReview() {
		for(int i = 0; i < 6; ++i){
			StringBuilder builder= new StringBuilder();
			builder.append("062");
			builder.append(i);
			String id = builder.toString();
			this.reviewDAO.save(new Review(id));
		}
		
		for(int i = 0; i < 6; ++i){
			StringBuilder builder= new StringBuilder();
			builder.append("064");
			builder.append(i);
			String id = builder.toString();
			this.reviewDAO.save(new Review(id));
		}
		
		for(int i = 0; i < 14; ++i){
			StringBuilder builder= new StringBuilder();
			builder.append("142");
			builder.append(i);
			String id = builder.toString();
			this.reviewDAO.save(new Review(id));
		}
		
		for(int i = 0; i < 14; ++i){
			StringBuilder builder= new StringBuilder();
			builder.append("144");
			builder.append(i);
			String id = builder.toString();
			this.reviewDAO.save(new Review(id));
		}
		
	}

	@Override
	public boolean isEmpty() {
		return this.reviewDAO.findAll().size()==0;
	}

	@Override
	public List<Review> findAllReviews() {
		return this.reviewDAO.findAll();
	}

}

package nju.edu.auctionExp.action.administration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.Action;

import nju.edu.auctionExp.action.BaseAction;
import nju.edu.auctionExp.model.Review;
import nju.edu.auctionExp.service.ReviewManager;

public class ReviewAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -631844588633961320L;
	private ReviewManager reviewManager;
	private Map<String, List<Review>> groupedReview;
	private Review review;
	
	/**
	 * get review form
	 * @return
	 */
	public String getReviewForm(){
				
		if(this.reviewManager.isEmpty()){
			this.reviewManager.generateEmptyReview();
		}
		
		groupedReview = new HashMap<String, List<Review>>();
		List<Review> reviewList062 = new ArrayList<Review>();
		List<Review> reviewList064 = new ArrayList<Review>();
		List<Review> reviewList142 = new ArrayList<Review>();
		List<Review> reviewList144 = new ArrayList<Review>();
		List<Review> allReview = this.reviewManager.findAllReviews();
		
		
		Review tmpReview;
		for(int i = 0; i < 40; ++i){
			tmpReview = allReview.get(i);
			
			String id = tmpReview.getId();
			if(id.startsWith("062")){
				reviewList062.add(tmpReview);
			}else if(id.startsWith("064")){
				reviewList064.add(tmpReview);
			}else if(id.startsWith("142")){
				reviewList142.add(tmpReview);
			}else{
				reviewList144.add(tmpReview);
			}
		}
		groupedReview.put("062", reviewList062);
		groupedReview.put("064", reviewList064);
		groupedReview.put("142", reviewList142);
		groupedReview.put("144", reviewList144);
		
		return Action.SUCCESS;
	}
	
	/**
	 * researcher set up reviews
	 * @return
	 */
	public String saveReview(){
		reviewManager.saveReview(review);
		this.setJsonModel(review);
		return Action.SUCCESS;
	}

	public void setReviewManager(ReviewManager reviewManager) {
		this.reviewManager = reviewManager;
	}

	public ReviewManager getReviewManager() {
		return reviewManager;
	}

	public void setGroupedReview(Map<String, List<Review>> groupedReview) {
		this.groupedReview = groupedReview;
	}

	public Map<String, List<Review>> getGroupedReview() {
		return groupedReview;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public Review getReview() {
		return review;
	}

}

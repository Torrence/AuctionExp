package nju.edu.auctionExp.action.user;

import nju.edu.auctionExp.action.BaseAction;
import nju.edu.auctionExp.model.user.User;
import nju.edu.auctionExp.service.user.UserManager;

import com.opensymphony.xwork2.Action;

public class UserAction extends BaseAction {
	
	private UserManager userManager;
	private User user;
	private Object jsonModel;

	/**
	 * 
	 */
	private static final long serialVersionUID = 3996858999051111626L;
	
	public String getUserProfile(){
		this.user = userManager.getUserById(user.getId());
		return Action.SUCCESS;
	}
	
	public String getUserJSON(){
		this.user = userManager.getUserById(user.getId());
		this.setJsonModel(user);
		return Action.SUCCESS;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setJsonModel(Object jsonModel) {
		this.jsonModel = jsonModel;
	}

	public Object getJsonModel() {
		return jsonModel;
	}

}

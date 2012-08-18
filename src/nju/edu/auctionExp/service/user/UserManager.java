package nju.edu.auctionExp.service.user;

import nju.edu.auctionExp.model.user.User;

/**
 * @author hamsongliu
 * action to handle user transactions
 */
public interface UserManager {

	/**
	 * @param id
	 * @return
	 */
	public User getUserById(String id);
}

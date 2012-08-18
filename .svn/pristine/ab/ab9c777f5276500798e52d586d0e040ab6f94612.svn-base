package nju.edu.auctionExp.service.user;

import nju.edu.auctionExp.dao.UserDAO;
import nju.edu.auctionExp.model.user.User;

public class UserManagerImpl implements UserManager {
	private UserDAO userDAO;

	public User getUserById(String id) {
		return userDAO.findById(id);
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}


}

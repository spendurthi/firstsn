package com.standone.web.manager;

import com.standone.hbr.dao.LoginDao;
import com.standone.hbr.vo.User;

public class LoginManager {
	private LoginDao loginDao;

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	public boolean validateUser(User user){
		User userLocal=(User) loginDao.select(user.getUserId());
		if (userLocal!=null){
			return userLocal.getPassword().equals(user.getPassword());
		}
		return false;
	}
}

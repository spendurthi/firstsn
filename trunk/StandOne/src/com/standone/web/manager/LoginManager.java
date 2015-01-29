package com.standone.web.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.standone.hbr.dao.LoginDao;
import com.standone.hbr.parents.ValueObject;
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
	public User getUser(String id){
		User dbUser=(User)loginDao.select(id);
		return dbUser;
	}
	public int update(User vo){
		int retValue = loginDao.update(vo);
		return retValue;
	}
	public int save(User vo){
		int retValue = loginDao.save(vo);
		return retValue;
	}
	public int delete(User vo){
		int retValue = loginDao.delete(vo);
		return retValue;
	}
	public List<com.standone.vo.User> selectAll(){
		com.standone.vo.User uiUsr=null;
		User dbUsr = null;
		Collection<ValueObject> lov=loginDao.select();
		List<com.standone.vo.User> list=new ArrayList<com.standone.vo.User>();
		for(ValueObject vo:lov){
			dbUsr = (User)vo;
			uiUsr = new com.standone.vo.User(dbUsr.getUserId(), dbUsr.getPassword());
			list.add(uiUsr);
		}
		return list;
	}
}

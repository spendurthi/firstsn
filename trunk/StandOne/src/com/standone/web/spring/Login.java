package com.standone.web.spring;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.standone.hbr.vo.User;
import com.standone.validations.UserValidation;
import com.standone.web.manager.LoginManager;

@SuppressWarnings("deprecation")
public class Login extends SimpleFormController  {
	private LoginManager loginManager;
	private User user;
	private UserValidation validations;
	public void setValidations(UserValidation validations) {
		this.validations = validations;
	}
	public void setLoginManager(LoginManager loginManager) {
		this.loginManager = loginManager;
	}
	public Login(){
		setCommandClass(User.class);
		setCommandName("user");
	}
	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {
		user=(User)command;
		boolean result=loginManager.validateUser(user);
		if (result){
			return new ModelAndView("organization","user",user);
		}
		return null;
	}
	
}

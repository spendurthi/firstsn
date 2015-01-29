package com.standone.web.spring;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.opensymphony.xwork2.inject.Inject;
import com.standone.web.manager.LoginManager;
@Controller
@RequestMapping("/users/")
public class Users extends MultiAction {
	
	@Inject private LoginManager loginManager;	
	
	@RequestMapping("add.htm")
	public ModelAndView add(HttpServletRequest request,	HttpServletResponse response) throws Exception { 
		return new ModelAndView("users"); 
	}
	@RequestMapping("/users/users.htm")
	public ModelAndView users(HttpServletRequest request,	HttpServletResponse response) throws Exception {
		System.out.println("Got iy");
		return new ModelAndView("users","users",loginManager.selectAll()); 
	}	
}

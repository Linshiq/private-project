package lsq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lsq.model.User;
import lsq.service.dao.UserServiceDao;

public class UserController {

	UserServiceDao usd;

	public UserServiceDao getUsd() {
		return usd;
	}

	@Autowired
	public void setUsd(UserServiceDao usd) {
		this.usd = usd;
	}
	
	@RequestMapping("/text")
	public String getJsp(Model model){
		User u = usd.getUserById("1");
		model.addAttribute("user", u);
		return "test";
	}
	
}

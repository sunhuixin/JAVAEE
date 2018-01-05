package com.iotek.shx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iotek.shx.entity.User;
import com.iotek.shx.service.UserService;

@Controller("userController")
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "findUserByName",method=RequestMethod.POST)
	@ResponseBody
	public String findUserByName(String name) {
		User user = userService.findUserByName(name);
		String data = "";
		if(user==null) {
			data="0";
		}else {
			data="1";
		}
		return data;
	}

	@RequestMapping(value = "findUserByNameAndPassword",method=RequestMethod.POST)
	public String findUserByNameAndPassword(String userName, String password) {
		System.out.println(userName+password);
		User user = userService.findUserByNameAndPassword(userName,password);
		System.out.println(user);
		if(user!=null) {
			return "user";
		}else {
			return "forward:login.jsp";
		}
	}

	@RequestMapping(value = "addUser")
	public String addUser(User user) {
		userService.addUser(user);
		return "index.jsp";
	}

}
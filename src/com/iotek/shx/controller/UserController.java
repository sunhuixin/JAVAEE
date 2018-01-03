package com.iotek.shx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iotek.shx.entity.User;
import com.iotek.shx.service.UserService;

@Controller("userController")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "findUserByName")
	@ResponseBody
	public String findUserByName(String name) {
		User user = userService.findUserByName(name);
		String data = "";
		if (user.getType() == 0) {
			data = "0";
		} else if (user.getType() == 1) {
			data = "1";
		} else if (user.getType() == 2) {
			data = "2";
		}
		return data;
	}

	@RequestMapping(value = "findUserByNameAndPassword")
	public String findUserByNameAndPassword(String name, String password) {
		User user = userService.findUserByNameAndPassword(name, password);
		String data = "";
		if (user.getType() == 0) {
			data = "0";
		} else if (user.getType() == 1) {
			data = "1";
		} else if (user.getType() == 2) {
			data = "2";
		}
		return data;
	}

	@RequestMapping(value = "addUser")
	public String addUser(String userName, String password) {
		userService.addUser(userName, password);
		return "index.jsp";
	}

}
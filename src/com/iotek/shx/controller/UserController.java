package com.iotek.shx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.iotek.shx.entity.Department;
import com.iotek.shx.entity.User;
import com.iotek.shx.service.DepartService;
import com.iotek.shx.service.UserService;

@Controller("userController")
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private DepartService departService;

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
	public String findUserByNameAndPassword(String userName, String password,Model model) {
		User user = userService.findUserByNameAndPassword(userName,password);
		List<Department> departs = departService.findAllDepart();
		model.addAttribute("departs", departs);
		if(user!=null) {
			return "user";
		}else {
			return "forward:login.jsp";
		}
	}
	@RequestMapping(value="findDepart",method=RequestMethod.POST)
	public String findDepart(int dId) {
		Department depart = departService.findDepart(dId);
		System.out.println(depart.getPosition());
		String position = JSON.toJSONString(depart.getPosition());
		return position;
	}

	@RequestMapping(value = "addUser",method=RequestMethod.POST)
	public String addUser(User user) {
		userService.addUser(user);
		return "forward:login.jsp";
	}
	
	@RequestMapping(value = "toRegister")
	public String toAdd() {
		
		return "redirect:../register.jsp";
	}

}
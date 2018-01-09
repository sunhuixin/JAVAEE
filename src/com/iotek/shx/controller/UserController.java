package com.iotek.shx.controller;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.iotek.shx.entity.Department;
import com.iotek.shx.entity.Position;
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
	public String findUserByNameAndPassword(String userName, String password,HttpSession session) {
		User user = userService.findUserByNameAndPassword(userName,password);
		session.setAttribute("user", user);
		if(user!=null&&user.getType()==0) {
			return "user";
		}else if(user!=null&&user.getType()==1){
			return "employee";
		}else if(user!=null&&user.getType()==2) {
			return "admin";
		}
		return "forward:login.jsp";
	}
	@RequestMapping(value="findDepart",method=RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findDepart(int dId) {
		Department depart = departService.findDepart(dId);
		Set<Position> position1 = depart.getPosition();
		String position = JSON.toJSONString(position1);
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
	
	@RequestMapping(value = "updatePassword")
	public String updatePassword(@Param(value="password")String password,@Param(value="userId")int userId) {
		System.out.println("password="+password+"userId="+userId);
		userService.updatePassword(password,userId);
		return "user";
	}
	@RequestMapping(value="toUpdatePassword")
	public String toUpdatePassword() {
		return "user";
	}

}
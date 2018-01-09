package com.iotek.shx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iotek.shx.entity.Department;
import com.iotek.shx.entity.Recruit;
import com.iotek.shx.service.DepartService;
import com.iotek.shx.service.RecruitService;

@Controller("recruitController")
@RequestMapping("/recruit")
public class RecruitController {
	@Autowired
	private DepartService departService;
	@Autowired
	private RecruitService recruitService;
	@RequestMapping(value="findAll",method=RequestMethod.GET)
	public String findAll(Model model) {
		List<Recruit> recruits = recruitService.findAll();
		List<Department> departs = departService.findAllDepart();
		model.addAttribute("departs", departs);
		model.addAttribute("recruits", recruits);
		return "recruit";
	}

}

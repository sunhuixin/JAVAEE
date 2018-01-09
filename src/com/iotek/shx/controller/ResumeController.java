package com.iotek.shx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iotek.shx.entity.Department;
import com.iotek.shx.entity.Position;
import com.iotek.shx.entity.Resume;
import com.iotek.shx.service.DepartService;
import com.iotek.shx.service.PositionService;
import com.iotek.shx.service.ResumeService;

@Controller("resumerController")
@RequestMapping("/resume")
public class ResumeController {
	@Autowired
	private ResumeService resumeService;
	@Autowired
	private DepartService departService;
	@Autowired
	private PositionService positionService;

	@RequestMapping(value = "findResume", method = RequestMethod.GET)
	public String findResume(Model model, int userId) {
		Resume resume = resumeService.findResume(userId);
		if (resume == null) {
			Resume resume1 = new Resume();
			model.addAttribute("resume", resume1);
		}
		List<Department> departs = departService.findAllDepart();
		model.addAttribute("departs", departs);
		model.addAttribute("resume", resume);
		return "user";
	}

	@RequestMapping(value = "addResume", method = RequestMethod.POST)
	public String addResume(Resume resume,int dId,int pId) {
		Department depart = departService.findDepart(dId);
		Position position = positionService.findPosition(pId);
		System.out.println("depart="+depart+"position="+position);
		resume.setDepart(depart);
		resume.setPosition(position);
		if (resume.getId() == 0) {
			resumeService.addResume(resume);
		} else {
			resumeService.updateResume(resume);
		}
		return "user";
	}

	@RequestMapping(value = "return")
	public String returning() {
		return "user";
	}

}

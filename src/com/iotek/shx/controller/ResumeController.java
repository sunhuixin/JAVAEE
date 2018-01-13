package com.iotek.shx.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.iotek.shx.entity.Department;
import com.iotek.shx.entity.Position;
import com.iotek.shx.entity.Resume;
import com.iotek.shx.entity.User;
import com.iotek.shx.service.DepartService;
import com.iotek.shx.service.PositionService;
import com.iotek.shx.service.ResumeService;

@Controller("resumerController")
@RequestMapping("/resume")
public class ResumeController extends BaseController{
	@RequestMapping("/addResume")
	public String newResume(Resume resume, @RequestParam("uage1")String uage,
			@RequestParam("deptId")Integer deptId,@RequestParam("pid")Integer pid,
			HttpSession session,Model model) throws ParseException, UnsupportedEncodingException{
		//System.out.println(deptId+" "+pid);
		User user=(User) session.getAttribute("user");
		Department dept=getDeptService().findDepart(deptId);
		//dept.setdName(MyUtil.EncoderByutf8(dept.getDeptName()));
		Position position =getPositionService().findPosition(pid);
		//position.setPname(MyUtil.EncoderByutf8(position.getPname()));
		SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd");
		Date date=df.parse(uage);
		resume.setDepart(dept);
		resume.setPosition(position);
		//resume.setAge(date);
		resume.setUserId(user.getUserId());
//		resume.setUname(MyUtil.EncoderByutf8(resume.getUname()));
//		resume.setUhobby(MyUtil.EncoderByutf8(resume.getUhobby()));
//		resume.setUworkExp(MyUtil.EncoderByutf8(resume.getUworkExp()));
		System.out.println(resume);
		int flag =getResumeService().addResume(resume);
		model.addAttribute("flag", flag);
		return "forward:/WEB-INF/views/user/userResult.jsp";
	}
	@RequestMapping("/updateResume")
	public String renewResume(Resume resume, @RequestParam("uage1")String uage,@RequestParam("deptId")Integer deptId,@RequestParam("pid")Integer pid,HttpSession session,Model model) throws ParseException, UnsupportedEncodingException{
		//System.out.println(deptId+" "+pid);
		User user=(User) session.getAttribute("user");
		Department dept=getDeptService().findDepart(deptId);
		//dept.setDeptName(MyUtil.EncoderByutf8(dept.getDeptName()));
		Position position =getPositionService().findPosition(pid);
		//position.setPname(MyUtil.EncoderByutf8(position.getPname()));
		SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd");
		Date date=df.parse(uage);
		resume.setDepart(dept);
		resume.setPosition(position);
		//resume.setAge(date);
		resume.setUserId(user.getUserId());
//		resume.setUname(MyUtil.EncoderByutf8(resume.getUname()));
//		resume.setUhobby(MyUtil.EncoderByutf8(resume.getUhobby()));
//		resume.setUworkExp(MyUtil.EncoderByutf8(resume.getUworkExp()));
		System.out.println(resume);
		int flag =getResumeService().updateResume(resume);
		model.addAttribute("flag", flag);
		return "forward:/WEB-INF/views/user/userResult.jsp";
	}

}

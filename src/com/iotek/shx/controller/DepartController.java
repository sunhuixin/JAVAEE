package com.iotek.shx.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iotek.shx.entity.Administrator;
import com.iotek.shx.entity.Department;
import com.iotek.shx.entity.Position;

@Controller
public class DepartController extends BaseController{

	@RequestMapping("/addDept")
	public String addDept(Model model,@Param("deptName") String deptName) throws UnsupportedEncodingException{
		System.out.println(deptName);
		Department depart = new Department();
		depart.setCreateTime(new Date());
		depart.setdName(deptName);
		int flag =getDeptService().addDepart(depart);
		System.out.println("add:"+flag);
		List<Department> depts = getDeptService().findAllDepart(); 
		model.addAttribute("depts", depts);
		return "forward:/WEB-INF/views/admin/dept.jsp";
		
	}
	@RequestMapping("/updateDept")
	public String updateDpet(Model model,@Param("deptId")Integer deptId,@Param("deptName") String deptName) throws UnsupportedEncodingException{
		System.out.println(deptId);
		System.out.println(deptName);
		int flag = getDeptService().updateDepart(deptId,deptName);
		System.out.println("update:"+flag);
		List<Department> depts = getDeptService().findAllDepart(); 
		model.addAttribute("depts", depts);
		return "forward:/WEB-INF/views/admin/dept.jsp";
		
	}
	@RequestMapping("/deleteDept")
	public String deleteDept(Model model,@Param("deptId")Integer deptId){
		System.out.println(deptId);
		int flag = getDeptService().deleteDepart(deptId);
		System.out.println("delete:"+flag);
		List<Department> depts = getDeptService().findAllDepart(); 
		model.addAttribute("depts", depts);
		return "forward:/WEB-INF/views/admin/dept.jsp";
	}
	@RequestMapping("/rdsupervisePosition")
	public String rdsupervisePosition(@Param("deptId")Integer deptId,Model model,HttpSession session){
		Administrator admin =(Administrator) session.getAttribute("admin");
		System.out.println(admin);
		List<Position> positions = getPositionService().findPositionsByDepartId(deptId);
		Department dept=getDeptService().findDepart(deptId);
		model.addAttribute("dept", dept);
		model.addAttribute("positions", positions);
		return "forward:/WEB-INF/views/admin/position.jsp";
	}
}

package com.iotek.shx.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iotek.shx.entity.Administrator;
import com.iotek.shx.entity.Department;
import com.iotek.shx.entity.Position;

public class PositionController extends BaseController{
	@RequestMapping("/addPosition")
	public String addPosition(HttpSession session,Model model,@Param("pname") String pname,@Param("deptId") Integer deptId) throws UnsupportedEncodingException{
		//pname=MyUtil.EncoderByutf8(pname);
		Position position = new Position();
		Department depart = getDeptService().findDepart(deptId);
		position.setDepart(depart);
		position.setGenerateTime(new Date());
		position.setPname(pname);
		int flag=getPositionService().addPosition(position);
		if(flag>0){
			model.addAttribute("success", "success");
		}
		sessionP(session);
		return "forward:/WEB-INF/views/admin/position.jsp";
	}
	@RequestMapping("/deletePosition")
	public String deletePosition(HttpSession session,Model model,@Param("pid")Integer pid){
		System.out.println(pid);		
		int flag =getPositionService().deletePosition(pid);
		if(flag>0){
			model.addAttribute("success", "success");
		}
		sessionP(session);
		return "forward:/WEB-INF/views/admin/position.jsp";
	}
	@RequestMapping("/updatePosition")
	public String updatePosition(HttpSession session,Model model,
			@Param("pid")Integer pid,@Param("pname")String pname,
			@Param("deptId") Integer deptId) throws UnsupportedEncodingException{
		System.out.println(pid);
		//pname=MyUtil.EncoderByutf8(pname);
		int flag =getPositionService().updatePosition(pid,pname,deptId);
		if(flag>0){
			model.addAttribute("success", "success");
		}
		sessionP(session);
		return "forward:/WEB-INF/views/admin/position.jsp";
	}
	public void sessionP(HttpSession session){
		Administrator admin =(Administrator) session.getAttribute("admin");
		int deptId=admin.getDepart().getdId();
		List<Position> positions = getPositionService().findPositionsByDepartId(deptId);
		Department dept=getDeptService().findDepart(deptId);
		session.setAttribute("positions", positions);
		session.setAttribute("dept", dept);
	}
}

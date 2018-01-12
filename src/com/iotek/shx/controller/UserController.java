package com.iotek.shx.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iotek.shx.entity.Administrator;
import com.iotek.shx.entity.Attendance;
import com.iotek.shx.entity.Department;
import com.iotek.shx.entity.Employee;
import com.iotek.shx.entity.Interview;
import com.iotek.shx.entity.Position;
import com.iotek.shx.entity.Recruit;
import com.iotek.shx.entity.Resume;
import com.iotek.shx.entity.Training;
import com.iotek.shx.entity.User;
import com.iotek.shx.util.MyUtil;

@Controller("userController")
@RequestMapping("/user")
public class UserController extends BaseController{
	@RequestMapping("/confirmInterview")
	public void confirmInterview(HttpServletRequest req,HttpServletResponse resp,HttpSession session,Model model) throws IOException{
		Integer interviewId =Integer.valueOf(req.getParameter("interviewId"));
		boolean flag = getUserService().confirmInterview(interviewId);
		System.out.println("replyed¸ü¸Ä:"+flag);
		User user =(User) session.getAttribute("user");
		Interview interview = getUserService().getInterviewByUid(user.getUserId());
		System.out.println(interview);
		session.setAttribute("interview", interview);
		PrintWriter out = resp.getWriter();
		if(flag){
			out.print(0);
		}else{
			out.print(1);
		}
	}
	@RequestMapping("checkInterview")
	public void checkInterview(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		String id =req.getParameter("interviewId");
		System.out.println(id);
		Integer iid = Integer.valueOf(id);
		PrintWriter out =resp.getWriter();
		boolean flag = getUserService().checkInterview(iid);
		if(flag){
			out.print(0);
		}else{
			out.print(1);
		}
	}
	@RequestMapping("/regist")
	public String regist(User user) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String newStr=MyUtil.EncoderByMd5(user.getPassword());
		user.setPassword(newStr);
		if(getUserService().addUser(user)>0){
			return "forward:/index.jsp";
		}
		return "forward:/index.jsp";
	}
	
	 @RequestMapping(value="/checkSame")  
	 public void checkSame(HttpServletRequest req,HttpServletResponse resp){
		 String userName =req.getParameter("name");
		 User user =getUserService().findUserByName(userName);
		 try {
			PrintWriter out =resp.getWriter();
			if(null==user){
				out.print("0");
			}else{
				out.print("1");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 @RequestMapping("/login")
	 public String login(User user,Model model,HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		 String newStr = MyUtil.EncoderByMd5(user.getPassword());
		 User newUser =getUserService().login(user.getUserName(),newStr);
		 if(newUser==null){
			 model.addAttribute("error",user);
			 return "forward:/index.jsp";
		 }else{
			session.setAttribute("user", newUser);
			System.out.println(newUser);
			Interview interview = getUserService().getInterviewByUid(newUser.getUserId());
			System.out.println(interview);
			session.setAttribute("interview", interview);
			Employee emp =getEmployeeService().findByUserId(newUser.getUserId());
			if(emp!=null){
				session.setAttribute("emp", emp);
				Training train = getTrainService().queryByEmpId(emp.getEmpId());
				session.setAttribute("train", train);
				Attendance todayCheck =getAttendService().findByEmpIdAndDate(new Date(),emp.getEmpId()); 
				session.setAttribute("todayCheck",todayCheck);
				Date date =new Date();
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				String date1=df.format(date);
				session.setAttribute("date", date1);
				return "forward:/emp/empShow.jsp";
			}
			return "forward:/user/userResult.jsp";
			
		 }
	 }
	 @RequestMapping("/resume")
	 public String resume(HttpSession session,Model model,HttpServletRequest req) throws UnsupportedEncodingException{
		 List<Department> departs =getDeptService().findAllDepart();
		 System.out.println(departs);
		 model.addAttribute("depts",departs );
		 User user =(User) session.getAttribute("user");
		 Resume resume= getResumeService().findResume(user.getUserId());
		// resume.setUname(MyUtil.EncoderByutf8(resume.getUname()));
		 model.addAttribute("resume", resume);
		 System.out.println(resume);
		// req.setCharacterEncoding("utf-8");
		return "forward:/user/userResume.jsp";
	 }
	 
	 @RequestMapping("/sendResume")
	 public void sendResume(HttpServletResponse resp,HttpServletRequest req,HttpSession session) throws IOException{
		 Integer pid =Integer.valueOf(req.getParameter("pid"));
		 Integer departId =Integer.valueOf(req.getParameter("deptId"));
		 Double salary=Double.valueOf(req.getParameter("salary"));
		 Integer uid =Integer.valueOf(req.getParameter("uid"));
		 Position position=getPositionService().findPosition(pid);
		 List<Administrator> admins =getAdminService().findByDepartId(departId);
		 Resume resume = getResumeService().findResume(uid);
		 PrintWriter out = resp.getWriter();
		 if(resume!=null){
		 resume.setExpectedSalary(salary);
		 boolean flag =getUserService().sendResume(resume,admins.get(0),position);
		 if(flag){
			out.print(0);
		 }else{
			 out.print(2);
		 }
		 }else{
			 out.print(1);
		 }
		 
	 }
	 @RequestMapping("/checkRecruit")
	 public String checkRecruit(HttpSession session){
		List<Recruit> recruitments=getRecruitService().findAll();
		session.setAttribute("recruits", recruitments);
		return "forward:/user/checkRecruit.jsp";
	 }
	 @RequestMapping("/homePage")
	 public String homePage(){
		 return "forward:/user/userResult.jsp";
	 }

}
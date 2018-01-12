package com.iotek.shx.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iotek.shx.entity.Administrator;
import com.iotek.shx.entity.Employee;
import com.iotek.shx.entity.Objection;
import com.iotek.shx.entity.Reward;
import com.iotek.shx.util.MyUtil;

@Controller()
public class EmployeeController extends BaseController{
	@RequestMapping("salaryObj")
	public void salaryObj(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		PrintWriter out =resp.getWriter();
		Integer eid =Integer.valueOf(req.getParameter("eid"));
		Integer rapId=Integer.valueOf(req.getParameter("rapId"));
		String oReason =req.getParameter("oReason");
		System.out.println(eid+" "+rapId+" "+oReason);
		boolean flag = getObjectionService().addOSalary(eid,rapId,oReason);
		System.out.println(flag);
		if(flag){
			out.print(0);
		}else{
			out.print(1);
		}
	}
	@RequestMapping("/myObjection")
	public String myObjection(HttpSession session,@RequestParam("eid")Integer eid){
		List<Objection> pObjections = getObjectionService().queryPByEid(eid);
		List<Objection> rObjections = getObjectionService().queryRByEid(eid);
		List<Objection> sObjections =getObjectionService().querySByEid(eid);
		session.setAttribute("pObjections", pObjections);
		session.setAttribute("rObjections", rObjections);
		session.setAttribute("sObjections", sObjections);
		return "forward:/WEB-INF/views/emp/myObj.jsp";
	}
	@RequestMapping("/homePage")
	public String homePage(){
		return "forward:/emp/empShow.jsp";
	}
	@RequestMapping("/overTime")
	public void overTime(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		Reward reward = new Reward();
		Date date = new Date();
		int totaldays=MyUtil.totalDays(date);
		Administrator admin = getAdminService().findById(0);
		Integer empId =Integer.valueOf(req.getParameter("eid"));
		Employee employee = getEmployeeService().findByUserId(empId);
		reward.setRewardMoney((employee.getBaseSalary()/totaldays));
		reward.setRewardReason("¼Ó°à");
		reward.setAdmin(admin);
		reward.setEmp(employee);
		PrintWriter out =resp.getWriter();
		reward.setRewardTime(date);
		boolean flag = getRewardService().overTime(reward);
		if(flag){
			out.print(0);
		}else{
			out.print(1);
		}
	}
	@RequestMapping("/objectPunish")
	public void objectPunish(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		Integer eid = Integer.valueOf(req.getParameter("eid"));
		Integer pid= Integer.valueOf(req.getParameter("pid"));
		String oReason=req.getParameter("oReason");
		System.out.println(oReason);
		Employee employee = getEmployeeService().findByEid(eid);
		Integer aid = Integer.valueOf(req.getParameter("aid"));
		if(aid==0){
			aid=3;
		}
		Admin admin = getAdminService().findById(aid);
		System.out.println(eid+"pid"+pid+"");
		boolean flag =getObjectionService().addOPunish(employee,pid,oReason,admin);
		System.out.println(flag);
		PrintWriter out = resp.getWriter();
		if(flag){
			out.print(0);
		}else{
			out.print(1);
		}	
	}
	@RequestMapping("/objectReward")
	public void objectReward(HttpServletRequest req,HttpServletResponse resp) throws IOException{
		Integer eid = Integer.valueOf(req.getParameter("eid"));
		Integer rewardId= Integer.valueOf(req.getParameter("rewardId"));
		String oReason=req.getParameter("oReason");
		System.out.println(oReason);
		Employee employee = getEmployeeService().findByEid(eid);
		Integer aid = Integer.valueOf(req.getParameter("aid"));
		if(aid==0){
			aid=3;
		}
		Admin admin = getAdminService().findById(aid);
		boolean flag =getObjectionService().addOReward(employee,rewardId,oReason,admin);
		PrintWriter out = resp.getWriter();
		if(flag){
			out.print(0);
		}else{
			out.print(1);
		}	
	}
	@RequestMapping("/showMonthCheck")
	public String showMonthCheck(@RequestParam("date")String date,@RequestParam("eid") Integer eid,Model model) throws ParseException {
		System.out.println(date);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
		Date date1 = df.parse(date);
		Integer year=date1.getYear();
		Integer month=date1.getMonth();
		int totaldays=MyUtil.totalDays(date1);
		
		List<Check> checks = getCheckService().findByEid(eid);
		List<Check> newChecks = new ArrayList<>();
		for (Check check : checks) {
			if(check.getDate().getYear()==year&&check.getDate().getMonth()==month){
				newChecks.add(check);
			}
		}
		int count = newChecks.size();
		int absent = totaldays-count;
		System.out.println(newChecks);
		model.addAttribute("eid", eid);
		model.addAttribute("checks", newChecks);
		model.addAttribute("totaldays", totaldays);
		model.addAttribute("absent", absent);
		return "forward:/WEB-INF/views/emp/showMonthCheck.jsp";
	}

	@RequestMapping("/changeShowSalary")
	public String changeShowSalary(Model model, @RequestParam("eid") Integer eid,
			@RequestParam("startTime") String startTime, @RequestParam("endTime") String endTime)
			throws ParseException {
		Employee emp = getEmployeeService().findByEid(eid);
		System.out.println(eid);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
		Date startDate = df.parse(startTime);
		Date endDate = df.parse(endTime);
		System.out.println(emp);
		System.out.println("startDate:" + startDate + "endDate:" + endDate);
		List<RAP> raps = getRapService().findByEidBeTween(eid, startDate, endDate);
		Map<RAP, Double> sums = new HashMap<>();
		for (RAP rap : raps) {
			sums.put(rap, rap.getBaseSalary() + rap.getRapSalary());
			System.out.println(rap);
		}
		model.addAttribute("startTime", startTime);
		model.addAttribute("endTime", endTime);
		if (raps.size() == 0) {
			Date date = new Date();
			if (date.getMonth() == 0) {
				date.setMonth(11);
				date.setYear(date.getYear() - 1);
			} else {
				date.setMonth(date.getMonth() - 1);
			}
			RAP rap = getRapService().findByEidAndDate(eid, date);
			if(rap!=null){
			raps.add(rap);
			sums.put(rap, rap.getBaseSalary() + rap.getRapSalary());
			model.addAttribute("none", "none");
			}
		}
		model.addAttribute("sums", sums);
		model.addAttribute("raps", raps);
		return "forward:/WEB-INF/views/emp/showSalary.jsp";
	}

	@RequestMapping("/changeAbsent")
	public void changeAbsent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Integer eid = Integer.valueOf(req.getParameter("eid"));
		Date date = new Date();
		boolean flag = getCheckService().changeAbsentByEid(eid, date);
		PrintWriter out = resp.getWriter();
		System.out.println(flag);
		if (flag) {
			out.print(0);
		} else {
			out.print("no");
		}
	}

	@RequestMapping("/changeOk")
	public void changeOk(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Integer eid = Integer.valueOf(req.getParameter("eid"));
		Date date = new Date();
		boolean flag = getCheckService().changeOkByEid(eid, date);
		PrintWriter out = resp.getWriter();
		if (flag) {
			out.print(0);
		} else {
			out.print("no");
		}
	}

	@RequestMapping("/changeLate")
	public void changeLate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Integer eid = Integer.valueOf(req.getParameter("eid"));
		Date date = new Date();
		boolean flag = getCheckService().changeLateByEid(eid, date);
		PrintWriter out = resp.getWriter();
		if (flag) {
			out.print(0);
		} else {
			out.print("no");
		}
	}

	@RequestMapping("/attendTrain")
	public void attendTrain(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out = resp.getWriter();	 
		Integer eid=0;
		if(req.getParameter("eid")!=""){
			eid =Integer.valueOf(req.getParameter("eid"));
		}else{
		out.print(2);	
		}
		boolean flag = getTrainService().changeAttendByEid(eid);
		if (flag) {
			out.print(0);
		} else {
			out.print(1);
		}
	}

	@RequestMapping("/showOthers")
	public String showOthers(@Param("deptId") Integer deptId, Model model) {
		System.out.println(deptId);
		List<Employee> emps = getEmployeeService().findByDeptId(deptId);
		model.addAttribute("emps", emps);
		List<Admin> admins = getAdminService().findWithDept(deptId);
		model.addAttribute("admins", admins);
		return "forward:/WEB-INF/views/emp/showAll.jsp";
	}

	@RequestMapping("/showSalary")
	public String showSalary(@Param("eid") Integer eid, Model model,HttpSession session) {
		Employee emp = getEmployeeService().findByEid(eid);
		System.out.println(emp);
		Date date = new Date();
		if (date.getMonth() == 0) {
			date.setMonth(11);
			date.setYear(date.getYear() - 1);
		} else {
			date.setMonth(date.getMonth() - 1);
		}
		System.out.println(date);
		RAP rap = getRapService().findByEidAndDate(eid, date);
		if(rap!=null){
		System.out.println("rap" + rap);
		
		double sum = rap.getBaseSalary() + rap.getRapSalary();
		model.addAttribute("sum", sum);
		}
		model.addAttribute("rap", rap);
		return "forward:/WEB-INF/views/emp/showSalary.jsp";
	}

	@RequestMapping("/rapRecords")
	public String queryRapRecords(@Param("eid") Integer eid, Model model) {
		System.out.println(eid);
		Employee emp = getEmployeeService().findByEid(eid);
		List<Punishment> punishments = getPunishmentService().findByEid(eid);
		List<Reward> rewards = getRewardService().findByEid(eid);
		model.addAttribute("punishments", punishments);
		model.addAttribute("rewards", rewards);
		model.addAttribute("emp", emp);
		double sum = 0.0;
		for (Reward reward : rewards) {
			sum += reward.getRewardMoney();
		}
		for (Punishment punishment : punishments) {
			sum -= punishment.getpMoney();
		}
		model.addAttribute("sum", sum);
		return "forward:/WEB-INF/views/emp/showRAP.jsp";
	}

	@RequestMapping("/checkOn")
	public void checkOn(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws IOException {
		Integer eid = Integer.valueOf(req.getParameter("eid"));
		System.out.println(eid);
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();
		Integer hour = c.get(Calendar.HOUR_OF_DAY);
		Integer minute = c.get(Calendar.MINUTE);
		Integer second = c.get(Calendar.SECOND);
		String time = hour + ":" + minute + ":" + second;
		System.out.println(time);
		// System.out.println(time);
		System.out.println(date);
		boolean flag = getCheckService().addOnTimeByEid(eid, date, time);
		PrintWriter out = resp.getWriter();
		if (flag) {
			out.print(0);
		} else {

			out.print(1);
		}
	}

	@RequestMapping("/checkOff")
	public void checkOff(HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws IOException {
		Integer eid = Integer.valueOf(req.getParameter("eid"));
		System.out.println(eid);
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();
		Integer hour = c.get(Calendar.HOUR_OF_DAY);
		Integer minute = c.get(Calendar.MINUTE);
		Integer second = c.get(Calendar.SECOND);
		String time = hour + ":" + minute + ":" + second;
		System.out.println(time);
		// System.out.println(time);
		System.out.println(date);
		boolean flag = getCheckService().changeOffTimeByEid(eid, date, time);
		PrintWriter out = resp.getWriter();
		if (flag) {
			out.print(0);
		} else {

			out.print(1);
		}
	}
}

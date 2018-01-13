package com.iotek.shx.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iotek.shx.entity.Administrator;
import com.iotek.shx.entity.Attendance;
import com.iotek.shx.entity.Department;
import com.iotek.shx.entity.Employee;
import com.iotek.shx.entity.Interview;
import com.iotek.shx.entity.Objection;
import com.iotek.shx.entity.Position;
import com.iotek.shx.entity.Punishment;
import com.iotek.shx.entity.Recruit;
import com.iotek.shx.entity.Resume;
import com.iotek.shx.entity.ResumeInfo;
import com.iotek.shx.entity.Reward;
import com.iotek.shx.entity.RewardAndPunishment;
import com.iotek.shx.entity.Training;
import com.iotek.shx.util.MyUtil;

@Controller()
public class AdminController extends BaseController{
	@RequestMapping("/showLeave")
	public String showLeave(HttpSession session){
		List<Leave> leaves = getLeaveService().getAll();
		System.out.println(leaves);
		session.setAttribute("leaves", leaves);
		return "forward:/WEB-INF/views/admin/showLeave.jsp";
	}
	@RequestMapping("/byeEmp")
	public void byeEmp(HttpSession session,HttpServletRequest req, HttpServletResponse resp) throws IOException, ParseException{
		Integer eid =Integer.valueOf( req.getParameter("eid"));
		PrintWriter out = resp.getWriter();
		String lReason = req.getParameter("lReason");
		lReason=MyUtil.EncoderByutf8(lReason);
		int flag = getEmployeeService().deleteByEmpId(eid);
		if(flag>0){
			out.print(0);
		}else{
			out.print(1);
		}
	}
	@SuppressWarnings("deprecation")
	@RequestMapping("/agreeR")
	public void agreeR(HttpSession session,HttpServletRequest req, HttpServletResponse resp) throws IOException, ParseException{
	Integer aid = Integer.valueOf(req.getParameter("aid"));
	Integer oid = Integer.valueOf(req.getParameter("oid"));
	Integer eid = Integer.valueOf(req.getParameter("eid"));
	String rewardReason = req.getParameter("rewardReason");
	Double rewardMoney = Double.valueOf(req.getParameter("rewardMoney"));
	Date date = Calendar.getInstance().getTime();
	@SuppressWarnings("deprecation")
	int month =date.getMonth();
	if(month==11){
		month=0;
		date.setYear(date.getYear()+1);
	}else{
		month+=1;
	}
	date.setMonth(month);
	date.setDate(1);
	Reward reward = new Reward();
	Administrator admin = getAdminService().findById(aid);
	Employee employee = getEmployeeService().findByEmpId(eid);
	reward.setAdmin(admin);
	reward.setEmp(employee);
	reward.setRewardMoney(rewardMoney);
	reward.setRewardReason(rewardReason);
	reward.setRewardTime(date);
	int flag = getRewardService().saveReward(reward);
	if(flag>0){
		 flag =getObjectionService().update2ByObjectionId(oid);
	}
	PrintWriter out =resp.getWriter();
	if(flag==0){
		out.print(0);
	}else{
		out.print(1);
	}
	}
	@RequestMapping("disagree")
	public void disagree(HttpSession session,HttpServletRequest req, HttpServletResponse resp) throws IOException, ParseException{
		Integer oid = Integer.valueOf(req.getParameter("oid"));
		String oReason = req.getParameter("oReason");
		int flag = getObjectionService().update1ByObjectionId(oReason,oid);
		PrintWriter out = resp .getWriter();
		if(flag>0){
			out.print(0);
		}else{
			out.print(1);
		}
	}
	@SuppressWarnings("deprecation")
	@RequestMapping("/showMonthCheck")
	public String showMonthCheck(Model model,@RequestParam("eid") Integer eid){
		System.out.println(eid);
		Date date = new Date();
		@SuppressWarnings("deprecation")
		Integer year = date.getYear();
		@SuppressWarnings("deprecation")
		Integer month = date.getMonth();
		List<Attendance> checks = getAttendService().findByEmpId(eid);
		List<Attendance> newChecks = new ArrayList<>();
		for (Attendance check : checks) {
			if(check.getDate().getYear()==year&&check.getDate().getMonth()==month){
				newChecks.add(check);
			}
		}
		int totaldays = MyUtil.totalDays(date);
		int count = newChecks.size();
		int absent = totaldays-count;
		model.addAttribute("totaldays",totaldays);
		model.addAttribute("eid", eid);
		model.addAttribute("checks", newChecks);
		model.addAttribute("absent", absent);
		return "forward:/WEB-INF/views/emp/showMonthCheck.jsp";
	}
	@RequestMapping("/checkEmp")
	public String checkEmp(HttpSession session){
		Administrator admin = (Administrator) session.getAttribute("admin");
		if(admin.getAdminlevel()!=3){
		List<Employee> emps=getEmployeeService().findByDepartId(admin.getDepart().getdId());
		session.setAttribute("emps", emps);
		}else{
			List<Employee> emps= getEmployeeService().findAll();
			session.setAttribute("emps", emps);
		}
		return "forward:/WEB-INF/views/admin/empCheck.jsp";
	}
	@RequestMapping("/sendAllSalary")
	public void sendAllSalary(HttpSession session,HttpServletRequest req, HttpServletResponse resp) throws IOException, ParseException{
		@SuppressWarnings("unchecked")
		Map<Employee, Integer> allchecks = (Map<Employee, Integer>) session.getAttribute("allchecks");
		System.out.println(allchecks);
		Integer days=(Integer) session.getAttribute("totaldays");
		System.out.println(days);
		@SuppressWarnings("unchecked")
		List<Employee> emps = (List<Employee>) session.getAttribute("emps");
		@SuppressWarnings("unchecked")
		Map<Employee,Double> sums= (Map<Employee, Double>) session.getAttribute("sums");
		Date date = (Date) session.getAttribute("date");
		int count = 0;
		for (Employee employee : emps) {
			double performance = 1.0*(days-allchecks.get(employee))/days;
			RewardAndPunishment rap = new RewardAndPunishment();
			rap.setEmp(employee);
			rap.setBaseSalary(employee.getBaseSalary()*performance);
			rap.setRapSalary(sums.get(employee));
			int flag = getRapService().insertByRap(rap, date);
			if(flag>0){
				count+=1;
			}
		}
		PrintWriter out =resp.getWriter();
		out.print(count);
		
	}
	@RequestMapping("/sendSalary")
	public void sendSalary(HttpSession session,HttpServletRequest req, HttpServletResponse resp) throws IOException, ParseException {
		Integer absent = Integer.valueOf(req.getParameter("absent"));
		Integer totaldays =Integer.valueOf(req.getParameter("totaldays"));
		double performance = 1.0*(totaldays-absent)/totaldays;
		Integer eid = Integer.valueOf(req.getParameter("eid"));
		Employee employee = getEmployeeService().findByEmpId(eid);
		Double baseSalary = Double.valueOf(req.getParameter("baseSalary"));
		Double rapSalary = Double.valueOf(req.getParameter("rapSalary"));
		Date date = (Date) session.getAttribute("date");
		PrintWriter out = resp.getWriter();
		RewardAndPunishment rap = new RewardAndPunishment();
		rap.setBaseSalary(baseSalary*performance);
		rap.setRapSalary(rapSalary);
		rap.setEmp(employee);
		int flag = getRapService().insertByRap(rap,date);
		if (flag>0) {
			out.print(0);
		} else {
			out.print(1);
		}
	}
	@SuppressWarnings("deprecation")
	@RequestMapping("/rdSendSalary")
	public String rdSendSalary(HttpSession session, Model model) {
		Administrator admin = (Administrator) session.getAttribute("admin");
		List<Employee> emps = new ArrayList<>();
		if(admin.getAdminlevel()==3){
			emps = getEmployeeService().findAll();
		}else{
		Integer deptId = admin.getDepart().getdId();
			emps = getEmployeeService().findByDepartId(deptId);
		}
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();
		Integer month = c.get(Calendar.MONTH);
		@SuppressWarnings("deprecation")
		int year = date.getYear();
		if(month==0){
			month=11;
			date.setYear(year-1);
		}else{
			month=month-1;
		}
		date.setMonth(month);
		int totaldays = MyUtil.totalDays(date);
		
		
		Map<Employee,Integer> allchecks=new HashMap<>();
		Map<Employee, Double> sums = new HashMap<>();
		for (Employee employee : emps) {
			List<Attendance> checks = getAttendService().findByEmpId(employee.getEmpId());
			List<Attendance> newChecks = new ArrayList<>();
			for (Attendance check : checks) {
				if(check.getDate().getYear()==year&&check.getDate().getMonth()==month){
					newChecks.add(check);
				}
			}
			allchecks.put(employee, totaldays-newChecks.size());
			Double sum = 0.0;
			List<Reward> rewards = getRewardService().queryRewardByEmpIdAndDate(employee.getEmpId(),date);
			for (Reward reward : rewards) {
				sum+=reward.getRewardMoney();
			}
			List<Punishment> punishments = getPunishmentService().queryPunishmentByEmpIdAndDate(employee.getEmpId(),date);
			for (Punishment punishment : punishments) {
				sum-=punishment.getPunishMoney();
			}
			sums.put(employee, sum);
		}
		// List<RAP> raps = getRapService().findByDeptId(deptId);
		// Map<RAP, Double> sums=new HashMap<>();
		// for (RAP rap : raps){
		// sums.put(rap, rap.getBaseSalary()+rap.getRapSalary());
		// }
		// session.addAttribute("sums", sums);
		// session.addAttribute("raps", raps);
		session.setAttribute("emps", emps);
		session.setAttribute("sums", sums);
		session.setAttribute("date", date);
		session.setAttribute("allchecks", allchecks);
		session.setAttribute("totaldays", totaldays);
		return "forward:/WEB-INF/views/admin/newSalary.jsp";
	}

	@RequestMapping("/punishment")
	public String punishment(Punishment punishment, @Param("aid") Integer aid, @Param("eid") Integer eid,
			@Param("deptId") Integer deptId, Model model) throws UnsupportedEncodingException {
		Date date = new Date();
		punishment.setPunishTime(date);
		punishment.setAdmin(new Administrator(aid));
		punishment.setEmp(new Employee(eid));
		punishment.setPunishReason(MyUtil.EncoderByutf8(punishment.getPunishReason()));
		getPunishmentService().savePunishment(punishment);
		List<Department> depts = getDeptService().findAllDepart();
		List<Employee> employees = getEmployeeService().findByDepartId(deptId);
		model.addAttribute("employees", employees);
		model.addAttribute("depts", depts);
		return "redirect:/admin/showEmp";
	}

	@RequestMapping("/reward")
	public String reward(Reward reward, @Param("aid") Integer aid, @Param("eid") Integer eid,
			@Param("deptId") Integer deptId, Model model) throws UnsupportedEncodingException {
		reward.setAdmin(new Administrator(aid));
		reward.setEmp(new Employee(eid));
		Date date = new Date();
		reward.setRewardTime(date);
		reward.setRewardReason(MyUtil.EncoderByutf8(reward.getRewardReason()));
		int flag = getRewardService().saveReward(reward);
		System.out.println(flag);
		List<Department> depts = getDeptService().findAllDepart();
		List<Employee> employees = getEmployeeService().findByDepartId(deptId);
		model.addAttribute("employees", employees);
		model.addAttribute("depts", depts);
		return "redirect:/admin/showEmp";
	}
	@RequestMapping("/showEmp")
	public String showEmp(){
		return "forward:/WEB-INF/views/admin/showEmps.jsp";
	}
	@RequestMapping("/queryEmp")
	public String queryEmp(@Param("deptId") Integer deptId, HttpSession session) {
		List<Employee> employees = getEmployeeService().findByDepartId(deptId);
		List<Department> depts = getDeptService().findAllDepart();
		List<Employee> emps = getEmployeeService().findAll();

		session.setAttribute("employees", employees);
		session.setAttribute("depts", depts);
		session.setAttribute("emps", emps);
		return "forward:/WEB-INF/views/admin/showEmps.jsp";

	}

	@RequestMapping("/queryResume")
	public String queryResume(HttpSession session, Model model) {
		Administrator admin = (Administrator) session.getAttribute("admin");
		List<ResumeInfo> resumeInfos = getAdminService().getResumeInfoByAdminId(admin.getAdminId());
		model.addAttribute("resumeInfos", resumeInfos);
		return "forward:/WEB-INF/views/admin/showResumes.jsp";

	}

	@RequestMapping("/login")
	public String login(Administrator admin, Model model, HttpSession session) {
		Administrator newAdmin = getAdminService().findByNameAndPassword(admin);
		if (null == newAdmin) {
			model.addAttribute("error", admin);
			return "forward:/WEB-INF/views/admin/adminLogin.jsp";
		} else {
			int count = 0;
			session.setAttribute("admin", newAdmin);
			List<ResumeInfo> resumeInfos = getAdminService().getResumeInfoByAdminId(newAdmin.getAdminId());
			model.addAttribute("resumeInfos", resumeInfos);
			for (ResumeInfo resumeInfo : resumeInfos) {
				if (resumeInfo.getCheck() == 1) {
					count++;
				}
			}
			List<Objection> rObjections = getObjectionService().queryRewardByAdminId(newAdmin.getAdminId());
			List<Objection> pObjections=getObjectionService().queryPunishmentByAdminId(newAdmin.getAdminId());
			List<Objection> sObjections = getObjectionService().querySByAid3();
			List<Interview> interviews = getAdminService().receiveReply(newAdmin.getAdminId());
			session.setAttribute("ilist", interviews);
			session.setAttribute("rObjections", rObjections);
			session.setAttribute("pObjections", pObjections);
			session.setAttribute("sObjections", sObjections);
			model.addAttribute("count", count);
			return "forward:/WEB-INF/views/admin/adminShow.jsp";
		}
	}

	@RequestMapping("/index")
	public String index() {
		return "forward:/WEB-INF/views/admin/adminLogin.jsp";
	}

	@RequestMapping("/addRecruitment")
	public String addRecruitment(HttpSession session, Recruit recruitment, @RequestParam("pid") Integer pid,
			@RequestParam("deptId") Integer deptId, @RequestParam("aid") Integer aid)
			throws UnsupportedEncodingException {
		System.out.println(recruitment);
		System.out.println(aid);
		recruitment.setTitle(MyUtil.EncoderByutf8(recruitment.getTitle()));
		Administrator admin = getAdminService().findById(aid);
		Position position = getPositionService().findById(pid);
		Department dept = getDeptService().findById(deptId);
		recruitment.setDept(dept);
		recruitment.setPosition(position);
		recruitment.setAdmin(admin);
		System.out.println(recruitment);
		boolean flag = getRecruitService().add(recruitment);
		if (flag) {
			session.setAttribute("success", "success");
			session.setAttribute("rCount", 1);
		} else {
			session.setAttribute("success", "fail");
		}
		return "redirect:/admin/homePage";

	}

	@RequestMapping("/readyAdd")
	public String readyAdd(HttpSession session, Model model) {
		Administrator admin = (Administrator) session.getAttribute("admin");
		System.out.println(admin);
		System.out.println(admin.getDepart().getdId());
		Department dept = getDeptService().findDepart(admin.getDepart().getdId());
		System.out.println(dept);
		model.addAttribute("dept", dept);
		return "forward:/WEB-INF/views/admin/addRecruit.jsp";
	}

	@RequestMapping("/resumeDetail")
	public String resumeDetail(@Param("rid") Integer rid, Model model) {
		Resume resume = getResumeService().findByResumeId(rid);
		boolean flag = getResumeService().changeInfoCheckedById(rid);
		ResumeInfo resumeInfo = getResumeInfoService().findByRid(rid);
		model.addAttribute("resume", resume);
		model.addAttribute("resumeInfo", resumeInfo);
		System.out.println(resume);
		return "forward:/WEB-INF/views/admin/showOneResume.jsp";
	}

	@RequestMapping("/homePage")
	public String homePage(HttpSession session) {
		int rCount = 0;
		if (session.getAttribute("rCount") != null) {
			rCount = (int) session.getAttribute("rCount");
			session.setAttribute("rCount", 2);
		}
		if (rCount == 1) {
			System.out.println(rCount);
		} else {
			session.setAttribute("success", "fail");
			System.out.println(rCount);
		}
		return "forward:/WEB-INF/views/admin/adminShow.jsp";
	}

	@RequestMapping("/interview")
	public String readyInterview(@Param("rid") Integer rid, Model model, HttpSession session) {
		Administrator admin = (Administrator) session.getAttribute("admin");
		System.out.println(rid);
		Resume resume = getResumeService().findByRid(rid);
		List<Employee> emps = getEmployeeService().findByDeptId(admin.getDept().getDeptId());
		model.addAttribute("resume", resume);
		model.addAttribute("emps", emps);
		System.out.println(resume);
		return "forward:/WEB-INF/views/admin/interview.jsp";
	}

	@RequestMapping("/sendInterview")
	public String sendInterview(Interview interview, HttpSession session, @RequestParam("iTime1") String iTime,
			@RequestParam("rid") Integer rid) throws ParseException, UnsupportedEncodingException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		Date date = df.parse(iTime);
		System.out.println(iTime);
		interview.setiTime(date);
		Resume resume = getResumeService().findByRid(rid);
		System.out.println(rid);
		interview.setResume(resume);
		Administrator admin = (Administrator) session.getAttribute("admin");
		System.out.println(admin);
		interview.setAdmin(admin);
		if (interview.getiInterviewer() != null) {
			interview.setiInterviewer(MyUtil.EncoderByutf8(interview.getiInterviewer()));
		}
		interview.setiPlace(MyUtil.EncoderByutf8(interview.getiPlace()));
		System.out.println(interview);
		boolean flag = getAdminService().sendInterview(interview);
		if (flag) {
			session.setAttribute("success", "success");
			session.setAttribute("rCount", 1);
		} else {
			session.setAttribute("success", "fail");
		}
		return "redirect:/admin/homePage";
	}

	@RequestMapping("/employee")
	public void employeeOne(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Integer rid = Integer.valueOf(req.getParameter("rid"));
		Resume resume = getResumeService().findByRid(rid);
		boolean flag = getEmployeeService().addOne(resume);
		PrintWriter out = resp.getWriter();
		if (flag) {
			out.print(0);
		} else {
			out.print(1);
		}
	}

	@RequestMapping("/unEmployee")
	public void unEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Integer rid = Integer.valueOf(req.getParameter("rid"));
		boolean flag = getResumeInfoService().deleteByRid(rid);
		PrintWriter out = resp.getWriter();
		if (flag) {
			out.print(0);
		} else {
			out.print(1);
		}
	}

	@RequestMapping("/rdsupervisePosition")
	public String supervisePosition(HttpSession session, Model model) {
		Administrator admin = (Administrator) session.getAttribute("admin");
		int deptId = admin.getDept().getDeptId();
		List<Position> positions = getPositionService().findAllByDeptId(deptId);
		Department dept = getDeptService().findById(deptId);
		session.setAttribute("positions", positions);
		session.setAttribute("dept", dept);
		return "forward:/WEB-INF/views/admin/position.jsp";
	}

	@RequestMapping("/rdsuperviseDept")
	public String rdsuperviseDept(Model model) {
		List<Department> depts = getDeptService().getAllDept();

		model.addAttribute("depts", depts);
		return "forward:/WEB-INF/views/admin/dept.jsp";

	}

	@RequestMapping("/changePosition")
	public String changePosition(@Param("eid") Integer eid, @Param("deptId") Integer deptId,
			@Param("pid") Integer pid,HttpSession session) {
		System.out.println("eid" + eid + "deptID" + deptId + "pid" + pid);
		boolean flag = getEmployeeService().changePostion(eid, deptId, pid);
		if(flag){
			List<Employee> employees = getEmployeeService().findByDeptId(deptId);
			List<Department> depts = getDeptService().getAll();
			List<Employee> emps = getEmployeeService().getAll();
			session.setAttribute("employees", employees);
			session.setAttribute("depts", depts);
			session.setAttribute("emps", emps);
		}
		return "forward:/WEB-INF/views/admin/showEmps.jsp";
	}

	@RequestMapping("/addMoney")
	public void addMoney(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Integer eid = Integer.valueOf(req.getParameter("eid"));
		System.out.println(eid);
		String adds = req.getParameter("addSalary");
		if (adds.equals("")) {
			adds = "0";
		}
		Double addSalary = Double.valueOf(adds);
		System.out.println(addSalary);
		boolean flag = getEmployeeService().changeSalaryByEid(eid, addSalary);
		PrintWriter out = resp.getWriter();
		if (flag) {
			out.print(0);
		} else {
			out.print(1);
		}
	}

	@RequestMapping("/rdAddTrains")
	public String rdAddTrains(HttpSession session, Model model) {
		Administrator admin = (Administrator) session.getAttribute("admin");
		if (admin.getaLevel() == 2) {
			List<Employee> emps = getEmployeeService().findByDeptId(admin.getDept().getDeptId());
			model.addAttribute("emps", emps);
			return "forward:/WEB-INF/views/admin/addTrains.jsp";
		} else {
			List<Employee> emps = getEmployeeService().getAll();
			System.out.println(emps);
			model.addAttribute("emps", emps);
			List<Department> depts = getDeptService().getAll();
			model.addAttribute("depts", depts);
			return "forward:/WEB-INF/views/admin/addTrains.jsp";
		}
	}

	@RequestMapping("/addTrains")
	public String addTraining(Model model, HttpSession session, Train train, @Param("eid") Integer eid,
			@Param("duration") Integer duration, @RequestParam("startTime1") String startTime) throws ParseException, UnsupportedEncodingException {
		System.out.println(startTime);
		Administrator admin = (Administrator) session.getAttribute("admin");
		Department dept = getDeptService().findById(admin.getDept().getDeptId());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		Date start = df.parse(startTime);
		long addtime = duration * 1000 * 60 * 60 * 24;
		long endtime = start.getTime() + addtime;
		Date end = new Date(endtime);
		Employee emp = getEmployeeService().findByEid(eid);
		train.settTitle(MyUtil.EncoderByutf8(train.gettTitle()));
		train.settContent(MyUtil.EncoderByutf8(train.gettContent()));
		train.setBeginTime(start);
		train.setAdmin(admin);
		train.setEndTime(end);
		train.setEmployee(emp);
		train.setDept(dept);
		System.out.println(train);
		boolean flag = getTrainService().addByEmp(train);
		if (flag) {
			model.addAttribute("trainOk", "ok");
		} else {
			model.addAttribute("trainOk", "no");
		}
		return "forward:/WEB-INF/views/admin/adminShow.jsp";
	}

	@RequestMapping("/addSuperTrains")
	public String addSuperTrains(Model model, HttpSession session, Training train,
			@RequestParam(value = "eid3",required=false) Integer[] eids, @RequestParam("duration") Integer duration,
			@RequestParam("startTime1") String startTime, @RequestParam(value="deptId",required=false) Integer[] deptIds)
			throws ParseException {

		System.out.println(eids);
		System.out.println(deptIds);
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		Date start = df.parse(startTime);
		long addtime = duration * 1000 * 60 * 60 * 24;
		long endtime = start.getTime() + addtime;
		Date end = new Date(endtime);
		Administrator admin = (Administrator) session.getAttribute("admin");
		train.setAdmin(admin);
		train.setBeginTime(start);
		train.setEndTime(end);
		if(eids!=null||deptIds!=null){
		int res = getTrainService().addBySuperAdmin(train, eids, deptIds);
		if(res>0){
			model.addAttribute("num", res);
		}
		}
		
		// return "forward:/WEB-INF/views/admin/adminShow.jsp";
		return "forward:/WEB-INF/views/admin/adminShow.jsp";
	}
}

package com.test.dao;


import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iotek.shx.dao.DepartmentDao;
import com.iotek.shx.dao.PositionDao;
import com.iotek.shx.dao.ResumeDao;
import com.iotek.shx.dao.UserDao;
import com.iotek.shx.entity.Department;
import com.iotek.shx.entity.Position;
import com.iotek.shx.entity.Resume;
import com.iotek.shx.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring.xml","/spring-mvc.xml","/spring-mybatis.xml"})
public class App {
	@Autowired
	private UserDao userDao;
	@Autowired
	private DepartmentDao departDao;
	@Autowired
	private PositionDao positionDao;
	@Autowired
	private ResumeDao resumeDao;

	@Test
	public void test() {
		User user = userDao.queryUserByName("aaa");
		System.out.println(user);
	}
	
	@Test
	public void test1() {
		User user = userDao.queryUserByNameAndPassword("aaa","123aaa");
		System.out.println(user);
	}
	@Test
	public void test2() {
		int res = userDao.saveUser(new User("bbb","123bbb",0));
		System.out.println(res);
	}
	@Test
	public void test3() {
		int res = departDao.saveDepart(new Department(-1,"技术部",new Date()));
		System.out.println(res);
	}
	
	@Test
	public void test4() {
		List<Department> departs = departDao.queryAllDepart();
		System.out.println(departs);
	}
	
	@Test
	public void test5() {
		int res = departDao.deleteDepart(1);
		System.out.println(res);
	}
	
	@Test
	public void test8() {
		Department depart = departDao.queryDepart(3);
		Set<Position> set = depart.getPosition();
			System.out.println(set);
		
	}
	
	@Test
	public void test6() {
		int res = departDao.updateDepart(new Department(2,"销售部",new Date()));
		System.out.println(res);
	}
	
	@Test
	public void test7() {
		int res = positionDao.savePosition(new Position(-1,"技术员",new Date(),new Department(5,"技术部",new Date())));
	
		System.out.println(res);
	}
	
	@Test
	public void test9() {
		Resume resume = resumeDao.queryResume(1);
		System.out.println(resume);
	}
	@Test
	public void test10() {
		int res = resumeDao.saveResume(new Resume(-1,1,"iotek","男",20,"硕士","13122223333","1312222@163.com",new Department(5,"技术部",new Date()),new Position(12,"技术总监",new Date(),new Department(5,"技术部",new Date())),"党员","java工程师","5年开发经验","5000-6000","打篮球"));
		System.out.println(res);
	}
}
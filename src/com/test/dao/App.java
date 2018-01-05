package com.test.dao;


import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iotek.shx.dao.DepartmentDao;
import com.iotek.shx.dao.PositionDao;
import com.iotek.shx.dao.UserDao;
import com.iotek.shx.entity.Department;
import com.iotek.shx.entity.Position;
import com.iotek.shx.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class App {
	@Autowired
	private UserDao userDao;
	@Autowired
	private DepartmentDao departDao;
	@Autowired
	private PositionDao positionDao;

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
	public void test6() {
		int res = departDao.updateDepart(new Department(2,"销售部",new Date()));
		System.out.println(res);
	}
	
	@Test
	public void test7() {
		int res = positionDao.savePosition(new Position(-1,"技术员",new Date(),new Department(5,"技术部",new Date())));
	
		System.out.println(res);
	}
}
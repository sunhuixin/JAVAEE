package com.test.dao;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iotek.shx.dao.UserDao;
import com.iotek.shx.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class App {
	@Autowired
	private UserDao userDao;

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
}
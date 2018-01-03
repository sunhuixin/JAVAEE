
package com.iotek.shx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.shx.dao.UserDao;
import com.iotek.shx.entity.User;
import com.iotek.shx.service.UserService;
@Service("userService")
public class UserServcieImpl implements UserService{
	@Autowired
	private UserDao userDao;

	@Override
	public User findUserByName(String name) {
		return userDao.queryUserByName(name);
	}

	@Override
	public User findUserByNameAndPassword(String name, String password) {
		return userDao.queryUserByNameAndPassword(name, password);
	}

	@Override
	public int addUser(String userName, String password) {
		return userDao.saveUser(userName, password);
	}
	
}
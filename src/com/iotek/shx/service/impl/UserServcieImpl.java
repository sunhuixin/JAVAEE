
package com.iotek.shx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.shx.dao.InterviewDao;
import com.iotek.shx.dao.UserDao;
import com.iotek.shx.entity.Administrator;
import com.iotek.shx.entity.Interview;
import com.iotek.shx.entity.Position;
import com.iotek.shx.entity.Resume;
import com.iotek.shx.entity.User;
import com.iotek.shx.service.UserService;
@Service("userService")
public class UserServcieImpl implements UserService{
	@Autowired
	private UserDao userDao;
	@Autowired
	private InterviewDao interviewDao;

	@Override
	public User findUserByName(String name) {
		return userDao.queryUserByName(name);
	}

	@Override
	public User login(String name, String password) {
		return userDao.queryUserByNameAndPassword(name, password);
	}

	@Override
	public int addUser(User user) {
		return userDao.saveUser(user);
	}

	@Override
	public int updatePassword(String password,int userId) {
		return userDao.updatePassword(password,userId);
	}

	@Override
	public boolean sendResume(Resume resume, Administrator admin, Position position) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Interview getInterviewByUid(int userId) {
		// TODO Auto-generated method stub
		return interviewDao.queryByUerId(userId);
	}

	@Override
	public boolean checkInterview(int interviewId) {
		// TODO Auto-generated method stub
		return interviewDao.updateChecked(interviewId)==0?false:true;
	}

	@Override
	public boolean confirmInterview(int interviewId) {
		// TODO Auto-generated method stub
		return interviewDao.updateReplyed(interviewId)==0?false:true;
	}
	
}
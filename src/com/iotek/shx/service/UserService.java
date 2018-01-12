
package com.iotek.shx.service;

import com.iotek.shx.entity.Administrator;
import com.iotek.shx.entity.Interview;
import com.iotek.shx.entity.Position;
import com.iotek.shx.entity.Resume;
import com.iotek.shx.entity.User;

public interface UserService{
	public User findUserByName(String name);
	public User login(String name,String password);
	public int addUser(User user);
	public int  updatePassword(String password, int userId);
	public boolean sendResume(Resume resume, Administrator admin, Position position);

	public User findById(int userId);

	public Interview getInterviewByUid(int userId);

	public boolean checkInterview(int interviewId);
	
	public boolean confirmInterview(int interviewId);
}
package com.iotek.shx.dao;

import org.apache.ibatis.annotations.Param;

import com.iotek.shx.entity.Administrator;
import com.iotek.shx.entity.Position;
import com.iotek.shx.entity.Resume;
import com.iotek.shx.entity.User;

public interface UserDao{
	public User queryUserByName(String name);
	public User queryUserByNameAndPassword(@Param(value="userName")String userName,@Param(value="password")String password);
	public int saveUser(User user);
	public int updatePassword(@Param(value="password")String password, @Param(value="userId")int userId);
	public int insertResumeInfo(@Param("resume")Resume resume, @Param("admin")Administrator admin,@Param("position")Position position);

	public User queryById(int userId);
}
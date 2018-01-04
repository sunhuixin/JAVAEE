package com.iotek.shx.dao;

import org.apache.ibatis.annotations.Param;
import com.iotek.shx.entity.User;

public interface UserDao{
	public User queryUserByName(String name);
	public User queryUserByNameAndPassword(@Param(value="userName")String userName,@Param(value="password")String password);
	public int saveUser(String userName,String password);
}
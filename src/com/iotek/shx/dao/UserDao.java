package com.iotek.shx.dao;

import com.iotek.shx.entity.User;

public interface UserDao{
	public User queryUserByName(String name);
	public User queryUserByNameAndPassword(String name,String password);
	public int saveUser(String userName,String password);
}
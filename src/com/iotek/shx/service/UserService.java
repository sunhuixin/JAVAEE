
package com.iotek.shx.service;

import com.iotek.shx.entity.User;

public interface UserService{
	public User findUserByName(String name);
	public User findUserByNameAndPassword(String name,String password);
	public int addUser(User user);
	public int  updatePassword(String password, int userId);
}
package com.demo.dao;

import com.demo.domain.User;

public interface UserDao {

	public abstract void add(User user);

	public abstract User find(String username, String password);

	public abstract User find(String username);

}
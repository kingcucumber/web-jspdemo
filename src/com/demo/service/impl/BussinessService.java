package com.demo.service.impl;

import com.demo.domain.User;

public interface BussinessService {

	public abstract void register(User user) throws Exception;

	public abstract User login(String username, String password);

}
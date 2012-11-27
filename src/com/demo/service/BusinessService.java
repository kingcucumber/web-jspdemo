package com.demo.service;

import com.demo.dao.UserDao;
import com.demo.dao.impl.UserDaoImpl;
import com.demo.domain.User;
import com.demo.exception.UserExistException;
import com.demo.service.impl.BussinessService;
import com.demo.utils.ServiceUtils;

public class BusinessService implements BussinessService {
	
	private UserDao dao = new UserDaoImpl();
	
	/* (non-Javadoc)
	 * @see com.demo.service.impl.BussinessService#register(com.demo.domain.User)
	 */
	@Override
	public void register(User user) throws Exception{
			boolean b = dao.find(user.getUsername()) != null;
			if(b){
				throw new UserExistException();
			}else{
				user.setPassword(ServiceUtils.md5(user.getPassword()));
				dao.add(user);
			}
	}
	
	/* (non-Javadoc)
	 * @see com.demo.service.impl.BussinessService#login(java.lang.String, java.lang.String)
	 */
	@Override
	public User login(String username,String password){
		password = ServiceUtils.md5(password);
		return dao.find(username,password);
	
	}
}

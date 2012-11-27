package com.demo.dao.impl;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import com.demo.dao.UserDao;
import com.demo.domain.User;
import com.demo.utils.XmlUtils;

public class UserDaoImpl implements UserDao {
	/* (non-Javadoc)
	 * @see com.demo.dao.impl.UserDao#add(com.demo.domain.User)
	 */
	@Override
	public void add(User user){
		try {
			Document document = XmlUtils.getDocument();
			Element root = document.getRootElement();
			
			root.addElement("user").setAttributeValue("id", user.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.demo.dao.impl.UserDao#find(java.lang.String, java.lang.String)
	 */
	@Override
	public User find(String username,String password){
		
		return null;
	}
	
	/* (non-Javadoc)
	 * @see com.demo.dao.impl.UserDao#find(java.lang.String)
	 */
	@Override
	public User find(String username){
		
		
		return null;
	}
}

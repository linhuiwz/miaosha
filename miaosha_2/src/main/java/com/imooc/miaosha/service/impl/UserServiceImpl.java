package com.imooc.miaosha.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.miaosha.dao.UserDao;
import com.imooc.miaosha.domain.User;
import com.imooc.miaosha.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public User getUserById(int userId) {
		return userDao.getById(userId);
	}

	@Transactional
	public void doTx() {
		User u1 = new User();
		u1.setId(1);
		u1.setName("test");
		userDao.insert(u1);
		User u2 = new User();
		u2.setId(1);
		u2.setName("test222");
		userDao.insert(u2);
	}

}

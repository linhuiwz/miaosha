package com.imooc.miaosha.service;

import com.imooc.miaosha.domain.User;

public interface UserService {
	
	User getUserById(int userId);

	void doTx();

}

package com.imooc.miaosha.access;

import com.imooc.miaosha.domain.MiaoshaUser;

public class UserContext {

	private static ThreadLocal<MiaoshaUser> userHolder = new ThreadLocal<MiaoshaUser>();

	public static MiaoshaUser getUser() {
		return userHolder.get();
	}
	
	public static void setUser(MiaoshaUser user) {
		userHolder.set(user);
	}

}

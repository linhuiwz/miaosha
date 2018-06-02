package com.imooc.miaosha.service;

import org.springframework.stereotype.Service;

import com.imooc.miaosha.result.Result;

@Service
public class VideoServiceImpl implements VideoService {

	@Override
	public Result<String> getVideoName() {
		return Result.success("Hello，world");
	}

}

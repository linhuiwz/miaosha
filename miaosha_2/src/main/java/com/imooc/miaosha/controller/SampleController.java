package com.imooc.miaosha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imooc.miaosha.domain.User;
import com.imooc.miaosha.result.CodeMsg;
import com.imooc.miaosha.result.Result;
import com.imooc.miaosha.service.UserService;

@RequestMapping("/demo")
@Controller
public class SampleController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Hello World!";
	}

	@RequestMapping("/hello")
	@ResponseBody
	public Result<String> hello() {
		return Result.success("hello, imooc!");
	}
	
	@RequestMapping("/helloError")
	@ResponseBody
	public Result<String> helloError() {
		return Result.error(CodeMsg.SERVER_ERROR);
	}
	
	@RequestMapping("/thymeleaf")
	public String thymeleaf(Model model) {
		model.addAttribute("name", "my name");
		return "hello";
	}
	
	@RequestMapping("/db/get")
	@ResponseBody
	public Result<User> dbGet() {
		return Result.success(userService.getUserById(1));
	}
	
	@RequestMapping("/db/tx")
	@ResponseBody
	public Result<Boolean> doTx() {
		userService.doTx();
		return Result.success(true);
	}
}

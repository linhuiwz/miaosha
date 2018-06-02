package com.immoc.miaosha.controller;

import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.imooc.miaosha.result.CodeMsg;
import com.imooc.miaosha.result.Result;

@RequestMapping("/demo")
@Controller
public class SampleController {

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
}

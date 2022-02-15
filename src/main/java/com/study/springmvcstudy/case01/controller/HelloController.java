package com.study.springmvcstudy.case01.controller;


import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/case01/hello")
public class HelloController {
	
	
	// 1. 取得字串資料
	// 路徑: /welcome
	@RequestMapping("/welcome")
	@ResponseBody // 直接根據回傳執型別回應
	public String welcome() {
		return "Hello SpringMVC "+new Date(); 
	}
	
	// 2. 帶參數(?xxx=xxx 配置)
	// 路徑: /sayhi?name=stanley&age=999
	@RequestMapping(value = {"/sayhi","/hi"},method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String sayhi(@RequestParam(value = "name") String name,
						@RequestParam(value = "age",required = false,defaultValue = "0") Integer age) {
		return String.format("Hi %s %d", name,age);
	}
}

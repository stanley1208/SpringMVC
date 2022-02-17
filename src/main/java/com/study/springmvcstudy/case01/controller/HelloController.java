package com.study.springmvcstudy.case01.controller;


import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

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
	
	// 2. 帶參數 (?xxx=xxx 配置)
	// 路徑: /sayhi?name=stanley&age=999
	@RequestMapping(value = {"/sayhi","/hi"},method = {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public String sayhi(@RequestParam(value = "name") String name,
						@RequestParam(value = "age",required = false,defaultValue = "0") Integer age) {
		return String.format("Hi %s %d", name,age);
	}
	
	/*
	 * 3. 帶參數 Lab 練習：?後帶入參數並計算
	 * 路徑：/bmi?h=170.0&w=60.0
	 * 可以使用：Optional<?> 來接參數
	 */
	// 請設計方法 api, 結果會得到 bmi = 20.76。若資訊不足則顯示 bmi = None!
	@GetMapping("/bmi")	
	@ResponseBody
	public String bmi(@RequestParam(value = "h",required = false)Optional<Double>h,
					  @RequestParam(value = "w",required = false)Optional<Double>w) {
		String result="None";
		if(h.isPresent() && w.isPresent()) {
			double bmi=w.get()/Math.pow(h.get()/100, 2);
			result=String.format("%.2f", bmi);
		}
		
		return String.format("bmi= %s", result);
	}
	
	/*
	 * 4. 路徑參數 @PathVariable
	 * 路徑：/exam/75 => score: 75 pass
	 * 路徑：/exam/45 => score: 45 fail
	 */
	
	@GetMapping("exam/{score}")
	@ResponseBody
	public String examScore(@PathVariable("score") Integer score) {
		return String.format("score: %d %s", score,(score>=60)?"Pass":"Fail");
	}
	
	
}

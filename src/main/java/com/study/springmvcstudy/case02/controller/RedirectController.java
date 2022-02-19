package com.study.springmvcstudy.case02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/case02/redirect")
public class RedirectController {
	// 重新向 redirect:
	// 由 server 端重新 redirect 命令(會放在header中)給 client 端，並由 client 端去執行
	// 所以 client 端的瀏覽網址不會改變
	// 重定向可以只向內網與外網

	@RequestMapping("/demo1")
	public String demo1() {
		return "redirect:/index.jsp";
	}

	// Lab (demo2) 我要透過 redirect: 重定向到 show_time.jsp 要如何寫?
	// http://localhost:8080/springmvcstudy/mvc/case02/redirect/demo2
	// http://localhost:8080/springmvcstudy/mvc/case02/time/now
	@RequestMapping("/demo2")
	public String demo2() {
		// return "redirect:/mvc/case02/time/now"; // 絕對路徑
		return "redirect:../time/now"; // 相對路徑
	}

	@RequestMapping("/demo3")
	public String demo3() {
		return "redirect:http://tw.yahoo.com";
	}

	// 重定向帶參數 I
	@RequestMapping("/demo4")
	public String demo4() {
		return "redirect:/show_param.jsp?username=Stanley&age=21";
	}

	// 重定向帶參數 II
	@RequestMapping("/demo5")
	public String demo5(RedirectAttributes attr) {
		attr.addAttribute("username","Google");
		attr.addAttribute("age","999");
		return "redirect:/show_param.jsp";
	}
	
	// 重定向帶參數 III (addFlashAttribute)
	// http://localhost:8080/springmvcstudy/mvc/case02/redirect/saveOrder?name=iPhone&price=25000&qty=5
	@RequestMapping("/saveOrder")
	public String saveOrder(@RequestParam("name") String name,
							@RequestParam("price") Integer price,
							@RequestParam("qty") Integer qty,
							RedirectAttributes attr) {
		attr.addFlashAttribute("name",name);
		attr.addFlashAttribute("price",price);
		attr.addFlashAttribute("qty",qty);

		
		return "redirect:./success";
		
	}
	
	@RequestMapping("/success")
	public String saveOrder() {
		return "case02/order_ok";
	}
}

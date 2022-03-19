package com.study.springmvcstudy.lab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springmvcstudy.lab.entity.Fundstock;
import com.study.springmvcstudy.lab.repository.FundstockDao;

@Controller
@RequestMapping("/lab/fundstock")
public class FundstockController {

	@Autowired
	private FundstockDao fundstockDao;
	
	@GetMapping("/")
	@ResponseBody
	public List<Fundstock>index(){
		return fundstockDao.queryAll();
	}
	
	
	@GetMapping("/page/{pageNumber}")
	@ResponseBody
	public List<Fundstock>page(@PathVariable("pageNumber") int pageNumber){
		// 1 -> 0, 2 -> 5, 3 -> 10
		int offset=(pageNumber-1)*FundstockDao.LIMIT;
		return fundstockDao.queryPage(offset);
	}
}

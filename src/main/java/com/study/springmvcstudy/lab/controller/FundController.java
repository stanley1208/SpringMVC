package com.study.springmvcstudy.lab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springmvcstudy.lab.entity.Fund;
import com.study.springmvcstudy.lab.repository.FundDao;

@Controller
@RequestMapping("/lab/fund")
public class FundController {
	
	@Autowired
	private FundDao fundDao;
	
	@GetMapping("/")
	@ResponseBody
	public List<Fund> index(){
		return fundDao.queryAll();
	}
}

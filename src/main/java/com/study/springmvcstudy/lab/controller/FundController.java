package com.study.springmvcstudy.lab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.springmvcstudy.lab.entity.Fund;
import com.study.springmvcstudy.lab.repository.FundDao;

@RestController
@RequestMapping("/lab/fund")
public class FundController {
	private int pageNumber;
	@Autowired
	private FundDao fundDao;
	
	@GetMapping("/")
	public List<Fund> index() {
		List<Fund> funds = fundDao.queryAll();
		// 將沒有成分股的基金其 fundstocks 屬性置空(null)
		funds.stream()
			.filter(f -> f.getFundstocks() != null)
			.filter(f -> f.getFundstocks().get(0).getFid() == null)
			.forEach(f -> f.setFundstocks(null));
		return funds;
	}
	
	@GetMapping("/{fid}")
	public Fund get(@PathVariable("fid") Integer fid) {
		return fundDao.get(fid);
	}
	
	@GetMapping("/totalPagecount")
	public int totalPagecount() {
		return (int)Math.ceil(fundDao.count() / (double)FundDao.LIMIT);
	}
	
	@GetMapping("/page/{pageNumber}")
	public List<Fund> page(@PathVariable("pageNumber") int pageNumber) {
		this.pageNumber = pageNumber;
		int offset = (pageNumber-1) * FundDao.LIMIT;
		return fundDao.queryPage(offset);
	}
	
	@PostMapping("/")
	public int add(@RequestBody Fund fund) {
		return fundDao.add(fund);
	}
	
	@PutMapping("/")
	public int update(@RequestBody Fund fund) {
		return fundDao.update(fund);
	}
	
	@DeleteMapping("/{fid}")
	public int delete(@PathVariable("fid") Integer fid) {
		return fundDao.delete(fid);
	}
	
}

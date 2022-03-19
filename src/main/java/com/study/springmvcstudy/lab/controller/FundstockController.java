package com.study.springmvcstudy.lab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springmvcstudy.lab.entity.Fund;
import com.study.springmvcstudy.lab.entity.Fundstock;
import com.study.springmvcstudy.lab.repository.FundDao;
import com.study.springmvcstudy.lab.repository.FundstockDao;

@Controller
@RequestMapping("/lab/fundstock")
public class FundstockController {

	@Autowired
	private FundstockDao fundstockDao;
	
	@Autowired
	private FundDao fundDao;
	
	private int pageNumber=-1;
	
	@GetMapping("/")
	public String index(@ModelAttribute Fundstock fundstock,Model model){
		return "redirect:./page/"+pageNumber;
	}
	
	
	@GetMapping("/page/{pageNumber}")
	
	public String page(@PathVariable("pageNumber") int pageNumber,@ModelAttribute Fundstock fundstock,Model model){
		// 1 -> 0, 2 -> 5, 3 -> 10
		this.pageNumber=pageNumber;
		int offset=(pageNumber-1)*FundstockDao.LIMIT;
		List<Fundstock>fundstocks= fundstockDao.queryPage(offset);
		
		List<Fund>funds=fundDao.queryAll();

		int pageTotalCount=fundstockDao.count()/FundstockDao.LIMIT;
		model.addAttribute("_method","POST");
		model.addAttribute("fundstocks",fundstocks);
		model.addAttribute("funds",funds);

		model.addAttribute("pageTotalCount",pageTotalCount);
		return "lab/fundstock";
	}
	
	@GetMapping("/{sid}")
	
	public Fundstock get(@PathVariable("sid") Integer sid) {
		return fundstockDao.get(sid);
	}
}

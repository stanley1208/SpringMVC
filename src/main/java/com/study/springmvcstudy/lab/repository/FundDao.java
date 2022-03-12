package com.study.springmvcstudy.lab.repository;

import java.util.List;

import com.study.springmvcstudy.lab.entity.Fund;


public interface FundDao {
	// 每頁5筆
	int LIMIT = 5;

	// 全部查詢
	List<Fund> queryAll();

	// 分業查詢
	List<Fund> queryPage(int offset);

	// 取得單筆
	Fund get(Integer sid);

	// 查詢所有筆數
	int count();
	
	// 新增
	int add(Fund fund);

	// 修改
	int update(Fund fund);

	// 刪除
	int delete(Integer fid);
	

	

	
}

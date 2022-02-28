package com.study.springmvcstudy.case03.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.study.springmvcstudy.case03.entity.Exam;
import com.study.springmvcstudy.case03.entity.ExamSubject;

@Service
public class ExamService {
	private List<Exam> exams = new CopyOnWriteArrayList<>(); // 註冊考試的紀錄集合
	private List<ExamSubject>examSubjects=new CopyOnWriteArrayList<>();
	
	{
		examSubjects.add(new ExamSubject("808","JavaSE 8 OCP I"));
		examSubjects.add(new ExamSubject("809","JavaSE 8 OCP II"));
		examSubjects.add(new ExamSubject("819","JavaSE 11 OCP "));
		examSubjects.add(new ExamSubject("900","JavaEE 7 OCP "));
	}
	
	//查詢所有 exam subject
	public List<ExamSubject>queryExamSubjectList(){
		return examSubjects;
	}
	
	// 首頁(查詢多筆)
	public List<Exam> query() {

		return exams;
	}

	// 查詢單筆
	public Optional<Exam> get(int index) {
		if (index < 0 || exams.size() == 0 || index >= exams.size()) {
			return Optional.ofNullable(null);
		}
		return Optional.ofNullable(exams.get(index));
	}

	// 新增
	public synchronized Boolean add(Exam exam) {
		int previousSize = exams.size();
		exams.add(exam);
		int nextSize = exams.size();
		return nextSize > previousSize;
	}

	// 修改
	public synchronized Boolean update(int index, Exam exam) {
		if (index < 0 || exams.size() == 0 || index >= exams.size()) {
			return false;
		}
		exams.set(index, exam);
		return true;
	}

	// 修改 ExamNote 欄位資料
	public synchronized Boolean updateExamNote(int index, String examNote) {
		if (index < 0 || exams.size() == 0 || index >= exams.size()) {
			return false;
		}
		Exam exam=exams.get(index);
		exam.setExamNote(examNote);
		exams.set(index, exam);
		return true;
	}

	// 刪除
	public synchronized Boolean delete(int index) {
		if (index < 0 || exams.size() == 0 || index >= exams.size()) {
			return false;
		}
		exams.remove(index);
		return true;
	}
}

package com.sai.dao;

import java.util.List;

import com.sai.model.Student;

public interface StudentDao {
	public void addStudent(Student student);

	public List<Student> findAllStudents();
}

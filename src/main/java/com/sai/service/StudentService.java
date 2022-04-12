package com.sai.service;

import java.util.List;

import com.sai.dto.StudentDto;

public interface StudentService {
	public void saveStudent(StudentDto studentDto);

	public List<StudentDto> getAllStudents();
}

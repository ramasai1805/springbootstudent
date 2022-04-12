package com.sai.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.dao.StudentDao;
import com.sai.dto.StudentDto;
import com.sai.model.Student;
import com.sai.service.StudentService;

@Service
//@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDao studentDao;

	@Override
	public void saveStudent(StudentDto dto) {
		studentDao.addStudent(new Student(dto.getName(), dto.getEmail()));
	}

	@Override
	public List<StudentDto> getAllStudents() {
		List<Student> students = studentDao.findAllStudents();
		List<StudentDto> dtos = new ArrayList<StudentDto>();
		students.forEach(s -> {
			dtos.add(new StudentDto(s.getSid(), s.getName(), s.getEmail()));
		});
		return dtos;
	}

}

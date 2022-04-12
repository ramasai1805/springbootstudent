package com.sai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sai.commons.StudentExcel;
import com.sai.commons.StudentPdf;
import com.sai.dto.StudentDto;
import com.sai.exception.StudentException;
import com.sai.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;

	@RequestMapping("/")
	public String getHome() {
		return "home";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveStudent(StudentDto dto) {
		if (dto.getName().isEmpty() || dto.getEmail().isEmpty()) {
			throw new StudentException("Student name and email should not be empty");
		} else {
			studentService.saveStudent(dto);
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public ModelAndView getStudents() {
		return new ModelAndView("list", "students", studentService.getAllStudents());
	}

	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public ModelAndView download(@RequestParam(value = "type") String type) {
		ModelAndView modelAndView = new ModelAndView("list");
		if (type != null && type.equals("xls")) {
			return new ModelAndView(new StudentExcel(), "students", studentService.getAllStudents());
		} else if (type != null && type.equals("pdf")) {
			return new ModelAndView(new StudentPdf(), "students", studentService.getAllStudents());
		}
		return modelAndView;
	}
}
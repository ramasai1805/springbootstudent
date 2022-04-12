package com.sai.commons;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.sai.dto.StudentDto;

public class StudentExcel extends AbstractXlsView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-disposition", "attachment; filename=\"emp_list.xls\"");
		List<StudentDto> list = (List<StudentDto>) model.get("students");
		Sheet sheet = workbook.createSheet("StudentsList");

		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("SID");
		header.createCell(0).setCellValue("NAME");
		header.createCell(0).setCellValue("EMAIL");
		int rowNum = 1;
		for (StudentDto dto : list) {
			Row row = sheet.createRow(rowNum);
			row.createCell(0).setCellValue(dto.getSid());
			row.createCell(0).setCellValue(dto.getName());
			row.createCell(0).setCellValue(dto.getEmail());
		}

	}

}

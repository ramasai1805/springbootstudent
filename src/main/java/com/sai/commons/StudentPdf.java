package com.sai.commons;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.sai.dto.StudentDto;

public class StudentPdf extends AbstractPdfView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setHeader("Content-disposition", "attachment; filename=\"emp_list.pdf\"");
		List<StudentDto> list = (List<StudentDto>) model.get("students");
		Table table = new Table(3);
		table.addCell("SID");
		table.addCell("NAME");
		table.addCell("EMAIL");

		for (StudentDto dto : list) {
			table.addCell(String.valueOf(dto.getSid()));
			table.addCell(dto.getName());
			table.addCell(dto.getEmail());
		}
		document.add(table);
	}

}

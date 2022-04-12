package com.sai.dto;

public class StudentDto {
	private Integer sid;
	private String name;
	private String email;

	public StudentDto() {
		super();
	}

	public StudentDto(Integer sid, String name, String email) {
		super();
		this.sid = sid;
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		return "StudentDto [sid=" + sid + ", name=" + name + ", email=" + email + "]";
	}

}

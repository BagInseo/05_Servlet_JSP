package edu.kh.jsp.test.dto;

public class Member {
	private String inputId;
	private String inputPw;
	private String inputPwCheck;
	private String inputName;
	
	
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Member(String inputId, String inputPw, String inputName) {
		this.inputId = inputId;
		this.inputPw = inputPw;
		this.inputName = inputName;
	}



	public String getInputId() {
		return inputId;
	}



	public void setInputId(String inputId) {
		this.inputId = inputId;
	}



	public String getInputPw() {
		return inputPw;
	}



	public void setInputPw(String inputPw) {
		this.inputPw = inputPw;
	}



	public String getInputPwCheck() {
		return inputPwCheck;
	}



	public void setInputPwCheck(String inputPwCheck) {
		this.inputPwCheck = inputPwCheck;
	}



	public String getInputName() {
		return inputName;
	}



	public void setInputName(String inputName) {
		this.inputName = inputName;
	}


	
	
}

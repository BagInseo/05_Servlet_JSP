<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 테스트 완료</title>
</head>
<body>

	<%--
		request 변수 == 전달 받은 HttpServletRequest 객체를 참조하는 변수
		
		<% %>  태그 : Scriptlet(스크립틀릿)
					JSP에서 자바 코드를 작성할 수 있게 하는 코드
					<% 자바 코드 %> 형식으로 작성
		<%= %> 태그 : Expression(표현식)
					JSP에서 자바의 값을 HTML 화면에 출력(표현)하는 태그
					(JAVA 값 -> HTML 코드로 변환)
	 --%>
	<%
	//전달 받은 파라미터 얻어오기
	String inputName=request.getParameter("inputName");
	String inputId=request.getParameter("inputId");
	String inputPw=request.getParameter("inputPw");
	String inputPwCheck=request.getParameter("inputPwCheck");
	String inputAge=request.getParameter("inputAge");
	%>
	
	<%
	if(!inputPw.equals(inputPwCheck)) {%>
	<h1>비밀번호가 일치하지 않습니다</h1>
	<%}else if(Integer.parseInt(inputAge)<14) {%>
	 <h1>14세 이상만 가입이 가능합니다</h1>
	 <%} else { %>
	 <h3>가입 성공!</h3>
	 <ul>
	 	<li>이름 : <%= inputName %></li>
	 	<li>아이디 : <%= inputId %></li>
	 	<li>비밀번호 : <%=inputPw %></li>
	 	<li>나이 : <%= inputAge %></li>
	 </ul>
	 <%} %>
</body>
</html>
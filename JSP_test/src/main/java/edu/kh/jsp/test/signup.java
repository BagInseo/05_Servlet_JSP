package edu.kh.jsp.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jsp.test.dto.Member;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/signup_test")
public class signup extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path="/WEB-INF/views/error.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		List<Member> members = new ArrayList<Member>();
		
		
		members.add(new Member("user01","1111","김유저"));
		members.add(new Member("user02","2222","이유저"));
		members.add(new Member("user03","3333","박유저"));

		
		String inputName=req.getParameter("inputName");
		String inputId=req.getParameter("inputId");
		String inputPw=req.getParameter("inputPw");
		String inputPwCheck=req.getParameter("inputPwCheck");
		String inputAge=req.getParameter("inputAge");
		
		
		for(Member member :members) {
			if(inputPw!=inputPwCheck) {
				
			}
			if(member.getInputId().equals(inputId) ) {
				
				String message=String.format("[%s]는 이미 존재하는 ID입니다", inputId);
				HttpSession session= req.getSession();
				req.setAttribute("messags", message);
				resp.sendRedirect("/error");
				return;
			}
		}
		
		
		Member member=new Member(inputId,inputPw,inputName);
		members.add(member);
		
		String message = String.format("%s/%s 님이 가입 되었습니다 (비밀번호 : %s)"  , inputId, inputName, inputPw);
		req.setAttribute("message", message);
		String path = "/WEB-INF/views/success.jsp"; //주소 경로가 잘못됨
		req.getRequestDispatcher(path).forward(req, resp);
		
	
//		String path="/WEB-INF/views/signup_test_result.jsp";
//		RequestDispatcher dispatcher=req.getRequestDispatcher(path);
//		dispatcher.forward(req, resp);
	}
}

package edu.kh.test.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.test.model.dto.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/join") // @WebServlet("주소")에서 주소가 잘못됨 "/signup" => "/join"
public class JoinServlet  extends HttpServlet  {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Member> memberList = new ArrayList<Member>();
		memberList.add(new Member("test01", "1234", "김테스트"));
		memberList.add(new Member("test02", "5678", "최테스트"));
		memberList.add(new Member("test03", "qwer", "박테스트"));
		//-----------------------------------------------------------
		String memberId = req.getParameter("memberId");  //파라미터에서 얻어오는 매개변수의 이름이 잘못 되었다. 
		String memberPw = req.getParameter("memberPw"); //
		String memberName = req.getParameter("memberName"); //
		
		for(Member member : memberList) { 
			if(member.getMemberId().equals(memberId)) {
				HttpSession session = req.getSession();
				session.setAttribute("message", memberId + "은/는 이미 존재하는 아이디 입니다.");
				resp.sendRedirect("/");
				return;
			} 

		}
		Member member = new Member(memberId, memberPw, memberName);
		memberList.add(member);
		String message = String.format("%s/%s 님이 가입 되었습니다 (비밀번호 : %s)"  , memberId, memberName, memberPw);
		req.setAttribute("message", message);
		String path = "/WEB-INF/views/success.jsp"; //주소 경로가 잘못됨
		req.getRequestDispatcher(path).forward(req, resp);

		
	}

}

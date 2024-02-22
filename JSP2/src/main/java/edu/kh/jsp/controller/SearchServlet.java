package edu.kh.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/search")
public class SearchServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<String> nameList=new ArrayList<String>();
		nameList.add("김씨");
		nameList.add("이씨");
		nameList.add("박씨");
		nameList.add("유씨");
		nameList.add("장씨");
		nameList.add("조씨");
		nameList.add("오씨");
		nameList.add("손씨");
	
		
		//List에 입력 받은 이름(파라미터)가 존재하는지 확인
		String inputName=req.getParameter("inputName");
		String searchMessage=null;
		
		if(nameList.contains(inputName)) {//존재하는 경우
			 searchMessage=
					String.format("%s 은/는 %d번째 인덱스에 존재합니다.", inputName,nameList.indexOf(inputName));
			
			//forward 시 request가 유지된다!
			req.setAttribute("searchMessage", searchMessage);
			
			String path="/WEB-INF/views/practice/search_result.jsp";
			req.getRequestDispatcher(path).forward(req, resp);
			
		}else {//존재하지 않는 경우
			 searchMessage=
					String.format("%s 은/는 존재하지 않습니다.", inputName);
				
				HttpSession session=req.getSession();
				session.setAttribute("searchMessage", searchMessage);
				
				//"/error"redirect
				resp.sendRedirect("/error"); //redirect는 무조건 GET방식
			
		}

	}

}

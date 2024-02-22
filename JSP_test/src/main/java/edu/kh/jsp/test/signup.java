package edu.kh.jsp.test;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup_test")
public class signup extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path="/WEB-INF/views/signup_test_result.jsp";
		
		RequestDispatcher dispatcher=req.getRequestDispatcher(path);
		
		dispatcher.forward(req, resp);
	}
}

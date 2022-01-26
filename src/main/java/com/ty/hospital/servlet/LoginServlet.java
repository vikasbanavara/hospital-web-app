package com.ty.hospital.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.hospital.dao.UserDao;
import com.ty.hospital.dto.User;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
	
		UserDao userDao = new UserDao();
		User user = userDao.validateUser(email, password);
		if(user != null) {
			
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("name", user.getName());
			httpSession.setAttribute("role", user.getRole());
			
			if(user.getRole().equals("staff")) {
				httpSession.setAttribute("branchid", user.getBranch().getId());
				RequestDispatcher dispatcher = req.getRequestDispatcher("staff_home.jsp");
				dispatcher.forward(req, resp);
			} else if(user.getRole().equals("admin")) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("admin_home.jsp");
				dispatcher.forward(req, resp);
			} else if(user.getRole().equals("user")) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("user_home.jsp");
				dispatcher.forward(req, resp);
			}
			
		} else {
			PrintWriter pout = resp.getWriter();
			pout.print("<html><body><h1> Invalid email or password. Try again");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}
	}
}

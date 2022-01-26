package com.ty.hospital.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.hospital.dao.PersonDao;
import com.ty.hospital.dto.Person;

@WebServlet(value="/createperson")
public class CreatePersonServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
	
		Person person = new Person();
		person.setName(name);
		person.setEmail(email);
		person.setAge(Integer.parseInt(age));
		person.setGender(gender);
		person.setPhone(Long.parseLong(phone));
		
		PersonDao personDao = new PersonDao();
		personDao.createPerson(person);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("create_person.jsp");
		dispatcher.forward(req, resp);
	
	}
}

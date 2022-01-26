package com.ty.hospital.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.hospital.dao.EncounterDao;
import com.ty.hospital.dto.Encounter;

@WebServlet(value = "/getencounters")
public class GetEcountersServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String id = req.getParameter("id");
		EncounterDao dao = new EncounterDao();
		List<Encounter> encounters = dao.getEncounters();

		
		req.setAttribute("encounterList", encounters);
	
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("display_encounter.jsp");
		requestDispatcher.forward(req, resp);
		
	}
}

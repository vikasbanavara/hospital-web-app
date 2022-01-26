package com.ty.hospital.servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.hospital.dao.EncounterDao;
import com.ty.hospital.dto.Encounter;
@WebServlet(value = "/createencounter")
public class CreateEcnounterServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession httpSession = req.getSession();
		Integer branchId = (Integer)httpSession.getAttribute("branchid");
		String name = (String) httpSession.getAttribute("name");
		String reason = req.getParameter("reason");
		
		String dateTime = req.getParameter("admitDateTime");
		LocalDateTime admitDateTime = LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_DATE_TIME);
		
		
		Encounter encounter = new Encounter();
		encounter.setReason(reason);
		encounter.setCreatorName(name);
		encounter.setAdmitDateTime(admitDateTime);
		
		int personId = Integer.parseInt(req.getParameter("personid"));
		
		EncounterDao encounterDao = new EncounterDao();
		encounterDao.createEncounter(personId, branchId, encounter);
	}
	
}

package com.ty.hospital.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.hospital.dao.HospitalDao;
import com.ty.hospital.dto.Hospital;

@WebServlet(value="/createhospital")
public class CreateHospitalServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String website = req.getParameter("website");
		String gst = req.getParameter("gst");
		
		Hospital hospital = new Hospital();
		hospital.setName(name);
		hospital.setWebsite(website);
		hospital.setGst(gst);
		
		HospitalDao hospitalDao = new HospitalDao();
		hospitalDao.createHosptial(hospital);
	}
}

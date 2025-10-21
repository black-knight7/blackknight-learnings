package com.regapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.regapp.model.DAOservice;
import com.regapp.model.DAOserviceimpl;


@WebServlet("/saveLogin")
public class SaveLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SaveLoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		DAOservice service = new DAOserviceimpl();
		service.connectDB();
		service.saveRegistration(email,password);
	
	}

}

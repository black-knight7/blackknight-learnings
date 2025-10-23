package com.regapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.regapp.model.DAOservice;
import com.regapp.model.DAOserviceimpl;

@WebServlet("/verifyLogin")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		DAOservice service = new DAOserviceimpl();
		service.connectDB();
		boolean status = service.verifyLogin(email,password);
		if(status) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/Create_registration.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("error", "invalid username/password");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
	}

}

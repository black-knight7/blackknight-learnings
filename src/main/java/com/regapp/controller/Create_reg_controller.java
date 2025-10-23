package com.regapp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/saveReg")
public class Create_reg_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Create_reg_controller() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		Statement state = null;
		String user = request.getParameter("user");
		String mobile = request.getParameter("mobile");
		String city = request.getParameter("city");
		String email = request.getParameter("email");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/regdb","root","junaid@786");
			state = conn.createStatement();
			int rows = state.executeUpdate("insert into registration values('"+user+"','"+mobile+"','"+city+"','"+email+"');");
			if(rows>0){
			request.setAttribute("status", true);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/Create_registration.jsp");
			rd.forward(request, response);
			}
			else
			{
				request.setAttribute("status", false);
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/Create_registration.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(state!=null) 					
					state.close();
				if(conn!=null)
					conn.close();
				}
	
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}

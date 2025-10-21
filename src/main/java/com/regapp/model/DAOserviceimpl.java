package com.regapp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DAOserviceimpl implements DAOservice{
	private Connection conn;
	private Statement state;
	private PreparedStatement pstate = null;
	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/regdb","root","junaid@786");
			state = conn.createStatement();		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public boolean verifyLogin(String email, String password) {
		boolean result=false;
		try {
			String query = "select * from login where email=? and passkey=?";
			pstate = conn.prepareStatement(query);
			pstate.setString(1,email);
			pstate.setString(2,password);
			ResultSet rs = pstate.executeQuery();
			if(rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				state.close();
				if(pstate != null) {
					pstate.close();
				}
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public void saveRegistration(String email,String password) {
		try {
			String query = "insert into login values(?,?);";
			pstate = conn.prepareStatement(query);
			pstate.setString(1,email);
			pstate.setString(2,password);
			int save = pstate.executeUpdate();
			if(save>0) {
				System.out.println("insert successfull!");
			}
			else {
				System.out.println("insert failed");				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				state.close();
				if(pstate != null) {
					pstate.close();
				}
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteRegistration(String email) {
		try {
			String query ="delete from login where email=?";
			pstate = conn.prepareStatement(query);
			pstate.setString(1,email);
			int del = pstate.executeUpdate();
			if(del>0) {
				System.out.println("delete successful");
			}
			else
			{
				System.out.println("deleted failed");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				state.close();
				if(pstate != null) {
					pstate.close();
				}
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}

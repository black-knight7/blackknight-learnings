package com.regapp.model;

public interface DAOservice {
	public void connectDB();
	public boolean verifyLogin(String email,String password);
	public void saveRegistration(String email,String password);
	public void deleteRegistration(String email);
}

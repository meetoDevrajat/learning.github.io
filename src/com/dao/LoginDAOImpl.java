package com.dao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.util.ConnectionManager;
import java.sql.*;

public class LoginDAOImpl implements LoginDAO{

	ConnectionManager cm;
 public LoginDAOImpl() {
	// TODO Auto-generated constructor stub
	cm = new ConnectionManager();
}

	@Override
	public void showLoginForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	@Override
	public boolean validateUser(String username, String password) throws SQLException {
		
		
	
		Connection conn = cm.connect();
		System.out.println(conn);
		String q =  "Select  username and password from user where username=? and password=?";
		PreparedStatement st = conn.prepareStatement(q);
		st.setString(1,username);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();
		if(rs.next())
		{
			System.out.println("has values");
		return true;
		}
		else
			return false;
		
		
	}

	
	
}

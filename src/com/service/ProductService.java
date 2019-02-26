package com.service;

import com.dao.ProductDAOImpl;
import com.login.model.Product;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class ProductService {
	
	ProductDAOImpl p;
	ProductService ps;
	
	public ProductService()
	{
		p = new ProductDAOImpl();
		
	}

	public void getallbooks(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException
	{
		List<Product> list = p.listallproduct();
		HttpSession sc  =  request.getSession();
		sc.setAttribute("productdetails", list);
		RequestDispatcher  rd = request.getRequestDispatcher("Product.jsp");
		rd.forward(request, response);
		
		
		
	}
	
	public void addProduct(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher rd = request.getRequestDispatcher("AddProduct.jsp");
		rd.forward(request, response);
		
	}
	
	public void addnewProduct(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException
	{
		Product pd = new Product(Integer.parseInt(request.getParameter("rating")),request.getParameter("category"), 
				request.getParameter("description"),request.getParameter("brand"), request.getParameter("name"),Float.valueOf(request.getParameter("price")));
	int result = p.insertProduct(pd);
	RequestDispatcher rd = request.getRequestDispatcher("/ProductController");
	rd.forward(request, response);
	
		
	}
 public void removeproduct(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException
 {
	 
	 int result = p.deleteProduct(request, response);
	 RequestDispatcher rd = request.getRequestDispatcher("/ProductController");
	 rd.forward(request, response);
	 
	 
 }
 
 public void viewproduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException
 {
	 String desc = p.view(request.getParameter("id"));
		HttpSession sc  =  request.getSession();
		sc.setAttribute("productview", desc);
		System.out.println(desc);
	 RequestDispatcher rd = request.getRequestDispatcher("ViewProduct.jsp");
	 rd.forward(request, response);
	
	 
	 
 }
 public void backbutton(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
	 List<Product> list = p.listallproduct();
		HttpSession sc  =  request.getSession();
		sc.setAttribute("productdetails", list);
		RequestDispatcher  rd = request.getRequestDispatcher("Product.jsp");
		rd.forward(request, response);
		
	 
		
		
	}
 
}

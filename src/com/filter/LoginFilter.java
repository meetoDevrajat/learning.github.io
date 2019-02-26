package com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LoginDAOImpl;
import com.mysql.fabric.Response;
import com.dao.*;
/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/ProductController")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
	
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		PrintWriter out = response.getWriter();
		LoginDAOImpl lb = new LoginDAOImpl();
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		boolean flag = false;
		
		try {
			flag  = lb.validateUser(username, password);
			System.out.println(flag);
			if(flag == true)
				{
				System.out.println("I am in validate login"+flag);
				out.println("Validate user");
				
				
				chain.doFilter(request, response);
				}
			else
			{
				System.out.println("Invalid user");
			
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
		// pass the request along the filter chain
		
	



	/**
	 * 
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig)  {
		// TODO Auto-generated method stub
	}

}

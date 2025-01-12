package com.Leucine;

import java.io.IOException;

import com.Leucine.Tables.User123;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class Login extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String id=req.getParameter("username");
		String pwd=req.getParameter("password");
		String role=req.getParameter("role");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lokesh");
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();
	    
	    et.begin();
	    User123 u=em.find(User123.class, Integer.parseInt(id));
	    if(((Integer.parseInt(id))== u.getId()) && pwd.equals(u.getPwd()) && role.equals(role)) {
	    	if(role.equalsIgnoreCase("Student")) {
	    		RequestDispatcher rd = req.getRequestDispatcher("StudentRegistrationForm.html");
		        rd.include(req, resp);
	    	}
	    	else if(role.equalsIgnoreCase("Admin")) {
	    		RequestDispatcher rd = req.getRequestDispatcher("AdminRegistrationForm.html");
		        rd.include(req, resp);
	    	}
	    	else if(role.equalsIgnoreCase("Faculty")) {
	    		RequestDispatcher rd = req.getRequestDispatcher("FacultyRegistrationForm.html");
		        rd.include(req, resp);
	    	}
	    	else {
	    		RequestDispatcher rd = req.getRequestDispatcher("HomePage.html");
		        rd.include(req, resp);
	    	}
	    }
	}
	

}

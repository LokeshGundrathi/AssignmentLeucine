package com.Leucine;

import java.io.IOException;
import java.io.PrintWriter;

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

@SuppressWarnings("serial")
@WebServlet("/user")
public class UserRegistration extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		
		String id=req.getParameter("id");
		String uname=req.getParameter("username");
		String pwd=req.getParameter("password");
		String role=req.getParameter("role");
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String phno=req.getParameter("phone");
		
		
		User123 u =new User123();
		u.setId(Integer.parseInt(id));
		u.setUname(uname);
		u.setPwd(pwd);
		u.setRole(role);
		u.setName(name);
		u.setEmail(email);
		u.setPhno(phno);
		
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("lokesh");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		boolean isInserted = false;

		try {
		   et.begin();
		   em.persist(u);
		   et.commit();
		   isInserted = true;
		} catch (Exception ec) {
		    em.getTransaction().rollback(); 
		    isInserted = false; 
		}

		if(isInserted) {
			
			RequestDispatcher rd=req.getRequestDispatcher("HomePage.html");
			rd.include(req, resp);
		}
		else {
			pw.println("<h1>Provide valid details</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("UserRegistrationForm.html");
			rd.include(req, resp);
		}
	}
	

}

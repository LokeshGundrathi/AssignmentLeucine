package com.Leucine;

import java.io.IOException;

import com.Leucine.Tables.AdminstrationTable;
import com.Leucine.Tables.Department;
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


@WebServlet("/admin")
public class Adminstration extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String id=req.getParameter("id");
		String deptno=req.getParameter("deptno");
		
        AdminstrationTable a=new AdminstrationTable();
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("lokesh");
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();
	    
	    User123 u=em.find(User123.class, Integer.parseInt(id));
	    if(u!=null) {
	    	a.setUser(u);
	    }
	    Department d=em.find(Department.class, Integer.parseInt(deptno));
	    if(d!=null) {
	    	a.setDept(d);
	    }
	    
	    boolean isInserted = false;

	    // Try inserting the student entity into the database
	    try {
	        et.begin();
	        em.persist(a);
	        et.commit();
	        isInserted = true;
	    } catch (Exception ec) {
	        em.getTransaction().rollback();  // Roll back the transaction in case of error
	        ec.printStackTrace();  // Log the error for debugging
	        isInserted = false;
	    }

	    // Redirect based on whether the insertion was successful
	    if (isInserted) {
	        RequestDispatcher rd = req.getRequestDispatcher("DisplayAdminstrator.jsp");
	        rd.include(req, resp);
	    } else {
	        RequestDispatcher rd = req.getRequestDispatcher("AdminRegistrationForm.html");
	        rd.include(req, resp);
	    }

	    // Clean up the entity manager
	    em.close();
	    emf.close();
	}

}

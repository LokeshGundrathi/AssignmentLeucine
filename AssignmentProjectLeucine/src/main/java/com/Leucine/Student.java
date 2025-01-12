package com.Leucine;

import java.io.IOException;

import com.Leucine.Tables.CourseTable;
import com.Leucine.Tables.Department;
import com.Leucine.Tables.StudentTable;
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

@WebServlet("/student")
public class Student extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	resp.setContentType("text/html");
	// Get form parameters
    String user = req.getParameter("id");
    String dept = req.getParameter("deptno");
    String year = req.getParameter("year");
    String cour=req.getParameter("courid");

    // Create a new StudentTable entity
    StudentTable s = new StudentTable();

    // Set up EntityManager and transaction
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("lokesh");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();

    // Fetch User123 and Department by their IDs
    User123 u1 = em.find(User123.class, Integer.parseInt(user));
    if (u1 != null) {
        s.setUser(u1);
    }

    Department d = em.find(Department.class, Integer.parseInt(dept));
    if (d != null) {
        s.setDept(d);
    }
 CourseTable c=em.find(CourseTable.class, Integer.parseInt(cour));
 if(c!=null)
	 s.setCour(c);
    s.setYear(year);

    boolean isInserted = false;

    // Try inserting the student entity into the database
    try {
        et.begin();
        em.persist(s);
        et.commit();
        isInserted = true;
    } catch (Exception ec) {
        em.getTransaction().rollback();  // Roll back the transaction in case of error
        ec.printStackTrace();  // Log the error for debugging
        isInserted = false;
    }

    // Redirect based on whether the insertion was successful
    if (isInserted) {
        RequestDispatcher rd = req.getRequestDispatcher("DisplayStudents.jsp");
        rd.include(req, resp);
    } else {
        RequestDispatcher rd = req.getRequestDispatcher("StudentRegistrationForm.html");
        rd.include(req, resp);
    }

    // Clean up the entity manager
    em.close();
    emf.close();
}
}


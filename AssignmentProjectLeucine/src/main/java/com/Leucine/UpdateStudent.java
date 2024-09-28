package com.Leucine;

import java.io.IOException;
import java.io.PrintWriter;

import com.Leucine.Tables.User123;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/UpdateUserServlet")
public class UpdateStudent extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter pw=resp.getWriter();
	resp.setContentType("text/html");
	PrintWriter pw1=resp.getWriter();
	String userId = req.getParameter("userId");
    String name = req.getParameter("name");
    String email = req.getParameter("email");

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("lokesh");
    EntityManager em = emf.createEntityManager();
    EntityTransaction transaction = em.getTransaction();

    String message;

    transaction.begin();
    try {
        User123 user = em.find(User123.class, userId);
        if (user != null) {
            if (name != null && !name.isEmpty()) {
                user.setName(name); // Assuming there is a setName method
            }
            if (email != null && !email.isEmpty()) {
                user.setEmail(email); // Assuming there is a setEmail method
            }
            em.merge(user);
            message = "User details updated successfully.";
        } else {
            message = "User not found.";
        }
        transaction.commit();
    } catch (Exception e) {
        transaction.rollback();
        message = "Error updating user: " + e.getMessage();
    } finally {
        em.close();
        emf.close();
    }
   pw1.println(message);
}
}

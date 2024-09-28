<!DOCTYPE html>
<%@page import="com.Leucine.Tables.User123"%>
<%@page import="jakarta.persistence.EntityTransaction"%>
<%@page import="jakarta.persistence.EntityManager"%>
<%@page import="jakarta.persistence.Persistence"%>
<%@page import="jakarta.persistence.EntityManagerFactory"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f4f4f4;
        }
        .registration-form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
            margin: 20px auto;
        }
        .registration-form h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        .form-group input {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }
        .form-group button {
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        .form-group button:hover {
            background-color: #45a049;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 12px 15px;
            text-align: center;
        }
        thead {
            background-color: #007BFF;
            color: #fff;
        }
        tbody tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tbody tr:hover {
            background-color: #f1f1f1;
        }
        th {
            font-size: 1.1em;
        }
        caption {
            margin: 10px 0;
            font-size: 1.2em;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="registration-form">
        <h2>Enter Student ID</h2>
        <form action="DisplayStudents.jsp" method="post">
            <div class="form-group">
                <label for="id">Student ID:</label>
                <input type="text" id="id" name="id" required>
            </div>
            <div class="form-group">
                <button type="submit">Submit</button>
            </div>
        </form>
    </div>

    <%
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lokesh");
        EntityManager em = emf.createEntityManager();
        String studentId = request.getParameter("id");

        if (studentId != null && !studentId.isEmpty()) {
            try {
                int id = Integer.parseInt(studentId); // Parsing student ID to integer
                User123 u = em.find(User123.class, id);

                if (u != null) {
                    // Display user details in the table
    %>  
                    <table>
                        <thead>
                            <tr>
                                <th>UID</th>
                                <th>UNAME</th>
                                <th>ROLE</th>
                                <th>NAME</th>
                                <th>EMAIL</th>
                                <th>PHONENUMBER</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><%= u.getId() %></td>
                                <td><%= u.getUname() %></td>
                                <td><%= u.getRole() %></td>
                                <td><%= u.getName() %></td>
                                <td><%= u.getEmail() %></td>
                                <td><%= u.getPhno() %></td>
                            </tr>
                        </tbody>
                    </table>
    <%
                } else {
                    out.println("<p>No user found with the given ID.</p>");
                }
            } catch (NumberFormatException e) {
                out.println("<p>Invalid student ID format. Please enter a valid number.</p>");
            } finally {
                em.close();
                emf.close();
            }
        }
    %>
</body>
</html>

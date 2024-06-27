<%-- 
    Document   : editHelper
    Created on : 19-Jun-2024, 17:53:57
    Author     : DELL
--%>

<%@page import="data.Student"%>
<%@page import="java.sql.Connection"%>
<%@page import="data.ConnManiDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <title>Edit Student</title>
    </head>
    <body>
        <%
            Connection c = (Connection) request.getServletContext().getAttribute("dbConnection");
            int id = Integer.parseInt(request.getParameter("id"));
            ConnManiDB cmdb = new ConnManiDB();
            Student s = cmdb.getRecord(id, c);
        %>
        
        <% if (s != null) { %>
        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-body">
                            <form action="editStudent.jsp" method="POST">
                                <div class="form-group">
                                    <label for="ID">ID</label>
                                    <input type="text" id="ID" name="id" class="form-control" value="<%= s.getId() %>" readonly>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="firstName">First Name</label>
                                        <input type="text" id="firstName" name="fname" class="form-control" value="<%= s.getFname() %>">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="lastName">Last Name</label>
                                        <input type="text" id="lastName" name="lname" class="form-control" value="<%= s.getLname() %>">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="email">Email</label>
                                    <input type="email" id="email" name="email" class="form-control" value="<%= s.getEmail() %>">
                                </div>
                                <div class="form-group">
                                    <label for="psw">Password</label>
                                    <input type="password" id="psw" name="pass" class="form-control" value="<%= s.getPass() %>">
                                </div>
                                <div class="form-group">
                                    <label>Gender</label><br>
                                    <div class="form-check form-check-inline">
                                        <input type="radio" id="male" name="gender" value="Male" class="form-check-input">
                                        <label for="male" class="form-check-label">Male</label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input type="radio" id="female" name="gender" value="Female" class="form-check-input">
                                        <label for="female" class="form-check-label">Female</label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="country">Country</label>
                                    <select id="country" name="country" class="form-control">
                                        <option value="Egypt">Egypt</option>
                                        <option value="Palestine">Palestine</option>
                                        <option value="Sudan">Sudan</option>
                                        <option value="Syria">Syria</option>
                                    </select>
                                </div>
                                <button type="submit" class="btn btn-success">Edit <i class="bi bi-person-fill-add"></i></button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <% } else { response.sendRedirect("errorPage.jsp"); } %>
    </body>
</html>

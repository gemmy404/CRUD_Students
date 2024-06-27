<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="data.ConnManiDB"%>
<%@page import="data.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>View Student</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">All Students</h2>
    <%--<jsp:useBean id="cmdb" class="data.ConnManiDB" scope="page" />--%>
    <%--<jsp:setProperty name="cmdb" property="*" />--%>

    <%
        ConnManiDB cmdb = new ConnManiDB();
        Connection c = (Connection) request.getServletContext().getAttribute("dbConnection");
        List<Student> list = cmdb.getTable(c);
        request.setAttribute("list", list);
    %>

    <div class="table-responsive">
        <table class="table table-bordered">
            <thead class="thead-dark">
            <tr align="center">
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Password</th>
                <th>Gender</th>
                <th>Country</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="s" items="${list}">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.fname}</td>
                    <td>${s.lname}</td>
                    <td>${s.email}</td>
                    <td>${s.pass}</td>
                    <td>${s.gender}</td>
                    <td>${s.country}</td>
                    <td><a href="editHelper.jsp?id=${s.id}" class="btn btn-primary"><i class="bi bi-pencil"></i> Edit</a></td>
                    <td><a href="deleteStudent.jsp?id=${s.id}" class="btn btn-danger"><i class="bi bi-trash"></i> Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <a href="studentForm.html" class="btn btn-success">Add Student <i class="bi bi-person-fill-add"></i></a>
</div>

<!-- jQuery and Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>

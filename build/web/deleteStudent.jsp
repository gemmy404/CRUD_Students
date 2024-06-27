<%@page import="java.sql.Connection"%>
<%@page import="data.ConnManiDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Student</title>
    </head>
    <body>
        <jsp:useBean id="s" class="data.Student" scope="page">
            <jsp:setProperty name="s" property="*" />
        </jsp:useBean>
        
        <%
            Connection c = (Connection) request.getServletContext().getAttribute("dbConnection");
            ConnManiDB cmdb = new ConnManiDB();
            cmdb.delete(s, c);
            response.sendRedirect("viewStudent.jsp");
        %>
    </body>
</html>

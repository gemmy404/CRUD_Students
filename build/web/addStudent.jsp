<%@page import="java.sql.Connection"%>
<%@page import="data.ConnManiDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Student</title>
</head>
<body>

    <jsp:useBean id="s" class="data.Student" scope="request">
        <jsp:setProperty name="s" property="*" />
    </jsp:useBean>
    
    <% 
        ConnManiDB cmdb = new ConnManiDB();
        Connection c = (Connection) request.getServletContext().getAttribute("dbConnection");
        int n = cmdb.insert(s, c);
        
        
        if (n > 0) {
            response.sendRedirect("successPage.jsp");
        } else {
            response.sendRedirect("errorPage.jsp");
        }
    %>
</body>
</html>

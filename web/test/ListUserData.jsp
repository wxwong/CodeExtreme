<%-- 
    Document   : ListUserData
    Created on : Jun 26, 2012, 3:21:33 PM
    Author     : Melvrick Goh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,model.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List User Data</title>
    </head>
    <body>
        <% 
            ServletContext context = getServletContext();
            SystemUserDAO dao = (SystemUserDAO) context.getAttribute("systemUserDAO");
            ArrayList<User> users = (ArrayList<User>) dao.getUserList();
        %>
        <h1>User Data File</h1>
        <table><th>Username</th><th>Password</th>
        <% 
            for (User u: users){
                out.println("<tr><td>"+u.getUsername()+"</td><td>"+u.getPassword()+"</td></tr>");
            }
        %>
        </table>
    </body>
</html>

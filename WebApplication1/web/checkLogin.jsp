<%-- 
    Document   : checkLogin
    Created on : Jun 19, 2012, 11:34:03 AM
    Author     : Janan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Check Login</title>
  </head>
  <body>
    <%
      String username = request.getParameter("username");
      String password = request.getParameter("password");
      out.println("Checking login<br>");
      if (username == null || password == null) {
        out.print("Invalid paramters ");
      }

      // change to checking of database
      if (username.toLowerCase().trim().equals("janan") && password.toLowerCase().trim().equals("janan")) {
        out.println("Welcome " + username + " <a href=\"index.jsp\">Back to main</a>");
        session.setAttribute("username", username);
      } else {
        out.println("Invalid username and password<br />");
        out.println("<a href='login.jsp'>Back</a>");
      }
    %> 
  </body>
</html>

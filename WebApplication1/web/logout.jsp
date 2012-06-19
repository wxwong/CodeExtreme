<%-- 
    Document   : logout
    Created on : Jun 19, 2012, 11:33:37 AM
    Author     : Janan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Logout</title>
  </head>
  <body>
    <%
      String username = (String)session.getAttribute("username");
      if(username != null) {
        out.println(username + " logged out, <a href=\"index.jsp\">Back</a>");
        session.removeAttribute("username");
      } else {
        out.println("You are already not login <a href=\"index.jsp\">Back</a>");
      }
    %>  
  </body>
</html>

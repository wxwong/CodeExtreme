<%-- 
    Document   : login
    Created on : Jun 19, 2012, 11:27:59 AM
    Author     : Janan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login page</title>
  </head>
  <body>
    <H1>LOGIN FORM</H1>
    <%
      String myname =  (String)session.getAttribute("username");

      if(myname!=null) {
          out.println("Welcome  " + myname + "  , <a href=\"logout.jsp\" >Logout</a>");
      } else {
    %>
    
    <form action="checkLogin.jsp">
        <table>
            <tr>
                <td> Username  : </td><td> <input name="username" size=15 type="text" /> </td> 
            </tr>
            <tr>
                <td> Password  : </td><td> <input name="password" size=15 type="text" /> </td> 
            </tr>
        </table>
        <input type="submit" value="login" />
     </form>
    
    <%  } %>
  </body>
</html>


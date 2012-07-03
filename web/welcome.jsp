<%-- 
    Document   : welcome
    Created on : Jun 24, 2012, 3:21:01 PM
    Author     : Melvrick Goh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>The Connoisseurs</title>
    </head>
    <body>
        <h1>Register/Login</h1>
        <form action="login.do">
        <table>
            <tr>
                <td> Username  : </td><td> <input name="username" size=15 type="text" /> </td> 
            </tr>
            <tr>
                <td> Password  : </td><td> <input name="password" size=15 type="text" /> </td> 
            </tr>
        </table>
        <input type="submit" value="login" />
        
        </br></br>
        <a href="UsernameVerificationServlet">Register</a>
        <a href="test/ListUserData.jsp">List User Data</a>
     </form>

    </body>
</html>

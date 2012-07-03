<%-- 
    Document   : Register
    Created on : Jul 3, 2012, 4:25:20 PM
    Author     : Melvrick Goh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Register Form JSP</h1>
        <% 
            ArrayList<String> errors;
            ArrayList<Integer> DAYS = new ArrayList<Integer>();
            ArrayList<Integer> MONTHS = new ArrayList<Integer>();
            ArrayList<Integer> YEARS = new ArrayList<Integer>();
            for (int i = 1;i<13; i++ ){
                DAYS.add(i);
            }
            for (int i=1;i<32;i++){
                MONTHS.add(i);
            }
            for (int i=1900;i<2013;i++){//Static needs to be updated with current time check
                YEARS.add(i);
            }
            try{
                errors = (ArrayList<String>) request.getAttribute("errorMsgs");
        %> 
        
        <form action='register.do' method='POST'>
        
        <%  
            String username = request.getParameter("username");
            if (username==null){
                username="";
            }
        
            out.println("Username: <input type='text' name='username' value='"+username+"' autocomplete='off' id='username' />");
            
            if (errors!=null){
                for (String s: errors){
                    if (s.charAt(0)=='1'){
                        out.println("<font color='red'>*"+s.substring(1)+"</font>");
                        break;
                    }
                }
             }
        %>
        </br>
        <div id="usernameReport" class="outputTextArea"></div>

                
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script>
        $(document).ready(function() {
            $("#username").change(function() {
                $.get("UsernameVerificationServlet", $(this).serialize(), function(data) {
                    if (!data.valid) {
                        $("#usernameReport").text("Duplicate username, choose another");
                    }
                });
            });
        });
    </script>
                
                
        <%
            
            }finally{ 
                out.close();
            }
        %>
    </body>
</html>

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;

/**
 *
 * @author Melvrick Goh
 */
public class RegisterFormServlet extends HttpServlet {
    private ArrayList<String> errors;
    private ArrayList<Integer> DAYS = new ArrayList<Integer>();
    private ArrayList<Integer> MONTHS = new ArrayList<Integer>();
    private ArrayList<Integer> YEARS = new ArrayList<Integer>();
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //Instantiating the Default Lists for Selection
        for (int i = 1;i<13; i++ ){
            DAYS.add(i);
        }
        for (int i=1;i<32;i++){
            MONTHS.add(i);
        }
        for (int i=1900;i<2013;i++){//Static needs to be updated with current time check
            YEARS.add(i);
        }
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            errors = (ArrayList<String>) request.getAttribute("errorMsgs");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>RegisterFormServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterFormServlet at " + request.getContextPath() + "</h1>");
            out.println("<form action='register.do' method='POST'>");
            /*if(errors!=null){
                for (String a:errors){
                    out.println("</br>"+a);
                }
            }*/
            
            //Username
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
            out.println("</br>");
            
            
            /*out.println("<div id=\"usernameReport\" class=\"outputTextArea\"></div>");

                out.println("<script type=\"text/javascript\" src=\"jquery-1.4.4.min.js\"></script>");
                out.println("<script type=\"text/javascript\">");
                out.println("$(document).ready(function() {");
                        out.println("$(\"#username\").click(function(){");
                                out.println("$username = document.getElementById(\"username\").value;");
                                out.println("$.post(\"UsernameVerificationServlet\", {username:$username}, function(data) {");
                                        out.println("alert(data);");
                                        out.println("$(\"#usernameReport\").html(data);");
                                out.println("});");
                        out.println("});");
                out.println("});");
                out.println("</script>");*/
            
            
            
            
            
            
            //Password
            String password = request.getParameter("password");
            if (password==null){
                password="";
            }
            out.println("Password: <input type='password' name='password' value='"+password+"' autocomplete='off'/>");
            if (errors!=null){
                for (String s: errors){
                    if (s.charAt(0)=='2'){
                        out.println("<font color='red'>*"+s.substring(1)+"</font>");
                        break;
                    }
                }
            }
            out.println("</br>");
            
            //Email
            String email = request.getParameter("email");
            if (email==null){
                email="";
            }
            out.println("Email: <input type='text' name='email' value='"+email+"' autocomplete='off'/>");
            if (errors!=null){
                for (String s: errors){
                    if (s.charAt(0)=='3'){
                        out.println("<font color='red'>*"+s.substring(1)+"</font>");
                        break;
                    }
                }
            }
            out.println("</br>");
            
            //First Name
            String firstName = request.getParameter("firstName");
            if (firstName==null){
                firstName="";
            }
            out.println("First Name: <input type='text' name='firstName' value='"+firstName+"' autocomplete='off'/>");
            if (errors!=null){
                for (String s: errors){
                    if (s.charAt(0)=='4'){
                        out.println("<font color='red'>*"+s.substring(1)+"</font>");
                        break;
                    }
                }
            }
            
            //Last Name
            String lastName = request.getParameter("lastName");
            if (lastName==null){
                lastName="";
            }
            out.println("Last Name: <input type='text' name='lastName' value='"+lastName+"' autocomplete='off'/>");
            if (errors!=null){
                for (String s: errors){
                    if (s.charAt(0)=='5'){
                        out.println("<font color='red'>*"+s.substring(1)+"</font>");
                        break;
                    }
                }
            }
            out.println("</br>");
            
            //Date of Birth
            String day = request.getParameter("day");
            String month = request.getParameter("month");
            String year = request.getParameter("year");
                //Select bar DAY
                out.println("Date of Birth (DD/MM/YYYY): <select name='day'>");
                for (int d: DAYS){
                    out.println("<option value='"+d + "'");
                    if (day!=null && Integer.parseInt(day)==d){
                        out.println(" SELECTED");
                    }
                    out.println(">"+d+"</option>");
                }
                out.println("</select>");
                //Select bar MONTH
                out.println("<select name='month'>");
                for (int m: MONTHS){
                    out.println("<option value='"+m + "'");
                    if (month!=null && Integer.parseInt(month)==m){
                        out.println(" SELECTED");
                    }
                    out.println(">"+m+"</option>");
                }
                out.println("</select>");
                //Select bar YEAR
                out.println("<select name='year'>");
                for (int y: YEARS){
                    out.println("<option value='"+y + "'");
                    if (year!=null && Integer.parseInt(year)==y){
                        out.println(" SELECTED");
                    }
                    out.println(">"+y+"</option>");
                }
                out.println("</select>");
            out.println("</br>");
            
            //Address
            String address = request.getParameter("address");
            if (address==null){
                address="";
            }
            out.println("Address: <input type='text' name='address' value='"+address+"' autocomplete='off'/>");
            if (errors!=null){
                for (String s: errors){
                    if (s.charAt(0)=='6'){
                        out.println("<font color='red'>*"+s.substring(1)+"</font>");
                        break;
                    }
                }
            }
            out.println("</br>");
            out.println("<input type='submit' value='Submit' />");
            out.println("</form>");
            
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

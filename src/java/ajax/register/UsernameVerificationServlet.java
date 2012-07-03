/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ajax.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SystemUserDAO;
import model.User;

/**
 *
 * @author Melvrick Goh
 */
public class UsernameVerificationServlet extends HttpServlet {

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
        ServletContext context = request.getServletContext();
        SystemUserDAO dao = (SystemUserDAO) context.getAttribute("systemUserDAO");
        ArrayList<User> users = (ArrayList<User>) dao.getUserList();
        
        try {
            String username = request.getParameter("username");
            String report = verify(username,users);
            if (report.length()==0){
                out.println("No errors");  
            } else {
                out.println(report);
            }
        } finally {            
            out.flush();
            out.close();
        }
    }
    
    private String verify(String username,ArrayList<User> users){
        String respond = null;
        if (isAlphanumeric(username)&&username.length()>=8){
            for (User u : users){
                if (u.getUsername().equals(username)){
                    respond = "Username unavailable. Please select another";
                }
            }
        }else{
            respond = "Username has to be alphanumeric and at least 8 characters long";
        }
        
        return respond;
    }
    
    private boolean isAlphanumeric(String s){
        String expression = "^[0-9a-zA-Z]+$";
        Pattern p = Pattern.compile(expression);
        Matcher m = p.matcher(s);
        return m.matches();
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

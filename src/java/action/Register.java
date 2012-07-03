/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.SystemUserDAO;
import model.User;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Melvrick Goh
 */
public class Register extends org.apache.struts.action.Action {

    /*
     * forward name="success" path=""
     */
    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List errorMsgs = new ArrayList<String>();
        try{
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String day = request.getParameter("day");
            String month = request.getParameter("month");
            String year = request.getParameter("year");
            String address = request.getParameter("address");
            int[] dob = {Integer.parseInt(day),Integer.parseInt(month),Integer.parseInt(year)};
            if (username==null||username.trim().length()==0){
                errorMsgs.add("1Please enter your username");
            }else{
                if (isAlphanumeric(username)&&isValidLength(username)){}else{
                    errorMsgs.add("1Username has to be alphanumeric and at least 8 characters long");
                }
            }
            if (password==null||password.trim().length()==0){
                errorMsgs.add("2Please enter your password");
            }else{
                if (isValidLength(password)){}else{
                    errorMsgs.add("2Password is to be at least 8 characters long");
                }
            }
            if (email==null||email.trim().length()==0){
                errorMsgs.add("3Please enter your email");
            }else{
                if (isValidEmail(email)){}else{
                    errorMsgs.add("3Invalid email");
                }
            }
            if (firstName==null||firstName.trim().length()==0){
                errorMsgs.add("4Please enter your first name");
            }
            if (lastName==null||lastName.trim().length()==0){
                errorMsgs.add("5Please enter your username");
            }
            if (address==null||address.trim().length()==0){
                errorMsgs.add("6Please enter your address");
            }
            if ( ! errorMsgs.isEmpty() ) {
                request.setAttribute("errorMsgs", errorMsgs);
                return mapping.findForward("error");
            }
            
            // retrieve the "library" attribute from the session-scope
            ServletContext context = getServlet().getServletContext();
            SystemUserDAO dao = (SystemUserDAO)context.getAttribute("systemUserDAO");
            User user = dao.addUser(new User(firstName,lastName,username,password,dob,address,email));
            
            // Store the item on the request-scope
            request.setAttribute("user", user);
            return mapping.findForward("success");
        }catch (RuntimeException e){
            errorMsgs.add("An unexpected error: " + e.getMessage());
            request.setAttribute("errorMsgs", errorMsgs);
            return mapping.findForward("error");
        }
    }
    
    private boolean isValidEmail (String s){
        return s.contains("@");
    }
    
    private boolean isValidLength (String s){
        if (s.length()>=8){
            return true;
        }else{
            return false;
        }
    }
    private boolean isAlphanumeric (String s){
        String expression = "^[0-9a-zA-Z]+$";
        Pattern p = Pattern.compile(expression);
        Matcher m = p.matcher(s);
        return m.matches();
    }
}

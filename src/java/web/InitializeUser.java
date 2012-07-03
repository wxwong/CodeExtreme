/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import model.SystemUserDAO;

/**
 * Web application lifecycle listener.
 *
 * @author Melvrick Goh
 */
public class InitializeUser implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //throw new UnsupportedOperationException("Not supported yet.");
        ServletContext context = sce.getServletContext();
        String dataDirectory = context.getRealPath(context.getInitParameter("userData"));
        System.out.println(dataDirectory);
        if (dataDirectory!=null){
            SystemUserDAO systemUserDAO = new SystemUserDAO(dataDirectory);
            context.setAttribute("systemUserDAO",systemUserDAO);
            context.log("systemUserDAO Library initialized");
        } else {
            context.log("systemUserDAO Library has not been initialized");
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}

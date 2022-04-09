package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ActorsDao;
import model.Actor;


 
@WebServlet("/actorServlet")
public class MainServlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    // This method is called by the servlet container to process a 'post' request
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        handleRequest(req, resp);
        
    }
 
    public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
 
        // Reading post parameters from the request
    	String param1 = req.getParameter("actor_name");  
    	
    	System.out.println(param1);
        // Checking for null and empty values
        if(param1 == null || "".equals(param1)) {
        	System.out.println("111");
            req.setAttribute("error_message", "Please enter Value");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
        	System.out.println("222");
        	ActorsDao actorsfound = new ActorsDao();
        	List<Actor> actorList = actorsfound.getActors(param1);
        	//actorList resFound = Util.getRestaurant(param1);
            
        	 
        	 
        	    if (actorList == null || actorList.size() == 0) {
        	   System.out.println("232");
            	req.setAttribute("error_message", "There is no actor!");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            } else {
                req.setAttribute("actors_details", actorList);
                req.getRequestDispatcher("/view.jsp").forward(req, resp);

            }   
            
        }       
    }
    
 
    
}
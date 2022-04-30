package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import dao.LanguageSearchDao;
import model.Movies;

/**
 * Servlet implementation class CategorySearch
 */
@WebServlet("/CategorySearch")
public class CategorySearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		categorySearch(request, response);
	}
	
    public void categorySearch(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
      	 
        // Reading post parameters from the request
    	System.out.println("INFO:4 Category is" + req.getParameter("categorySearch"));
    	String languageName = req.getParameter("categorySearch"); 
    	System.out.println(languageName);
        // Checking for null and empty values
    	List<Movies> movieList;
    	CategoryDao moviesfound = new CategoryDao();
    	movieList = moviesfound.getCategory(languageName);

        
	    if (movieList == null || movieList.size() == 0) {
	    	req.setAttribute("error_message", "Sorry, Movies not found :: Search again");
	        req.getRequestDispatcher("/movies.jsp").forward(req, resp);
	    } else {
	    	req.setAttribute("movieDetails", movieList);
	        req.getRequestDispatcher("/movies.jsp").forward(req, resp);

	    }        
	    System.out.println("INFO:4.3 Category is" + req.getParameter("categorySearch") + " complete");
    }

}

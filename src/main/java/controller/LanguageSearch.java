package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LanguageSearchDao;
import model.Movies;

/**
 * Servlet implementation class LanguageSearch
 */
@WebServlet("/LanguageSearch")
public class LanguageSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		languageSearch(request, response);
	}
	
    public void languageSearch(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
      	 
        // Reading post parameters from the request
    	System.out.println("INFO:2 Language is" + req.getParameter("languageSearch"));
    	String languageName = req.getParameter("languageSearch"); 
    	System.out.println(languageName);
        // Checking for null and empty values
    	List<Movies> movieList;
    	LanguageSearchDao moviesfound = new LanguageSearchDao();
    	movieList = moviesfound.getMovies(languageName);

        
	    if (movieList == null || movieList.size() == 0) {
	    	req.setAttribute("error_message", "Sorry, Movies not found :: Search again");
	        req.getRequestDispatcher("/movies.jsp").forward(req, resp);
	    } else {
	    	req.setAttribute("movieDetails", movieList);
	        req.getRequestDispatcher("/movies.jsp").forward(req, resp);

	    }        
	    System.out.println("INFO:2.3 Language is" + req.getParameter("languageSearch") + " complete");
    }

}

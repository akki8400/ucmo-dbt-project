package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MovieSearchDao;
import model.Movies;

/**
 * Servlet implementation class MovieDetails
 */
@WebServlet("/MovieDetails")
public class MovieDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	       handleDetails(request, response);
	}

    public void handleDetails(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
   	 
        // Reading post parameters from the request
    	
    	System.out.println(req.getHeaderNames());
    	String movieName = req.getParameter("action_search"); 
    	System.out.println(movieName);
    	System.out.println("info: " + movieName);
        // Checking for null and empty values
    	List<Movies> movieList;
    	MovieSearchDao moviesfound = new MovieSearchDao();
    	movieList = moviesfound.getMovies(movieName);
    	req.setAttribute("movieDetails", movieList);
        req.getRequestDispatcher("/movieDetail.jsp").forward(req, resp);

    }
}

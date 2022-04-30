package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ActorsDao;
import dao.MovieSearchDao;
import model.Actor;
import model.Movies;

/**
 * Servlet implementation class MovieSearch
 */
@WebServlet("/MovieSearch")
public class MovieSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        handleRequest(req, resp);
        
    }
    public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
    	 
        // Reading post parameters from the request
  
    	System.out.println("INFO:3 Movie Search" + req.getParameter("searchName"));
    	String movieName = req.getParameter("searchName"); 
    	System.out.println("Movie to search" + movieName);
    	List<Movies> movieList;
    	MovieSearchDao moviesfound = new MovieSearchDao();
    	movieList = moviesfound.getMovies(movieName);

        System.out.println(232);
	    if (movieList == null || movieList.size() == 0) {
	    	req.setAttribute("error_message", "Sorry, Movies not found :: Search again");
	        req.getRequestDispatcher("/movies.jsp").forward(req, resp);
	    } else {
	    	req.setAttribute("movieDetails", movieList);
	        req.getRequestDispatcher("/movies.jsp").forward(req, resp);
	    }  
    }

}

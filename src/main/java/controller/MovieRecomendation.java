package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import dao.MovieSearchDao;
import dao.RecommendationDao;
import model.Category;
import model.Movies;

/**
 * Servlet implementation class MovieRecomendation
 */
@WebServlet("/MovieRecomendation")
public class MovieRecomendation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		movieRecomend(request, response);
	}

    public void movieRecomend(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
   	 
        // Reading post parameters from the request
 
    	System.out.println("INFO ::1 Recommendation Call");
    	String movieName = req.getParameter("recommendation"); 
    	System.out.println(movieName);
    	List<Movies> movieList;
    	RecommendationDao moviesfound = new RecommendationDao();
    	movieList = moviesfound.getMovies();
    	System.out.println(movieList);
        req.setAttribute("movieDetails", movieList);
        
        // category search
        List<Category> categoryList;
        CategoryDao categoryfound = new CategoryDao();
        
        categoryList = categoryfound.getCategory();
        req.setAttribute("categoryList", categoryList);
        
        req.getRequestDispatcher("/recommendation.jsp").forward(req, resp);
    	System.out.println("INFO :: 1.3 Recommendation Call Complete");
    }

}

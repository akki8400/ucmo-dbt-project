package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Category;
import model.Movies;

public class CategoryDao {
	String mysqlConnectionUrl = "jdbc:mysql://localhost:3306/sakila?useSSL=false";
	String mysqlUser = "root";
	String mysqlPwd = "123456789";
	//String movieName = "ACE";
	public List<Category> getCategory(){
	
		
	
	List<Category> categoryList = new ArrayList();
	
	String searchQuery1 = "SELECT name FROM sakila.category;";
	
	System.out.println("INFO :: 4.2 Recommendation Call Dao ");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}

	try (Connection connection = DriverManager
			.getConnection(mysqlConnectionUrl, mysqlUser, mysqlPwd);

			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection
					.prepareStatement(searchQuery1)) {
		//preparedStatement.setString(1, movieName);
		//preparedStatement.setString(2, loginBean.getPassword());
		

		System.out.println(preparedStatement);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {   
			Category newCat = new Category(); 
			newCat.setCategory(rs.getString(1));             
		
			 categoryList.add(newCat);
			}
		
		//:TODO loop here for results

	} catch (SQLException e) {
		// process sql exception
		e.printStackTrace();
	}
	return categoryList;	
	}
	public List<Movies> getCategory(String category) {
		//category = category == null ? "ACADEMY DINOSAUR" : category;
		List<Movies> movieList = new ArrayList();
		
		String languageQuery1 = "SELECT f.title as 'film', "
				+ "f.description as 'description', " 
				+ "f.release_year as 'year', "
				+ "f.rental_duration as 'rental_duration', "
				+ "f.rental_rate as 'rate', "
				+ "f.special_features as 'features', "
				+ "f.length as 'length', "
				+ "f.rating as 'rating', "
				+ "la.name as 'language', "
				+ "ac.first_name as 'actor_firstname', "
				+ "ac.last_name as 'actor_lastname', "
				+ "cat.name as 'category' "
				+ "FROM film as f "
				+ "join language as la on f.language_id = la.language_id " 
				+ "JOIN film_actor as fa on f.film_id = fa.film_id "
				+ "JOIN actor as ac on fa.actor_id = ac.actor_id "
				+ "JOIN film_category as flc on flc.film_id = f.film_id "
				+ "JOIN category as cat on cat.category_id = flc.category_id "
				+ "where cat.name = ? "
				+ "GROUP BY f.title;";
		
	    System.out.println("INFO:4.5 category is " + category );
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try (Connection connection = DriverManager
				.getConnection(mysqlConnectionUrl, mysqlUser, mysqlPwd);

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement(languageQuery1)) {
			preparedStatement.setString(1, category);
			//preparedStatement.setString(2, loginBean.getPassword());
			

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {   
				 Movies movieNew = new Movies(); 
				 movieNew.setTitle(rs.getString(1));             
				 movieNew.setDescription(rs.getString(2));
				 movieNew.setReleaseYear(rs.getInt(3));
				 movieNew.setRentalDuration(rs.getInt(4));
				 movieNew.setRentalRate(rs.getDouble(5));
				 movieNew.setMovieFeatures(rs.getString(6));
				 movieNew.setMovieLength(rs.getInt(7));
				 movieNew.setMovieRating(rs.getString(8));
				 movieNew.setLangage(rs.getString(9));
				 movieNew.setActorFirstName(rs.getString(10));
				 movieNew.setActorLastName(rs.getString(11));
				 movieNew.setCategory(rs.getString(12));
				 movieList.add(movieNew);
				}
			
			//:TODO loop here for results

		} catch (SQLException e) {
			// process sql exception
			e.printStackTrace();
		}
		return movieList;
	}
}
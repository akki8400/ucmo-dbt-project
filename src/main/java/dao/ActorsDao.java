package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Actor;


public class ActorsDao {
	
	public List<Actor> getActors(String firstname) {
		
		List<Actor> actorList = new ArrayList();
		

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try (Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/sakila?useSSL=false", "root", "123456789");

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from actor where first_name = ? ")) {
			preparedStatement.setString(1, firstname);
			//preparedStatement.setString(2, loginBean.getPassword());
			

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {   
				 Actor actor = new Actor(); 
				 actor.setActorId(rs.getInt(1));             
				 actor.setFirstName(rs.getString(2));
				 actor.setLastName(rs.getString(3));
				 actorList.add(actor);
				}
			
			//:TODO loop here for results

		} catch (SQLException e) {
			// process sql exception
			e.printStackTrace();
		}
		return actorList;
	}
	
	
	

}

package MovieTicketBookingSystem;

import java.util.List;
import java.util.Map;

public class Movie {
    private DatabaseOperation db = new DatabaseOperation();

    

    // Methods

    // Method to insert movie into database
    public void insertMovie(String title, String genre, double rating, int duration, String synopsis){
        String sql = "INSERT INTO movies (title, genre, rating, duration, synopsis) VALUES (?,?,?,?,?)";
        Object[] values = {title, genre, rating, duration, synopsis};
        int rowsAffected = db.executeUpdate(sql, values);
        if(rowsAffected>0)
            System.out.println("Movie inserted successfully");
        else
            System.out.println("Something went wrong.Movie not inserted.");
    }

    //Method to view all movies in database
    public List<Map<String, Object>> showMovies() {
        String sql = "SELECT * FROM Movies";
        List<Map<String, Object>> movies = db.getRecords(sql);
		return movies;
    }
    
    public void deleteMovie() {
    	
    }

}
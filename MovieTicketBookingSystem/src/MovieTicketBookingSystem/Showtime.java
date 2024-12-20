package MovieTicketBookingSystem;

import java.sql.Timestamp;
import java.util.*;

public class Showtime {

    DatabaseOperation db = new DatabaseOperation();
    public void insertShowtime(int MovieID,int TheaterID,Timestamp showtime){
        String sql = "INSERT INTO Showtimes(MovieID,TheaterID,Showtime) VALUES(?,?,?)";
        Object[] values = {MovieID,TheaterID,showtime};
        int rowsAffected = db.executeUpdate(sql, values);
        if(rowsAffected>0)
            System.out.println("Showtime added successfully");
        else
            System.out.println("Something went wrong.Showtime not inserted.");
    
    }

    public List<Map<String,Object>> showShowtimes(){
        String sql = "SELECT * from Showtimes";
        List<Map<String,Object>> showtimes = db.getRecords(sql);
        return showtimes;
    }

    public void showShowtimesDetails(int showtimeID){
        String sql = "SELECT s.ShowtimeID, m.Title,m.Duration,s.Showtime from Showtimes s, Movies m where s.MovieID = m.MovieID and s.ShowtimeID = ? ";
        db.getShowtimeDetails(sql, showtimeID);
    }
    public int getTheaterCapacity(int showtime){
        String sql = "SELECT SeatingCapacity from theaters where TheaterID = (SELECT TheaterID from showtimes where ShowtimeID = ?)";
        return db.getSeatingCapacity(sql, showtime);
    }
    
    
    public void deleteShowing(int showtimeID) {
    	String sql = "DELETE FROM bookings Where ShowtimeID = " + showtimeID;
    	db.deleteTableEntry(sql);
    	sql = "DELETE FROM Showtimes Where ShowtimeID = " + showtimeID;
    	db.deleteTableEntry(sql);
    }
}

package swingGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import MovieTicketBookingSystem.Admin;
import MovieTicketBookingSystem.MovieTicketDriver;

public class AdminMenuPage extends GUIOperations{
	private static JPanel adminMenuPage;
	private NumberFormat numberFormat = NumberFormat.getNumberInstance();
	private Admin adm = new Admin();
	
	public void createAdminMenuPage() {
		JPanel adminMenuPanel = new JPanel();
		adminMenuPanel.setLayout(new BoxLayout(adminMenuPanel, BoxLayout.X_AXIS));
		JTabbedPane tabbedAdminMenuPanel = new JTabbedPane();
		JPanel createMoviePanel = new JPanel();
		createMoviePanel.setLayout(new BoxLayout(createMoviePanel, BoxLayout.Y_AXIS));
		
		//
		//CreateMoviePanel
		//
		
		tabbedAdminMenuPanel.addTab("Enter Movie", null, createMoviePanel, "Adds a Movie into the database");

		createLabel("MovieTitle" , createMoviePanel);
		JTextField MovieTitle = new JTextField();
		createMoviePanel.add(MovieTitle);
		MovieTitle.setMaximumSize(new Dimension(400, MovieTitle.getPreferredSize().height));
		
		createLabel("Genre" , createMoviePanel);
		JTextField Genre = new JTextField();
		createMoviePanel.add(Genre);
		Genre.setMaximumSize(new Dimension(400, Genre.getPreferredSize().height));
		
		createLabel("Rating" , createMoviePanel);
		JFormattedTextField Rating = new JFormattedTextField(numberFormat);
		createMoviePanel.add(Rating);
		Rating.setMaximumSize(new Dimension(75, Rating.getPreferredSize().height));
		
		createLabel("Duration(In Minutes)" , createMoviePanel);
		JFormattedTextField Duration = new JFormattedTextField(numberFormat);
		createMoviePanel.add(Duration);
		Duration.setMaximumSize(new Dimension(75, Duration.getPreferredSize().height));
		
		createLabel("Synopsis" , createMoviePanel);
		JTextField Synopsis = new JTextField();
		createMoviePanel.add(Synopsis);
		Synopsis.setMaximumSize(new Dimension(400, Duration.getPreferredSize().height));
		
		JButton enterMovieSubmitBtn = createButton("Submit", createMoviePanel);
		enterMovieSubmitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				adm.getMovie().insertMovie(MovieTitle.getText(), Genre.getText(), Integer.parseInt(Rating.getText()), Integer.parseInt(Duration.getText()), Synopsis.getText());
				JOptionPane.showMessageDialog(null, "MOVIE SUCCESFULLY SUBMITED" , "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
          }
		});
		//
		//ShowMoviePanel
		//
		
		JPanel showMoviePanel = new JPanel();
		tabbedAdminMenuPanel.addTab("Show Movies", null, showMoviePanel, "Shows all movies in database");
		List<Map<String, Object>> movies = adm.getMovie().showMovies();
        for (Map<String, Object> movie : movies) {
            createLabel("Movie ID: " + movie.get("MovieID"), showMoviePanel);
            createLabel("Title: " + movie.get("Title"), showMoviePanel);
            createLabel("Genre: " + movie.get("Genre"), showMoviePanel);
            createLabel("Rating: " + movie.get("Rating"), showMoviePanel);
            createLabel("Duration(mins): " + movie.get("Duration"), showMoviePanel);
            createLabel("Synopsis: " + movie.get("Synopsis"), showMoviePanel);
        }
        addRefreshBtn(showMoviePanel);
        
        //
		//setShowtimePanel
		//
		
		JPanel setShowtimePanel = new JPanel();
		tabbedAdminMenuPanel.addTab("Set Showtime", null, setShowtimePanel, "Set a showtime for a movie");
		
		createLabel("Movie ID" , setShowtimePanel);
		JFormattedTextField mID = new JFormattedTextField(numberFormat);
		setShowtimePanel.add(mID);
		Rating.setMaximumSize(new Dimension(75, mID.getPreferredSize().height));
		
		createLabel("Theater ID" , setShowtimePanel);
		JFormattedTextField tID = new JFormattedTextField(numberFormat);
		setShowtimePanel.add(tID);
		Duration.setMaximumSize(new Dimension(75, tID.getPreferredSize().height));
		
		createLabel("Showtime Hour" , setShowtimePanel);
		JFormattedTextField showtimeHour = new JFormattedTextField(numberFormat);
		setShowtimePanel.add(showtimeHour);
		Rating.setMaximumSize(new Dimension(75, showtimeHour.getPreferredSize().height));
		
		createLabel("Showtime Minute" , setShowtimePanel);
		JFormattedTextField showtimeMinute = new JFormattedTextField(numberFormat);
		setShowtimePanel.add(showtimeMinute);
		Duration.setMaximumSize(new Dimension(75, showtimeMinute.getPreferredSize().height));
		
		//Error occurs if attempt to make showtime without correct information
		JButton setShowtimeSubmitBtn = createButton("Submit", setShowtimePanel);
		setShowtimeSubmitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				adm.setShowtime(Integer.parseInt(mID.getText()), Integer.parseInt(tID.getText()), Integer.parseInt(showtimeHour.getText()), Integer.parseInt(showtimeMinute.getText()));
				JOptionPane.showMessageDialog(null, "SHOWTIME SUCCESFULLY SUBMITED" , "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
          }
		});
		
		//
		//seeShowtimePanel
		//
		
		JPanel seeShowtimePanel = new JPanel();
		tabbedAdminMenuPanel.addTab("See Showtimes", null, seeShowtimePanel, "See all showtimes in database");
		showShowtimes(seeShowtimePanel);
		addRefreshBtn(seeShowtimePanel);
		
		//
		//deleteShowtimePanel
		//
		
		JPanel deleteShowtimePanel = new JPanel();
		tabbedAdminMenuPanel.addTab("Delete Showtime", null, deleteShowtimePanel, "Delete a showtime from database");
		createLabel("Movie ID" , deleteShowtimePanel);
		JFormattedTextField stID = new JFormattedTextField(numberFormat);
		deleteShowtimePanel.add(stID);
		Rating.setMaximumSize(new Dimension(75, mID.getPreferredSize().height));
		
		JButton deleteShowtimeSubmitBtn = createButton("Submit", deleteShowtimePanel);
		deleteShowtimeSubmitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				adm.getShowtime().deleteShowing(Integer.parseInt(stID.getText()));
				JOptionPane.showMessageDialog(null, "SHOWTIME SUCCESFULLY DELETED" , "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
          }
		});
		
		//
		//addTheaterPanel
		//
		
		JPanel addTheaterPanel = new JPanel();
		addTheaterPanel.setLayout(new BoxLayout(addTheaterPanel, BoxLayout.Y_AXIS));
		tabbedAdminMenuPanel.addTab("Add a Theater", null, addTheaterPanel, "Adds a Theater into the database");
		createLabel("Theater location" , addTheaterPanel);
		JTextField tLocation = new JTextField();
		addTheaterPanel.add(tLocation);
		tLocation.setMaximumSize(new Dimension(400, tLocation.getPreferredSize().height));
		
		createLabel("Seating capacity" , addTheaterPanel);
		JFormattedTextField seatingCapacity = new JFormattedTextField(numberFormat);
		addTheaterPanel.add(seatingCapacity);
		seatingCapacity.setMaximumSize(new Dimension(75, seatingCapacity.getPreferredSize().height));
		
		JButton addTheatherSubmitBtn = createButton("Submit", addTheaterPanel);
		addTheatherSubmitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				adm.getTheater().insertTheater(tLocation.getText(), Integer.parseInt(seatingCapacity.getText()));
				JOptionPane.showMessageDialog(null, "THEATER SUCCESFULLY ADDED" , "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
          }
		});
		//
		//seeTheaterPanel
		//
		
		JPanel seeTheaterPanel = new JPanel();
		tabbedAdminMenuPanel.addTab("See Theaters", null, seeTheaterPanel, "See all Theaters in database");
		List<Map<String, Object>> theaters = adm.getTheater().showTheaters();
		for (Map<String, Object> theater : theaters) {
			createLabel("Theater ID: " + theater.get("TheaterID"), seeTheaterPanel);
			createLabel("Location: " + theater.get("Location"),seeTheaterPanel);
			createLabel("Seating Capacity: " + theater.get("SeatingCapacity"),seeTheaterPanel);
		}
		//
		//bookTicketPanel
		//
		
		JPanel bookTicketPanel = new JPanel();
		bookTicketPanel.setLayout(new BoxLayout(bookTicketPanel, BoxLayout.Y_AXIS));
		tabbedAdminMenuPanel.addTab("Book Ticket", null, bookTicketPanel, "Book a ticket");
		createLabel("User ID" , bookTicketPanel);
		JFormattedTextField uID = new JFormattedTextField(numberFormat);
		bookTicketPanel.add(uID);
		uID.setMaximumSize(new Dimension(75, seatingCapacity.getPreferredSize().height));
		
		JButton bootTicketSubmitBtn = createButton("Show avaiable Showtimes", bookTicketPanel);
		bootTicketSubmitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				uID.setEditable(false);
				JPanel ConfirmShowtimeFrame = new JPanel();
				createLabel("Avaiable showtimes:", ConfirmShowtimeFrame);
				showShowtimes(ConfirmShowtimeFrame);
				JFormattedTextField stID = new JFormattedTextField(numberFormat);
				ConfirmShowtimeFrame.add(stID);
				bookTicketPanel.add(ConfirmShowtimeFrame);
				
				
          }
		});
		//
		//seeTickingBookingsPanel
		//
		
		JPanel seeTicketBookingsPanel = new JPanel();
		tabbedAdminMenuPanel.addTab("See Bookings", null, seeTicketBookingsPanel, "See all Bookings in database");
		createLabel("User ID" , seeTicketBookingsPanel);
		JFormattedTextField uID2 = new JFormattedTextField(numberFormat);
		seeTicketBookingsPanel.add(uID2);
		uID2.setMaximumSize(new Dimension(75, seatingCapacity.getPreferredSize().height));
		
		//
		//cancelTicketBookingsPanel
		//
		
		JPanel cancelTicketBookings = new JPanel();
		tabbedAdminMenuPanel.addTab("Cancel Booking", null, cancelTicketBookings, "Cancel a Booking");
		
		
		adminMenuPanel.add(tabbedAdminMenuPanel);
		adminMenuPage = adminMenuPanel;
	}
	
	public JPanel getPage() {
		return adminMenuPage;
	}
	
	public AdminMenuPage() {
		createAdminMenuPage();
	}
	
	private JPanel getBookingfromShowtimeID(int userID, int showtimeID) {
		return null;
		
	}
	
	private void showShowtimes(JPanel pane) {
		List<Map<String,Object>> showtimes = adm.getShowtime().showShowtimes();
		for (Map<String, Object> showtime : showtimes) {
            createLabel("Showtime ID: " + showtime.get("ShowtimeID"), pane);
            createLabel("Movie ID: " + showtime.get("MovieID"),pane);
            createLabel("Theater ID: " + showtime.get("TheaterID"),pane);
            createLabel("Showtime: " + showtime.get("Showtime"),pane);
        }
	}
	
	private void addRefreshBtn(JPanel pane) {
		JButton refreshBtn = createButton("Refresh", pane);
		refreshBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminMenuPage.removeAll();
				AdminMenuPage admin_menu_page = new AdminMenuPage();
		    	showPage(admin_menu_page.getPage(), adminMenuPage);
		    	adminMenuPage.validate();
          }
		});
		pane.add(refreshBtn);
	}
	
}

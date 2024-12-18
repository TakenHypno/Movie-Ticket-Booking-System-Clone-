package swingGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.PopupFactory;

import MovieTicketBookingSystem.MovieTicketDriver;

public class LoginPage extends GUIOperations{
	private static JPanel loginPage;
	
	public void createLoginPage() {
		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
		loginPanel.add(Box.createVerticalGlue());
		
		JTextField Username = new JTextField("Username", 5);
		Username.setMaximumSize(new Dimension(400, Username.getPreferredSize().height));
		loginPanel.add(Username);
		
		JPasswordField Password = new JPasswordField(5);
		Password.setMaximumSize(new Dimension(400, Password.getPreferredSize().height));
		loginPanel.add(Password);
		
		JPanel helpfulPanel = new JPanel();
		helpfulPanel.setLayout(new BoxLayout(helpfulPanel, BoxLayout.X_AXIS));
		
		createButton("Login As User", helpfulPanel);
		JButton adminLoginBtn = createButton("Login As Admin", helpfulPanel);
		adminLoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				boolean validAccount = MovieTicketDriver.admin_login(Username.getText(), String.valueOf(Password.getPassword()));
				System.out.println(validAccount);
				if (validAccount) {
					AdminMenuPage admin_menu_page= new AdminMenuPage();
	            	showPage(admin_menu_page.getPage(), loginPage);
				} else {
					JOptionPane.showMessageDialog(null, "ERROR INCORRECT USERNAME/PASSWORD" , "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
					
				}
          }
		});
		
		
		JButton returnBtn = createButton("Return", helpfulPanel);
		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				HomePage home_page = new HomePage();
            	showPage(home_page.getPage(), loginPage);
          }
		});
		loginPanel.add(helpfulPanel);
		loginPanel.add(Box.createVerticalGlue());
		loginPage = loginPanel;
	}
	
	public JPanel getPage() {
		return loginPage;
	}
	
	public LoginPage() {
		createLoginPage();
	}
}


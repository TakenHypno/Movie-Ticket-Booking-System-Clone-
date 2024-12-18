package swingGUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import MovieTicketBookingSystem.MovieTicketDriver;

public class AdminCreationPage extends GUIOperations{
		private static JPanel adminCreationPage;
		
		public void createadminCreationPage() {
			JPanel adminCreationPanel = new JPanel();
			adminCreationPanel.setLayout(new BoxLayout(adminCreationPanel, BoxLayout.Y_AXIS));
			adminCreationPanel.add(Box.createVerticalGlue());
			
			JTextField Username = new JTextField("Username", 5);
			Username.setMaximumSize(new Dimension(400, Username.getPreferredSize().height));
			adminCreationPanel.add(Username);
			
			JPasswordField Password = new JPasswordField(5);
			Password.setMaximumSize(new Dimension(400, Password.getPreferredSize().height));
			adminCreationPanel.add(Password);
			
			JPanel helpfulPanel = new JPanel();
			helpfulPanel.setLayout(new BoxLayout(helpfulPanel, BoxLayout.X_AXIS));
		
			JButton createAdminBtn = createButton("Create Admin Account", helpfulPanel);
			createAdminBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					MovieTicketDriver.admin_signup(Username.getText(), String.valueOf(Password.getPassword()));
					HomePage home_page = new HomePage();
	            	showPage(home_page.getPage(), adminCreationPage);
	          }
			});
			
			JButton returnBtn = createButton("Return", helpfulPanel);
			returnBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					HomePage home_page = new HomePage();
	            	showPage(home_page.getPage(), adminCreationPage);
	          }
			});
			adminCreationPanel.add(helpfulPanel);
			adminCreationPanel.add(Box.createVerticalGlue());
			adminCreationPage = adminCreationPanel;
		}
		
		public JPanel getPage() {
			return adminCreationPage;
		}
		
		public AdminCreationPage() {
			createadminCreationPage();
		}
}


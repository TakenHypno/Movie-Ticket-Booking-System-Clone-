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

public class UserCreationPage extends GUIOperations{
	private static JPanel userCreationPage;
	public void CreateUserCreationPage() {
		JPanel UserCreationPanel = new JPanel();
		UserCreationPanel.setLayout(new BoxLayout(UserCreationPanel, BoxLayout.Y_AXIS));
		UserCreationPanel.add(Box.createVerticalGlue());
		
		JTextField Username = new JTextField("Username", 5);
		Username.setMaximumSize(new Dimension(400, Username.getPreferredSize().height));
		UserCreationPanel.add(Username);
		
		JTextField Password = new JTextField("Password", 5);
		Password.setMaximumSize(new Dimension(400, Password.getPreferredSize().height));
		UserCreationPanel.add(Password);
		
		JTextField Name = new JTextField("Name", 5);
		Name.setMaximumSize(new Dimension(400, Name.getPreferredSize().height));
		UserCreationPanel.add(Name);
		
		JTextField Phone = new JTextField("Phone Number", 5);
		Phone.setMaximumSize(new Dimension(400, Phone.getPreferredSize().height));
		UserCreationPanel.add(Phone);
		
		JTextField Address = new JTextField("Address", 5);
		Address.setMaximumSize(new Dimension(400, Address.getPreferredSize().height));
		UserCreationPanel.add(Address);
		
		JPanel helpfulPanel = new JPanel();
		helpfulPanel.setLayout(new BoxLayout(helpfulPanel, BoxLayout.X_AXIS));
		
		JButton createUserBtn = createButton("Create Account", helpfulPanel);
		createUserBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				MovieTicketDriver.user_signup(Username.getText(), Password.getText(), Name.getText(), Phone.getText(), Address.getText());
				HomePage home_page = new HomePage();
            	showPage(home_page.getPage(), userCreationPage);
          }
		});
		
		
		JButton returnBtn = createButton("Return", helpfulPanel);
		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				HomePage home_page = new HomePage();
	        	showPage(home_page.getPage(), userCreationPage);
	      }
		});
		UserCreationPanel.add(helpfulPanel);
		UserCreationPanel.add(Box.createVerticalGlue());
		userCreationPage = UserCreationPanel;
	}
	
	public JPanel getPage() {
		return userCreationPage;
	}
	
	public UserCreationPage() {
		CreateUserCreationPage();
	}
}

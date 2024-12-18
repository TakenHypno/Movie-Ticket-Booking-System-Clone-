package swingGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

public class HomePage extends GUIOperations{
	private static JPanel homePage;
	
	public void createHomePage() {
		JPanel homePanel = new JPanel();
		homePanel.setLayout(new BoxLayout(homePanel, BoxLayout.Y_AXIS));
		homePanel.add(Box.createVerticalGlue());
		JButton loginBtn = createButton("I have an account", homePanel);
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				LoginPage login_page = new LoginPage();
				showPage(login_page.getPage(), homePage);
          }
		});
		JButton createUserBtn = createButton("Create User Account", homePanel);
		createUserBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				UserCreationPage user_creation_page = new UserCreationPage();
				showPage(user_creation_page.getPage(), homePage);
          }
		});
		JButton createAdminBtn = createButton("Create Admin Account", homePanel);
		createAdminBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				AdminCreationPage admin_creation_page = new AdminCreationPage();
				showPage(admin_creation_page.getPage(), homePage);
          }
		});
		homePanel.add(Box.createVerticalGlue());
		homePage = homePanel;
	}
	
	public JPanel getPage() {
		return homePage;
	}
	
	public HomePage() {
		createHomePage();
	}
}



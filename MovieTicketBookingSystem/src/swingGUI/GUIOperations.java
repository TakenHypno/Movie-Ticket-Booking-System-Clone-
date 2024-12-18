package swingGUI;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class GUIOperations{

	
	static JFrame frame;
	public static void initializeFrame() {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		            break;
		        }
		    }
		} catch (UnsupportedLookAndFeelException e) {
		    // handle exception
		} catch (ClassNotFoundException e) {
		    // handle exception
		} catch (InstantiationException e) {
		    // handle exception
		} catch (IllegalAccessException e) {
		    // handle exception
		}
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		HomePage home_page = new HomePage();
		frame.add(home_page.getPage());
		frame.setSize(2000, 700);
		frame.setVisible(true);
	}
	
	protected static JButton createButton(String label, JPanel pane) {
		JButton button = new JButton(label);
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		pane.add(button);
		return button;
	}
	
	protected static void createLabel(String text, JPanel pane) {
		JLabel label = new JLabel();
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setText(text);
		pane.add(label);
	}
	
	protected static void showPage(JPanel newPage, JPanel currentPage) {
		frame.remove(currentPage);
		frame.add(newPage);
		frame.validate();
	}
	
	protected JPanel getPage() {
		return null;
	}
	
}

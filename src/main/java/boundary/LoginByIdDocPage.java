package boundary;

import javax.swing.*;
import java.awt.*;

public class LoginByIdDocPage extends JPanel {

	private JPanel contentPane;
	private JButton BTOBut;
	private JButton back;
	/**
	 * @author Ziyi Chen
	 * Login by id document page
	 */
	public LoginByIdDocPage() {

		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		this.add(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Detected your ID document, press the Login button to login by ID document");
		lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 24));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("");
		
		ImageIcon icon = new ImageIcon("src/main/java/boundary/images/HeathrowAirport.jpg");
		icon.setImage(icon.getImage().getScaledInstance(800,500,1));
		lblNewLabel_1.setIcon(icon);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		BTOBut = new JButton("Back to Origin");

		BTOBut.setFont(new Font("SimSun", Font.PLAIN, 18));
		panel_2.add(BTOBut);


		back = new JButton("Login");

		back.setFont(new Font("SimSun", Font.PLAIN, 18));
		panel_2.add(back);
	}

	public JButton getButton_backToInit(){
		return BTOBut;
	}
	public void makeSound(){}
	public JButton getLogin(){return back;}
	public void loginFailedWarning(){
		JOptionPane.showMessageDialog(this, "Cannot find your ID document!", "Exception occurs",JOptionPane.WARNING_MESSAGE);
	}
	public void loginSuccessDialog(){
		JOptionPane.showMessageDialog(this, "Login successful!", "Login",JOptionPane.DEFAULT_OPTION);
	}


}

package formend;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LoginByIdDocPage extends JPanel {

	private JPanel contentPane;

	/**
	 * Create the panel.
	 */
	public LoginByIdDocPage() {
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		this.add(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Please Scan the QR code：");
		lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 24));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel("");
		
		ImageIcon icon = new ImageIcon("C:\\Users\\29077\\eclipse-workspace\\Formend\\src\\formend\\QRcode.jpg");
		icon.setImage(icon.getImage().getScaledInstance(500,500,1));
		lblNewLabel_1.setIcon(icon);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton BTOBut = new JButton("Back to Origin");
		BTOBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
	            contentPane.repaint();
	            contentPane.add(new initPage());
	            contentPane.validate();
			}
		});
		BTOBut.setFont(new Font("SimSun", Font.PLAIN, 18));
		panel_2.add(BTOBut);
	}

}

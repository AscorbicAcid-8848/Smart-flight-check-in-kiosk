package Boundary;

import javax.swing.*;
import java.awt.*;

public class LoginByNameIdPage extends JPanel {

	/**
	 * The page of Inputing ID
	 * author: Ziyi Chen
	 */
	private static final long serialVersionUID = 8463888530175832824L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton BTOBut;
	private JButton CertBut;
	/**
	 * Create the panel.
	 */
	public LoginByNameIdPage() {
		setBounds(100, 100, 685, 386);
		
		contentPane = new JPanel();
		this.add(contentPane);
		
		JPanel ChoosePage = new JPanel();
		FlowLayout fl_ChoosePage = (FlowLayout) ChoosePage.getLayout();
		fl_ChoosePage.setHgap(30);
		fl_ChoosePage.setVgap(30);
		
		BTOBut = new JButton("Go Back");
		BTOBut.setFont(new Font("SimSun", Font.PLAIN, 18));
		ChoosePage.add(BTOBut);
		
		CertBut = new JButton("Confirm");
		CertBut.setFont(new Font("SimSun", Font.PLAIN, 18));

		ChoosePage.add(CertBut);
		contentPane.setLayout(new BorderLayout(0, 30));
		contentPane.add(ChoosePage, BorderLayout.SOUTH);
		
		JPanel InfoPage = new JPanel();
		FlowLayout fl_InfoPage = (FlowLayout) InfoPage.getLayout();
		fl_InfoPage.setVgap(30);
		contentPane.add(InfoPage, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel("Please type your Surname and ID number:");
		lblNewLabel_2.setFont(new Font("SimSun", Font.PLAIN, 24));
		InfoPage.add(lblNewLabel_2);
		
		JPanel CenterInput = new JPanel();
		contentPane.add(CenterInput, BorderLayout.CENTER);
		CenterInput.setLayout(new BorderLayout(0, 0));
		
		JPanel InputArea = new JPanel();
		CenterInput.add(InputArea);
		InputArea.setLayout(new GridLayout(0, 1, 0, 30));
		
		JPanel SurnInput = new JPanel();
		InputArea.add(SurnInput);
		SurnInput.setLayout(new GridLayout(0, 2, -100, 5));
		
		JLabel lblNewLabel = new JLabel("Surname:");
		lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 16));
		SurnInput.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		SurnInput.add(textField);
		
		JPanel IDInput = new JPanel();
		InputArea.add(IDInput);
		IDInput.setLayout(new GridLayout(0, 2, -100, 0));
		
		JLabel lblNewLabel_1 = new JLabel("ID number:");
		lblNewLabel_1.setFont(new Font("SimSun", Font.PLAIN, 16));
		IDInput.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		IDInput.add(textField_1);
		
		JPanel WestEdge = new JPanel();
		FlowLayout fl_WestEdge = (FlowLayout) WestEdge.getLayout();
		fl_WestEdge.setHgap(40);
		CenterInput.add(WestEdge, BorderLayout.WEST);
		
		JPanel EastEdge = new JPanel();
		FlowLayout fl_EastEdge = (FlowLayout) EastEdge.getLayout();
		fl_EastEdge.setHgap(40);
		CenterInput.add(EastEdge, BorderLayout.EAST);
	}
	//返回button给initpage
	public JButton getButton_backToInit() {
		return BTOBut;
	}

	public JButton getButton_confirm() {
		return CertBut;
	}

	//获取用户输入的名字,initPage调用这个方法以获取用户输入
	public String getSurname(){
		return textField.getText();
	}
	public String getId(){
		return textField_1.getText();
	}

	//用户输入错误情况：1.没有输入姓名,此操作不会抛出exception
	//2.没有输入id或者输入id含有特殊字符，抛出NumberFormatException
	public void nameWarning(){
		JOptionPane.showMessageDialog(this, "Enter your name please", "Exception occurs",JOptionPane.WARNING_MESSAGE);
	}

	public void IdWarning(){
		JOptionPane.showMessageDialog(this, "Invalid ID format", "Exception occurs",JOptionPane.WARNING_MESSAGE);
	}

	public void refresh(){
		textField_1.setText("");
		textField.setText("");
	}
}
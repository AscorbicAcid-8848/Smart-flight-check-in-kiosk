package boundary;

import model.Passenger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class LoginByBookingNumPage extends JPanel {
    /**
     * @author Ran Xu
     * Login by booking number page
     */

    private JPanel panelTop;
    private JPanel panelMid;
    private JPanel panelBot;

    private JPanel panel_name;
    private JPanel panel_id;

    private JLabel label_overall;

    private JLabel label_name;
    private JLabel passengerName;


    private JLabel label_IdNum;
    private JPasswordField passengerId;

    private JButton button_backToInit;
    private JButton button_next;
    private JButton button_withdraw;

    private JToggleButton see;
    private int see_type =1;

    public LoginByBookingNumPage(){
        panelTop = new JPanel();
        panelMid = new JPanel();
        panelBot = new JPanel();

        button_withdraw = new JButton("Withdraw");

        panel_name = new JPanel();
        panel_name.setLayout(new GridLayout(0,3,0,0));
        panel_id = new JPanel();

        label_overall = new JLabel("Login via booking number");
        label_overall.setFont(new Font("SimSun", Font.PLAIN, 24));
        panel_id.setLayout(new GridLayout(0,3,0,0));
        label_name = new JLabel("                              ");

        passengerName = new JLabel();
        passengerId = new JPasswordField();


        label_IdNum = new JLabel("                             Booking Number:");
        label_IdNum.setFont(new Font("SimSun", Font.PLAIN, 15));
        button_backToInit = new JButton("Go Back");
        button_next = new JButton("Next");


        this.setLayout(new GridLayout(3,1,0,50));
        panelMid.setLayout(new GridLayout(2,1,30,20));

        add(panelTop);
        add(panelMid);
        add(panelBot);

        panelTop.add(label_overall);

        panelMid.add(panel_name);
        panelMid.add(panel_id);

        panel_name.add(label_name);
        panel_name.add(passengerName);
        panel_id.add(label_IdNum);
        panel_id.add(passengerId);
        panelBot.add(button_backToInit);
        panelBot.add(button_next);
        panelBot.add(button_withdraw);

        passengerId.setColumns(10);
        passengerId.setEchoChar('*');
        see = new JToggleButton();
        see.setBounds(0,0,20,16);
        URL resource = LoginByBookingNumPage.class.getResource("images//eye-fill.png");
        ImageIcon eye_fillIcon = new ImageIcon(resource);
        Image temp = eye_fillIcon.getImage().getScaledInstance(see.getWidth(), see.getHeight(), eye_fillIcon.getImage().SCALE_DEFAULT);
        eye_fillIcon = new ImageIcon(temp);

        URL resource1 = LoginByBookingNumPage.class.getResource("images//eye slash-fill.png");
        ImageIcon eye_slashIcon = new ImageIcon(resource1);
        Image temp1 = eye_slashIcon.getImage().getScaledInstance(see.getWidth(), see.getHeight(), eye_slashIcon.getImage().SCALE_DEFAULT);
        eye_slashIcon = new ImageIcon(temp1);
        see.setContentAreaFilled(false);
        see.setText("                                                ");
        see.setIcon(eye_slashIcon);
        see.setSelectedIcon(eye_fillIcon);
        see.setBorderPainted(false);
        see.setFocusPainted(false);
        panel_id.add(see);
        see.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == see){
                    see_type = -see_type;
                    if(see_type==-1)
                        setId().setEchoChar('\0');
                    else if(see_type ==1)
                        setId().setEchoChar('*');
                }
            }
        });
        button_withdraw.setFont(new Font("SimSun", Font.PLAIN, 18));
        button_backToInit.setFont(new Font("SimSun", Font.PLAIN, 18));
        button_next.setFont(new Font("SimSun", Font.PLAIN, 18));
    }

    public JButton getButton_backToInit() {
        return button_backToInit;
    }

    public JButton getButton_next() {
        return button_next;
    }

    public JPasswordField setId(){
        return passengerId;
    }

    public JToggleButton getButton_see(){
        return see;
    }

    public JButton getButton_withdraw(){return button_withdraw;}

    /**
     *
     * @return return the booking number user type in
     */
    public String getBookingNum(){
        return passengerId.getText();
    }

    public void refresh(){
        passengerId.setText("");
    }

    public void bookingNumWarning(){
        JOptionPane.showMessageDialog(this, "Please enter the booking number", "Exception occurs",JOptionPane.WARNING_MESSAGE);

    }
    public void bookingNumFormatWarning(){
        JOptionPane.showMessageDialog(this, "Invalid booking number format, please enter a number with 5 digits.", "Exception occurs",JOptionPane.WARNING_MESSAGE);

    }
    public void bookingNumNonExistWarning(int invalidTimes){
        JOptionPane.showMessageDialog(this, "Booking Number does not exist, "+(5-invalidTimes)+" times remain", "Exception occurs",JOptionPane.WARNING_MESSAGE);

    }
    public void alreadyCheckedWarning(){
        JOptionPane.showMessageDialog(this, "You have already checked in this flight!", "Exception occurs",JOptionPane.WARNING_MESSAGE);

    }

}
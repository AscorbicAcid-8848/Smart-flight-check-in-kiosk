package Boundary;

import model.Passenger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInfoPage extends JPanel{

    private JLabel label_overall;

    private JLabel label_name;
    private JLabel passengerName;


    private JLabel label_IdNum;
    private JLabel passengerId;

    private JButton button_backToInit;
    private JButton button_next;

    public UserInfoPage(){
        label_overall = new JLabel("Account Information");

        label_name = new JLabel("Name:");

        passengerName = new JLabel();
        passengerId = new JLabel();

        label_IdNum = new JLabel("ID Number:");
        button_backToInit = new JButton("Go Back");
        button_next = new JButton("Next");


        this.setLayout(new GridLayout(4,1));
        add(label_overall);
        add(label_name);
        add(passengerName);
        add(label_IdNum);
        add(passengerId);
        add(button_backToInit);
    }

    public JButton getButton_backToInit() {
        return button_backToInit;
    }

    public JButton getButton_next() {
        return button_next;
    }

    public void render(Passenger passenger){
        passengerName.setText(passenger.getSurname());
        passengerId.setText(passenger.getPassengerId().toString());
    }

}

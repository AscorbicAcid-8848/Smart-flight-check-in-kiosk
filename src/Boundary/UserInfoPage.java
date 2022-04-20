package Boundary;

import model.Passenger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInfoPage extends JPanel{

    private JPanel panelTop;
    private JPanel panelMid;
    private JPanel panelBot;

    private JPanel panel_name;
    private JPanel panel_id;

    private JLabel label_overall;

    private JLabel label_name;
    private JLabel passengerName;


    private JLabel label_IdNum;
    private JLabel passengerId;

    private JButton button_backToInit;
    private JButton button_next;

    public UserInfoPage(){
        panelTop = new JPanel();
        panelMid = new JPanel();
        panelBot = new JPanel();

        panel_name = new JPanel();
        panel_id = new JPanel();
        label_overall = new JLabel("Here is your account information");

        label_name = new JLabel("Name:");

        passengerName = new JLabel();
        passengerId = new JLabel();

        label_IdNum = new JLabel("ID Number:");
        button_backToInit = new JButton("Go Back");
        button_next = new JButton("Check My Flights");


        this.setLayout(new GridLayout(3,1,0,50));
        panelMid.setLayout(new GridLayout(2,1,0,20));
        panelBot.setLayout(new GridLayout(1,2,100,0));


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
    }

    public JButton getButton_backToInit() {
        return button_backToInit;
    }

    public JButton getButton_next() {
        return button_next;
    }

    //所有需要显示数据库信息的页面都应该有render方法
    public void render(Passenger passenger){
        passengerName.setText(passenger.getSurname());
        passengerId.setText(passenger.getPassengerId().toString());
    }

}

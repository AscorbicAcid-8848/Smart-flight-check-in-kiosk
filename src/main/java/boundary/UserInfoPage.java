package boundary;

import controller.PassengerController;
import model.Passenger;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UserInfoPage extends JPanel{
    /**
     * @author: Ran Xu
     * User info page
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
    private JLabel passengerId;
    private JLabel flights_number;

    private JButton button_backToInit;
    private JButton button_next;
    private PassengerController passengerController = new PassengerController();

    public UserInfoPage(){
        panelTop = new JPanel();
        panelMid = new JPanel();
        panelBot = new JPanel();

        panel_name = new JPanel();
        panel_id = new JPanel();
        flights_number = new JLabel();

        label_overall = new JLabel("Here is your account information");

        label_name = new JLabel("Name:");

        passengerName = new JLabel();
        passengerId = new JLabel();

        label_IdNum = new JLabel("ID Number:");
        button_backToInit = new JButton("Go Back");
        button_next = new JButton("Check My Flights");

        this.setLayout(new GridLayout(3,1,0,50));
        panelMid.setLayout(new GridLayout(3,1,0,20));
        panelBot.setLayout(new GridLayout(1,2,100,0));

        add(panelTop);
        add(panelMid);
        add(panelBot);

        panelTop.add(label_overall);

        panelMid.add(panel_name);
        panelMid.add(panel_id);
        panelMid.add(flights_number);

        panel_name.add(label_name);
        panel_name.add(passengerName);
        panel_id.add(label_IdNum);
        panel_id.add(passengerId);

        panelBot.add(button_backToInit);
        panelBot.add(button_next);
        label_overall.setFont(new Font("SimSun", Font.PLAIN, 24));

    }

    public JButton getButton_backToInit() {
        return button_backToInit;
    }

    public JButton getButton_next() {
        return button_next;
    }

    /**
     * Invoked in init page
     * @param passenger The passenger object to display
     */
    public void render(Passenger passenger){
        passengerName.setText(passenger.getFirstname()+" "+passenger.getSurname());
        passengerId.setText(passenger.getPassengerId().toString());
        ArrayList<Integer> bookingNums = (ArrayList<Integer>) passenger.getBookingNumber();
        int num = bookingNums.size();
        for(int i=0; i<bookingNums.size();i++){
            if(passengerController.isChecked(passenger.getPassengerId(),passenger.getSurname(),passenger.getBookingNumber().get(i))){
                num--;
            }
        }
        flights_number.setText("                                        You have "+num+" booked flights");
    }
    public void noFlightsWarning(){
        JOptionPane.showMessageDialog(this, "You have no flights to check in !", "No flight",JOptionPane.WARNING_MESSAGE);
    }

}

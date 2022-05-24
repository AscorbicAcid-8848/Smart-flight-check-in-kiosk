package boundary;

import model.Flight;
import model.Passenger;

import javax.swing.*;
import java.awt.*;

public class FinalConfirmPage extends JPanel {
    /**
     * @author Ran Xu
     * Final confirm page
     */

    //panels：
    private JPanel panel_top;
    private JPanel panel_mid;
    private JPanel panel_bot;

    //buttons
    private JButton button_confirm;

    //labels
    JLabel label_top_first = new JLabel();
    JLabel label_top_second = new JLabel();
    JLabel departureTime = new JLabel();
    JLabel departureGate = new JLabel();
    JLabel arrivalGate_terminal = new JLabel();
    JLabel arrivalTime = new JLabel();
    JLabel seatNumber = new JLabel();
    JLabel seatLevel = new JLabel();
    JLabel meal = new JLabel();


    public FinalConfirmPage(){

        panel_top = new JPanel();
        panel_mid = new JPanel();
        panel_bot = new JPanel();

        button_confirm = new JButton("Confirm");

        this.setLayout(new GridLayout(3,1,0,20));
        panel_top.setLayout(new GridLayout(2,1,0,10));
        panel_mid.setLayout(new GridLayout(5,2,30,10));
        panel_bot.setLayout(new GridLayout(1,2,200,0));

        this.add(panel_top);
        this.add(panel_mid);
        this.add(panel_bot);

        panel_top.add(label_top_first);
        panel_top.add(label_top_second);

        panel_mid.add(departureTime);
        panel_mid.add(departureGate);
        panel_mid.add(arrivalTime);
        panel_mid.add(arrivalGate_terminal);
        panel_mid.add(seatLevel);
        panel_mid.add(seatNumber);
        panel_mid.add(meal);

        panel_bot.add(button_confirm);


    }
    public JButton getButton_confirm() {
        return button_confirm;
    }

    /**
     *
     * @param passenger The passenger object displayed in this page.
     * @param flight    The flight object displayed in this page.
     * @param mealName  The meal displayed in this page.
     */
    public void render(Passenger passenger,Flight flight,String mealName){
        label_top_first.setText("Dear"+passenger.getSurname()+",");
        label_top_second.setText("Please check your information of your flight: "+flight.getFlightName());
        departureTime.setText("Departure Time: "+flight.getDepartureTime());
        departureGate.setText("Departure Gate: "+flight.getDepartureGate());
        arrivalTime.setText("Arrival Time: "+flight.getFallTime());
        arrivalGate_terminal.setText("Arrival Airport&Terminal:  "+flight.getArrivalAirport()+" Terminal"+ flight.getArrivalTerminal());
        seatLevel.setText("Seat Level: "+passenger.getSeatLevel());
        seatNumber.setText("Seat Number: "+passenger.getSeatNumber());
        meal.setText("Meal: "+mealName);
        //destWeather.setText("Destination Weather: "+flight.getDestWeather());
        //COVIDPolicy.setText("Destination COVID Policy: "+flight.getDestCOVIDPolicy());
        //delayState.setText(flight.isDelayed() ? "Delay State: Delayed":"Delay State: No Delay");
    }

    /**
     * @description: Notify user when system terminates.
     */
    public void FinishNotification(){
        JOptionPane.showMessageDialog(this, "You have confirmed the check-in, your boarding pass, baggage tag and ticket will be printed", "Have a nice trip",JOptionPane.DEFAULT_OPTION);

    }


}

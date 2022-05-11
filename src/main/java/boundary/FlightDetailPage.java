package boundary;

import model.Flight;
import model.Passenger;

import javax.swing.*;
import java.awt.*;

public class FlightDetailPage extends JPanel {
//
//    //旅客信息
//    private Passenger passenger;
//    //航班信息
//    private Flight flight;

    /**
     * 需要的数据：
     * 由passenger对象提供：
     * bookingNumber
     * surName
     *
     * 由flight对象提供：
     * String flightName
     * Integer airlineId;
     * Integer flightId;
     * Date departureTime;
     * Date fallTime;
     *
     * Boolean isDelayed
     * Integer departureGate
     * String destWeather
     * String destCOVIDPolicy
     * String arrivalAirport
     * Integer arrivalTerminal
     *
     */

    //panels：
    private JPanel panel_top;//用来显示标题
    private JPanel panel_mid;//显示各种航班的信息
    private JPanel panel_bot;//显示前进和后退按钮


    //buttons
    private JButton button_back;
    private JButton button_confirm;

    //labels
    JLabel label_top_first = new JLabel();
    JLabel label_top_second = new JLabel();
    JLabel departureTime = new JLabel();
    JLabel departureGate = new JLabel();
    JLabel arrivalGate_terminal = new JLabel();
    JLabel arrivalTime = new JLabel();
    JLabel destWeather = new JLabel();
    JLabel COVIDPolicy = new JLabel();
    JLabel delayState = new JLabel();


    public FlightDetailPage(){

        panel_top = new JPanel();
        panel_mid = new JPanel();
        panel_bot = new JPanel();

        button_back = new JButton("To initial page");
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
        panel_mid.add(destWeather);
        panel_mid.add(delayState);
        panel_mid.add(COVIDPolicy);

        panel_bot.add(button_back);
        panel_bot.add(button_confirm);


    }
//获取button，由initpage调用，在initpage实现监听
    public JButton getButton_back() {
        return button_back;
    }
    public JButton getButton_confirm() {
        return button_confirm;
    }


    public void render(Passenger passenger,Flight flight, Integer bookingNum){
        label_top_first.setText("Dear"+passenger.getSurname()+", with booking number "+bookingNum+",");
        label_top_second.setText("Here is the information for flight: "+flight.getFlightName());
        departureTime.setText("Departure Time: "+flight.getDepartureTime());
        departureGate.setText("Departure Gate: "+flight.getDepartureGate());
        arrivalTime.setText("Arrival Time: "+flight.getFallTime());
        arrivalGate_terminal.setText("Arrival Airport&Terminal:  "+flight.getArrivalAirport()+" Terminal"+ flight.getArrivalTerminal());
        destWeather.setText("Destination Weather: "+flight.getDestWeather());
        COVIDPolicy.setText("Destination COVID Policy: "+flight.getDestCOVIDPolicy());
        delayState.setText(flight.isDelayed() ? "Delay State: Delayed":"Delay State: No Delay");
    }


}

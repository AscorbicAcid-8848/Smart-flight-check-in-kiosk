package boundary;

import model.Flight;
import model.Passenger;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.security.KeyStore;
import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;


public class AllFlightsPage extends JPanel{

    private JTextArea curTex;
    private JPanel buttonPanel  = new JPanel();
    private ArrayList<JTextArea> texs = new ArrayList<>();
    private JButton currentButton = null;
    private JButton confirm = new JButton("confirm");
    private JButton back = new JButton("back");

    private ArrayList<JButton> buttonList = new ArrayList<>();
    private JButton infoButton;

    public JButton getCurrentButton() {
        return currentButton;
    }

    public JButton getConfirm() {
        return confirm;
    }

    public JButton getBack(){
        return back;
    }

    public ArrayList<JButton> getButtonList(){
        return buttonList;
    }

    public AllFlightsPage() {
    }

    public void render(ArrayList<Flight> flightList){
        this.setSize(new Dimension(1000, 900));
        this.setLayout(null);
        /*init TextArea*/
        Flight curFlight;
        int x1 = 100, y1 = 20;
        int x2 = 450, y2 = 20;
        JLabel jlabel = new JLabel("You have " + flightList.size() + " flights, click on more to select meal and seat.");
        jlabel.setBounds(100,0,700,40);
        jlabel.setFont(new Font("Arial", Font.BOLD, 20));
        for (Iterator<Flight> f = flightList.iterator(); f.hasNext(); ) {
            curFlight = f.next();
            curTex = new JTextArea();
            infoButton = new JButton("More");
            infoButton.setSize(new Dimension(50, 20));
            curTex.setPreferredSize(new Dimension(350, 90));
            curTex.setBorder(BorderFactory.createTitledBorder(curFlight.getFlightName()));
            curTex.setFont(new Font("Arial", Font.PLAIN, 15));
            curTex.setText("Arrival Airport:" + curFlight.getArrivalAirport() + "\n" + "Arrival Terminal: " + curFlight.getArrivalTerminal() +
                    "\nDelay status: " + curFlight.isDelayed() + "\nDeparture Time: " + curFlight.getDepartureTime() + "\nFall Time: " + curFlight.getFallTime());
            texs.add(curTex);
            Flight finalCurFlight = curFlight;
            curTex.setBounds(x1, y1 + 40, 350, 120);
            curTex.setEditable(false);
            infoButton.setBounds( x2 + 50, 35 + y2 + 40, 100, 50);
            y1 = y1 + 550 / flightList.size();
            y2 = y2 + 550 / flightList.size();
            this.add(curTex);
            this.add(infoButton);
            buttonList.add(infoButton);
        }
        back.setBounds(400, 600, 100, 50);
        this.add(jlabel);
        this.add(back);
        this.setVisible(true);
    }

}


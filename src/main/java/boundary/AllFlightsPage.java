package boundary;

import model.Flight;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.security.KeyStore;
import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;


public class AllFlightsPage extends JPanel{

    private JPanel infoPanel;
    private JTextArea curTex;
    private JPanel buttonPanel;
    private JPanel labelPanel;
    private JButton confirm = new JButton();
    private JButton withdraw = new JButton();
    private JButton back = new JButton();
    protected ArrayList<JTextArea> texs = new ArrayList<JTextArea>();
    private JButton infoButton;
    public AllFlightsPage() {
    }

    public static void main(String[] agrs){
        ArrayList<Flight> flights = new ArrayList<Flight>();
        flights.add(new Flight());
        flights.add(new Flight());
        flights.add(new Flight());
        flights.add(new Flight());
        JFrame f = new JFrame();
        f.setSize(new Dimension(500, 500));
        AllFlightsPage a = new AllFlightsPage();
        a.render(flights);
        f.add(a);
        f.setVisible(true);
    }

    public void render(ArrayList<Flight> flightList){
        if (flightList == null) {
            JOptionPane.showMessageDialog(null, "Error", "No booked flight!", JOptionPane.ERROR_MESSAGE);
        }
        this.setSize(new Dimension(500, 500));
        this.setLayout(null);
        /*init TextArea*/
        Flight curFlight;
        int x1 = 20, y1 = 20;
        int x2 = 250, y2 = 20;
        for (Iterator<Flight> f = flightList.iterator(); f.hasNext(); ) {
            curFlight = f.next();
            curTex = new JTextArea();
            infoButton = new JButton("More");
            infoButton.setSize(new Dimension(50, 20));
            curTex.setPreferredSize(new Dimension(200, 100));
            curTex.setBorder(BorderFactory.createTitledBorder(curFlight.getFlightName()));
            curTex.setText("Arrival Airport:" + curFlight.getArrivalAirport() + "\n" + "Arrival Terminal: " + curFlight.getArrivalTerminal() +
                    "\n Delay status: " + curFlight.isDelayed());
            texs.add(curTex);
            Flight finalCurFlight = curFlight;
            infoButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, finalCurFlight.toString(), "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            });
            curTex.setBounds(x1, y1, 150, 70);
            curTex.setEditable(false);
            infoButton.setBounds(x2, y2, 100, 50);
            y1 = y1 + 500 / flightList.size();
            y2 = y2 + 500 / flightList.size();
            this.add(curTex);
            this.add(infoButton);
        }

        this.add(withdraw);
        this.add(back);
        this.add(confirm);
        this.setVisible(true);
    }

}
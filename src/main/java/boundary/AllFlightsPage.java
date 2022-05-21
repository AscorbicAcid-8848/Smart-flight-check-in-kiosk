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

    //private JPanel infoPanel;
    private JTextArea curTex;
    //private JPanel buttonPanel;
    //private JPanel labelPanel;
    private JPanel buttonPanel  = new JPanel();
    private ArrayList<JTextArea> texs = new ArrayList<>();
    private JButton currentButton = null;
    private JButton confirm = new JButton("confirm");
    private JButton back = new JButton("back");
    //private String[] title = {"FlightId", "Departure", "FallTime", "is delay", "COVID policy"};

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

    /*public static void main(String[] agrs){
        ArrayList<Flight> flights = new ArrayList<Flight>();
        flights.add(new Flight());
        flights.add(new Flight());
        flights.add(new Flight());
        flights.add(new Flight());
        JFrame f = new JFrame();
        f.setSize(new Dimension(1000, 900));
        AllFlightsPage a = new AllFlightsPage();
        a.render(flights);
        f.add(a);
        f.setVisible(true);
    }*/

    public void render(ArrayList<Flight> flightList){
        /*if (flightList == null) {
            JOptionPane.showMessageDialog(null, "Error", "No booked flight!", JOptionPane.ERROR_MESSAGE);
        }
        String[][] info = new String[flightList.size()][5];
        for(int i = 0; i < flightList.size(); i++){
            info[i][0] = String.valueOf(flightList.get(i).getFlightId());
            info[i][1] = String.valueOf(flightList.get(i).getDepartureTime());
            info[i][2] = String.valueOf(flightList.get(i).getFallTime());
            info[i][3] = String.valueOf(flightList.get(i).isDelayed());
            info[i][4] = flightList.get(i).getDestCOVIDPolicy();
        }

        this.setLayout(new BorderLayout());
        this.setSize(400, 300);
        this.add(buttonPanel, BorderLayout.SOUTH);
        confirm.setBounds(200,700,100,50);
        back.setBounds(350,700,100,50);
        buttonPanel.setSize(400,400);
        buttonPanel.setLayout(null);
        buttonPanel.add(back);
        buttonPanel.add(confirm);
        buttonPanel.setVisible(true);
        JTable t = new JTable(info, title);
        JScrollPane sp = new JScrollPane(t);
        t.setEnabled(false);
        t.getColumnModel().getColumn(0).setPreferredWidth(10);
        sp.setViewportView(t);

        this.add(sp, BorderLayout.CENTER);
        this.setVisible(true);*/



        this.setSize(new Dimension(1000, 900));
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
            curTex.setBounds(x1, y1, 150, 70);
            curTex.setEditable(false);
            infoButton.setBounds(x2, y2, 100, 50);
            y1 = y1 + 500 / flightList.size();
            y2 = y2 + 500 / flightList.size();
            this.add(curTex);
            this.add(infoButton);
            buttonList.add(infoButton);
        }
        back.setBounds(200, 700, 100, 50);
        confirm.setBounds(350,700,100,50);
        this.add(back);
        this.add(confirm);
        this.setVisible(true);
    }

}

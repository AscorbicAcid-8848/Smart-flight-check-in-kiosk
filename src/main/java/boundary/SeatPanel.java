package boundary;

import model.Passenger;
import model.Seat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Iterator;
import controller.FlightSeatController;



public class SeatPanel extends JPanel implements ActionListener{

    ArrayList<JButton> bts = new ArrayList<>();
    ArrayList<Seat> seatList;
    Passenger passenger;
    JButton selectedButton = null;
    JPanel economicPanel;
    JPanel businessPanel;
    JPanel specialSeatPanel;
    JPanel controlPanel;
    JPanel infoPanel;
    JTextArea tex;
    private int price = 0;


    JButton confirm;
    JButton withdraw;
    JButton back;

    int lastSeatNum = -1;
    public SeatPanel(){
        int count = 0;
        //this.setSize(new Dimension(400, 500));
        this.setLayout(null);
        controlPanel = new JPanel();
        controlPanel.setLayout(null);
        economicPanel = new JPanel();
        businessPanel = new JPanel();
        specialSeatPanel = new JPanel();
        infoPanel = new JPanel();
        businessPanel.setBounds(350,0,200,350);
        economicPanel.setBounds(550,0,350,600);
        specialSeatPanel.setBounds(350,350,200,250);
        controlPanel.setBounds(250,600,400,100);
        infoPanel.setBounds(0, 400, 350, 200);
        economicPanel.setBorder(BorderFactory.createTitledBorder("Economic Seat"));
        businessPanel.setBorder(BorderFactory.createTitledBorder("Business Seat"));
        specialSeatPanel.setBorder(BorderFactory.createTitledBorder("Special Seat"));
        economicPanel.setLayout(null);
        businessPanel.setLayout(null);
        specialSeatPanel.setLayout(null);
        tex = new JTextArea();
        infoPanel.add(tex);
        for(int j = 0; j < 2; j++){
            for(int i = 0; i < 5; i++) {
                JButton button = new JButton("A" + count++);
                button.setBounds(40 + 60 * j, 40 + 60 * i, 60, 40);
                button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                businessPanel.add(button);
                bts.add(button);
                button.addActionListener(this);
            }
        }

        for(int j = 0; j < 2; j++){
            for(int i = 0; i < 3; i++) {
                JButton button = new JButton("B" + count++);
                button.setBounds(40 + 60 * j, 10 + 40 + 60 * i, 60, 40);
                button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                specialSeatPanel.add(button);
                bts.add(button);
                button.addActionListener(this);
            }
        }

        for(int j = 0; j < 2; j++){
            for(int i = 0; i < 9; i++) {
                JButton button = new JButton("C" + count++);
                button.setBounds(40 + 60 * j, 40 + 60 * i, 60, 40);
                button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                economicPanel.add(button);
                bts.add(button);
                button.addActionListener(this);
            }
        }

        for(int j = 0; j < 2; j++){
            for(int i = 0; i < 9; i++){
                JButton button = new JButton("C" + count++);
                button.setBounds(200+60*j,40+60*i, 60, 40);
                button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                economicPanel.add(button);
                bts.add(button);
                button.addActionListener(this);
            }
        }

        businessPanel.setVisible(true);
        specialSeatPanel.setVisible(true);
        economicPanel.setVisible(true);

        confirm = new JButton("Confirm");
        confirm.setBounds(20,20,100,40);
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == confirm){
                    if(passenger.getSeatLevel() == null || passenger.getSeatNumber() == null || passenger.getSeatNumber() < 0){
                        JOptionPane.showMessageDialog(null, "You haven't choose your seat yet.", "Exception occurs",JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                }
            }
        });

        withdraw= new JButton("Withdraw");
        withdraw.setBounds(140,20,100,40);
        withdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == withdraw){
                    if(selectedButton == null && lastSeatNum == -1){
                        return;
                    }
                    seatList.get(lastSeatNum).setOccupied(false);
                    bts.get(lastSeatNum).setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
                    lastSeatNum = -1;
                    selectedButton = null;
                    passenger.setSeatLevel(null);
                    passenger.setSeatNumber(-1);
                    updateTex();
                }
            }
        });


        back = new JButton("Back to meal choosing");
        back.setBounds(260,20,100,40);
        controlPanel.add(back);
        controlPanel.add(confirm);
        controlPanel.add(withdraw);



        this.add(businessPanel);
        this.add(economicPanel);
        this.add(specialSeatPanel);
        this.add(controlPanel);
        this.add(infoPanel);
        this.setVisible(true);
    }

    public JButton getConfirm() {
        return confirm;
    }

    public JButton getBack(){
        return back;
    }

    public int getPrice(){return price;}

    @Override
    public void actionPerformed(ActionEvent e) {
        int seatNum = bts.indexOf(e.getSource());
        System.out.println("passenger seat level: " + passenger.getSeatLevel());
        System.out.println("seat number: " + seatNum);
        System.out.println("seat level: " + seatList.get(seatNum).getSeatLevel());
        System.out.println("seat occupied: " + seatList.get(seatNum).isOccupied());
        if(e.getSource() == selectedButton){
            JOptionPane.showMessageDialog(null, "You already selected this seat.", "Sorry", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(seatList.get(seatNum).isOccupied()) {
            JOptionPane.showMessageDialog(null, "This seat is occupied.", "Sorry", JOptionPane.WARNING_MESSAGE);
            return;
        }
        else{
            int seatIt = JOptionPane.showConfirmDialog(null, "You want to seat on this seat?", "Prompt", JOptionPane.YES_NO_CANCEL_OPTION);
            if(seatIt == JOptionPane.YES_OPTION) {
                int changeLevel;
                if (seatList.get(seatNum).getSeatLevel() != passenger.getSeatLevel()) {
                    if(passenger.getSeatLevel() != null){
                        changeLevel = JOptionPane.showConfirmDialog(null, "Your current class is " + passenger.getSeatLevel() + " class, do you want to change the level to " + seatList.get(seatNum).getSeatLevel(), "Prompt", JOptionPane.YES_NO_CANCEL_OPTION);
                    }else{
                        changeLevel = JOptionPane.showConfirmDialog(null, "Do you want to set your set level to " + seatList.get(seatNum).getSeatLevel(), "Prompt", JOptionPane.YES_NO_CANCEL_OPTION);
                    }

                    if (changeLevel == JOptionPane.YES_OPTION)
                        passenger.setSeatLevel(seatList.get(seatNum).getSeatLevel());
                    else{
                        return;
                    }
                }
                exclusiveCheck((JButton) e.getSource());
                seatList.get(seatNum).setOccupied(true);
                selectedButton = (JButton) e.getSource();
                passenger.setSeatNumber(seatNum);
                passenger.setSeatLevel(seatList.get(seatNum).getSeatLevel());
                //price = seatList.get(seatNum).getSeatCost();
                updateTex();
                ((JButton) e.getSource()).setBorder(BorderFactory.createLineBorder(Color.GREEN ,1));
                lastSeatNum = seatNum;
            }
        }
    }

    public void exclusiveCheck(JButton b){
        if(lastSeatNum == -1){
            return;
        }else if(bts.get(lastSeatNum) != b){
            seatList.get(lastSeatNum).setOccupied(false);
            bts.get(lastSeatNum).setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        }else if(bts.get(lastSeatNum) == b){
            return;
        }
    }

    public void render(ArrayList<Seat> s, Passenger p){
        seatList = s;
        passenger = p;
        for(JButton b : bts){
            if(seatList != null && seatList.get(bts.indexOf(b)).isOccupied())
                b.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
        }
        infoPanel.setBorder(BorderFactory.createTitledBorder(passenger.getFirstname() + " " + passenger.getSurname()));
        tex.setEditable(false);
        updateTex();
    }

    public void updateTex(){
        String seatLevel, seatNumber;
        if(passenger.getSeatLevel() == null)   {seatLevel = "not Selected";}
        else {seatLevel = passenger.getSeatLevel() + "";}
        if(passenger.getSeatNumber() == -1) { seatNumber = "not Selected";}
        else {seatNumber = passenger.getSeatNumber() + "";}
        tex.setText("Your seat level: " + seatLevel + "\nYour seat number:" + seatNumber
                + "\nYour price now:");
    }

    public int resultSeatNumber(){
        return passenger.getSeatNumber();
    }

    public String resultSeatLevel(){
        return passenger.getSeatLevel();
    }


    public static void main(String[] args) {
        JFrame f = new JFrame();
        JPanel pl = new JPanel();
        pl.setLayout(new BorderLayout());
        SeatPanel sp = new SeatPanel();


        ArrayList<Seat> seats = new ArrayList<Seat>();

        for(int i = 0; i < 10; i++){
            Seat s1 = new Seat();
            s1.setOccupied(false);
            s1.setSeatLevel("Business");
            seats.add(s1);
        }

        for(int i = 0; i < 6; i++){
            Seat s1 = new Seat();
            s1.setOccupied(true);
            s1.setSeatLevel("Special");
            seats.add(s1);
        }

        for(int i = 0; i < 36; i++){
            Seat s1 = new Seat();
            s1.setOccupied(false);
            s1.setSeatLevel("Economic");
            seats.add(s1);
        }
        int i = 0;
        for(Iterator<Seat> s = seats.iterator(); s.hasNext();){
            System.out.println(i + s.next().getSeatLevel() + s.next().isOccupied());
            i = i + 1;
        }
        Passenger p = new Passenger();
        p.setSeatLevel("Special");
        p.setFirstname("Kyo");
        p.setSurname("KAUS");
        p.setSeatNumber(-1);
        f.add(pl);
        pl.add(sp, BorderLayout.CENTER);
        sp.setVisible(true);
        pl.setVisible(true);
        f.setBounds(200,200,917,717);
        sp.render(seats, p);;
        f.setVisible(true);

    }
}

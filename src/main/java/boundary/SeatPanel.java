//package boundary;
//
//import model.Passenger;
//import model.Seat;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.*;
//import java.awt.*;
//import model.Airline;
//import java.net.http.HttpResponse;
//import java.util.ArrayList;
//import java.util.Iterator;
//import controller.FlightSeatController;
//
//
//
//public class SeatPanel extends JPanel implements ActionListener{
//
//    ArrayList<JButton> bts = new ArrayList<>();
//    ArrayList<Seat> seatList;
//    Passenger passenger;
//    JButton selectedButton = null;
//    JPanel economicPanel;
//    JPanel businessPanel;
//    JPanel specialSeatPanel;
//    JPanel controlPanel;
//    JPanel infoPanel;
//    JTextArea tex;
//    private int price = 0;
//    int initPrice;
//    int currentPrice;
//    int airline;
//    JButton confirm;
//    JButton withdraw;
//    JButton back;
//    JPanel iconPanel;
//
//    int lastSeatNum = -1;
//    public SeatPanel(){
//        int count = 0;
//        //this.setSize(new Dimension(400, 500));
//        controlPanel = new JPanel();
//        controlPanel.setLayout(null);
//        economicPanel = new JPanel();
//        businessPanel = new JPanel();
//        specialSeatPanel = new JPanel();
//        iconPanel = new JPanel();
//        infoPanel = new JPanel();
//        businessPanel.setBounds(350,0,200,350);
//        economicPanel.setBounds(550,0,350,600);
//        specialSeatPanel.setBounds(350,350,200,250);
//        controlPanel.setBounds(250,600,400,100);
//        infoPanel.setBounds(0, 200, 350, 400);
//        iconPanel.setBounds(0,0,350,200);
//        economicPanel.setBorder(BorderFactory.createTitledBorder("Economic Seat"));
//        businessPanel.setBorder(BorderFactory.createTitledBorder("Business Seat"));
//        specialSeatPanel.setBorder(BorderFactory.createTitledBorder("Special Seat"));
//        iconPanel.setBorder(BorderFactory.createTitledBorder("Airline"));
//        economicPanel.setLayout(null);
//        businessPanel.setLayout(null);
//        specialSeatPanel.setLayout(null);
//        iconPanel.setLayout(new BorderLayout());
//        tex = new JTextArea();
//        infoPanel.add(tex);
//        for(int j = 0; j < 2; j++){
//            for(int i = 0; i < 5; i++) {
//                JButton button = new JButton("A" + count++);
//                button.setBounds(40 + 60 * j, 40 + 60 * i, 60, 40);
//                button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
//                businessPanel.add(button);
//                bts.add(button);
//                button.addActionListener(this);
//            }
//        }
//
//        for(int j = 0; j < 2; j++){
//            for(int i = 0; i < 3; i++) {
//                JButton button = new JButton("B" + count++);
//                button.setBounds(40 + 60 * j, 10 + 40 + 60 * i, 60, 40);
//                button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
//                specialSeatPanel.add(button);
//                bts.add(button);
//                button.addActionListener(this);
//            }
//        }
//
//        for(int j = 0; j < 2; j++){
//            for(int i = 0; i < 9; i++) {
//                JButton button = new JButton("C" + count++);
//                button.setBounds(40 + 60 * j, 40 + 60 * i, 60, 40);
//                button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
//                economicPanel.add(button);
//                bts.add(button);
//                button.addActionListener(this);
//            }
//        }
//
//        for(int j = 0; j < 2; j++){
//            for(int i = 0; i < 9; i++){
//                JButton button = new JButton("C" + count++);
//                button.setBounds(200+60*j,40+60*i, 60, 40);
//                button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
//                economicPanel.add(button);
//                bts.add(button);
//                button.addActionListener(this);
//            }
//        }
//
//        businessPanel.setVisible(true);
//        specialSeatPanel.setVisible(true);
//        iconPanel.setVisible(true);
//
//        confirm = new JButton("Confirm");
//        confirm.setBounds(20,20,100,40);
////        confirm.addActionListener(new ActionListener() {
////            @Override
////            public void actionPerformed(ActionEvent e) {
////                if(e.getSource() == confirm){
////                    if(passenger.getSeatLevel() == null || passenger.getSeatNumber() == null || passenger.getSeatNumber() < 0){
////                        JOptionPane.showMessageDialog(null, "You haven't choose your seat yet.", "Exception occurs",JOptionPane.WARNING_MESSAGE);
////                        return;
////                    }
////                }
////            }
////        });
//
//        withdraw= new JButton("Withdraw");
//        withdraw.setBounds(140,20,100,40);
//        withdraw.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if(e.getSource() == withdraw){
//                    if(selectedButton == null && lastSeatNum == -1){
//                        return;
//                    }
//                    seatList.get(lastSeatNum).setOccupied(false);
//                    bts.get(lastSeatNum).setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
//                    lastSeatNum = -1;
//                    selectedButton = null;
//                    passenger.setSeatLevel(null);
//                    passenger.setSeatNumber(-1);
//                    currentPrice = initPrice;
//                    updateTex();
//                }
//            }
//        });
//
//
//        back = new JButton("Back");
//        back.setBounds(260,20,100,40);
//        controlPanel.add(back);
//        controlPanel.add(confirm);
//        controlPanel.add(withdraw);
//
//
//        this.setLayout(new BorderLayout());
//        this.add(businessPanel);
//        this.add(economicPanel);
//        this.add(specialSeatPanel);
//        this.add(controlPanel);
//        this.add(infoPanel);
//        this.add(iconPanel);
//        this.setVisible(true);
//    }
//
//    public JButton getConfirm() {
//        return confirm;
//    }
//
//    public JButton getBack(){
//        return back;
//    }
//
//    public int getPrice(){return price;}
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        int seatNum = bts.indexOf(e.getSource());
//        /*System.out.println("passenger seat level: " + passenger.getSeatLevel());
//        System.out.println("seat number: " + seatNum);
//        System.out.println("seat level: " + seatList.get(seatNum).getSeatLevel());
//        System.out.println("seat occupied: " + seatList.get(seatNum).isOccupied());*/
//        if(e.getSource() == selectedButton){
//            JOptionPane.showMessageDialog(null, "You already selected this seat.", "Sorry", JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//        if(seatList.get(seatNum).isOccupied()) {
//            JOptionPane.showMessageDialog(null, "This seat is occupied.", "Sorry", JOptionPane.WARNING_MESSAGE);
//            return;
//        }
//        else{
//            int seatIt = JOptionPane.showConfirmDialog(null, "You want to seat on this seat?", "Prompt", JOptionPane.YES_NO_CANCEL_OPTION);
//            if(seatIt == JOptionPane.YES_OPTION) {
//                int changeLevel;
//                if (seatList.get(seatNum).getSeatLevel() != passenger.getSeatLevel()) {
//                    if(passenger.getSeatLevel() != null){
//                        changeLevel = JOptionPane.showConfirmDialog(null, "Your current class is " + passenger.getSeatLevel() + " class, do you want to change the level to " + seatList.get(seatNum).getSeatLevel(), "Prompt", JOptionPane.YES_NO_CANCEL_OPTION);
//                    }else{
//                        changeLevel = JOptionPane.showConfirmDialog(null, "Do you want to set your set level to " + seatList.get(seatNum).getSeatLevel(), "Prompt", JOptionPane.YES_NO_CANCEL_OPTION);
//                    }
//
//                    if (changeLevel == JOptionPane.YES_OPTION)
//                        passenger.setSeatLevel(seatList.get(seatNum).getSeatLevel());
//                    else{
//                        return;
//                    }
//                }
//                exclusiveCheck((JButton) e.getSource());
//                seatList.get(seatNum).setOccupied(true);
//                selectedButton = (JButton) e.getSource();
//                passenger.setSeatNumber(seatNum);
//                passenger.setSeatLevel(seatList.get(seatNum).getSeatLevel());
//                //price = seatList.get(seatNum).getSeatCost();
//                currentPrice = initPrice + seatList.get(seatNum).getSeatCost();
//                updateTex();
//                ((JButton) e.getSource()).setBorder(BorderFactory.createLineBorder(Color.GREEN ,1));
//                lastSeatNum = seatNum;
//            }
//        }
//    }
//
//    public void exclusiveCheck(JButton b){
//        if(lastSeatNum == -1){
//            return;
//        }else if(bts.get(lastSeatNum) != b){
//            seatList.get(lastSeatNum).setOccupied(false);
//            bts.get(lastSeatNum).setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
//        }else if(bts.get(lastSeatNum) == b){
//            return;
//        }
//    }
//
//    public void render(ArrayList<Seat> s, Passenger p, int initPrice, int airline){
//        ImageIcon airlineImg = null;
//        JLabel welcome = new JLabel();
//        if(airline == 1){ airlineImg = new ImageIcon("src/main/java/boundary/images/britishAirway.png"); welcome.setText("Welcome to Air China!");}
//        if(airline == 2){ airlineImg = new ImageIcon("src/main/java/boundary/images/easternAirway.png" ); welcome.setText("Welcome to British Airway!");}
//        if(airline == 3){ airlineImg = new ImageIcon("src/main/java/boundary/images/airChina.png" ); welcome.setText("Welcome to China Eastern!");}
//        if(airline == 4){ airlineImg = new ImageIcon("src/main/java/boundary/images/chinaEastern.png"); welcome.setText("Welcome to Eastern Airline!");}
//        JLabel imgLabel = new JLabel();
//
//        airlineImg.setImage(airlineImg.getImage().getScaledInstance(iconPanel.getWidth(), iconPanel.getHeight(), Image.SCALE_DEFAULT)); //set size
//        imgLabel.setIcon(airlineImg);
//        seatList = s;
//        passenger = p;
//        this.initPrice = initPrice;
//        this.airline = airline;
//        currentPrice = initPrice;
//        for(JButton b : bts){
//            if(seatList != null && seatList.get(bts.indexOf(b)).isOccupied())
//                b.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
//        }
//
//        infoPanel.setBorder(BorderFactory.createTitledBorder(passenger.getFirstname() + " " + passenger.getSurname()));
//        tex.setEditable(false);
//        iconPanel.add(imgLabel, BorderLayout.NORTH);
//        iconPanel.add(welcome, BorderLayout.SOUTH);
//        imgLabel.setBounds(0,0,350,200);
//        updateTex();
//    }
//
//    public void updateTex(){
//        String seatLevel, seatNumber;
//        if(passenger.getSeatLevel() == null)   {seatLevel = "not Selected";}
//        else {seatLevel = passenger.getSeatLevel() + "";}
//        if(passenger.getSeatNumber() == -1) { seatNumber = "not Selected";}
//        else {seatNumber = passenger.getSeatNumber() + "";}
//        tex.setText("Your seat level: " + seatLevel + "\nYour seat number:" + seatNumber
//                + "\nYour seat price: " + seatList.get(passenger.getSeatNumber()).getSeatCost() + "\nYour price now:" + currentPrice);
//        tex.setFont(new Font("Arial",Font.PLAIN,15));
//    }
//
//    public int resultSeatNumber(){
//        return passenger.getSeatNumber();
//    }
//
//    public String resultSeatLevel(){
//        return passenger.getSeatLevel();
//    }
//    public void NotChooseWarning(){
//        JOptionPane.showMessageDialog(this, "You haven't choose your seat yet", "Exception occurs",JOptionPane.WARNING_MESSAGE);
//    }
//
//}
package boundary;

import model.Passenger;
import model.Seat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import model.Airline;
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
    int initPrice;
    int currentPrice;
    int airline;
    JButton confirm;
    JButton withdraw;
    JButton back;
    JPanel iconPanel;

    int lastSeatNum = -1;
    public SeatPanel(){
        int count = 0;
        //this.setSize(new Dimension(400, 500));
        controlPanel = new JPanel();
        controlPanel.setLayout(null);
        economicPanel = new JPanel();
        businessPanel = new JPanel();
        specialSeatPanel = new JPanel();
        iconPanel = new JPanel();
        infoPanel = new JPanel();
        businessPanel.setBounds(350,0,200,350);
        economicPanel.setBounds(550,0,350,600);
        specialSeatPanel.setBounds(350,350,200,250);
        controlPanel.setBounds(250,600,400,100);
        infoPanel.setBounds(0, 200, 350, 400);
        iconPanel.setBounds(0,0,350,200);
        economicPanel.setBorder(BorderFactory.createTitledBorder("Economic Seat"));
        businessPanel.setBorder(BorderFactory.createTitledBorder("Business Seat"));
        specialSeatPanel.setBorder(BorderFactory.createTitledBorder("Special Seat"));
        iconPanel.setBorder(BorderFactory.createTitledBorder("Airline"));
        economicPanel.setLayout(null);
        businessPanel.setLayout(null);
        specialSeatPanel.setLayout(null);
        iconPanel.setLayout(new BorderLayout());
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
        iconPanel.setVisible(true);

        confirm = new JButton("Confirm");
        confirm.setBounds(20,20,100,40);


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
                    currentPrice = initPrice;
                    updateTex();
                }
            }
        });


        back = new JButton("Back");
        back.setBounds(260,20,100,40);
        controlPanel.add(back);
        controlPanel.add(confirm);
        controlPanel.add(withdraw);


        this.setLayout(new BorderLayout());
        this.add(businessPanel);
        this.add(economicPanel);
        this.add(specialSeatPanel);
        this.add(controlPanel);
        this.add(infoPanel);
        this.add(iconPanel);
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
                currentPrice = initPrice + seatList.get(seatNum).getSeatCost();
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

    public void render(ArrayList<Seat> s, Passenger p, int initPrice, int airline){
        ImageIcon airlineImg = null;
        JLabel welcome = new JLabel();
        if(airline == 1){ airlineImg = new ImageIcon("src/main/java/boundary/images/britishAirway.png"); welcome.setText("Welcome to Air China!");}
        if(airline == 2){ airlineImg = new ImageIcon("src/main/java/boundary/images/easternAirway.png" ); welcome.setText("Welcome to British Airway!");}
        if(airline == 3){ airlineImg = new ImageIcon("src/main/java/boundary/images/airChina.png" ); welcome.setText("Welcome to China Eastern!");}
        if(airline == 4){ airlineImg = new ImageIcon("src/main/java/boundary/images/chinaEastern.png"); welcome.setText("Welcome to Eastern Airline!");}
        JLabel imgLabel = new JLabel();

        airlineImg.setImage(airlineImg.getImage().getScaledInstance(iconPanel.getWidth(), iconPanel.getHeight(), Image.SCALE_DEFAULT)); //set size
        imgLabel.setIcon(airlineImg);
        seatList = s;
        passenger = p;
        this.initPrice = initPrice;
        this.airline = airline;
        for(JButton b : bts){
            if(seatList != null && seatList.get(bts.indexOf(b)).isOccupied())
                b.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
        }

        if(passenger.getSeatNumber() < 0) {currentPrice = initPrice;
        }else{
            currentPrice = initPrice + seatList.get((p.getSeatNumber())).getSeatCost();
            bts.get(passenger.getSeatNumber()).setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
            selectedButton = bts.get(passenger.getSeatNumber());
            lastSeatNum = passenger.getSeatNumber();
            seatList.get(lastSeatNum).setOccupied(true);
        }

        infoPanel.setBorder(BorderFactory.createTitledBorder(passenger.getFirstname() + " " + passenger.getSurname()));
        tex.setEditable(false);
        iconPanel.add(imgLabel, BorderLayout.NORTH);
        iconPanel.add(welcome, BorderLayout.SOUTH);
        imgLabel.setBounds(0,0,350,200);
        updateTex();
    }

    public void updateTex(){
        String seatLevel, seatNumber;
        int seatCost;
        if(passenger.getSeatLevel() == null)   {seatLevel = "not Selected";}
        else {seatLevel = passenger.getSeatLevel() + "";}
        if(passenger.getSeatNumber() == -1) { seatNumber = "not Selected"; seatCost = 0;}
        else {seatNumber = passenger.getSeatNumber() + ""; seatCost = seatList.get(passenger.getSeatNumber()).getSeatCost();}
        tex.setText("Your seat level: " + seatLevel + "\nYour seat number:" + seatNumber
                + "\nYour seat price: " + seatCost + "\nYour price now:" + currentPrice);
        tex.setFont(new Font("Arial",Font.PLAIN,15));
    }

    public int resultSeatNumber(){
        return passenger.getSeatNumber();
    }

    public String resultSeatLevel(){
        return passenger.getSeatLevel();
    }
    public void NotChooseWarning(){
        JOptionPane.showMessageDialog(this, "You haven't choose your seat yet", "Exception occurs",JOptionPane.WARNING_MESSAGE);
    }

}


package boundary;

import controller.AirlineMealController;
import model.Meal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class ChooseMealPage extends JPanel {

    private JPanel airlinePanel;
    private JPanel mealPanel;
    private JPanel controlPanel;
    private JLabel priceLabel;
    private JPanel mealImgPanel = new JPanel();
    private JComboBox chooseBox = new JComboBox();
    private Meal meal;



    JLabel pageIntro = new JLabel();
    JPanel logoPanel = new JPanel();

    
    JButton confirm;
    
    JButton back;

    JButton withdraw;

    public ChooseMealPage() {

        this.setLayout(null);

//        panelTop = new JPanel();
//        panelMid = new JPanel();
//        panelBot = new JPanel();
//        panelTop.setLayout(new BorderLayout());
        airlinePanel = new JPanel();
        controlPanel = new JPanel();
        mealPanel = new JPanel();
        priceLabel = new JLabel("Price: 0");


        pageIntro.setFont(new Font("Arial", Font.PLAIN, 15));

        mealPanel.setLayout(null);
        controlPanel.setLayout(null);
        airlinePanel.setLayout(null);
        airlinePanel.setBounds(0,0,450,500);
        controlPanel.setBounds(250,580,400,100);
        mealPanel.setBounds(460,0,400,500);
        pageIntro.setBounds(10,320,450,100);
//        mealListPanel.setBounds(20,10,300,200);
        chooseBox.setBounds(40,45,330,20);
        priceLabel.setBounds(320,45,40,20);
        mealImgPanel.setBounds(10,180,380,300);
        airlinePanel.setBorder(BorderFactory.createTitledBorder("Airline"));
        mealPanel.setBorder(BorderFactory.createTitledBorder("Choose your meal here"));
        this.setVisible(true);
        mealPanel.setVisible(true);
        controlPanel.setVisible(true);
        airlinePanel.setVisible(true);
        priceLabel.setVisible(true);
//        mealListPanel.setVisible(true);


        confirm = new JButton("Confirm");
        back = new JButton("Back");
        withdraw = new JButton("Withdraw");
        back.setBounds(260,0,100,40);
        confirm.setBounds(20,0,100,40);
        withdraw.setBounds(140,0,100,40);

        airlinePanel.add(pageIntro);

        this.add(airlinePanel);
        this.add(controlPanel);
        this.add(mealPanel);

        controlPanel.add(back);
        controlPanel.add(confirm);
        controlPanel.add(withdraw);
        airlinePanel.add(logoPanel);
        mealPanel.add(chooseBox);
        mealPanel.add(mealImgPanel);
//        chooseBox.addItemListener(new ItemListener() {
//            @Override
//            public void itemStateChanged(ItemEvent e) {
//                ImageIcon foodIcon = null;
//                JLabel mealImgLabel = null;
//                mealImgLabel = new JLabel();
//                foodIcon = new ImageIcon("src/main/java/boundary/images/Red Wine Braised Beef with Polenta.png");
//                mealImgPanel.setLayout(new BorderLayout());
//                foodIcon.setImage(foodIcon.getImage().getScaledInstance(mealImgPanel.getWidth(),mealImgPanel.getHeight(),Image.SCALE_DEFAULT));
//                mealImgLabel.setIcon(foodIcon);
//                mealImgPanel.add(mealImgLabel,BorderLayout.CENTER);
//                mealImgPanel.setVisible(true);
//            }
//        });
        chooseBox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ImageIcon foodIcon = null;
                    JLabel mealImgLabel = null;
                    mealImgLabel = new JLabel();
                    foodIcon = new ImageIcon("src/main/java/boundary/images/Red Wine Braised Beef with Polenta.png");
                    mealImgPanel.setLayout(new BorderLayout());
                    foodIcon.setImage(foodIcon.getImage().getScaledInstance(mealImgPanel.getWidth(),mealImgPanel.getHeight(),Image.SCALE_DEFAULT));
                    mealImgLabel.setIcon(foodIcon);
                    mealImgPanel.add(mealImgLabel,BorderLayout.CENTER);
                    mealImgPanel.setVisible(true);
                }
            });


    }

    public void render(ArrayList<Meal> meals, Integer airlineID){
        JLabel airlineLogoLabel= new JLabel();
        ImageIcon airlineIcon = null;

        chooseBox.removeAllItems();
        chooseBox.addItem(makeObj(""));
        for (Meal meal : meals) {
            chooseBox.addItem(makeObj(meal.getMealName()+"    Price: "+meal.getMealCost()));
        }


        logoPanel.setLayout(new BorderLayout());
        logoPanel.setBounds(10,20,430,300);
        if(airlineID == 1){airlineIcon= new ImageIcon("src/main/java/boundary/images/britishAirway.png");pageIntro.setText("Welcome to British Airway! Best meals prepared!");}
        if(airlineID == 2){airlineIcon= new ImageIcon("src/main/java/boundary/images/easternAirway.png");pageIntro.setText("Welcome to Eastern Airway! You will never forget these meals!");}
        if(airlineID == 3){airlineIcon= new ImageIcon("src/main/java/boundary/images/airChina.png");pageIntro.setText("Welcome to Air China! Good meals bring good travel!");}
        if(airlineID == 4){airlineIcon= new ImageIcon("src/main/java/boundary/images/chinaEastern.png");pageIntro.setText("Welcome to China Eastern! The best flight kitchen here!");}

        airlineIcon.setImage(airlineIcon.getImage().getScaledInstance(logoPanel.getWidth(),logoPanel.getHeight(),Image.SCALE_DEFAULT));
        airlineLogoLabel.setIcon(airlineIcon);
        logoPanel.add(airlineLogoLabel,BorderLayout.CENTER);
        logoPanel.setVisible(true);

    }

    private Object makeObj(final String item)  {
        return new Object() { public String toString() { return item; } };
    }

    private void updatePrice(int price){
        priceLabel.setText("Price: "+price);
    }


    public void refresh(){
        chooseBox.removeAllItems();
    }
    public void withdraw(){
        chooseBox.setSelectedIndex(0);
    }

    public JButton getBack() {
        return back;
    }
    public JButton getConfirm() {
        return confirm;
    }
    public JButton getWithdraw() {
        return withdraw;
    }
    public int getMeal(){
        return chooseBox.getSelectedIndex();
    }
    public void mealNotChosenWarning(){
        JOptionPane.showMessageDialog(this, "You haven't choose your meal yet.", "Exception occurs",JOptionPane.WARNING_MESSAGE);
    }


}

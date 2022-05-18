package boundary;

import model.Meal;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class ChooseMealPage extends JPanel {

    private JPanel panelTop;
    private JPanel panelMid;
    private JPanel panelBot;

    JLabel pageIntro = new JLabel("Here you can choose your meal.");
    JLabel AirlineLogo;
    JComboBox chooseBox;



    JButton confirm;



    JButton back;


    JButton withdraw;

    ArrayList<String> testing = new ArrayList<>();


    public ChooseMealPage() {

        this.setLayout(new GridLayout(3,1,100,0));

        panelTop = new JPanel();
        panelMid = new JPanel();
        panelBot = new JPanel();

        this.add(panelTop);
        this.add(panelMid);
        this.add(panelBot);

        confirm = new JButton("Confirm");
        back = new JButton("Back to init");
        confirm = new JButton("Confirm");
        withdraw = new JButton("Withdraw");

        AirlineLogo = new JLabel("");

        testing.add("Meal1");
        testing.add("Meal2");
        testing.add("Meal3");
        testing.add("Meal4");

        chooseBox = new JComboBox();

        panelMid.add(chooseBox);
        panelBot.add(back);
        panelBot.add(confirm);
        panelBot.add(withdraw);

        panelTop.add(pageIntro);


    }

    public void render(ArrayList<Meal> meals, Integer airlineID){

        chooseBox.addItem(makeObj(""));

        for (Meal meal : meals) {
            chooseBox.addItem(makeObj(meal.getMealName()));
        }
        ImageIcon easternAirline= new ImageIcon("src/main/java/boundary/images/easternAirline.jpg");
        easternAirline.setImage(easternAirline.getImage().getScaledInstance(200,100,1));
        AirlineLogo.setIcon(easternAirline);
        panelTop.add(AirlineLogo);

    }

    private Object makeObj(final String item)  {
        return new Object() { public String toString() { return item; } };
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

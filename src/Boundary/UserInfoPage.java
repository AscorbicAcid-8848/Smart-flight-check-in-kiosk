package Boundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserInfoPage extends JPanel implements ActionListener {

    private JLabel label_overall;// = new JLabel("Account Information");
//   JLabel label_surname;// = new JLabel("Xu");//写死的数据，之后会和后端对接
    private JLabel label_name;
//    JLabel label_firstname;// = new JLabel("Ran");
    private JLabel label_IdNum;

    private JButton button_backToInit;
    private JButton button_next;

    public UserInfoPage(){
        label_overall = new JLabel("Account Information");
//        label_surname = new JLabel("");
        label_name = new JLabel("Name:");
//        label_firstname  = new JLabel("Ran");
        label_IdNum = new JLabel("ID Number:");
        button_backToInit = new JButton("Go Back");
        button_next = new JButton("Next");

//        button_next.addActionListener(this);
//        button_backToInit.addActionListener(this);

        this.setLayout(new GridLayout(4,1));
        add(label_overall);
        add(label_name);
        add(label_IdNum);
        add(button_backToInit);
    }

    public JButton getButton_backToInit() {
        return button_backToInit;
    }

    public JButton getButton_next() {
        return button_next;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

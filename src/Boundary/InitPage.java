package Boundary;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class InitPage extends JFrame implements ActionListener {
    //此次登录的用户对象
    private static Passenger passenger =new Passenger();
    //此次登录的航空公司对象
    private Airline airline = new Airline();
    //此次登录的登机牌对象
    private BoardingPass boardingPass = new BoardingPass();
    //此次登录的航班对象
    private Flight flight = new Flight();
    //此次登录的Id doc
    private IdDocument idDocument = new IdDocument();

    //最高级panel：所有页面的容器
    private JPanel framePanel;

    //与InitPage 有关的组件以及容器
    private JButton button_bookNum;
    private JButton button_UserInfo;
    private JButton button_Scan;
    private JPanel panel_InitPage;

    //LoginByNameIdPage
    private LoginByNameIdPage panel_LoginByNameIdPage;
    private JButton button_LoginByNameId_backToInit;
    private JButton button_LoginByNameId_confirm;

    //LoginByIdDocPage
    private LoginByIdDocPage panel_LoginByIdDocPage;
    private JButton button_LoginByIdDocPage_backToInit;

    //UserInfoPage
    private UserInfoPage panel_UserInfoPage;
    private JButton button_userinfo_backToInit;

    public InitPage(){//此方法作用：初始化Frame 及framePanel，不作对于panel的修改

        framePanel = new JPanel();
        setPanelInitPage();
        setOtherPages();
        showInitPage();//第一次进入，展示initpage内容
        setBounds(300,300,977,717);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void setPanelInitPage(){

        JLabel label_Login = new JLabel("Welcome, Choose a way to login!");
        button_bookNum = new JButton("Booking Number");
        button_UserInfo = new JButton("User info");
        button_Scan = new JButton("Scan ID document");
        panel_InitPage = new JPanel();

        button_bookNum.addActionListener(this);
        button_UserInfo.addActionListener(this);
        button_Scan.addActionListener(this);

        panel_InitPage.setLayout(new GridLayout(4,1));
        panel_InitPage.add(label_Login);
        panel_InitPage.add(button_bookNum);
        panel_InitPage.add(button_UserInfo);
        panel_InitPage.add(button_Scan);

    }
    public void showInitPage(){
        add(framePanel);
        framePanel.add(panel_InitPage);
    }
    public void setOtherPages(){//实例化每一个界面的panel对象，以及拿到对应panel里面的按钮，并给按钮绑定事件
        panel_UserInfoPage = new UserInfoPage();
        button_userinfo_backToInit = panel_UserInfoPage.getButton_backToInit();
        button_userinfo_backToInit.addActionListener(this);

        panel_LoginByNameIdPage = new LoginByNameIdPage();
        button_LoginByNameId_backToInit = panel_LoginByNameIdPage.getButton_backToInit();
        button_LoginByNameId_confirm = panel_LoginByNameIdPage.getButton_confirm();
        button_LoginByNameId_backToInit.addActionListener(this);
        button_LoginByNameId_confirm.addActionListener(this);

        panel_LoginByIdDocPage = new LoginByIdDocPage();
        button_LoginByIdDocPage_backToInit = panel_LoginByIdDocPage.getButton_backToInit();
        button_LoginByIdDocPage_backToInit.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button_bookNum){
            //测试：点击此按钮进入userinfo界面
            pageChange(panel_UserInfoPage);
        }
        ///////////////////////////去往用名字Id登录的界面
        if(e.getSource() == button_UserInfo){
            pageChange(panel_LoginByNameIdPage);
        }
        //属于LoginByNameId,返回到最高级
        if(e.getSource()==button_LoginByNameId_backToInit){
            pageChange(panel_InitPage);
            refresh();
        }
        //属于LoginByNameId,确定登录,之后进入UserInfoPage
        //在前往userInfoPage之前，渲染界面。
        //to be added: 检查数据库里面有没有这个人，如果没有，不能通过。
        if(e.getSource()==button_LoginByNameId_confirm){
            boolean isValid = true;

            passenger.setSurname(panel_LoginByNameIdPage.getSurname());

            if(Objects.equals(passenger.getSurname(), "")){
                isValid = false;
                panel_LoginByNameIdPage.nameWarning();
            }

            try{
                passenger.setPassengerId(Integer.parseInt(panel_LoginByNameIdPage.getId()));
                panel_UserInfoPage.render(passenger);
            }
            catch(NumberFormatException exception){
                isValid = false;
                panel_LoginByNameIdPage.IdWarning();
            }
            if(isValid)
                pageChange(panel_UserInfoPage);
            else
                pageChange(panel_LoginByNameIdPage);
        }

        ////////////////////////////去往 扫描界面
        if(e.getSource()==button_Scan){
            pageChange(panel_LoginByIdDocPage);
        }
        //属于LoginByIdDocPage,返回最高级
        if(e.getSource()==button_LoginByIdDocPage_backToInit){
            pageChange(panel_InitPage);
            refresh();
        }
        //属于UserInfoPage,返回最高级
        if(e.getSource() == button_userinfo_backToInit){
            pageChange(panel_InitPage);
            refresh();
        }
    }

    public void pageChange(JPanel page){
        framePanel.removeAll();
        framePanel.repaint();
        framePanel.add(page);
        framePanel.validate();
    }

    //在返回到最高级之后，将所有带有输入框的页面refresh
    //并且将用户，航空公司等对象信息全部清零
    public void refresh(){
        panel_LoginByNameIdPage.refresh();

        passenger = new Passenger();
        airline = new Airline();
        boardingPass = new BoardingPass();
        idDocument = new IdDocument();
        flight = new Flight();
    }

}

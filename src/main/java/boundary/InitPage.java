package boundary;

import controller.BoardingPassController;
import controller.FlightController;
import controller.PassengerController;
import model.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class InitPage extends JFrame implements ActionListener {
    //此次登录的用户对象
    private Passenger passenger =new Passenger();
    //此次登录的航空公司对象
    private Airline airline = new Airline();
    //此次登录的登机牌对象
    private BoardingPass boardingPass = new BoardingPass();
    //此次登录的航班对象
    private Flight flight = new Flight();
    //此次登录的Id doc
    private IdDocument idDocument = new IdDocument();

    //controllers
    //BoardingPassController
    //返回一个乘客的登机牌
    //可以用在通过bookingnum登录页面
    BoardingPassController boardingPassController = new BoardingPassController();

    //FlightController
    //返回这个人的所有航班
    FlightController flightController = new FlightController();

    //PassengerController
    //检查乘客存不存在
    PassengerController passengerController = new PassengerController();

    //最高级panel：所有页面的容器
    private JPanel framePanel;

    //与InitPage 有关的组件以及容器
    private JButton button_bookNum;
    private JButton button_UserInfo;
    private JButton button_Scan;
    private JPanel panel_InitPage;
    private JPanel panel_top;
    private JPanel panel_bot;
    private ImageIcon heathrowImage;
    private JLabel heathrowLabel;


    //LoginByNameIdPage
    private LoginByNameIdPage panel_LoginByNameIdPage;
    private JButton button_LoginByNameId_backToInit;
    private JButton button_LoginByNameId_confirm;
    private JToggleButton button_LoginByNameId_see;
    private int see_type =1;

    //LoginByIdDocPage
    private LoginByIdDocPage panel_LoginByIdDocPage;
    private JButton button_LoginByIdDocPage_backToInit;

    //LoginByBookingNumPage
    private LoginByBookingNumPage panel_LoginByBookingNumPage;
    private JButton button_LoginByBookingNumPage_backToInit;
    private JButton button_LoginByBookingNumPage_next;
    private JToggleButton button_LoginByBookingNumPage_see;

    //UserInfoPage
    private UserInfoPage panel_UserInfoPage;
    private JButton button_userinfo_backToInit;

    //flight detail page
    private FlightDetailPage panel_flightDetailPage;
    private JButton button_flightDetailPage_confirm;
    private JButton button_flightDetailPage_back;

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

        JLabel label_Login = new JLabel("Welcome to London Heathrow, Choose a way login!");
        button_bookNum = new JButton("Booking Number");
        button_UserInfo = new JButton("User info");
        button_Scan = new JButton("Scan ID document");
        panel_InitPage = new JPanel();
        panel_bot = new JPanel();
        panel_top = new JPanel();
        heathrowImage = new ImageIcon("boundary/images/HeathrowAirport.jpg");
        heathrowLabel = new JLabel(heathrowImage);

        label_Login.setFont(new Font("SimSun", Font.PLAIN, 20));
        button_bookNum.setFont(new Font("Serif", Font.PLAIN, 15));
        button_UserInfo.setFont(new Font("Serif", Font.PLAIN, 15));
        button_Scan.setFont(new Font("Serif", Font.PLAIN, 15));

        button_bookNum.addActionListener(this);
        button_UserInfo.addActionListener(this);
        button_Scan.addActionListener(this);

//        panel_InitPage.add(heathrowLabel);
        heathrowLabel.setBounds(0,0,977,717);

        panel_InitPage.setLayout(new GridLayout(2,1,0,50));
        panel_bot.setLayout(new GridLayout(3,1,0,30));
        panel_InitPage.add(panel_top);
        panel_InitPage.add(panel_bot);
        panel_top.add(label_Login);
        panel_bot.add(button_bookNum);
        panel_bot.add(button_UserInfo);
        panel_bot.add(button_Scan);

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
        button_LoginByNameId_see = panel_LoginByNameIdPage.getButton_see();
        button_LoginByNameId_backToInit.addActionListener(this);
        button_LoginByNameId_confirm.addActionListener(this);
        button_LoginByNameId_see.addActionListener(this);
        
        panel_LoginByIdDocPage = new LoginByIdDocPage();
        button_LoginByIdDocPage_backToInit = panel_LoginByIdDocPage.getButton_backToInit();
        button_LoginByIdDocPage_backToInit.addActionListener(this);

        panel_LoginByBookingNumPage = new LoginByBookingNumPage();
        button_LoginByBookingNumPage_backToInit = panel_LoginByBookingNumPage.getButton_backToInit();
        button_LoginByBookingNumPage_next = panel_LoginByBookingNumPage.getButton_next();
        button_LoginByBookingNumPage_see = panel_LoginByBookingNumPage.getButton_see();
        button_LoginByBookingNumPage_see.addActionListener(this);
        button_LoginByBookingNumPage_next.addActionListener(this);
        button_LoginByBookingNumPage_backToInit.addActionListener(this);

        panel_flightDetailPage = new FlightDetailPage();
        button_flightDetailPage_back = panel_flightDetailPage.getButton_back();
        button_flightDetailPage_confirm = panel_flightDetailPage.getButton_confirm();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button_LoginByNameId_see){
            see_type = -see_type;
            if(see_type==-1)
            panel_LoginByNameIdPage.setId().setEchoChar('\0');
            else if(see_type ==1)
            panel_LoginByNameIdPage.setId().setEchoChar('*');
        }
        if(e.getSource() == button_LoginByBookingNumPage_see){
            see_type = -see_type;
            if(see_type==-1)
                panel_LoginByBookingNumPage.setId().setEchoChar('\0');
            else if(see_type ==1)
                panel_LoginByBookingNumPage.setId().setEchoChar('*');
        }
        ///////////////////////////去往用bookingNum登录页面
        if(e.getSource() == button_bookNum){

            pageChange(panel_LoginByBookingNumPage);
        }//属于LoginByBookingNum,返回到最高级
        if(e.getSource() == button_LoginByBookingNumPage_backToInit){
            pageChange(panel_InitPage);
            refresh();
        }
        //属于LoginByBookingNum,确定登录,之后进入FlightDetailPage
        //在前往FlightDetailPage之前，渲染界面。
        if(e.getSource() == button_LoginByBookingNumPage_next){
            boolean isValid = true;
            Integer bookingNum = null;
            if(Objects.equals(panel_LoginByBookingNumPage.getBookingNum(), "")){
                isValid = false;
                panel_LoginByBookingNumPage.bookingNumWarning();
            }
            else{
                try{
                    bookingNum = Integer.parseInt(panel_LoginByBookingNumPage.getBookingNum());
                }
                catch(NumberFormatException exception){
                    isValid = false;
                    panel_LoginByBookingNumPage.bookingNumFormatWarning();
                }
            }


            if(isValid){
                if(boardingPassController.checkPassenger(bookingNum)!=null){
                    passenger = boardingPassController.checkPassenger(bookingNum).getPassenger();
                    flight = boardingPassController.checkPassenger(bookingNum).getFlight();
                    panel_flightDetailPage.render(passenger,flight);
                    pageChange(panel_flightDetailPage);
                }
                else{
                    panel_LoginByBookingNumPage.bookingNumNonExistWarning();
                    pageChange(panel_LoginByBookingNumPage);
                }
            }
            else
                pageChange(panel_LoginByBookingNumPage);
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
            String surname;
            Integer passengerId = null;

            if(Objects.equals(panel_LoginByNameIdPage.getSurname(), "")){
                isValid = false;
                panel_LoginByNameIdPage.nameWarning();
            }
            surname = panel_LoginByNameIdPage.getSurname();
            try{
                passengerId = Integer.parseInt(panel_LoginByNameIdPage.getId());
            }
            catch(NumberFormatException exception){
                isValid = false;
                panel_LoginByNameIdPage.IdWarning();
            }
            if(isValid){
                if(passengerController.doesPassengerExist(surname,passengerId)){
                    passenger = boardingPassController.checkPassenger(surname,passengerId).getPassenger();
                    panel_UserInfoPage.render(passenger);
                    pageChange(panel_UserInfoPage);
                }
                else{
                    panel_LoginByNameIdPage.passengerNonExistWarning();
                    pageChange(panel_LoginByNameIdPage);
                }
            }

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
        panel_LoginByBookingNumPage.refresh();

        passenger = new Passenger();
        airline = new Airline();
        boardingPass = new BoardingPass();
        idDocument = new IdDocument();
        flight = new Flight();
    }

}

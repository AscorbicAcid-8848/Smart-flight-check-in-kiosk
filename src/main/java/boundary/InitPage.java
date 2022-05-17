package boundary;

import controller.BoardingPassController;
import controller.FlightController;
import controller.PassengerController;
import model.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class InitPage extends JFrame implements ActionListener {


    ///////////////////testing, constructor 里面进行初始化
    ArrayList<String> testing = new ArrayList<>();
    //////////////////testing, constructor 里面进行初始化
    ArrayList<Seat> seats = new ArrayList<Seat>();



    //此次登录的用户对象
    private Passenger passenger =new Passenger();
    //此次登录的航空公司对象
    private Airline airline = new Airline();
    //此次登录的登机牌对象
    private BoardingPass boardingPass = new BoardingPass();
    //此次登录的航班对象
    private Flight flight = new Flight();
    //此次登录的Id doc
    private IdDocumentCard idDocument = new IdDocumentCard();

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
    private JButton button_LoginByNameId_withdraw;
    private int see_type =1;

    //LoginByIdDocPage
    private LoginByIdDocPage panel_LoginByIdDocPage;
    private JButton button_LoginByIdDocPage_backToInit;

    //LoginByBookingNumPage
    private LoginByBookingNumPage panel_LoginByBookingNumPage;
    private JButton button_LoginByBookingNumPage_backToInit;
    private JButton button_LoginByBookingNumPage_next;
    private JButton button_LoginByBookingNum_withdraw;
    private JToggleButton button_LoginByBookingNumPage_see;

    //UserInfoPage
    private UserInfoPage panel_UserInfoPage;
    private JButton button_userinfo_backToInit;

    //flight detail page
    private FlightDetailPage panel_flightDetailPage;
    private JButton button_flightDetailPage_confirm;
    private JButton button_flightDetailPage_back;

    //ChooseMealPage
    private ChooseMealPage panel_chooseMealPage;
    private JButton button_chooseMealPage_confirm;
    private JButton button_chooseMealPage_back;
    private JButton button_chooseMealPage_withdraw;

    //choose seat page
    private SeatPanel panel_chooseSeat;
    private JButton button_chooseSeat_confirm;
    private JButton button_chooseSeat_back;
    //private JButton button_chooseSeat_withdraw;

    //paying page
    private PayingPage panel_payingPage;
    private JButton button_paying_confirm;
    private JButton button_paying_back;



    private int invalidTimes = 0;
    public InitPage(){//此方法作用：初始化Frame 及framePanel，不作对于panel的修改
//////////////////////////////////////////////
        testing.add("Meal1");
        testing.add("Meal2");
        testing.add("Meal3");
        testing.add("Meal4");
/////////////////////////////////////////////
        for(int i = 0; i < 10; i++){
            Seat s1 = new Seat();
            s1.setOccupied(false);
            s1.setSeatLevel("A");
            seats.add(s1);
        }

        for(int i = 0; i < 42; i++){
            Seat s1 = new Seat();
            s1.setOccupied(false);
            s1.setSeatLevel("B");
            seats.add(s1);
        }
        


        framePanel = new JPanel();

        setPanelInitPage();
        setOtherPages();
        showInitPage();//第一次进入，展示initpage内容
        setBounds(300,200,900,700);
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
        button_LoginByNameId_withdraw = panel_LoginByNameIdPage.getButton_withdraw();

        button_LoginByNameId_backToInit.addActionListener(this);
        button_LoginByNameId_confirm.addActionListener(this);
        button_LoginByNameId_see.addActionListener(this);
        button_LoginByNameId_withdraw.addActionListener(this);
        
        panel_LoginByIdDocPage = new LoginByIdDocPage();
        button_LoginByIdDocPage_backToInit = panel_LoginByIdDocPage.getButton_backToInit();
        button_LoginByIdDocPage_backToInit.addActionListener(this);

        panel_LoginByBookingNumPage = new LoginByBookingNumPage();
        button_LoginByBookingNumPage_backToInit = panel_LoginByBookingNumPage.getButton_backToInit();
        button_LoginByBookingNumPage_next = panel_LoginByBookingNumPage.getButton_next();
        button_LoginByBookingNumPage_see = panel_LoginByBookingNumPage.getButton_see();
        button_LoginByBookingNum_withdraw = panel_LoginByBookingNumPage.getButton_withdraw();
        button_LoginByBookingNumPage_see.addActionListener(this);
        button_LoginByBookingNumPage_next.addActionListener(this);
        button_LoginByBookingNumPage_backToInit.addActionListener(this);
        button_LoginByBookingNum_withdraw.addActionListener(this);

        panel_flightDetailPage = new FlightDetailPage();
        button_flightDetailPage_back = panel_flightDetailPage.getButton_back();
        button_flightDetailPage_confirm = panel_flightDetailPage.getButton_confirm();
        button_flightDetailPage_confirm.addActionListener(this);
        button_flightDetailPage_back.addActionListener(this);

        panel_chooseMealPage = new ChooseMealPage();
        button_chooseMealPage_back = panel_chooseMealPage.getBack();
        button_chooseMealPage_confirm = panel_chooseMealPage.getConfirm();
        button_chooseMealPage_withdraw = panel_chooseMealPage.getWithdraw();
        button_chooseMealPage_back.addActionListener(this);
        button_chooseMealPage_confirm.addActionListener(this);
        button_chooseMealPage_withdraw.addActionListener(this);

        panel_chooseSeat = new SeatPanel();
        panel_chooseSeat.setLayout(null);
        button_chooseSeat_confirm = panel_chooseSeat.getConfirm();
        button_chooseSeat_back = panel_chooseSeat.getBack();
        button_chooseSeat_back.addActionListener(this);
        button_chooseSeat_confirm.addActionListener(this);

        panel_payingPage = new PayingPage();
        button_paying_confirm = panel_payingPage.getButton_confirm();
        button_paying_back = panel_payingPage.getButton_back();
        button_paying_back.addActionListener(this);
        button_paying_confirm.addActionListener(this);

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
        if(e.getSource()==button_LoginByBookingNum_withdraw){
            panel_LoginByBookingNumPage.refresh();
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
                    if(panel_LoginByBookingNumPage.getBookingNum().length()!=5){
                        throw new NumberFormatException();
                    }
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
                    panel_flightDetailPage.render(passenger,flight,bookingNum);
                    pageChange(panel_flightDetailPage);
                    invalidTimes = 0;
                }
                else{
                    panel_LoginByBookingNumPage.bookingNumNonExistWarning(invalidTimes++);
                    if(invalidTimes<=5)
                        pageChange(panel_LoginByBookingNumPage);
                    else
                    {
                        enteringTimesWarning();
                        refresh();
                        pageChange(panel_InitPage);
                        invalidTimes = 0;
                    }
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
        // 属于LoginByNameId,撤销操作
        if(e.getSource()==button_LoginByNameId_withdraw){
            panel_LoginByNameIdPage.refresh();
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
                    invalidTimes = 0;
                }
                else{
                    panel_LoginByNameIdPage.passengerNonExistWarning(invalidTimes++);

                    if(invalidTimes<=5)
                        pageChange(panel_LoginByNameIdPage);
                    else
                    {
                        enteringTimesWarning();
                        refresh();
                        pageChange(panel_InitPage);
                        invalidTimes = 0;
                    }
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
        ////////////属于FlightDetailPage
        if(e.getSource() == button_flightDetailPage_back){
            pageChange(panel_InitPage);
            refresh();
        }//属于FlightDetailPage, to choosingMealPage
        if(e.getSource() == button_flightDetailPage_confirm){
            pageChange(panel_chooseMealPage);
            panel_chooseMealPage.render(testing, 1);
        }
        //////////////belongs to chooseMealPage, to origin
        if(e.getSource() == button_chooseMealPage_back){
            pageChange(panel_InitPage);
            refresh();
        }//////belongs to chooseMealPage, withdraw
        if(e.getSource() == button_chooseMealPage_withdraw){
            panel_chooseMealPage.withdraw();
        }///to chooseSeatPage
        if(e.getSource() == button_chooseMealPage_confirm){

            if(Objects.equals(panel_chooseMealPage.getMeal(), "")){
                panel_chooseMealPage.mealNotChosenWarning();

            }
            else {
                framePanel.setLayout(new BorderLayout());
                panel_chooseSeat.render(seats, passenger);
                framePanel.removeAll();
                framePanel.repaint();
                framePanel.add(panel_chooseSeat, BorderLayout.CENTER);
                framePanel.validate();
            }
        }
        ////////////////////////belongs to chooseSeatPage, back to chooseMealPage
        if(e.getSource() == button_chooseSeat_back){
            framePanel.setLayout(new FlowLayout());
            pageChange(panel_chooseMealPage);
        }

        ///belongs to chooseSeatPage, to paying page
        if(e.getSource() == button_chooseSeat_confirm){
            framePanel.setLayout(new FlowLayout());
            pageChange(panel_payingPage);
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
        panel_chooseMealPage.refresh();

        passenger = new Passenger();
        airline = new Airline();
        boardingPass = new BoardingPass();
        idDocument = new IdDocumentCard();
        flight = new Flight();
    }
    public void enteringTimesWarning(){
        JOptionPane.showMessageDialog(this, "Entered more than 5 times, system will init again", "Exception occurs",JOptionPane.WARNING_MESSAGE);
    }

}

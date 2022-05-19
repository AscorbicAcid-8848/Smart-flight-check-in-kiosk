package boundary;

import controller.*;
import model.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class InitPage extends JFrame implements ActionListener {

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
    //此次登录的meal
    private Meal meal = new Meal();

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

    AirlineMealController airlineMealController = new AirlineMealController();

    FlightSeatController flightSeatController = new FlightSeatController();

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
    private JButton button_LoginByNameId_withdraw;

    //LoginByIdDocPage
    private LoginByIdDocPage panel_LoginByIdDocPage;
    private JButton button_LoginByIdDocPage_backToInit;
    private JButton button_LoginByIdDoc_login;

    //LoginByBookingNumPage
    private LoginByBookingNumPage panel_LoginByBookingNumPage;
    private JButton button_LoginByBookingNumPage_backToInit;
    private JButton button_LoginByBookingNumPage_next;
    private JButton button_LoginByBookingNum_withdraw;


    //UserInfoPage
    private UserInfoPage panel_UserInfoPage;
    private JButton button_userinfo_backToInit;
    private JButton button_userinfo_next;

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


    //all flights page
    private AllFlightsPage panel_allFlights;
    private ArrayList<JButton> flightButtons;

    //final confirm page
    private FinalConfirmPage panel_finalConfirm;
    private JButton button_finalConfirm;





    private int invalidTimes = 0;
    private Integer bookingNum = null;
    private boolean loginViaBookingNum = false;

    public InitPage(){//此方法作用：初始化Frame 及framePanel，不作对于panel的修改
/////////////////////////////////////////////
        for(int i = 0; i < 10; i++){
            Seat s1 = new Seat();
            s1.setOccupied(true);
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
        button_userinfo_next = panel_UserInfoPage.getButton_next();
        button_userinfo_backToInit.addActionListener(this);
        button_userinfo_next.addActionListener(this);

        panel_LoginByNameIdPage = new LoginByNameIdPage();
        button_LoginByNameId_backToInit = panel_LoginByNameIdPage.getButton_backToInit();
        button_LoginByNameId_confirm = panel_LoginByNameIdPage.getButton_confirm();
        button_LoginByNameId_withdraw = panel_LoginByNameIdPage.getButton_withdraw();

        button_LoginByNameId_backToInit.addActionListener(this);
        button_LoginByNameId_confirm.addActionListener(this);
        button_LoginByNameId_withdraw.addActionListener(this);
        
        panel_LoginByIdDocPage = new LoginByIdDocPage();
        button_LoginByIdDocPage_backToInit = panel_LoginByIdDocPage.getButton_backToInit();
        button_LoginByIdDoc_login = panel_LoginByIdDocPage.getLogin();
        button_LoginByIdDoc_login.addActionListener(this);
        button_LoginByIdDocPage_backToInit.addActionListener(this);

        panel_LoginByBookingNumPage = new LoginByBookingNumPage();
        button_LoginByBookingNumPage_backToInit = panel_LoginByBookingNumPage.getButton_backToInit();
        button_LoginByBookingNumPage_next = panel_LoginByBookingNumPage.getButton_next();
        button_LoginByBookingNum_withdraw = panel_LoginByBookingNumPage.getButton_withdraw();
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


        panel_allFlights = new AllFlightsPage();


        panel_finalConfirm = new FinalConfirmPage();
        button_finalConfirm = panel_finalConfirm.getButton_confirm();
        button_finalConfirm.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ///////////////////////////去往用bookingNum登录页面
        if(e.getSource() == button_bookNum){
            loginViaBookingNum = true;
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
        // userinfo page, click "check my flights" to check all flights.

        if(e.getSource()==button_userinfo_next){
            framePanel.setLayout(new BorderLayout());
            panel_allFlights.render((ArrayList<Flight>) flightController.getBySurnameAndPassengerId(passenger.getSurname(),passenger.getPassengerId()));
            //render之后才能拿到所有的按钮///////////////////////
            flightButtons = panel_allFlights.getButtonList();//成功拿到
            for (JButton flightButton : flightButtons) flightButton.addActionListener(this);

            framePanel.removeAll();
            framePanel.repaint();
            framePanel.add(panel_allFlights, BorderLayout.CENTER);
            framePanel.validate();
        }////用户点击了航班按钮中的一个,,离开allflights页面，去往航班细节页面
        //拿到flight对象
        try{
            if(flightButtons.contains((JButton) e.getSource())){
                flight = flightController.getBySurnameAndPassengerId(passenger.getSurname(),passenger.getPassengerId()).get(flightButtons.indexOf(e.getSource()));
                panel_flightDetailPage.render(passenger,flight,passenger.getBookingNumber().get(flightButtons.indexOf(e.getSource())));
                flightController.chooseFlight(flight.getFlightId());
                framePanel.setLayout(new FlowLayout());
                pageChange(panel_flightDetailPage);
            }
        }
        catch(NullPointerException ignored){
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
        //属于LoginByIdDocPage, login
        if(e.getSource()==button_LoginByIdDoc_login){
            if(boardingPassController.checkPassenger()==null){
                panel_LoginByIdDocPage.loginFailedWarning();
                pageChange(panel_LoginByIdDocPage);
            }
            else{
                passenger = boardingPassController.checkPassenger().getPassenger();
                panel_LoginByIdDocPage.loginSuccessDialog();
                panel_UserInfoPage.render(passenger);
                pageChange(panel_UserInfoPage);
            }
        }
        //属于UserInfoPage,返回最高级
        if(e.getSource() == button_userinfo_backToInit){
            pageChange(panel_InitPage);
            refresh();
        }
        ////////////属于FlightDetailPage
        if(e.getSource() == button_flightDetailPage_back){
            if(loginViaBookingNum){
                pageChange(panel_InitPage);
                refresh();
            }

            else{
                framePanel.setLayout(new BorderLayout());
                panel_allFlights.render((ArrayList<Flight>) flightController.getBySurnameAndPassengerId(passenger.getSurname(),passenger.getPassengerId()));
                framePanel.removeAll();
                framePanel.repaint();
                framePanel.add(panel_allFlights, BorderLayout.CENTER);
                framePanel.validate();
            }

        }//属于FlightDetailPage, to choosingMealPage
        if(e.getSource() == button_flightDetailPage_confirm){
            panel_chooseMealPage.render((ArrayList<Meal>)airlineMealController.showMeals(flight.getAirlineId()), 1);
            pageChange(panel_chooseMealPage);
        }
        //////////////belongs to chooseMealPage, to origin
        if(e.getSource() == button_chooseMealPage_back){
            panel_flightDetailPage.render(passenger,flight,bookingNum);
            pageChange(panel_flightDetailPage);
        }//////belongs to chooseMealPage, withdraw
        if(e.getSource() == button_chooseMealPage_withdraw){
            panel_chooseMealPage.withdraw();
        }///to chooseSeatPage
        if(e.getSource() == button_chooseMealPage_confirm){

            if(Objects.equals(panel_chooseMealPage.getMeal(), 0)){
                panel_chooseMealPage.mealNotChosenWarning();
            }
            else {
                meal = airlineMealController.showMeals(flight.getAirlineId()).get(panel_chooseMealPage.getMeal()-1);
                framePanel.setLayout(new BorderLayout());
                airlineMealController.selectMeal(passenger.getIdDocument(),flight.getAirlineId(),meal.getMealId());

                seats = (ArrayList<Seat>)flightSeatController.showSeats(flight.getFlightId());
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

//            if(panel_chooseSeat.i==1){
                passenger.setSeatLevel(panel_chooseSeat.resultSeatLevel());
                passenger.setSeatNumber(panel_chooseSeat.resultSeatNumber());

                flightSeatController.selectSeat(passenger.getIdDocument(),flight.getFlightId(),passenger.getSeatNumber());

                framePanel.setLayout(new FlowLayout());
                pageChange(panel_payingPage);
        }

        //belongs to paying page, back
        if(e.getSource() == button_paying_back){
            framePanel.setLayout(new BorderLayout());
            panel_chooseSeat.render(seats, passenger);
            framePanel.removeAll();
            framePanel.repaint();
            framePanel.add(panel_chooseSeat, BorderLayout.CENTER);
            panel_payingPage.refresh();
            invalidTimes = 0;
        }
        //belongs to paying page, confirm
        if(e.getSource() == button_paying_confirm){
            boolean isValid = true;
            Integer cardNum = null;
            String pin = null;
            if(Objects.equals(panel_payingPage.getCardNum(), "") || Objects.equals(pin = panel_payingPage.getPassword(), ""))
            {
                panel_payingPage.infoIncompleteWarning();
                pageChange(panel_payingPage);
                isValid = false;
            }
            else{
                try{
                    cardNum = Integer.parseInt(panel_payingPage.getCardNum());
                    if(panel_payingPage.getCardNum().length()!=5){
                        throw new NumberFormatException();
                    }
                }catch (NumberFormatException exception){
                    panel_payingPage.cardNumWarning();
                    pageChange(panel_payingPage);
                    isValid = false;
                }
            }

            if(isValid){
                if(passengerController.isCardPinCorrect(cardNum,passenger.getPassengerId(),passenger.getSurname(),pin)){
                    panel_payingPage.PayNotification(meal.getMealCost()+seats.get(panel_chooseSeat.resultSeatNumber()).getSeatCost());
                    panel_finalConfirm.render(passenger,flight,meal.getMealName());
                    pageChange(panel_finalConfirm);

                    invalidTimes = 0;
                }
                else{
                    panel_payingPage.nonExistWarning(invalidTimes++);
                    if(invalidTimes<=5)
                        pageChange(panel_payingPage);
                    else
                    {
                        enteringTimesWarning();
                        refresh();
                        pageChange(panel_InitPage);
                        invalidTimes = 0;
                    }
                }
            }
        }//属于finalconfirm页面，点击后结束程序。
        if(e.getSource() == button_finalConfirm){
            panel_finalConfirm.FinishNotification();
            System.exit(1);
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
        panel_payingPage.refresh();

        passenger = new Passenger();
        airline = new Airline();
        boardingPass = new BoardingPass();
        idDocument = new IdDocumentCard();
        flight = new Flight();

        loginViaBookingNum = false;
    }
    public void enteringTimesWarning(){
        JOptionPane.showMessageDialog(this, "Entered more than 5 times, system will init again", "Exception occurs",JOptionPane.WARNING_MESSAGE);
    }

}

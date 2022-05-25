package boundary;

import controller.*;
import javazoom.jl.decoder.JavaLayerException;
import model.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class InitPage extends JFrame implements ActionListener {
    /**
     * @author: Ran Xu
     * @date 2022/5/24
     * @version 6.0
     */

    ArrayList<Seat> seats = new ArrayList<Seat>();

    private Passenger passenger =new Passenger();

    private Flight flight = new Flight();

    private Meal meal = new Meal();

    BoardingPassController boardingPassController = new BoardingPassController();


    FlightController flightController = new FlightController();

    PassengerController passengerController = new PassengerController();

    AirlineMealController airlineMealController = new AirlineMealController();

    FlightSeatController flightSeatController = new FlightSeatController();

    private JPanel framePanel;

    //InitPage
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

    //paying page
    private PayingPage panel_payingPage;
    private JButton button_paying_confirm;
    private JButton button_paying_back;


    //all flights page
    private AllFlightsPage panel_allFlights;
    private ArrayList<JButton> flightButtons;
    private JButton button_allFlights_back;

    //final confirm page
    private FinalConfirmPage panel_finalConfirm;
    private JButton button_finalConfirm;


    private int invalidTimes = 0;
    private Integer bookingNum = null;
    private boolean loginViaBookingNum = false;

    /**
     * Constructor of init page.
     * Init page is in charge of all the transfers between pages
     */
    public InitPage(){
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

    /**
     * Set the init page
     */
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

    /**
     * In this method we get the buttons of other pages.
     */
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
        button_allFlights_back = panel_allFlights.getBack();
        button_allFlights_back.addActionListener(this);

        panel_finalConfirm = new FinalConfirmPage();
        button_finalConfirm = panel_finalConfirm.getButton_confirm();
        button_finalConfirm.addActionListener(this);
    }

    @Override
    /**
     * Here we listen all the buttons related with page transfer and determine the transfer relation.
     */
    public void actionPerformed(ActionEvent e) {

        //to login by bookingNum page
        if(e.getSource() == button_bookNum){
            loginViaBookingNum = true;
            pageChange(panel_LoginByBookingNumPage);
        }//belongs to LoginByBookingNum, back to init
        if(e.getSource() == button_LoginByBookingNumPage_backToInit){
            pageChange(panel_InitPage);
            refresh();
        }
        if(e.getSource()==button_LoginByBookingNum_withdraw){
            panel_LoginByBookingNumPage.refresh();
        }
        //belongs to LoginByBookingNum, enter FlightDetailPage
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
                    if(passengerController.isChecked(passenger.getPassengerId(),passenger.getSurname(),bookingNum)){
                        panel_LoginByBookingNumPage.alreadyCheckedWarning();
                        refresh();
                        return;
                    }
                    else{
                        panel_flightDetailPage.render(passenger,flight,bookingNum);
                        pageChange(panel_flightDetailPage);
                        invalidTimes = 0;
                    }
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
        //to login by id name page.
        if(e.getSource() == button_UserInfo){
            pageChange(panel_LoginByNameIdPage);
        }
        //belongs to LoginByNameId, back to init
        if(e.getSource()==button_LoginByNameId_backToInit){
            pageChange(panel_InitPage);
            refresh();
        }
        // belongs to LoginByNameId, withdraw
        if(e.getSource()==button_LoginByNameId_withdraw){
            panel_LoginByNameIdPage.refresh();
        }
        //belongs to LoginByNameId
        //userInfoPage
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
            ArrayList<Flight> filteredFlightList = (ArrayList<Flight>) flightController.getBySurnameAndPassengerId(passenger.getSurname(),passenger.getPassengerId());
            for (int i = 0 ; i < filteredFlightList.size(); i++) {
                if(passengerController.isChecked(passenger.getPassengerId(),passenger.getSurname(), passenger.getBookingNumber().get(i))){
                    filteredFlightList.remove(filteredFlightList.get(i));
                }
            }
            if(filteredFlightList.size() == 0){
                panel_UserInfoPage.noFlightsWarning();
                return;
            }

            framePanel.setLayout(new BorderLayout());
            panel_allFlights.render(filteredFlightList);
            flightButtons = panel_allFlights.getButtonList();
            for (JButton flightButton : flightButtons) flightButton.addActionListener(this);

            framePanel.removeAll();
            framePanel.repaint();
            framePanel.add(panel_allFlights, BorderLayout.CENTER);
            framePanel.validate();
        }//user clicks a flight button
        try{
            if(flightButtons.contains((JButton) e.getSource())){
                flight = flightController.getBySurnameAndPassengerId(passenger.getSurname(),passenger.getPassengerId()).get(flightButtons.indexOf(e.getSource()));
                bookingNum = passenger.getBookingNumber().get(flightButtons.indexOf(e.getSource()));
                panel_flightDetailPage.render(passenger,flight,bookingNum);
                flightController.chooseFlight(flight.getFlightId());
                framePanel.setLayout(new FlowLayout());
                pageChange(panel_flightDetailPage);
            }
        }
        catch(NullPointerException ignored){
        }
        if(e.getSource() == button_allFlights_back){
            panel_UserInfoPage.render(passenger);
            framePanel.setLayout(new FlowLayout());
            pageChange(panel_UserInfoPage);

        }
        //to LoginByIdDocPage
        if(e.getSource()==button_Scan){
            try {
                panel_LoginByIdDocPage.detectedAudio();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (JavaLayerException ex) {
                ex.printStackTrace();
            }
            pageChange(panel_LoginByIdDocPage);
        }
        //LoginByIdDocPage, to init
        if(e.getSource()==button_LoginByIdDocPage_backToInit){
            pageChange(panel_InitPage);
            refresh();
        }
        //LoginByIdDocPage, login
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
        //UserInfoPage,to init
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
                ArrayList<Flight> filteredFlightList = (ArrayList<Flight>) flightController.getBySurnameAndPassengerId(passenger.getSurname(),passenger.getPassengerId());
                for (int i = 0 ; i < filteredFlightList.size(); i++) {
                    if(passengerController.isChecked(passenger.getPassengerId(),passenger.getSurname(), passenger.getBookingNumber().get(i))){
                        filteredFlightList.remove(filteredFlightList.get(i));
                    }
                }
                panel_allFlights.render(filteredFlightList);
                framePanel.removeAll();
                framePanel.repaint();
                framePanel.add(panel_allFlights, BorderLayout.CENTER);
                framePanel.validate();
            }

        }//属于FlightDetailPage, to choosingMealPage
        if(e.getSource() == button_flightDetailPage_confirm){
//            panel_chooseMealPage.render((ArrayList<Meal>)airlineMealController.showMeals(flight.getAirlineId()), flight.getAirlineId());
            panel_chooseMealPage.render((ArrayList<Meal>)airlineMealController.showMeals(flight.getAirlineId()), flight.getAirlineId());

            framePanel.setLayout(new BorderLayout());
            framePanel.removeAll();
            framePanel.repaint();
            framePanel.add(panel_chooseMealPage, BorderLayout.CENTER);
            framePanel.validate();
            pageChange(panel_chooseMealPage);
        }
        //////////////belongs to chooseMealPage, to panel_flightDetailPage
        if(e.getSource() == button_chooseMealPage_back){
            panel_flightDetailPage.render(passenger,flight,bookingNum);
            framePanel.setLayout(new FlowLayout());
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
                panel_chooseSeat.render(seats, passenger, meal.getMealCost(),flight.getAirlineId());
                framePanel.removeAll();
                framePanel.repaint();
                framePanel.add(panel_chooseSeat, BorderLayout.CENTER);
                framePanel.validate();
            }
        }
        ////////////////////////belongs to chooseSeatPage, back to chooseMealPage
        if(e.getSource() == button_chooseSeat_back){
            panel_chooseMealPage.render((ArrayList<Meal>)airlineMealController.showMeals(flight.getAirlineId()), flight.getAirlineId());
            framePanel.removeAll();
            framePanel.repaint();
            framePanel.add(panel_chooseMealPage, BorderLayout.CENTER);
            framePanel.validate();
        }

        ///belongs to chooseSeatPage, to paying page
        if(e.getSource() == button_chooseSeat_confirm){

//            if(panel_chooseSeat.i==1){
            if(passenger.getSeatLevel() == null || passenger.getSeatNumber() == null || passenger.getSeatNumber() < 0){
                panel_chooseSeat.NotChooseWarning();
                return;
            }
                passenger.setSeatLevel(panel_chooseSeat.resultSeatLevel());
                passenger.setSeatNumber(panel_chooseSeat.resultSeatNumber());

                flightSeatController.selectSeat(passenger.getIdDocument(),flight.getFlightId(),passenger.getSeatNumber());

                framePanel.setLayout(new FlowLayout());
                pageChange(panel_payingPage);
        }

        //belongs to paying page, back
        if(e.getSource() == button_paying_back){
            framePanel.setLayout(new BorderLayout());
            panel_chooseSeat.render(seats, passenger,meal.getMealCost(),flight.getAirlineId());
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
                    if(panel_payingPage.getCardNum().length()!=8){
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
                    panel_finalConfirm.finalConfirmAudio();
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
            passengerController.check(passenger.getPassengerId(),passenger.getSurname(),bookingNum);
            boardingPassController.printBoardingPass(passenger,flight);
            boardingPassController.printCarryOnBaggageTag(passenger,flight);
            boardingPassController.printCheckinBaggageTicket(passenger,flight);
            System.exit(1);
        }
    }

    /**
     * Invoked to change page
     * @param page the new page to display
     */
    public void pageChange(JPanel page){
        framePanel.removeAll();
        framePanel.repaint();
        framePanel.add(page);
        framePanel.validate();
    }

    /**
     * When go back to init page, we need to refresh all pages and all model objects related with login process
     */
    public void refresh(){
        panel_LoginByNameIdPage.refresh();
        panel_LoginByBookingNumPage.refresh();
        panel_chooseMealPage.refresh();
        panel_payingPage.refresh();

        passenger = new Passenger();
        flight = new Flight();
        meal = new Meal();
        seats = new ArrayList<Seat>();

        loginViaBookingNum = false;
    }

    /**
     * When user enter more than 5 times, a warning will occur.
     */
    public void enteringTimesWarning(){
        JOptionPane.showMessageDialog(this, "Entered more than 5 times, system will init again", "Exception occurs",JOptionPane.WARNING_MESSAGE);
    }

}

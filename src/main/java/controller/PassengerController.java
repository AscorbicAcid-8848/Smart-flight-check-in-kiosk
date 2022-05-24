package controller;

import model.Passenger;
import service.PassengerService;
import service.imp.PassengerServiceImp;
import service.imp.PassengerTableServiceImp;

import java.util.Objects;

/**
 * @author YichenLiu
 * @description: TODO
 * @date 2022/4/8 18:16
 */
public class PassengerController {

    /**
     *
     * @param surname
     * @param passengerId
     * @return check the passenger
     */
    public boolean doesPassengerExist(String surname, Integer passengerId){
        PassengerService passengerService = new PassengerServiceImp();
        Passenger passenger = passengerService.searchBySurnameAndPassengerId(surname, passengerId);
        if(passenger != null){
            return true;
        }
        return false;
    }

    /**
     *
     * @param creditcardNum
     * @param passengerId
     * @param surname
     * @return check the visa id.
     */
    public Boolean doesCardExist(Integer creditcardNum, Integer passengerId, String surname){
        PassengerService passengerService = new PassengerServiceImp();
        Passenger passenger = passengerService.searchBySurnameAndPassengerId(surname, passengerId);
        if(Objects.equals(passenger.getVisaId(), creditcardNum)){
            return true;
        }
        return false;
    }

    /**
     *
     * @param creditcardNum
     * @param passengerId
     * @param surname
     * @param cardPin
     * @return check the visa card password
     */
    public Boolean isCardPinCorrect(Integer creditcardNum,Integer passengerId, String surname, String cardPin){
        PassengerService passengerService = new PassengerServiceImp();
        Passenger passenger = passengerService.searchBySurnameAndPassengerId(surname, passengerId);
        if(Objects.equals(passenger.getVisaPassword(), cardPin) && this.doesCardExist(creditcardNum, passengerId, surname)){
            return true;
        }
        return false;
    }

    /**
     *
     * @param passengerId
     * @param surname
     * @param bookingNumber
     */
    public void check(Integer passengerId, String surname, Integer bookingNumber){
        PassengerServiceImp passengerService = new PassengerServiceImp();
        PassengerTableServiceImp passengerTableListService = new PassengerTableServiceImp();
        Passenger passenger = passengerService.searchBySurnameAndPassengerId(surname, passengerId);
        String booknum = bookingNumber.toString();
        booknum = booknum.substring(0, 3);
        Integer flightId = Integer.parseInt(booknum);
        Integer idDocument = passenger.getIdDocument();
        passengerTableListService.setChecked(flightId,idDocument,true);
        passengerTableListService.toJSON();
    }

    /**
     *
     * @param passengerId
     * @param surname
     * @param bookingNumber
     * @return passenger's is checked status
     */
    public boolean isChecked(Integer passengerId, String surname, Integer bookingNumber){
        PassengerServiceImp passengerService = new PassengerServiceImp();
        PassengerTableServiceImp passengerTableListService = new PassengerTableServiceImp();
        Passenger passenger = passengerService.searchBySurnameAndPassengerId(surname, passengerId);
        String booknum = bookingNumber.toString();
        booknum = booknum.substring(0, 3);
        Integer flightId = Integer.parseInt(booknum);
        Integer idDocument = passenger.getIdDocument();
        return passengerTableListService.isChecked(flightId, idDocument);
    }

}

package controller;

import model.Passenger;
import service.FlightService;
import service.PassengerService;
import service.imp.FlightServiceImp;
import service.imp.PassengerServiceImp;

import java.util.Objects;

/**
 * @author YichenLiu
 * @description: TODO
 * @date 2022/4/8 18:16
 */
public class PassengerController {
    private PassengerService passengerService = new PassengerServiceImp();

    public boolean doesPassengerExist(String surname, Integer passengerId){
        Passenger passenger = passengerService.searchBySurnameAndPassengerId(surname, passengerId);
        if(passenger != null){
            return true;
        }
        return false;
    }

    public Boolean doesCardExist(Integer creditcardNum, Integer passengerId, String surname){
        Passenger passenger = passengerService.searchBySurnameAndPassengerId(surname, passengerId);
        if(Objects.equals(passenger.getCreditcardNum(), creditcardNum)){
            return true;
        }
        return false;
    }

    public Boolean isCardPinCorrect(Integer creditcardNum,Integer passengerId, String surname, String cardPin){
        Passenger passenger = passengerService.searchBySurnameAndPassengerId(surname, passengerId);
        if(Objects.equals(passenger.getCardPin(), cardPin) && this.doesCardExist(creditcardNum, passengerId, surname)){
            return true;
        }
        return false;
    }
}

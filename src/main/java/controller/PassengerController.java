package controller;

import model.Passenger;
import service.PassengerService;
import service.imp.PassengerServiceImp;

import java.util.Objects;

/**
 * @author YichenLiu
 * @description: TODO
 * @date 2022/4/8 18:16
 */
public class PassengerController {


    public boolean doesPassengerExist(String surname, Integer passengerId){
        PassengerService passengerService = new PassengerServiceImp();
        Passenger passenger = passengerService.searchBySurnameAndPassengerId(surname, passengerId);
        if(passenger != null){
            return true;
        }
        return false;
    }

    public Boolean doesCardExist(Integer creditcardNum, Integer passengerId, String surname){
        PassengerService passengerService = new PassengerServiceImp();
        Passenger passenger = passengerService.searchBySurnameAndPassengerId(surname, passengerId);
        if(Objects.equals(passenger.getVisaId(), creditcardNum)){
            return true;
        }
        return false;
    }

    public Boolean isCardPinCorrect(Integer creditcardNum,Integer passengerId, String surname, String cardPin){
        PassengerService passengerService = new PassengerServiceImp();
        Passenger passenger = passengerService.searchBySurnameAndPassengerId(surname, passengerId);
        if(Objects.equals(passenger.getVisaPassword(), cardPin) && this.doesCardExist(creditcardNum, passengerId, surname)){
            return true;
        }
        return false;
    }
}

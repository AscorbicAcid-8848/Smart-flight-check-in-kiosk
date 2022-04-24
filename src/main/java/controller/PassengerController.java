package controller;

import model.Passenger;
import service.FlightService;
import service.PassengerService;
import service.imp.FlightServiceImp;
import service.imp.PassengerServiceImp;

/**
 * @author YichenLiu
 * @description: TODO
 * @date 2022/4/8 18:16
 */
public class PassengerController {
    private PassengerService passengerService = new PassengerServiceImp();

    boolean doesPassengerExist(String surname, Integer id){
        Passenger passenger = passengerService.searchBySurnameAndPassengerId(surname, id);
        if(passenger != null){
            return true;
        }
        return false;
    }
    //更改自选
    public Passenger customChoices(Passenger passenger,Integer meal,Integer seatNumber,String seatLevel){
        passenger = passengerService.update(passenger,seatLevel,meal,seatNumber);
        return passenger;
    }
}

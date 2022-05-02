package controller;

import model.BoardingPass;
import model.Flight;
import model.IdDocument;
import model.Passenger;
import service.FlightService;
import service.PassengerService;
import service.imp.FlightServiceImp;
import service.imp.PassengerServiceImp;

import java.util.List;

/**
 * @author YichenLiu
 * @description: 操控乘客
 * @date 2022/3/16 17:16
 */
//这是我的登机牌controller
public class BoardingPassController {
    private FlightController flightController = new FlightController();
    private FlightService flightService = new FlightServiceImp();
    private PassengerService passengerService = new PassengerServiceImp();

    public BoardingPass checkPassenger(Integer bookingNumber){
        Passenger passenger = passengerService.searchByBookingNumber(bookingNumber);
        List<Flight> flightList = flightController.getByBookingNumber(bookingNumber);
        Flight currentFlight = new Flight();
        for(Flight flight:flightList){
            if(flight.getCurrent()){
                currentFlight =flight;
            }
        }
        return returnBoardingPass(currentFlight,passenger);
    }
    public BoardingPass checkPassenger(String surname, Integer passengerId){
        Passenger passenger = passengerService.searchBySurnameAndPassengerId(surname,passengerId);
        List<Flight> flightList = flightController.getBySurnameAndPassengerId(surname, passengerId);
        Flight currentFlight = new Flight();
        for(Flight flight:flightList){
            if(flight.getCurrent()){
                currentFlight =flight;
            }
        }
        return returnBoardingPass(currentFlight,passenger);
    }
    public BoardingPass checkPassenger(IdDocument idDocument){
        Passenger passenger = passengerService.searchByIdDocument(idDocument.getId());
        List<Flight> flightList = flightController.getByIdDocument(idDocument);
        Flight currentFlight = new Flight();
        for(Flight flight:flightList){
            if(flight.getCurrent()){
                currentFlight =flight;
            }
        }
        return returnBoardingPass(currentFlight,passenger);
    }
    /**
     *
     * @param flight
     * @param passenger
     * @return boardingPass
     */
    public BoardingPass returnBoardingPass(Flight flight, Passenger passenger){
        BoardingPass boardingPass = new BoardingPass();
        boardingPass.setFlight(flight);
        boardingPass.setPassenger(passenger);
        return boardingPass;
    }
}

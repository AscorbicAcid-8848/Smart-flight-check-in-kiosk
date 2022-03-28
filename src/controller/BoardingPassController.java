package controller;

import model.BoardingPass;
import model.Flight;
import model.IdDocument;
import model.Passenger;
import service.FlightService;
import service.PassengerService;
import service.imp.FlightServiceImp;
import service.imp.PassengerServiceImp;

/**
 * @author YichenLiu
 * @description: 操控乘客
 * @date 2022/3/16 17:16
 */
//这是我的登机牌controller
public class BoardingPassController {

    private FlightService flightService = new FlightServiceImp();
    private PassengerService passengerService = new PassengerServiceImp();

    public BoardingPass checkPassenger(Integer bookingNumber){
        Passenger passenger = passengerService.searchByBookingNumber(bookingNumber);
        Integer flightId = passenger.getFlightId();
        Flight flight = flightService.searchByFlightId(flightId);
        return returnBoardingPass(flight,passenger);
    }
    public BoardingPass checkPassenger(String surname, Integer passengerId){
        Passenger passenger = passengerService.searchBySurnameAndPassengerId(surname,passengerId);
        Integer flightId = passenger.getFlightId();
        Flight flight = flightService.searchByFlightId(flightId);
        return returnBoardingPass(flight,passenger);
    }
    public BoardingPass checkPassenger(IdDocument idDocument){
        Passenger passenger = passengerService.searchByIdDocument(idDocument.getId());
        Integer flightId = passenger.getFlightId();
        Flight flight = flightService.searchByFlightId(flightId);
        return returnBoardingPass(flight,passenger);
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

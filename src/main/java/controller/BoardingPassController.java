package controller;

import model.BoardingPass;
import model.Flight;
import model.IdDocumentCard;
import model.Passenger;
import service.BoardingPassService;
import service.FlightService;
import service.IdDocumentCardService;
import service.PassengerService;
import service.imp.BoardingPassServiceImp;
import service.imp.FlightServiceImp;
import service.imp.IdDocumentCardServiceImp;
import service.imp.PassengerServiceImp;

import java.util.List;

/**
 * @author YichenLiu
 * @description: 操控乘客
 * @date 2022/3/16 17:16
 */
//这是我的登机牌controller
public class BoardingPassController {

    /**
     *
     * @param bookingNumber
     * @return the boarding pass which been selected by booking number
     */
    public BoardingPass checkPassenger(Integer bookingNumber){
        FlightController flightController = new FlightController();
        PassengerService passengerService = new PassengerServiceImp();
        IdDocumentCardService idDocumentCardService = new IdDocumentCardServiceImp();
        Passenger passenger = passengerService.searchByBookingNumber(bookingNumber);
        Flight currentFlight = flightController.getByBookingNumber(bookingNumber);
        if(currentFlight==null){
            return null;
        }
        return returnBoardingPass(currentFlight,passenger);
    }

    /**
     *
     * @param surname
     * @param passengerId
     * @return the boarding pass which been selected by surname and passenger id.
     */
    public BoardingPass checkPassenger(String surname, Integer passengerId){
        FlightController flightController = new FlightController();
        PassengerService passengerService = new PassengerServiceImp();
        IdDocumentCardService idDocumentCardService = new IdDocumentCardServiceImp();
        Passenger passenger = passengerService.searchBySurnameAndPassengerId(surname,passengerId);
        List<Flight> flightList = flightController.getBySurnameAndPassengerId(surname, passengerId);
        Flight currentFlight = new Flight();
        if(flightList==null){
            return null;
        }
        for(Flight flight:flightList){
            if(flight.getCurrent()){
                currentFlight =flight;
            }
        }
        return returnBoardingPass(currentFlight,passenger);
    }

    /**
     *
     * @return the boarding pass which been selected by id document
     */
    public BoardingPass checkPassenger(){
        FlightController flightController = new FlightController();
        PassengerService passengerService = new PassengerServiceImp();
        IdDocumentCardService idDocumentCardService = new IdDocumentCardServiceImp();
        IdDocumentCard idDocumentCard = idDocumentCardService.checkCard();
        Passenger passenger = passengerService.searchByIdDocument(idDocumentCard.getId());
        List<Flight> flightList = flightController.getByIdDocument(idDocumentCard);
        Flight currentFlight = new Flight();
        if(flightList==null){
            return null;
        }
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

    /**
     *
     * @param passenger
     * @param flight
     */
    public void printBoardingPass(Passenger passenger,Flight flight){
        BoardingPassService boardingPassService = new BoardingPassServiceImp();
        boardingPassService.printBoardingPass(passenger, flight);
    }

    /**
     *
     * @param passenger
     * @param flight
     */
    public void printCarryOnBaggageTag(Passenger passenger,Flight flight){
        BoardingPassService boardingPassService = new BoardingPassServiceImp();
        boardingPassService.printCarryOnBaggageTag(passenger, flight);
    }

    /**
     *
     * @param passenger
     * @param flight
     */
    public void printCheckinBaggageTicket(Passenger passenger,Flight flight){
        BoardingPassService boardingPassService = new BoardingPassServiceImp();
        boardingPassService.printCheckinBaggageTicket(passenger, flight);
    }
}

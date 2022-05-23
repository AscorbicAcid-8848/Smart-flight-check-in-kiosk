package controller;

import model.Passenger;
import model.Seat;
import service.FlightSeatService;
import service.PassengerService;
import service.imp.FlightSeatServiceImp;
import service.imp.PassengerServiceImp;

import java.util.List;

/**
 * @author YichenLiu
 * @description: TODO
 * @date 2022/4/30 21:24
 */
public class FlightSeatController {

    /**
     * select the seat
     * @param idDocument
     * @param flightId
     * @param seatNumber
     * @return return the updated passenger
     */
    public Passenger selectSeat(Integer idDocument, Integer flightId, Integer seatNumber){
        FlightSeatServiceImp flightSeatService = new FlightSeatServiceImp();
        Passenger passenger = flightSeatService.update(idDocument, flightId, seatNumber);
        return passenger;
    }

    /**
     * return all seat of same light
     * @param flightId
     * @return
     */
    public List<Seat> showSeats(Integer flightId){
        FlightSeatServiceImp flightSeatService = new FlightSeatServiceImp();
        List<Seat> seatList = flightSeatService.searchByFlightId(flightId).getSeatList();
        return seatList;
    }
}

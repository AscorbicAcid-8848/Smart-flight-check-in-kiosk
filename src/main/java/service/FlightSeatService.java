package service;

import model.FlightSeat;
import model.Passenger;
import model.Seat;

import java.util.List;

/**
 * @author YichenLiu
 * @description: TODO
 * @date 2022/4/30 17:32
 */
public interface FlightSeatService {

    /**
     * update a flight seat by inputting idDocument of the passenger, flight id of the flight and the seat number
     * passenger choose
     * @param idDocument
     * @param flightId
     * @param seatNumber
     * @return
     */
    public Passenger update(Integer idDocument, Integer flightId, Integer seatNumber);

    /**
     * get the flight seat list of a flight by inputting its flight id
     * @param flightId
     * @return FlightSeat
     */
    public FlightSeat searchByFlightId(Integer flightId);
}



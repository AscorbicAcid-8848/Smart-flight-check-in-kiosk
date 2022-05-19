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
    private PassengerService passengerService = new PassengerServiceImp();
    private FlightSeatServiceImp flightSeatService = new FlightSeatServiceImp();
    //选座
    public Passenger selectSeat(Integer idDocument, Integer flightId, Integer seatNumber){
        Passenger passenger = flightSeatService.update(idDocument, flightId, seatNumber);
        return passenger;
    }
    //展示所有座位
    public List<Seat> showSeats(Integer flightId){
        List<Seat> seatList = flightSeatService.searchByFlightId(flightId).getSeatList();
        return seatList;
    }
}

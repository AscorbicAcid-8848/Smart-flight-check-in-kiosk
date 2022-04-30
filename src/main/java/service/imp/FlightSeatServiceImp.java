package service.imp;

import model.Passenger;
import model.Seat;
import service.FlightSeatService;
import service.PassengerService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YichenLiu
 * @description: TODO
 * @date 2022/4/30 17:39
 */
public class FlightSeatServiceImp implements FlightSeatService {
    private PassengerService passengerService = new PassengerServiceImp();
    @Override
    public void update(Integer idDocument, Integer flightId, Integer seatNumber, String seatLevel) {
        //首先修改座位表的数据
        //然后修改Passenger的数据
        Passenger passenger = passengerService.searchByIdDocument(idDocument);
        passenger.setSeatLevel(seatLevel);
        passenger.setSeatNumber(seatNumber);
        passengerService.update(passenger);
    }

    @Override
    public List<Seat> searchByFlightId(Integer flightId) {
        List<Seat> seatList = new ArrayList();
        //查找该航班的座位表
        return seatList;
    }
}

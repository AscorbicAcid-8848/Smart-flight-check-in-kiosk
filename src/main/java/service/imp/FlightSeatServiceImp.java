package service.imp;

import model.FlightSeat;
import model.Passenger;
import service.FlightSeatService;
import service.PassengerService;

/**
 * @author YichenLiu
 * @description: TODO
 * @date 2022/4/30 17:39
 */
public class FlightSeatServiceImp implements FlightSeatService {
    private PassengerService passengerService = new PassengerServiceImp();
    @Override
    public Passenger update(Integer idDocument, Integer flightId, Integer seatNumber, String seatLevel) {
        //首先修改座位表的数据，叶哥麻烦你加一下
        //然后修改Passenger的数据,我做了
        Passenger passenger = passengerService.searchByIdDocument(idDocument);
        passenger.setSeatLevel(seatLevel);
        passenger.setSeatNumber(seatNumber);
        passengerService.update(passenger);
        return passenger;
    }

    @Override
    public FlightSeat searchByFlightId(Integer flightId) {
        FlightSeat flightSeat = new FlightSeat();
        //查找该航班的座位表，叶哥加一下
        return flightSeat;
    }
}

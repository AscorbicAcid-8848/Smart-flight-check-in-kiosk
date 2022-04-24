package service.imp;

import model.Flight;
import model.Passenger;
import service.FlightService;
import service.PassengerService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author YichenLiu
 * @description: 航班服务的实现类
 * @date 2022/3/27 20:39
 */
public class FlightServiceImp implements FlightService {
    private PassengerService passengerService = new PassengerServiceImp();
    @Override
    public Flight insert(Integer airlineId, Integer flightId, String flightName, Date departureTime, Date fallTime, boolean isDelayed, Integer departureGate, String destWeather, String destCOVIDPolicy, String arrivalAirport, Integer arrivalTerminal) {
        Flight flight = new Flight();
        flight.setAirlineId(airlineId);
        flight.setFlightName(flightName);
        flight.setDepartureTime(departureTime);
        flight.setFallTime(fallTime);
        //向json文件中插入数据
        return flight;
    }

    @Override
    public Flight searchByFlightId(Integer flightId) {
        Flight flight = new Flight();
        //根据flightId查找文件中的json数据，并返回给flight
        return flight;
    }

    @Override
    public Flight change(Flight flight){
        //根据入参的类来改变数据库的数值
        return flight;
    }
}

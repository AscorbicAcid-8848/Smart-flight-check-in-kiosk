package service.imp;

import model.Flight;
import service.FlightService;

import java.util.Date;

/**
 * @author YichenLiu
 * @description: 航班服务的实现类
 * @date 2022/3/27 20:39
 */
public class FlightServiceImp implements FlightService {
    @Override
    public Flight insert(Integer airlineId, String flightName, Date departureTime, Date fallTime) {
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
}

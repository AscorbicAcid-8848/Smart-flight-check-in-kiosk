package service;

import model.Flight;

import java.util.Date;
import java.util.List;

/**
 * @author YichenLiu
 * @description: 航班信息表
 * @date 2022/3/27 20:38
 */
public interface FlightService {
    //增加一个新航班
    Flight insert(Integer airlineId, Integer flightId, String flightName, Date departureTime, Date fallTime, boolean isDelayed, Integer departureGate, String destWeather, String destCOVIDPolicy, String arrivalAirport, Integer arrivalTerminal);
    //根据航班id查询航班
    Flight searchByFlightId(Integer flightId);
    //更改航班信息
    Flight change(Flight flight);

}

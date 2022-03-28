package service;

import model.Flight;

import java.util.Date;

/**
 * @author YichenLiu
 * @description: 航班信息表
 * @date 2022/3/27 20:38
 */
public interface FlightService {
    //增加一个新航班
    Flight insert(Integer airlineId, String flightName, Date departureTime, Date fallTime);
    //根据航班id查询航班
    Flight searchByFlightId(Integer flightId);
}

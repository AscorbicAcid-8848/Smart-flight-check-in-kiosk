package service;

import model.Flight;

import java.util.Date;

/**
 * @author YichenLiu
 * @description: 航班信息表
 * @date 2022/3/27 20:38
 */
public interface FlightService {

    /**
     * input attributes of a new flight and insert this flight into service
     * @param airlineId
     * @param flightId
     * @param flightName
     * @param departureTime
     * @param fallTime
     * @param isDelayed
     * @param departureGate
     * @param destWeather
     * @param destCOVIDPolicy
     * @param arrivalAirport
     * @param arrivalTerminal
     * @param isCurrent
     * @return Flight
     */
    Flight insert(Integer airlineId, Integer flightId, String flightName, Date departureTime, Date fallTime, boolean isDelayed, Integer departureGate, String destWeather, String destCOVIDPolicy, String arrivalAirport, Integer arrivalTerminal,Boolean isCurrent);

    /**
     * get a certain flight by inputting its flight id
     * @param flightId
     * @return
     */
    Flight searchByFlightId(Integer flightId);

    /**
     * change a flight by inputting a changed flight
     * @param flight
     * @return
     */
    Flight change(Flight flight);
}

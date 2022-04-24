package controller;

import model.Flight;
import model.Passenger;
import service.FlightService;
import service.PassengerService;
import service.imp.FlightServiceImp;
import service.imp.PassengerServiceImp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @description: TODO
* @author YichenLiu
* @date 2022/4/8 18:32
*/
public class FlightController {
    private final FlightService flightService = new FlightServiceImp();
    private final PassengerService passengerService = new PassengerServiceImp();

    public Flight generate(Integer airlineId, Integer flightId, String flightName, Date departureTime, Date fallTime, boolean isDelayed, Integer departureGate, String destWeather, String destCOVIDPolicy,
                         String arrivalAirport, Integer arrivalTerminal){
        Flight flight = flightService.insert(airlineId, flightId, flightName, departureTime, fallTime, isDelayed, departureGate, destWeather, destCOVIDPolicy, arrivalAirport, arrivalTerminal);
        return flight;
    }

    public Flight update(Flight flight){
        flight = flightService.change(flight);
        return flight;
    }


}

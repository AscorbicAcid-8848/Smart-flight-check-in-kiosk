package controller;

import model.Flight;
import model.IdDocument;
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
                         String arrivalAirport, Integer arrivalTerminal,Boolean isCurrent){
        Flight flight = flightService.insert(airlineId, flightId, flightName, departureTime, fallTime, isDelayed, departureGate, destWeather, destCOVIDPolicy, arrivalAirport, arrivalTerminal,isCurrent);
        return flight;
    }

    public Flight update(Flight flight){
        flight = flightService.change(flight);
        return flight;
    }

    public List<Flight> getBySurnameAndPassengerId(String surname, Integer passengerId){
        List<Flight> flightList = new ArrayList();
        Passenger passenger= passengerService.searchBySurnameAndPassengerId(surname, passengerId);
        if(passenger==null){
            return null;
        }
        List<Integer> flightIds = passenger.getFlightId();
        for (Integer flightId:flightIds){
            Flight flight = flightService.searchByFlightId(flightId);
            flightList.add(flight);
        }
        return flightList;
    }

    public List<Flight> getByBookingNumber(Integer bookingNumber){
        List<Flight> flightList = new ArrayList();
        Passenger passenger= passengerService.searchByBookingNumber(bookingNumber);
        if(passenger==null){
            return null;
        }
        List<Integer> flightIds = passenger.getFlightId();
        for (Integer flightId:flightIds){
            Flight flight = flightService.searchByFlightId(flightId);
            flightList.add(flight);
        }
        return flightList;
    }

    public List<Flight> getByIdDocument(IdDocument idDocument){
        List<Flight> flightList = new ArrayList();
        Passenger passenger= passengerService.searchByIdDocument(idDocument.getId());
        if(passenger==null){
            return null;
        }
        List<Integer> flightIds = passenger.getFlightId();
        for (Integer flightId:flightIds){
            Flight flight = flightService.searchByFlightId(flightId);
            flightList.add(flight);
        }
        return flightList;
    }
    //乘客选择一个航班为当前航班
    public void chooseFlight(Integer flightId){
        Flight flight = flightService.searchByFlightId(flightId);
        flight.setCurrent(true);
        flightService.change(flight);
    }
}

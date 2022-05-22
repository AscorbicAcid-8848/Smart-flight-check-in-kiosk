package controller;

import model.Flight;
import model.IdDocumentCard;
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

    public Flight generate(Integer airlineId, Integer flightId, String flightName, Date departureTime, Date fallTime, boolean isDelayed, Integer departureGate, String destWeather, String destCOVIDPolicy,
                         String arrivalAirport, Integer arrivalTerminal,Boolean isCurrent){
        FlightServiceImp flightService = new FlightServiceImp();
        Flight flight = flightService.insert(airlineId, flightId, flightName, departureTime, fallTime, isDelayed, departureGate, destWeather, destCOVIDPolicy, arrivalAirport, arrivalTerminal,isCurrent);
        return flight;
    }

    public Flight update(Flight flight){
        FlightServiceImp flightService = new FlightServiceImp();
        flight = flightService.change(flight);
        return flight;
    }

    public List<Flight> getBySurnameAndPassengerId(String surname, Integer passengerId){
        FlightServiceImp flightService = new FlightServiceImp();
        PassengerService passengerService = new PassengerServiceImp();
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

    public Flight getByBookingNumber(Integer bookingNumber){
        FlightServiceImp flightService = new FlightServiceImp();
        PassengerService passengerService = new PassengerServiceImp();
        String booknum = bookingNumber.toString();
        booknum = booknum.substring(0, 3);
        Integer flightId = Integer.parseInt(booknum);
        Passenger passenger= passengerService.searchByBookingNumber(bookingNumber);
        if(passenger==null){
            return null;
        }
        Flight flight = flightService.searchByFlightId(flightId);
        return flight;
    }

    public List<Flight> getByIdDocument(IdDocumentCard idDocumentCard){
        FlightServiceImp flightService = new FlightServiceImp();
        PassengerService passengerService = new PassengerServiceImp();
        List<Flight> flightList = new ArrayList();
        Passenger passenger= passengerService.searchByIdDocument(idDocumentCard.getId());
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
        FlightServiceImp flightService = new FlightServiceImp();
        Flight flight = flightService.searchByFlightId(flightId);
        flight.setCurrent(true);
        flightService.change(flight);
        flightService.toJSON();
    }
}

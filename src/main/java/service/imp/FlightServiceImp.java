package service.imp;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import mock.FlightMock;
import model.Flight;
import service.FlightService;

import java.beans.ConstructorProperties;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author YichenLiu ZihaoYe
 * @description: 航班服务的实现类
 * @date 2022/3/27 20:39
 */
public class FlightServiceImp implements FlightService {
    private List<Flight> flights = new ArrayList<Flight>();
    ObjectMapper objectMapper = new ObjectMapper();

    @ConstructorProperties({})
    public FlightServiceImp(){

        File flightList = new File("data\\flightList.json");

        try {
            JavaType type = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Flight.class);
            flights = objectMapper.readValue(flightList, type);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public Flight insert(Integer airlineId, Integer flightId, String flightName, Date departureTime, Date fallTime, boolean isDelayed,
                         Integer departureGate, String destWeather, String destCOVIDPolicy, String arrivalAirport, Integer arrivalTerminal) {
        Flight flight = new Flight();
        flight.setAirlineId(airlineId);
        flight.setFlightName(flightName);
        flight.setDepartureTime(departureTime);
        flight.setFallTime(fallTime);
        flight.setFlightId(flightId);
        flight.setFallTime(fallTime);
        flight.setDelayed(isDelayed);
        flight.setDepartureGate(departureGate);
        flight.setDestWeather(destWeather);
        flight.setDestCOVIDPolicy(destCOVIDPolicy);
        flight.setArrivalAirport(arrivalAirport);
        flight.setArrivalTerminal(arrivalTerminal);
        //向json文件中插入数据
        flights.add(flight);
        return flight;
    }

    @Override
    public Flight searchByFlightId(Integer flightId) {
        int result = -1;

        //search in flight list
        for(int i=0; i< flights.size(); i++) {
            //if booking numbers match
            if (flights.get(i).getFlightId().equals(flightId)) {
                //and if there is only one result
                if (result == -1) {
                    result = i;
                } else { //is there are more than one result: print alarm and show the first result
                    System.out.println("There are more than one result!");
                }
            }
        }

        //if there is result return it
        if(result != -1) {
            return flights.get(result);
        }else {//if there is no result, return an empty flight
            System.out.println("No result");
            return null;
        }
    }

    @Override
    public Flight change(Flight flight){
        int result = -1;

        for (int i = 0; i < flights.size(); i++) {
            if (flights.get(i).getFlightId().equals(flight.getFlightId())) {
                //update
                flights.get(i).setFlightName(flight.getFlightName());
                flights.get(i).setArrivalTerminal(flight.getArrivalTerminal());
                flights.get(i).setFallTime(flight.getFallTime());
                flights.get(i).setAirlineId(flight.getAirlineId());
                flights.get(i).setDepartureTime(flight.getDepartureTime());
                flights.get(i).setDelayed(flight.isDelayed());
                flights.get(i).setDepartureGate(flight.getDepartureGate());
                flights.get(i).setDestWeather(flight.getDestWeather());
                flights.get(i).setDestCOVIDPolicy(flight.getDestCOVIDPolicy());
                flights.get(i).setArrivalAirport(flight.getArrivalAirport());
                flights.get(i).setArrivalTerminal(flight.getArrivalTerminal());

                result = i;
            }
        }

        if (result != -1) {
            return flights.get(result);
        } else {
            System.out.println("no flight found!");
            return null;
        }
    }

    public void toJSON() {
        FlightMock flightMock = new FlightMock();
        try {
            flightMock.toJSON((ArrayList<Flight>) flights,false);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

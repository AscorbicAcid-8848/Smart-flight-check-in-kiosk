package service.imp;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Flight;
import model.FlightSeat;
import model.Passenger;
import service.FlightSeatService;
import service.PassengerService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author YichenLiu
 * @description: TODO
 * @date 2022/4/30 17:39
 */
public class FlightSeatServiceImp implements FlightSeatService {

    private List<FlightSeat> flightSeats = new ArrayList<>();
    private PassengerService passengerService = new PassengerServiceImp();
    ObjectMapper objectMapper = new ObjectMapper();

    public FlightSeatServiceImp(){

        File flightSeatList = new File("data\\flightSeatList.json");

        try {
            JavaType type = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, FlightSeat.class);
            flightSeats = objectMapper.readValue(flightSeatList, type);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public Passenger update(Integer idDocument, Integer flightId, Integer seatNumber, String seatLevel) {

        //search in flight list
        for(int i=0; i< flightSeats.size(); i++) {
            //if match
            if (flightSeats.get(i).getFlightId().equals(flightId)) {
                //set seat level
                flightSeats.get(i).getSeatList().get(seatNumber).setSeatLevel(seatLevel);
                flightSeats.get(i).getSeatList().get(seatNumber).setOccupied(true);
            }
        }

        //然后修改Passenger的数据,我做了
        Passenger passenger = passengerService.searchByIdDocument(idDocument);
        passenger.setSeatLevel(seatLevel);
        passenger.setSeatNumber(seatNumber);
        passengerService.update(passenger);
        return passenger;
    }

    @Override
    public FlightSeat searchByFlightId(Integer flightId) {
        int result = -1;

        //search in flightSeat list
        for(int i=0; i< flightSeats.size(); i++) {
            //if flight id match
            if (flightSeats.get(i).getFlightId().equals(flightId)) {
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
            return flightSeats.get(result);
        }else {//if there is no result, return an empty flight
            System.out.println("No result");
            return null;
        }

    }
}

package mock;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Flight;
import model.FlightSeat;
import model.Seat;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zihao Ye
 * @version 1.0
 */
public class FlightSeatMock {

    //FlightSeat List
    List<FlightSeat> flightSeats = new ArrayList<>();
    FlightSeat flightSeat0 = new FlightSeat();
    FlightSeat flightSeat1 = new FlightSeat();
    FlightSeat flightSeat2 = new FlightSeat();
    private final int seatNum = 100; //100 seats for default


    public FlightSeatMock(){
        //set flight id
        flightSeat0.setFlightId(100);
        flightSeat1.setFlightId(101);
        flightSeat2.setFlightId(200);

        //return a flight seat object with all the seat's occupied=false seatlevel=nul
        //this object does not set its flightID!
        for(int i=0; i< seatNum; i++){
            Seat seat = new Seat(i, false, "nul");
            flightSeat0.getSeatList().add(seat);
        }
        for(int i=0; i< seatNum; i++){
            Seat seat = new Seat(i, false, "nul");
            flightSeat1.getSeatList().add(seat);
        }
        for(int i=0; i< seatNum; i++){
            Seat seat = new Seat(i, false, "nul");
            flightSeat2.getSeatList().add(seat);
        }

        flightSeats.add(flightSeat0);
        flightSeats.add(flightSeat1);
        flightSeats.add(flightSeat2);

    }

    public void toJSON(ArrayList<FlightSeat> input, Boolean useMockData) throws JsonGenerationException, JsonMappingException, IOException {
        //determine whether use mock data or not
        if(!useMockData){
            flightSeats = input;
        }

        ObjectMapper mapper = new ObjectMapper();
        FileWriter file = new FileWriter("data\\flightSeatList.json",false);

        try {
            file.write("");
        }catch (IOException e) {
            e.printStackTrace();
        }

        //write json data to json file
        try {
            mapper.writeValue(file, flightSeats);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}

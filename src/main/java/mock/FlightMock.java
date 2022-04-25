package mock;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Flight;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Zihao Ye
 * @version 1.0
 */
public class FlightMock {

    //Flight list
    List<Flight> flights = new ArrayList<Flight>();
    Flight flight0 = new Flight();
    Flight flight1 = new Flight();

    public FlightMock(){
        Date departureTime0;
        Date departureTime1;
        Date fallTime0;
        Date fallTime1;

        //set time format
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");

        //set airline id
        flight0.setAirlineId(1);
        flight1.setAirlineId(2);

        //set flightID
        flight0.setFlightId(100);
        flight1.setFlightId(101);

        //set flightName
        flight0.setFlightName("BUPT2022");
        flight1.setFlightName("QM2022");

        try {
            departureTime0 = ft.parse("2022-04-20 08:20:00");
            departureTime1 = ft.parse("2022-04-28 23:00:00");
            //set departure time
            flight0.setDepartureTime(departureTime0);
            flight1.setDepartureTime(departureTime1);
        }catch (ParseException e){
            e.printStackTrace();
        }

        try {
            fallTime0 = ft.parse("2022-04-20 10:00:00");
            fallTime1 = ft.parse("2022-04-29 01:30:00");
            //set departure time
            flight0.setFallTime(fallTime0);
            flight1.setFallTime(fallTime1);
        }catch (ParseException e){
            e.printStackTrace();
        }

        //set if the flight is delayed
        flight0.setDelayed(false);
        flight1.setDelayed(true);

        //set departure gare
        flight0.setDepartureGate(20);
        flight1.setDepartureGate(56);

        //set dest weather
        flight0.setDestWeather("sunny");
        flight1.setDestWeather("cloudy");

        //set dest covid policy
        flight0.setDestCOVIDPolicy("loose");
        flight1.setDestCOVIDPolicy("strict");

        //set arrival airport
        flight0.setArrivalAirport("Daxing Beijing China");
        flight1.setArrivalAirport("Heathrow London UK");

        //set arrival terminal
        flight0.setArrivalTerminal(2);
        flight1.setArrivalTerminal(3);

        flights.add(flight0);
        flights.add(flight1);
    }

    public void toJSON(ArrayList<Flight> input, Boolean useMockData) throws JsonGenerationException, JsonMappingException, IOException{
        //determine whether use mock data or not
        if(!useMockData){
            flights = input;
        }

        ObjectMapper mapper = new ObjectMapper();
        FileWriter file = new FileWriter("data\\flightList.json",false);

        try {
            file.write("");
        }catch (IOException e) {
            e.printStackTrace();
        }

        //write json data to json file
        try {
            mapper.writeValue(file, flights);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}

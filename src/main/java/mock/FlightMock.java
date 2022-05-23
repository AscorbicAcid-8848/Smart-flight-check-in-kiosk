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
    Flight flight2 = new Flight();
    Flight flight3 = new Flight();
    Flight flight4 = new Flight();
    Flight flight5 = new Flight();
    Flight flight6 = new Flight();


    public FlightMock(){
        Date departureTime0;
        Date departureTime1;
        Date departureTime2;
        Date departureTime3;
        Date fallTime0;
        Date fallTime1;
        Date fallTime2;
        Date fallTime3;

        //set time format
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");

        //set airline id
        flight0.setAirlineId(1);
        flight1.setAirlineId(2);
        flight2.setAirlineId(1);
        flight3.setAirlineId(3);
        flight4.setAirlineId(4);
        flight5.setAirlineId(2);
        flight6.setAirlineId(4);

        //set flightID
        flight0.setFlightId(100);
        flight1.setFlightId(200);
        flight2.setFlightId(101);
        flight3.setFlightId(300);
        flight4.setFlightId(400);
        flight5.setFlightId(201);
        flight6.setFlightId(401);


        //set flightName
        flight0.setFlightName("BA2021");
        flight1.setFlightName("T34572");
        flight2.setFlightName("BA8798");
        flight3.setFlightName("CA7887");
        flight4.setFlightName("CE2333");
        flight5.setFlightName("T38777");
        flight6.setFlightName("CA1578");

        try {
            departureTime0 = ft.parse("2022-04-20 08:20:00");
            departureTime1 = ft.parse("2022-04-28 23:00:00");
            departureTime2 = ft.parse("2021-05-01 11:00:00");
            departureTime3 = ft.parse("2022-05-22 18:00:00");

            //set departure time
            flight0.setDepartureTime(departureTime0);
            flight1.setDepartureTime(departureTime1);
            flight2.setDepartureTime(departureTime2);
            flight3.setDepartureTime(departureTime0);
            flight4.setDepartureTime(departureTime3);
            flight5.setDepartureTime(departureTime2);
            flight6.setDepartureTime(departureTime1);

        }catch (ParseException e){
            e.printStackTrace();
        }

        try {
            fallTime0 = ft.parse("2022-04-20 10:00:00");
            fallTime1 = ft.parse("2022-04-29 01:30:00");
            fallTime2 = ft.parse("2021-05-01 13:00:00");
            fallTime3 = ft.parse("2022-05-22 21:30:00");


            //set departure time
            flight0.setFallTime(fallTime0);
            flight1.setFallTime(fallTime1);
            flight2.setFallTime(fallTime2);
            flight3.setFallTime(fallTime0);
            flight4.setFallTime(fallTime3);
            flight5.setFallTime(fallTime2);
            flight6.setFallTime(fallTime1);
        }catch (ParseException e){
            e.printStackTrace();
        }

        //set if the flight is delayed
        flight0.setDelayed(false);
        flight1.setDelayed(true);
        flight2.setDelayed(true);
        flight3.setDelayed(false);
        flight4.setDelayed(false);
        flight5.setDelayed(true);
        flight6.setDelayed(false);

        //set departure gare
        flight0.setDepartureGate(20);
        flight1.setDepartureGate(56);
        flight2.setDepartureGate(10);
        flight3.setDepartureGate(2);
        flight4.setDepartureGate(13);
        flight5.setDepartureGate(44);
        flight6.setDepartureGate(32);

        //set dest weather
        flight0.setDestWeather("sunny");
        flight1.setDestWeather("cloudy");
        flight2.setDestWeather("windy");
        flight3.setDestWeather("sunny");
        flight4.setDestWeather("cloudy");
        flight5.setDestWeather("stormy");
        flight6.setDestWeather("sunny");

        //set dest covid policy
        flight0.setDestCOVIDPolicy("loose");
        flight1.setDestCOVIDPolicy("strict");
        flight2.setDestCOVIDPolicy("loose");
        flight3.setDestCOVIDPolicy("loose");
        flight4.setDestCOVIDPolicy("loose");
        flight5.setDestCOVIDPolicy("loose");
        flight6.setDestCOVIDPolicy("loose");

        //set arrival airport
        flight0.setArrivalAirport("Daxing Beijing China");
        flight1.setArrivalAirport("Heathrow London UK");
        flight2.setArrivalAirport("Capital Beijing China");
        flight3.setArrivalAirport("Heathrow London UK");
        flight4.setArrivalAirport("Heathrow London UK");
        flight5.setArrivalAirport("Capital Beijing China");
        flight6.setArrivalAirport("Daxing Beijing China");

        //set arrival terminal
        flight0.setArrivalTerminal(1);
        flight1.setArrivalTerminal(3);
        flight2.setArrivalTerminal(1);
        flight3.setArrivalTerminal(1);
        flight4.setArrivalTerminal(3);
        flight5.setArrivalTerminal(3);
        flight6.setArrivalTerminal(1);

        //set current state
        flight0.setCurrent(false);
        flight1.setCurrent(false);
        flight2.setCurrent(false);
        flight3.setCurrent(false);
        flight4.setCurrent(false);
        flight5.setCurrent(false);
        flight6.setCurrent(false);

        flights.add(flight0);
        flights.add(flight1);
        flights.add(flight2);
        flights.add(flight3);
        flights.add(flight4);
        flights.add(flight5);
        flights.add(flight6);
    }

    /**
     * a methed to transform input to json file, or you can choose use mock data to create default json
     * @param input: data you want to transform
     * @param useMockData: whether you want to use mock data
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
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

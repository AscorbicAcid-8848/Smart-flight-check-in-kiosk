package mock;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Airline;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zihao Ye
 * @version 1.0
 */
public class AirlineMock {
    List<Airline> airlines = new ArrayList<Airline>();
    Airline airline0 = new Airline();
    Airline airline1 = new Airline();
    Airline airline2 = new Airline();
    Airline airline3 = new Airline();

    public AirlineMock(){

        //set airline id
        airline0.setAirlineId(1);
        airline1.setAirlineId(2);
        airline2.setAirlineId(3);
        airline3.setAirlineId(4);


        airline0.setAirlineName("British Airways");
        airline1.setAirlineName("Eastern Airways");
        airline2.setAirlineName("China Eastern");
        airline3.setAirlineName("Air China");

        airlines.add(airline0);
        airlines.add(airline1);
        airlines.add(airline2);
        airlines.add(airline3);
    }

    public void toJSON(ArrayList<Airline> input, Boolean useMockData) throws JsonGenerationException, JsonMappingException, IOException {
        //determine whether use mock data or not
        if(!useMockData){
            airlines = input;
        }

        ObjectMapper mapper = new ObjectMapper();
        FileWriter file = new FileWriter("data\\airlineList.json");

        try {
            file.write("");
        }catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mapper.writeValue(file, airlines);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }

    }
}




package service.imp;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;
import model.AirLineMeal;
import model.FlightSeat;
import model.Passenger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Zihao Ye
 * @version 1.0
 */
public class AirlineMealServiceImpTest extends TestCase {

    Passenger passenger = new Passenger();
    AirlineMealServiceImp airlineMealServiceImp = new AirlineMealServiceImp();
//    AirLineMeal airLineMeal = new AirLineMeal();

    public void testUpdate() {

        File airlineMealList = new File("data\\airlineMealList.json");
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<AirLineMeal> airLineMeals = new ArrayList<>();

        try {
            JavaType type = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, AirLineMeal.class);
            airLineMeals = objectMapper.readValue(airlineMealList, type);
        }catch (IOException e){
            e.printStackTrace();
        }

        passenger = airlineMealServiceImp.update(1111,100,1);
        System.out.println(passenger.toString());

    }

    public void testSearchByAirlineId() {

//        airLineMeal  = airlineMealServiceImp.searchByAirlineId(2);
//        System.out.println(airLineMeal.toString());

    }
}
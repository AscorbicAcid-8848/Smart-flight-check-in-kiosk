package service.imp;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.AirLineMeal;
import model.FlightSeat;
import model.Passenger;
import service.AirlineMealService;
import service.PassengerService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author YichenLiu
 * @description: implement meal
 * @date 2022/5/16 10:44
 */
public class AirlineMealServiceImp implements AirlineMealService {

    private List<AirLineMeal> airLineMeals = new ArrayList<>();
    private PassengerService passengerService = new PassengerServiceImp();
    ObjectMapper objectMapper = new ObjectMapper();

    public AirlineMealServiceImp(){

        File flightSeatList = new File("data\\airlineMealList.json");

        try {
            JavaType type = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, AirLineMeal.class);
            airLineMeals = objectMapper.readValue(flightSeatList, type);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public Passenger update(Integer idDocument, Integer airlineId, Integer mealId) {
        Passenger passenger = passengerService.searchByIdDocument(idDocument);
        passenger.setMeal(mealId);
        return passenger;
    }

    @Override
    public AirLineMeal searchByAirlineId(Integer airlineId) {

        int result = -1;

        //search in flightSeat list
        for(int i=0; i< airLineMeals.size(); i++) {
            //if flight id match
            if (airLineMeals.get(i).getAirlineId().equals(airlineId)) {
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
            return airLineMeals.get(result);
        }else {//if there is no result, return an empty flight
            System.out.println("No result");
            return null;
        }

    }
}

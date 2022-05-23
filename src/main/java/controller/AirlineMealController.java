package controller;

import model.Meal;
import model.Passenger;
import service.AirlineMealService;
import service.PassengerService;
import service.imp.AirlineMealServiceImp;
import service.imp.PassengerServiceImp;

import java.util.List;

/**
 * @author YichenLiu
 * @description: Meal control
 * @date 2022/5/16 15:35
 */
public class AirlineMealController {
    /**
     *
     * @param idDocument
     * @param airlineId
     * @param mealId
     * @return the updated passenger
     */
    public Passenger selectMeal(Integer idDocument, Integer airlineId, Integer mealId){
        AirlineMealServiceImp airlineMealService = new AirlineMealServiceImp();
        Passenger passenger = airlineMealService.update(idDocument, airlineId, mealId);
        airlineMealService.toJSON();
        return  passenger;
    }

    /**
     *
     * @param airlineId
     * @return the meal menu for selected airline
     */
    public List<Meal> showMeals(Integer airlineId){
        AirlineMealServiceImp airlineMealService = new AirlineMealServiceImp();
        List<Meal> mealList = airlineMealService.searchByAirlineId(airlineId).getMeals();
        return mealList;
    }
}

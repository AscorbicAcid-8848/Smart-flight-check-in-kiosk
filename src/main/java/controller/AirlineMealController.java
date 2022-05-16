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
    private AirlineMealService airlineMealService = new AirlineMealServiceImp();
    private PassengerService passengerService = new PassengerServiceImp();

    public Passenger selectMeal(Integer idDocument, Integer airlineId, Integer mealId){
        return  airlineMealService.update(idDocument, airlineId, mealId);
    }

    public List<Meal> getMeals(Integer airlineId){
        List<Meal> mealList = airlineMealService.searchByAirlineId(airlineId).getMealList();
        return mealList;
    }
}

package controller;

import model.Meal;
import model.Passenger;
import service.AirlineMealService;
import service.PassengerService;
import service.imp.AirlineMealServiceImp;
import service.imp.PassengerServiceImp;

import java.util.List;
+
/**
 * @author YichenLiu
 * @description: Meal control
 * @date 2022/5/16 15:35
 */
public class AirlineMealController {
    private AirlineMealServiceImp airlineMealService = new AirlineMealServiceImp();

    public Passenger selectMeal(Integer idDocument, Integer airlineId, Integer mealId){
        Passenger passenger = airlineMealService.update(idDocument, airlineId, mealId);
        airlineMealService.toJSON();
        return  passenger;
    }

    public List<Meal> showMeals(Integer airlineId){
        List<Meal> mealList = airlineMealService.searchByAirlineId(airlineId).getMeals();
        return mealList;
    }
}

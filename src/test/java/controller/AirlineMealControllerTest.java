package controller;

import junit.framework.TestCase;
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
public class AirlineMealControllerTest extends TestCase {
    private AirlineMealController airlineMealController = new AirlineMealController();

    public void testUpdate(){
        airlineMealController.selectMeal(1111,1,0);
    }

}

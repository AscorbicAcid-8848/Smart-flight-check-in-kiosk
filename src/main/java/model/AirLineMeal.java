package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YichenLiu
 * @description: Airline meal
 * @date 2022/5/16 10:38
 */
public class AirLineMeal {
    private Integer airlineId;
    private List<Meal> meals = new ArrayList<>();

    public AirLineMeal(){}

    public AirLineMeal(Integer airlineId, List<Meal> meals) {
        this.airlineId = airlineId;
        this.meals = meals;
    }

    public Integer getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(Integer airlineId) {
        this.airlineId = airlineId;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMealList(List<Meal> meals) {
        this.meals = meals;
    }
}

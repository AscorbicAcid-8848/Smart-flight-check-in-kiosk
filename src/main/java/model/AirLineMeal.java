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
    private List<Meal> mealList = new ArrayList<>();

    public AirLineMeal(){}

    public AirLineMeal(Integer airlineId, List<Meal> mealList) {
        this.airlineId = airlineId;
        this.mealList = mealList;
    }

    public Integer getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(Integer airlineId) {
        this.airlineId = airlineId;
    }

    public List<Meal> getMealList() {
        return mealList;
    }

    public void setMealList(List<Meal> mealList) {
        this.mealList = mealList;
    }
}
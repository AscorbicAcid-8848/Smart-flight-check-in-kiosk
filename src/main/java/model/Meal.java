package model;

/**
 * @author YichenLiu
 * @description: Meal
 * @date 2022/5/16 10:36
 */
public class Meal {
    private Integer mealId;
    private String mealName;
    private Integer mealCost;

    public Meal(){}

    public Meal(Integer mealId, String mealName, Integer mealCost) {
        this.mealId = mealId;
        this.mealName = mealName;
        this.mealCost = mealCost;
    }

    public Integer getMealId() {
        return mealId;
    }

    public void setMealId(Integer mealId) {
        this.mealId = mealId;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public Integer getMealCost() {
        return mealCost;
    }

    public void setMealCost(Integer mealCost) {
        this.mealCost = mealCost;
    }
}

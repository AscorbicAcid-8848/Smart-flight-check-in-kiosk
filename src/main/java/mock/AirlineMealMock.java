package mock;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.AirLineMeal;
import model.Meal;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author YichenLiu
 * @description: mock meal data
 * @date 2022/5/16 10:58
 */
public class AirlineMealMock {

    //Meal List
    List<AirLineMeal> airLineMeals = new ArrayList<>();
    AirLineMeal airLineMeal0 = new AirLineMeal();
    AirLineMeal airLineMeal1 = new AirLineMeal();
    AirLineMeal airLineMeal2 = new AirLineMeal();
    AirLineMeal airLineMeal3 = new AirLineMeal();

    public AirlineMealMock() {

        //set airline id
        airLineMeal0.setAirlineId(1);
        airLineMeal1.setAirlineId(2);
        airLineMeal2.setAirlineId(3);
        airLineMeal3.setAirlineId(4);

        //create meal
        Meal meal0_0 = new Meal(0,"Cascade Brisket Chili", 10);
        Meal meal0_1 = new Meal(1,"Red Wine Braised Beef with Polenta", 90);
        Meal meal0_2 = new Meal(2,"Chicken Cobb Salad", 30);
        Meal meal0_3 = new Meal(3,"Hong Kong-style Curry Chicken", 50);

        Meal meal1_0 = new Meal(0,"Strawberry Frozen Yogurt Bars", 15);
        Meal meal1_1 = new Meal(1,"Loco Moco", 55);
        Meal meal1_2 = new Meal(2,"Kale Salad", 37);
        Meal meal1_3 = new Meal(3,"Sirloin Sandwich", 57);

        Meal meal2_0 = new Meal(0,"Hot Ham and Cheese Breakfast", 26);
        Meal meal2_1 = new Meal(1,"Lasagna with Malbec and Flan", 70);
        Meal meal2_2 = new Meal(2,"Classic Arabic Mezze", 64);
        Meal meal2_3 = new Meal(3,"Flight Bites Tapas", 36);

        Meal meal3_0 = new Meal(0,"Marvellous Mac’N’Cheese Kids Meal", 120);
        Meal meal3_1 = new Meal(1,"Hot Ham and Cheese Breakfast", 42);
        Meal meal3_2 = new Meal(2,"Loco Moco", 25);
        Meal meal3_3 = new Meal(3,"Chicken Cobb Salad", 75);

        airLineMeal0.getMeals().add(meal0_0);
        airLineMeal0.getMeals().add(meal0_1);
        airLineMeal0.getMeals().add(meal0_2);
        airLineMeal0.getMeals().add(meal0_3);

        airLineMeal1.getMeals().add(meal1_0);
        airLineMeal1.getMeals().add(meal1_1);
        airLineMeal1.getMeals().add(meal1_2);
        airLineMeal1.getMeals().add(meal1_3);

        airLineMeal2.getMeals().add(meal2_0);
        airLineMeal2.getMeals().add(meal2_1);
        airLineMeal2.getMeals().add(meal2_2);
        airLineMeal2.getMeals().add(meal2_3);

        airLineMeal3.getMeals().add(meal3_0);
        airLineMeal3.getMeals().add(meal3_1);
        airLineMeal3.getMeals().add(meal3_2);
        airLineMeal3.getMeals().add(meal3_3);

        airLineMeals.add(airLineMeal0);
        airLineMeals.add(airLineMeal1);
        airLineMeals.add(airLineMeal2);
        airLineMeals.add(airLineMeal3);
    }

    public void toJSON(ArrayList<AirLineMeal> input, Boolean useMockData) throws JsonGenerationException, JsonMappingException, IOException {
        //determine whether use mock data or not
        if(!useMockData){
            airLineMeals = input;
        }

        ObjectMapper mapper = new ObjectMapper();
        FileWriter file = new FileWriter("data\\airlineMealList.json");

        try {
            file.write("");
        }catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mapper.writeValue(file, airLineMeals);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }

    }

}
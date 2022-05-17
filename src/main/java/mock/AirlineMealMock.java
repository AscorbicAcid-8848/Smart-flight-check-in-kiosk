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

    public AirlineMealMock() {

        //set airline id
        airLineMeal0.setAirlineId(1);
        airLineMeal1.setAirlineId(2);

        //create meal
        Meal meal0_0 = new Meal(0,"BUPT bad food 1", 10);
        Meal meal0_1 = new Meal(1,"BUPT bad food 2", 9);
        Meal meal0_2 = new Meal(2,"BUPT good food 1", 30);
        Meal meal0_3 = new Meal(3,"BUPT good food 2", 50);

        Meal meal1_0 = new Meal(0,"QM bad food 1", 15);
        Meal meal1_1 = new Meal(1,"QM bad food 2", 4);
        Meal meal1_2 = new Meal(2,"QM good food 1", 37);
        Meal meal1_3 = new Meal(3,"QM good food 2", 57);

        airLineMeal0.getMeals().add(meal0_0);
        airLineMeal0.getMeals().add(meal0_1);
        airLineMeal0.getMeals().add(meal0_2);
        airLineMeal0.getMeals().add(meal0_3);

        airLineMeal1.getMeals().add(meal1_0);
        airLineMeal1.getMeals().add(meal1_1);
        airLineMeal1.getMeals().add(meal1_2);
        airLineMeal1.getMeals().add(meal1_3);

        airLineMeals.add(airLineMeal0);
        airLineMeals.add(airLineMeal1);
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
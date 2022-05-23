package service;

import model.AirLineMeal;
import model.Passenger;

/**
 * @author YichenLiu
 * @description: meal service
 * @date 2022/5/16 10:42
 */
public interface AirlineMealService {

    /**
     * update a passenger's mealId, input idDocument and airline id to locate the passenger
     * @param idDocument: idDocument corresponding to the passenger
     * @param airlineId: airline id of the airline
     * @param mealId: meal id of the meal that the passenger chooses
     * @return
     */
    public Passenger update (Integer idDocument, Integer airlineId, Integer mealId);

    /**
     * method to get a AirlineMeal object by its airline id
     * @param airlineId: airline id of the airline
     * @return AirLineMeal
     */
    public AirLineMeal searchByAirlineId(Integer airlineId);
}

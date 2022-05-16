package service;

import model.AirLineMeal;
import model.Passenger;

/**
 * @author YichenLiu
 * @description: meal service
 * @date 2022/5/16 10:42
 */
public interface AirlineMealService {
    public Passenger update (Integer idDocument, Integer airlineId, Integer mealId);
    //展示所在flight的全部座位
    public AirLineMeal searchByAirlineId(Integer airlineId);
}

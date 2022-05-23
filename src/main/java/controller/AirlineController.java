package controller;

import model.Airline;
import service.AirlineService;
import service.imp.AirlineServiceImp;

/**
 * @author YichenLiu
 * @description: airline control
 * @date 2022/5/23 9:52
 */
public class AirlineController {

    public Airline getAirline(Integer airlineId){
        AirlineService airlineService = new AirlineServiceImp();
        return airlineService.search(airlineId);
    }
}

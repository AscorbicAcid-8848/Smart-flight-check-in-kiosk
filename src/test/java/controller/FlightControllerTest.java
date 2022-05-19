package controller;

import junit.framework.TestCase;
import model.Flight;
import model.IdDocumentCard;
import model.Passenger;
import service.FlightService;
import service.PassengerService;
import service.imp.FlightServiceImp;
import service.imp.PassengerServiceImp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @description: TODO
* @author YichenLiu
* @date 2022/4/8 18:32
*/
public class FlightControllerTest extends TestCase {
    private FlightController flightController= new FlightController();
    public void testChooseFlight(){
        flightController.chooseFlight(100);
    }
}

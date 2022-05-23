package controller;

import junit.framework.TestCase;
import model.Passenger;
import model.Seat;
import org.junit.Test;
import service.FlightSeatService;
import service.PassengerService;
import service.imp.FlightSeatServiceImp;
import service.imp.PassengerServiceImp;

import java.util.List;

/**
 * @author YichenLiu
 * @description: TODO
 * @date 2022/4/30 21:24
 */
public class FlightSeatControllerTest extends TestCase {
    private FlightSeatController flightSeatController = new FlightSeatController();

    /**
     *
     */
    @Test
    public void testSelect(){
        flightSeatController.selectSeat(1111,100,1);
    }
}

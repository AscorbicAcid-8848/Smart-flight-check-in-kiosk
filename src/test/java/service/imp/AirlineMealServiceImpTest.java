package service.imp;

import junit.framework.TestCase;
import model.AirLineMeal;
import model.FlightSeat;
import model.Passenger;

/**
 * @author Zihao Ye
 * @version 1.0
 */
public class AirlineMealServiceImpTest extends TestCase {

    Passenger passenger = new Passenger();
    AirlineMealServiceImp airlineMealServiceImp = new AirlineMealServiceImp();
    AirLineMeal airLineMeal = new AirLineMeal();

    public void testUpdate() {

        passenger = airlineMealServiceImp.update(1111,100,1);
        System.out.println(passenger.toString());

    }

    public void testSearchByAirlineId() {
        airLineMeal  = airlineMealServiceImp.searchByAirlineId(2);
        System.out.println(airLineMeal.toString());
    }
}
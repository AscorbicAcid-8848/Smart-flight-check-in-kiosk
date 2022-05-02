package service.imp;

import model.Flight;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;

/**
 * @author Zihao Ye
 * @version 1.0
 */
public class FlightServiceImpTest {
    FlightServiceImp flightServiceImp = new FlightServiceImp();

    @Test
    public void testInsert() {
        for (String s : Arrays.asList(flightServiceImp.insert(8888, 8888, "Test", new Date(), new Date(), true,
                8888, "Test", "Test", "Test", 8888, true).toString(), "")) {
            System.out.println(s);
        }
    }

    @Test
    public void testSearchByFlightId() {
        System.out.println(flightServiceImp.searchByFlightId(100).toString());
    }

    @Test
    public void testChange() {
        Flight flight = new Flight();
        flight.setFlightId(100);
        System.out.println(flightServiceImp.change(flight));
    }

    @Test
    public void testToJSON() {
        flightServiceImp.toJSON();
    }
}
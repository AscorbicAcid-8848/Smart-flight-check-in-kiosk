package service.imp;

import model.FlightSeat;
import model.Passenger;
import model.Seat;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Zihao Ye
 * @version 1.0
 */
public class FlightSeatServiceImpTest {

    FlightSeatServiceImp flightSeatServiceImp = new FlightSeatServiceImp();
    @Test
    public void update() {
        Passenger passenger = new Passenger();
        FlightSeat flightSeat = new FlightSeat();

        passenger = flightSeatServiceImp.update(1111,100,1);
        System.out.println(passenger.toString());


        flightSeat  = flightSeatServiceImp.searchByFlightId(100);

        System.out.println();

        flightSeatServiceImp.toJSON();
    }

    @Test
    public void searchByFlightId() {

    }

    public void testToJSON() {

    }
}
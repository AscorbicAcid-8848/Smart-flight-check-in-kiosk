package service.imp;

import model.Passenger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zihao Ye
 * @version 1.0
 */
public class PassengerServiceImpTest {

    @Test
    public void searchByBookingNumber() {
        PassengerServiceImp passengerServiceImp = new PassengerServiceImp();

        System.out.println(passengerServiceImp.searchByBookingNumber(10000).toString());
    }

    @Test
    public void searchBySurnameAndPassengerId() {
        PassengerServiceImp passengerServiceImp = new PassengerServiceImp();

        System.out.println(passengerServiceImp.searchBySurnameAndPassengerId("Ye",1).toString());
    }

    @Test
    public void searchByIdDocument() {
        PassengerServiceImp passengerServiceImp = new PassengerServiceImp();

        System.out.println(passengerServiceImp.searchByIdDocument(1111).toString());
    }

    //verification by passenger id
    @Test
    public void update() {
        PassengerServiceImp passengerServiceImp = new PassengerServiceImp();
        Passenger passenger = new Passenger();
        List<Integer> passengerFlightIDs = new ArrayList<>();
        passengerFlightIDs.add(100);
        passengerFlightIDs.add(101);
        passengerFlightIDs.add(200);

        passenger.setPassengerId(1);
        passenger.setSurname("Ye");
        passenger.setFirstname("Zihao");
        passenger.setGender(1);
        passenger.setSeatNumber(-1);
        passenger.setMeal(-1);
        passenger.setIdDocument(1111);
        passenger.setSeatLevel("fir");

        System.out.println(passengerServiceImp.update(passenger).toString());
    }
}
package service.imp;

import org.junit.Test;

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

    @Test
    public void update() {
        PassengerServiceImp passengerServiceImp = new PassengerServiceImp();

        System.out.println(passengerServiceImp.update(passengerServiceImp.searchByIdDocument(1111),"fir",1,80).toString());
    }
}
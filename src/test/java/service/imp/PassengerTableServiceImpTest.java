package service.imp;

import model.PassengerTable;
import org.junit.Test;

/**
 * @author Zihao Ye
 * @version 1.0
 */
public class PassengerTableServiceImpTest {
    PassengerTableServiceImp passengerTableServiceImp = new PassengerTableServiceImp();

    @Test
    public void checkPassengerCheckInStatus() {
        System.out.println(passengerTableServiceImp.checkPassengerCheckInStatus(300).toString());

        passengerTableServiceImp.setChecked(100,1111,true);
        System.out.println(passengerTableServiceImp.checkPassengerCheckInStatus(100).toString());

        passengerTableServiceImp.toJSON();
    }

    @Test
    public void setChecked() {
    }

    @Test
    public void toJSON() {
    }
}
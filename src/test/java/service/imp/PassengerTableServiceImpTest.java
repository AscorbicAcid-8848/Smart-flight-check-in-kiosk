package service.imp;

import model.PassengerTable;
import org.junit.Test;

/**
 * @author Zihao Ye
 * @version 1.0
 */
public class PassengerTableServiceImpTest {



    @Test
    public void freshTable() {
    }

    @Test
    public void checkPassengerCheckInStatus() {
        PassengerTableServiceImp passengerTableServiceImp = new PassengerTableServiceImp();

        passengerTableServiceImp.freshTable();

        PassengerTable passengerTable = passengerTableServiceImp.checkPassengerCheckInStatus(100);

        passengerTableServiceImp.setChecked(100,1111, true);

        try {
            passengerTableServiceImp.toJSON();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void setChecked() {
    }



    @Test
    public void toJSON() {
    }
}
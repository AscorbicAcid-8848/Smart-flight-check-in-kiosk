package mock;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Zihao Ye
 * @version 1.0
 */
public class PassengerTableMockTest {

    @Test
    public void addIdDocument() {
        PassengerTableMock passengerTableMock = new PassengerTableMock();
        try {
            passengerTableMock.toJSON(null,true);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void freshTable() {
    }

    @Test
    public void toJSON() {
    }
}
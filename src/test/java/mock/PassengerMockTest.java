package mock;

import org.junit.Test;

import java.io.IOException;

/**
 * @author Zihao Ye
 * @version 1.0
 */
public class PassengerMockTest {

    @Test
    public void toJSON() {
        PassengerMock passengerMock = new PassengerMock();
        try {
            passengerMock.toJSON(null,true);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
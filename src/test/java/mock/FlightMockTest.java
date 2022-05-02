package mock;

import org.junit.Test;
import service.imp.FlightServiceImp;

import java.util.Date;

/**
 * @author Zihao Ye
 * @version 1.0
 */
public class FlightMockTest {

    @Test
    public void toJSON() {

        FlightMock flightMock = new FlightMock();

        try {
            flightMock.toJSON(null, true);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
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

        FlightServiceImp flightServiceImp = new FlightServiceImp();

        try {
            flightServiceImp.toJSON();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
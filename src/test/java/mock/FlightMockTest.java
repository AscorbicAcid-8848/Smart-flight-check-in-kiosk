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
        flightServiceImp.insert(8888,8888,"Test",new Date(),new Date(),true,
                8888,"Test","Test","Test",8888).toString();

        try {
            flightServiceImp.toJSON();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
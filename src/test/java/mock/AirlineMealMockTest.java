package mock;

import junit.framework.TestCase;

import java.io.IOException;

/**
 * @author Zihao Ye
 * @version 1.0
 */
public class AirlineMealMockTest extends TestCase {

    public void testToJSON() {
        AirlineMealMock airlineMealMock = new AirlineMealMock();
        try {
            airlineMealMock.toJSON(null,true);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
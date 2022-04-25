package mock;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author Zihao Ye
 * @version 1.0
 */
public class AirlineMockTest {

    @Test
    public void toJSON() {
        AirlineMock airlineMock = new AirlineMock();
        try {
            airlineMock.toJSON(null,true);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
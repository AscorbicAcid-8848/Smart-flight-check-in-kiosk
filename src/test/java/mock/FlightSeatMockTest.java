package mock;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author Zihao Ye
 * @version 1.0
 */
public class FlightSeatMockTest {

    @Test
    public void toJSON() throws IOException {
        FlightSeatMock flightSeatMock = new FlightSeatMock();
        try {
            flightSeatMock.toJSON(null,true);
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
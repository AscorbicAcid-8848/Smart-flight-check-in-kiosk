package mock;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;

/**
 * @author YichenLiu
 * @description:
 * @date 2022/5/19 17:18
 */
public class MockAll extends TestCase {

    @Test
    public void refreshData(){
        PassengerMock passengerMock = new PassengerMock();
        IdDocumentCardMock idDocumentCardMock = new IdDocumentCardMock();
        FlightSeatMock flightSeatMock = new FlightSeatMock();
        FlightMock flightMock = new FlightMock();
        AirlineMock airlineMock = new AirlineMock();
        AirlineMealMock airlineMealMock = new AirlineMealMock();
        try {
            //passenger
            passengerMock.toJSON(null,true);
            //idDocumentCard
            idDocumentCardMock.toJSON(1111,"Zihao Ye");
            idDocumentCardMock.toJSON(2222,"Yichen Liu");
            idDocumentCardMock.toJSON(3333,"Ran Xu");
            idDocumentCardMock.toJSON(4444,"Zhihan Zhang");
            //seat
            flightSeatMock.toJSON(null,true);
            //flight
            flightMock.toJSON(null, true);
            //airline
            airlineMock.toJSON(null,true);
            //meal
            airlineMealMock.toJSON(null,true);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

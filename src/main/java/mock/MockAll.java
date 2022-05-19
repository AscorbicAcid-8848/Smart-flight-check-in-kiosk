package mock;/**
 * @author Zihao Ye
 * @version 1.0
 */

import java.io.IOException;

/**
 * @projectName: workspace.xml
 * @package: mock
 * @className: MockAll
 * @author: Zihao YE
 * @description: TODO
 * @date: 2022/5/19 18:23
 * @version: 1.0
 */
public class MockAll {

    public void refreshData(){

        PassengerMock passengerMock = new PassengerMock();
        FlightSeatMock flightSeatMock = new FlightSeatMock();
        FlightMock flightMock = new FlightMock();
        AirlineMock airlineMock = new AirlineMock();
        AirlineMealMock airlineMealMock = new AirlineMealMock();

        try {
            //passenger
            passengerMock.toJSON(null,true);

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

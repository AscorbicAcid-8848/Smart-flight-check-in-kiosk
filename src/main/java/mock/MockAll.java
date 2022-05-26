package mock;/**
 * @author Zihao Ye
 * @version 1.0
 */

import java.io.File;
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

    /**
     * refresh all the data
     */
    public void refreshData(){

        PassengerMock passengerMock = new PassengerMock();
        FlightSeatMock flightSeatMock = new FlightSeatMock();
        FlightMock flightMock = new FlightMock();
        AirlineMock airlineMock = new AirlineMock();
        AirlineMealMock airlineMealMock = new AirlineMealMock();
        PassengerTableMock passengerTableMock = new PassengerTableMock();

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
            //passenger table
            passengerTableMock.freshTable();
            passengerTableMock.toJSON(null,true);

            //delete file
            File file1 = new File("BoardingPass_Tag_Ticket\\boardingPass.json");
            File file2 = new File("BoardingPass_Tag_Ticket\\bagTag.json");
            File file3 = new File("BoardingPass_Tag_Ticket\\bagTicket.json");
            file1.delete();
            file2.delete();
            file3.delete();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

}

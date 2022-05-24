package mock;/**
 * @author Zihao Ye
 * @version 1.0
 */

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: Smart-flight-check-in-kiosk
 * @package: mock
 * @className: PassengerTableMock
 * @author: Zihao YE
 * @description: TODO
 * @date: 2022/5/23 17:42
 * @version: 1.0
 */
public class PassengerTableMock {
    List<PassengerTable> passengerTables = new ArrayList<>();

    public PassengerTableMock(){
        this.freshTable();
    }

    /**
     * add a new idDocument to Passenger Table and set its check status to checkStatus
     * @param flightId: flightId
     * @param idDocument: idDocument
     * @param checkStatus: checkStatus
     */
    public void addIdDocument(Integer flightId,Integer idDocument, Boolean checkStatus) {

        PassengerCheckInStatue passengerCheckInStatue = new PassengerCheckInStatue();
        passengerCheckInStatue.setIdDocument(idDocument);
        passengerCheckInStatue.setChecked(checkStatus);

        for (int i=0; i<passengerTables.size(); i++) {
            if (passengerTables.get(i).getFlightId() == flightId) {
                this.passengerTables.get(i).getPassengerCheckInStatueList().add(passengerCheckInStatue);
            }
        }
    }

    /**
     * fresh the data
     */
    public void freshTable() {

        //read file
        ObjectMapper objectMapper = new ObjectMapper();
        List<Passenger> passengers = new ArrayList<Passenger>();
        List<Flight> flights = new ArrayList<Flight>();
        File passengerList = new File("data\\passengerList.json");
        File flightList = new File("data\\flightList.json");

        try {
            JavaType passenger_type = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Passenger.class);
            passengers = objectMapper.readValue(passengerList, passenger_type);
            JavaType flight_type = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Flight.class);
            flights = objectMapper.readValue(flightList, flight_type);
        }catch (IOException e){
            e.printStackTrace();
        }


        this.passengerTables = new ArrayList<>();

        for(int i=0; i<flights.size(); i++){
            PassengerTable passengerTable = new PassengerTable();
            passengerTable.setFlightId(flights.get(i).getFlightId());

            this.passengerTables.add(passengerTable);
        }


        for(int i=0; i<passengers.size(); i++){

            for(int j=0; j<passengers.get(i).getFlightId().size(); j++){

                for(int k=0; k<passengerTables.size(); k++){

                    if(passengers.get(i).getFlightId().get(j).equals(this.passengerTables.get(k).getFlightId())){

                        this.addIdDocument(this.passengerTables.get(k).getFlightId(),passengers.get(i).getIdDocument(),false);

                    }
                }
            }
        }

        System.out.println();
    }

    /**
     * a methed to transform data to json
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    public void toJSON(ArrayList<PassengerTable> input, Boolean useMockData) throws JsonGenerationException, JsonMappingException, IOException{
        //determine whether use mock data or not
        if(!useMockData){
            passengerTables = input;
        }

        ObjectMapper mapper = new ObjectMapper();
        FileWriter file = new FileWriter("data\\passengerTableList.json",false);

        try {
            file.write("");
        }catch (IOException e) {
            e.printStackTrace();
        }

        //write json data to json file
        try {
            mapper.writeValue(file, passengerTables);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}

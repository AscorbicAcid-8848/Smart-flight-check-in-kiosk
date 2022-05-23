package service.imp;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mock.FlightSeatMock;
import mock.PassengerTableMock;
import model.Flight;
import model.FlightSeat;
import model.Passenger;
import model.PassengerTable;
import service.PassengerTableListService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author YichenLiu Zihao Ye
 * @description:
 * @date 2022/5/23 10:53
 */
public class PassengerTableServiceImp implements PassengerTableListService {
    ArrayList<PassengerTable> passengerTables = new ArrayList<>();
    ObjectMapper objectMapper = new ObjectMapper();

    public PassengerTableServiceImp(){
        File passengerTableList = new File("data\\passengerTableList.json");

        try {
            JavaType type = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, PassengerTable.class);
            passengerTables = objectMapper.readValue(passengerTableList, type);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * get the passenger checkIn status by input corresponding flight id
     * @param flightId: flight id
     * @return: passenger table
     */
    @Override
    public PassengerTable checkPassengerCheckInStatus(Integer flightId){
        PassengerTable searchResult = new PassengerTable();

        for (int i=0; i<passengerTables.size(); i++){
            if( passengerTables.get(i).getFlightId().equals(flightId) ){

                searchResult = passengerTables.get(i);

            }
        }

        return searchResult;
    }

    /**
     * method set passenger check status with its flight id, idDocument and update statues isChecked
     * @param flightId :flightId
     * @param idDocument :idDocument
     * @param isChecked :isChecked
     */
    @Override
    public void setChecked(Integer flightId, Integer idDocument, Boolean isChecked){

        for(int i=0; i<passengerTables.size(); i++){

            if( passengerTables.get(i).getFlightId().equals(flightId) ){

                passengerTables.get(i).setChecked(idDocument, isChecked);

            }
        }
    }

    /**
     * method to store data in service to json file
     */
    public void toJSON(){
        PassengerTableMock passengerTableMock = new PassengerTableMock();
        try {
            passengerTableMock.toJSON((ArrayList<PassengerTable>) passengerTables, false);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}

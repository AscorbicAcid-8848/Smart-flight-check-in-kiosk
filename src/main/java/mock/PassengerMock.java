package mock;


import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Passenger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zihao Ye
 * @version 1.0
 */
public class PassengerMock {

    //passenger list
    List<Passenger> passengers = new ArrayList<Passenger>();
    Passenger passenger0 = new Passenger();
    Passenger passenger1 = new Passenger();
    Passenger passenger2 = new Passenger();
    Passenger passenger3 = new Passenger();

    public PassengerMock(){


        //set flight id (three flight 100:BUPT2022 ,101:QM2022, 200:BUPT2021
        List<Integer> passenger0FlightIDs = new ArrayList<>();
        List<Integer> passenger1FlightIDs = new ArrayList<>();
        List<Integer> passenger2FlightIDs = new ArrayList<>();
        List<Integer> passenger3FlightIDs = new ArrayList<>();
        passenger0FlightIDs.add(100);
        passenger0FlightIDs.add(200);
        passenger1FlightIDs.add(100);
        passenger1FlightIDs.add(101);
        passenger2FlightIDs.add(200);
        passenger3FlightIDs.add(200);
        passenger3FlightIDs.add(101);
        passenger0.setFlightId(passenger0FlightIDs);
        passenger1.setFlightId(passenger1FlightIDs);
        passenger2.setFlightId(passenger2FlightIDs);
        passenger3.setFlightId(passenger3FlightIDs);


        //set passenger ID (4 passengers corresponds to 1,2,3,4)
        passenger0.setPassengerId(1);
        passenger1.setPassengerId(2);
        passenger2.setPassengerId(3);
        passenger3.setPassengerId(4);

        List<Integer> bookingnumber0 = new ArrayList<>();
        List<Integer> bookingnumber1 = new ArrayList<>();
        List<Integer> bookingnumber2 = new ArrayList<>();
        List<Integer> bookingnumber3 = new ArrayList<>();
        //set booking number
        for(Integer i: passenger0.getFlightId()){
            bookingnumber0.add(i*100 + passenger0.getPassengerId());
        }
        for(Integer i: passenger1.getFlightId()){
            bookingnumber1.add(i*100 + passenger1.getPassengerId());
        }
        for(Integer i: passenger2.getFlightId()){
            bookingnumber2.add(i*100 + passenger2.getPassengerId());
        }
        for(Integer i: passenger3.getFlightId()){
            bookingnumber3.add(i*100 + passenger3.getPassengerId());
        }
        passenger0.setBookingNumber(bookingnumber0);
        passenger1.setBookingNumber(bookingnumber1);
        passenger2.setBookingNumber(bookingnumber2);
        passenger3.setBookingNumber(bookingnumber3);

        //set surname (4 people: Zihao Ye, Yichen Liu, Ran Xu, Zhihan Zhang)
        passenger0.setSurname("Ye");
        passenger1.setSurname("Liu");
        passenger2.setSurname("Xu");
        passenger3.setSurname("Zhang");

        //set first name
        passenger0.setFirstname("Zihao");
        passenger1.setFirstname("Yichen");
        passenger2.setFirstname("Ran");
        passenger3.setFirstname("Zhihan");

        //set gender 1: male 2:female 3:other gender
        passenger0.setGender(3);
        passenger1.setGender(1);
        passenger2.setGender(2);
        passenger3.setGender(1);

        //set seat level (fir: first class, bus: business class, eco: economy class) nul: for null
        passenger0.setSeatLevel("nul");
        passenger1.setSeatLevel("nul");
        passenger2.setSeatLevel("nul");
        passenger3.setSeatLevel("nul");

        //set seat number -1:for null
        passenger0.setSeatNumber(-1);
        passenger1.setSeatNumber(-1);
        passenger2.setSeatNumber(-1);
        passenger3.setSeatNumber(-1);

        //set meal (1,2) -1:for null
        passenger0.setMeal(-1);
        passenger1.setMeal(-1);
        passenger2.setMeal(-1);
        passenger3.setMeal(-1);

        //set IdDocument
        passenger0.setIdDocument(1111);
        passenger1.setIdDocument(2222);
        passenger2.setIdDocument(3333);
        passenger3.setIdDocument(4444);

        //set visa id
        passenger0.setVisaId(11111111);
        passenger1.setVisaId(22222222);
        passenger2.setVisaId(33333333);
        passenger3.setVisaId(44444444);

        //set visa password
        passenger0.setVisaPassword("yezihao000");
        passenger1.setVisaPassword("liuyichen111");
        passenger2.setVisaPassword("xuran222");
        passenger3.setVisaPassword("zhangzhihan333");

        //set visa informations

        passengers.add(passenger0);
        passengers.add(passenger1);
        passengers.add(passenger2);
        passengers.add(passenger3);
    }

    public void toJSON(ArrayList<Passenger> input, Boolean useMockData) throws JsonGenerationException, JsonMappingException, IOException {
        //determine whether use mock data or not
        if(!useMockData){
            passengers = input;
        }

        ObjectMapper mapper = new ObjectMapper();
        FileWriter file = new FileWriter("data\\passengerList.json");

        try {
            file.write("");
        }catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mapper.writeValue(file, passengers);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }

    }

}

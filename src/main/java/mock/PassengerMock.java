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

        //set booking number
        passenger0.setBookingNumber(10000);
        passenger1.setBookingNumber(10001);
        passenger2.setBookingNumber(20000);
        passenger3.setBookingNumber(20001);

        //set flight id (two flight 1 and 2)
        passenger0.setFlightId(1);
        passenger1.setFlightId(1);
        passenger2.setFlightId(2);
        passenger3.setFlightId(2);

        //set passenger ID (4 passengers corresponds to 1,2,3,4)
        passenger0.setPassengerId(1);
        passenger1.setPassengerId(2);
        passenger2.setPassengerId(3);
        passenger3.setPassengerId(4);

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

        //set seat level (fir: first class, bus: business class, eco: economy class)
        passenger0.setSeatLevel("eco");
        passenger1.setSeatLevel("bus");
        passenger2.setSeatLevel("fir");
        passenger3.setSeatLevel("eco");

        //set seat number
        passenger0.setSeatNumber(1);
        passenger1.setSeatNumber(2);
        passenger2.setSeatNumber(10);
        passenger3.setSeatNumber(11);

        //set meal (1,2)
        passenger0.setMeal(1);
        passenger1.setMeal(2);
        passenger2.setMeal(1);
        passenger3.setMeal(2);

        //set IdDocument
        passenger0.setIdDocument(1111);
        passenger1.setIdDocument(2222);
        passenger2.setIdDocument(3333);
        passenger3.setIdDocument(4444);

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

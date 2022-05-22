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
    Passenger passenger4 = new Passenger();
    Passenger passenger5 = new Passenger();
    Passenger passenger6 = new Passenger();
    Passenger passenger7 = new Passenger();
    Passenger passenger8 = new Passenger();
    Passenger passenger9 = new Passenger();
    Passenger passenger10 = new Passenger();
    Passenger passenger11 = new Passenger();

    public PassengerMock(){


        //set flight id (three flight 100:BUPT2022 ,101:QM2022, 200:BUPT2021
        List<Integer> passenger0FlightIDs = new ArrayList<>();
        List<Integer> passenger1FlightIDs = new ArrayList<>();
        List<Integer> passenger2FlightIDs = new ArrayList<>();
        List<Integer> passenger3FlightIDs = new ArrayList<>();
        List<Integer> passenger4FlightIDs = new ArrayList<>();
        List<Integer> passenger5FlightIDs = new ArrayList<>();
        List<Integer> passenger6FlightIDs = new ArrayList<>();
        List<Integer> passenger7FlightIDs = new ArrayList<>();
        List<Integer> passenger8FlightIDs = new ArrayList<>();
        List<Integer> passenger9FlightIDs = new ArrayList<>();
        List<Integer> passenger10FlightIDs = new ArrayList<>();
        List<Integer> passenger11FlightIDs = new ArrayList<>();

        passenger0FlightIDs.add(100);
        passenger0FlightIDs.add(200);

        passenger1FlightIDs.add(100);
        passenger1FlightIDs.add(101);

        passenger2FlightIDs.add(200);

        passenger3FlightIDs.add(200);
        passenger3FlightIDs.add(101);

        passenger4FlightIDs.add(200);
        passenger4FlightIDs.add(101);
        passenger4FlightIDs.add(300);

        passenger5FlightIDs.add(400);
        passenger5FlightIDs.add(300);

        passenger6FlightIDs.add(201);

        passenger6FlightIDs.add(401);
        passenger6FlightIDs.add(201);

        passenger7FlightIDs.add(300);
        passenger7FlightIDs.add(101);

        passenger8FlightIDs.add(400);
        passenger8FlightIDs.add(201);

        passenger9FlightIDs.add(200);

        passenger10FlightIDs.add(100);
        passenger10FlightIDs.add(101);

        passenger11FlightIDs.add(100);
        passenger11FlightIDs.add(101);

        passenger0.setFlightId(passenger0FlightIDs);
        passenger1.setFlightId(passenger1FlightIDs);
        passenger2.setFlightId(passenger2FlightIDs);
        passenger3.setFlightId(passenger3FlightIDs);
        passenger4.setFlightId(passenger4FlightIDs);
        passenger5.setFlightId(passenger5FlightIDs);
        passenger6.setFlightId(passenger6FlightIDs);
        passenger7.setFlightId(passenger7FlightIDs);
        passenger8.setFlightId(passenger8FlightIDs);
        passenger9.setFlightId(passenger9FlightIDs);
        passenger10.setFlightId(passenger10FlightIDs);
        passenger11.setFlightId(passenger11FlightIDs);


        //set passenger ID (4 passengers corresponds to 1,2,3,4)
        passenger0.setPassengerId(1);
        passenger1.setPassengerId(2);
        passenger2.setPassengerId(3);
        passenger3.setPassengerId(4);
        passenger4.setPassengerId(5);
        passenger5.setPassengerId(6);
        passenger6.setPassengerId(7);
        passenger7.setPassengerId(8);
        passenger8.setPassengerId(9);
        passenger9.setPassengerId(10);
        passenger10.setPassengerId(11);
        passenger11.setPassengerId(12);

        List<Integer> bookingnumber0 = new ArrayList<>();
        List<Integer> bookingnumber1 = new ArrayList<>();
        List<Integer> bookingnumber2 = new ArrayList<>();
        List<Integer> bookingnumber3 = new ArrayList<>();
        List<Integer> bookingnumber4 = new ArrayList<>();
        List<Integer> bookingnumber5 = new ArrayList<>();
        List<Integer> bookingnumber6 = new ArrayList<>();
        List<Integer> bookingnumber7 = new ArrayList<>();
        List<Integer> bookingnumber8 = new ArrayList<>();
        List<Integer> bookingnumber9 = new ArrayList<>();
        List<Integer> bookingnumber10 = new ArrayList<>();
        List<Integer> bookingnumber11 = new ArrayList<>();

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
        for(Integer i: passenger4.getFlightId()){
            bookingnumber4.add(i*100 + passenger4.getPassengerId());
        }
        for(Integer i: passenger5.getFlightId()){
            bookingnumber5.add(i*100 + passenger5.getPassengerId());
        }
        for(Integer i: passenger6.getFlightId()){
            bookingnumber6.add(i*100 + passenger6.getPassengerId());
        }
        for(Integer i: passenger7.getFlightId()){
            bookingnumber7.add(i*100 + passenger7.getPassengerId());
        }
        for(Integer i: passenger8.getFlightId()){
            bookingnumber8.add(i*100 + passenger8.getPassengerId());
        }
        for(Integer i: passenger9.getFlightId()){
            bookingnumber9.add(i*100 + passenger9.getPassengerId());
        }
        for(Integer i: passenger10.getFlightId()){
            bookingnumber10.add(i*100 + passenger10.getPassengerId());
        }
        for(Integer i: passenger11.getFlightId()){
            bookingnumber11.add(i*100 + passenger11.getPassengerId());
        }
        passenger0.setBookingNumber(bookingnumber0);
        passenger1.setBookingNumber(bookingnumber1);
        passenger2.setBookingNumber(bookingnumber2);
        passenger3.setBookingNumber(bookingnumber3);
        passenger4.setBookingNumber(bookingnumber4);
        passenger5.setBookingNumber(bookingnumber5);
        passenger6.setBookingNumber(bookingnumber6);
        passenger7.setBookingNumber(bookingnumber7);
        passenger8.setBookingNumber(bookingnumber8);
        passenger9.setBookingNumber(bookingnumber9);
        passenger10.setBookingNumber(bookingnumber10);
        passenger11.setBookingNumber(bookingnumber11);

        //set surname (4 people: Zihao Ye, Yichen Liu, Ran Xu, Zhihan Zhang)
        passenger0.setSurname("Ye");
        passenger1.setSurname("Liu");
        passenger2.setSurname("Xu");
        passenger3.setSurname("Zhang");
        passenger4.setSurname("Ma");
        passenger5.setSurname("Peng");
        passenger6.setSurname("Chen");
        passenger7.setSurname("Micheal");
        passenger8.setSurname("Ye");
        passenger9.setSurname("Alan");
        passenger10.setSurname("Chen");
        passenger11.setSurname("Guo");

        //set first name
        passenger0.setFirstname("Zihao");
        passenger1.setFirstname("Yichen");
        passenger2.setFirstname("Ran");
        passenger3.setFirstname("Zhihan");
        passenger4.setFirstname("Ling");
        passenger5.setFirstname("Jing");
        passenger6.setFirstname("Ziyi");
        passenger7.setFirstname("Jackson");
        passenger8.setFirstname("Ziiihooo");
        passenger9.setFirstname("Brown");
        passenger10.setFirstname("Meiling");
        passenger11.setFirstname("Yijun");

        //set gender 1: male 2:female 3:other gender
        passenger0.setGender(3);
        passenger1.setGender(1);
        passenger2.setGender(2);
        passenger3.setGender(1);
        passenger4.setGender(2);
        passenger5.setGender(2);
        passenger6.setGender(1);
        passenger7.setGender(1);
        passenger8.setGender(1);
        passenger9.setGender(1);
        passenger10.setGender(2);
        passenger11.setGender(2);

        //set seat level (fir: first class, bus: business class, eco: economy class) nul: for null
        passenger0.setSeatLevel(null);
        passenger1.setSeatLevel(null);
        passenger2.setSeatLevel(null);
        passenger3.setSeatLevel(null);
        passenger4.setSeatLevel(null);
        passenger5.setSeatLevel(null);
        passenger6.setSeatLevel(null);
        passenger7.setSeatLevel(null);
        passenger8.setSeatLevel(null);
        passenger9.setSeatLevel(null);
        passenger10.setSeatLevel(null);
        passenger11.setSeatLevel(null);

        //set seat number -1:for null
        passenger0.setSeatNumber(-1);
        passenger1.setSeatNumber(-1);
        passenger2.setSeatNumber(-1);
        passenger3.setSeatNumber(-1);
        passenger4.setSeatNumber(-1);
        passenger5.setSeatNumber(-1);
        passenger6.setSeatNumber(-1);
        passenger7.setSeatNumber(-1);
        passenger8.setSeatNumber(-1);
        passenger9.setSeatNumber(-1);
        passenger10.setSeatNumber(-1);
        passenger11.setSeatNumber(-1);

        //set meal (1,2) -1:for null
        passenger0.setMeal(-1);
        passenger1.setMeal(-1);
        passenger2.setMeal(-1);
        passenger3.setMeal(-1);
        passenger4.setMeal(-1);
        passenger5.setMeal(-1);
        passenger6.setMeal(-1);
        passenger7.setMeal(-1);
        passenger8.setMeal(-1);
        passenger9.setMeal(-1);
        passenger10.setMeal(-1);
        passenger11.setMeal(-1);

        //set IdDocument
        passenger0.setIdDocument(1111);
        passenger1.setIdDocument(2222);
        passenger2.setIdDocument(3333);
        passenger3.setIdDocument(4444);
        passenger4.setIdDocument(5555);
        passenger5.setIdDocument(6666);
        passenger6.setIdDocument(7777);
        passenger7.setIdDocument(8888);
        passenger8.setIdDocument(9999);
        passenger9.setIdDocument(1010);
        passenger10.setIdDocument(1101);
        passenger11.setIdDocument(1212);

        //set visa id
        passenger0.setVisaId(11111111);
        passenger1.setVisaId(22222222);
        passenger2.setVisaId(33333333);
        passenger3.setVisaId(44444444);
        passenger4.setVisaId(55555555);
        passenger5.setVisaId(66666666);
        passenger6.setVisaId(77777777);
        passenger7.setVisaId(88888888);
        passenger8.setVisaId(99999999);
        passenger9.setVisaId(10101010);
        passenger10.setVisaId(11011101);
        passenger11.setVisaId(12121212);

        //set visa password
        passenger0.setVisaPassword("yezihao000");
        passenger1.setVisaPassword("liuyichen111");
        passenger2.setVisaPassword("xuran222");
        passenger3.setVisaPassword("zhangzhihan333");
        passenger4.setVisaPassword("123456");
        passenger5.setVisaPassword("123456");
        passenger6.setVisaPassword("123456");
        passenger7.setVisaPassword("123456");
        passenger8.setVisaPassword("123456");
        passenger9.setVisaPassword("123456");
        passenger10.setVisaPassword("123456");
        passenger11.setVisaPassword("123456");

        //set visa informations

        passengers.add(passenger0);
        passengers.add(passenger1);
        passengers.add(passenger2);
        passengers.add(passenger3);
        passengers.add(passenger4);
        passengers.add(passenger5);
        passengers.add(passenger6);
        passengers.add(passenger7);
        passengers.add(passenger8);
        passengers.add(passenger9);
        passengers.add(passenger10);
        passengers.add(passenger11);
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

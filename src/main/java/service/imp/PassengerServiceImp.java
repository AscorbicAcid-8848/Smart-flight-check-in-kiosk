package service.imp;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import mock.PassengerMock;
import model.Passenger;
import service.PassengerService;

import java.beans.ConstructorProperties;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author YichenLiu ZihaoYe
 * @description: User Service entity
 * @date 2022/3/16 16:26
 */
public class PassengerServiceImp implements PassengerService {


    private List<Passenger> passengers = new ArrayList<Passenger>();

    @ConstructorProperties({})
    public PassengerServiceImp(){
        ObjectMapper objectMapper = new ObjectMapper();
        File passengerList = new File("data\\passengerList.json");

        try {
            JavaType type = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Passenger.class);
            passengers = objectMapper.readValue(passengerList, type);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public Passenger searchByBookingNumber(Integer bookingNumber) {
        int result = -1;

        //search in passenger list
        for(int i=0; i< passengers.size(); i++){
            //if booking numbers match
            if(passengers.get(i).getBookingNumber().equals(bookingNumber)){
                //and if there is only one result
                if(result == -1){
                    result = i;
                }else{ //is there are more than one result: print alarm and show the first result
                    System.out.println("There are more than one result!");
                }
            }
        }

        //if there is result return it
        if(result != -1) {
            return passengers.get(result);
        }else {//if there is no result, return an empty passenger
            System.out.println("No result");
            return null;
        }
    }

    @Override
    public Passenger searchBySurnameAndPassengerId(String surname, Integer passengerId) {
        int result = -1;

        //search in passenger list
        for(int i=0; i<passengers.size(); i++){
            //if match
            if( (passengers.get(i).getSurname().equals(surname) && (passengers.get(i).getPassengerId().equals(passengerId)) )){
                //and if there is only one result
                if(result == -1){
                    result = i;
                }else{ //is there are more than one result: print alarm and show the first result
                    System.out.println("There are more than one result!");
                }
            }
        }

        //if there is result return it
        if(result != -1) {
            return passengers.get(result);
        }else {//if there is no result, return an empty passenger
            System.out.println("No result");
            return null;
        }
    }

    @Override
    public Passenger searchByIdDocument(Integer idDocument) {
        int result = -1;

        //search in passenger list
        for(int i=0; i< passengers.size(); i++){
            //if match
            if( passengers.get(i).getIdDocument().equals(idDocument)){
                //and if there is only one result
                if(result == -1){
                    result = i;
                }else{ //is there are more than one result: print alarm and show the first result
                    System.out.println("There are more than one result!");
                }
            }
        }

        //if there is result return it
        if(result != -1) {
            return passengers.get(result);
        }else {//if there is no result, return an empty passenger
            System.out.println("No result");
            return null;
        }
    }

    @Override
    public Passenger update(Passenger passenger) {

        int result = -1;

        for (int i = 0; i < passengers.size(); i++) {
            if (passengers.get(i).getPassengerId().equals(passenger.getPassengerId())) {
                //update
                passengers.get(i).setBookingNumber(passenger.getBookingNumber());
                passengers.get(i).setFlightId(passenger.getFlightId());
                passengers.get(i).setPassengerId(passenger.getPassengerId());
                passengers.get(i).setSurname(passenger.getSurname());
                passengers.get(i).setFirstname(passenger.getFirstname());
                passengers.get(i).setGender(passenger.getGender());
                passengers.get(i).setSeatLevel(passenger.getSeatLevel());
                passengers.get(i).setMeal(passenger.getMeal());
                passengers.get(i).setSeatNumber(passenger.getSeatNumber());

                result = i;
            }
        }

        if (result != -1) {
            return passengers.get(result);
        } else {
            System.out.println("no passenger found!");
            return null;
        }
    }

    public void toJSON(){
        PassengerMock passengerMock = new PassengerMock();
        try {
            passengerMock.toJSON((ArrayList<Passenger>) passengers, false);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}

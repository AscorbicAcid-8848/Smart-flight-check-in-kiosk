package mock;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Flight;
import model.FlightSeat;
import model.Seat;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zihao Ye
 * @version 1.0
 */
public class FlightSeatMock {

    //FlightSeat List
    List<FlightSeat> flightSeats = new ArrayList<>();
    FlightSeat flightSeat0 = new FlightSeat();
    FlightSeat flightSeat1 = new FlightSeat();
    FlightSeat flightSeat2 = new FlightSeat();
    FlightSeat flightSeat3 = new FlightSeat();
    FlightSeat flightSeat4 = new FlightSeat();
    FlightSeat flightSeat5 = new FlightSeat();
    FlightSeat flightSeat6 = new FlightSeat();

//    private final int seatNum = 52; //100 seats for default
    private final int BusNum = 10; //10 seats for Business Seat
    private final int SpeNum = 6; //6 seats for Special Seat
    private final int EcoNum = 36; //36 seats for Economic Seat
    private final int BusCost = 250;
    private final int SpeCost = 400;
    private final int EcoCost = 150;


    public FlightSeatMock(){
        //set flight id
        flightSeat0.setFlightId(100);
        flightSeat1.setFlightId(200);
        flightSeat2.setFlightId(101);
        flightSeat3.setFlightId(300);
        flightSeat4.setFlightId(400);
        flightSeat5.setFlightId(201);
        flightSeat6.setFlightId(401);


        //set seats for flight 0
        for(int j=0; j< BusNum; j++){
            Seat seat = new Seat(j, false, "Business", BusCost);
            flightSeat0.getSeatList().add(seat);
        }
        for(int j=0; j< SpeNum; j++){
            Seat seat = new Seat(j+BusNum, false, "Special", SpeCost);
            flightSeat0.getSeatList().add(seat);
        }
        for(int j=0; j< EcoNum; j++){
            Seat seat = new Seat(j+BusNum+SpeNum, false, "Economic", EcoCost);
            flightSeat0.getSeatList().add(seat);
        }

        //set seats for flight 0
        for(int j=0; j< BusNum; j++){
            Seat seat = new Seat(j, false, "Business", BusCost);
            flightSeat1.getSeatList().add(seat);
        }
        for(int j=0; j< SpeNum; j++){
            Seat seat = new Seat(j+BusNum, false, "Special", SpeCost);
            flightSeat1.getSeatList().add(seat);
        }
        for(int j=0; j< EcoNum; j++){
            Seat seat = new Seat(j+BusNum+SpeNum, false, "Economic", EcoCost);
            flightSeat1.getSeatList().add(seat);
        }

        //set seats for flight 0
        for(int j=0; j< BusNum; j++){
            Seat seat = new Seat(j, false, "Business", BusCost);
            flightSeat2.getSeatList().add(seat);
        }
        for(int j=0; j< SpeNum; j++){
            Seat seat = new Seat(j+BusNum, false, "Special", SpeCost);
            flightSeat2.getSeatList().add(seat);
        }
        for(int j=0; j< EcoNum; j++){
            Seat seat = new Seat(j+BusNum+SpeNum, false, "Economic", EcoCost);
            flightSeat2.getSeatList().add(seat);
        }

        //set seats for flight 0
        for(int j=0; j< BusNum; j++){
            Seat seat = new Seat(j, false, "Business", BusCost);
            flightSeat3.getSeatList().add(seat);
        }
        for(int j=0; j< SpeNum; j++){
            Seat seat = new Seat(j+BusNum, false, "Special", SpeCost);
            flightSeat3.getSeatList().add(seat);
        }
        for(int j=0; j< EcoNum; j++){
            Seat seat = new Seat(j+BusNum+SpeNum, false, "Economic", EcoCost);
            flightSeat3.getSeatList().add(seat);
        }

        //set seats for flight 0
        for(int j=0; j< BusNum; j++){
            Seat seat = new Seat(j, false, "Business", BusCost);
            flightSeat4.getSeatList().add(seat);
        }
        for(int j=0; j< SpeNum; j++){
            Seat seat = new Seat(j+BusNum, false, "Special", SpeCost);
            flightSeat4.getSeatList().add(seat);
        }
        for(int j=0; j< EcoNum; j++){
            Seat seat = new Seat(j+BusNum+SpeNum, false, "Economic", EcoCost);
            flightSeat4.getSeatList().add(seat);
        }

        //set seats for flight 0
        for(int j=0; j< BusNum; j++){
            Seat seat = new Seat(j, false, "Business", BusCost);
            flightSeat5.getSeatList().add(seat);
        }
        for(int j=0; j< SpeNum; j++){
            Seat seat = new Seat(j+BusNum, false, "Special", SpeCost);
            flightSeat5.getSeatList().add(seat);
        }
        for(int j=0; j< EcoNum; j++){
            Seat seat = new Seat(j+BusNum+SpeNum, false, "Economic", EcoCost);
            flightSeat5.getSeatList().add(seat);
        }

        //set seats for flight 0
        for(int j=0; j< BusNum; j++){
            Seat seat = new Seat(j, false, "Business", BusCost);
            flightSeat6.getSeatList().add(seat);
        }
        for(int j=0; j< SpeNum; j++){
            Seat seat = new Seat(j+BusNum, false, "Special", SpeCost);
            flightSeat6.getSeatList().add(seat);
        }
        for(int j=0; j< EcoNum; j++){
            Seat seat = new Seat(j+BusNum+SpeNum, false, "Economic", EcoCost);
            flightSeat6.getSeatList().add(seat);
        }

        flightSeats.add(flightSeat0);
        flightSeats.add(flightSeat1);
        flightSeats.add(flightSeat2);
        flightSeats.add(flightSeat3);
        flightSeats.add(flightSeat4);
        flightSeats.add(flightSeat5);
        flightSeats.add(flightSeat6);

    }

    /**
     * a methed to transform input to json file, or you can choose use mock data to create default json
     * @param input: data you want to transform
     * @param useMockData: whether you want to use mock data
     * @throws JsonGenerationException
     * @throws JsonMappingException
     * @throws IOException
     */
    public void toJSON(ArrayList<FlightSeat> input, Boolean useMockData) throws JsonGenerationException, JsonMappingException, IOException {
        //determine whether use mock data or not
        if(!useMockData){
            flightSeats = input;
        }

        ObjectMapper mapper = new ObjectMapper();
        FileWriter file = new FileWriter("data\\flightSeatList.json",false);

        try {
            file.write("");
        }catch (IOException e) {
            e.printStackTrace();
        }

        //write json data to json file
        try {
            mapper.writeValue(file, flightSeats);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}

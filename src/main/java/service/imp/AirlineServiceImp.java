package service.imp;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import mock.AirlineMock;
import model.Airline;
import service.AirlineService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author YichenLiu
 * @description: 航空公司实现类
 * @date 2022/3/27 21:03
 */
public class AirlineServiceImp implements AirlineService {

    private List<Airline> airlines = new ArrayList<Airline>();

    public AirlineServiceImp(){
        ObjectMapper objectMapper = new ObjectMapper();
        File airlineList = new File("data\\airlineList.json");

        try {
            JavaType type = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Airline.class);
            airlines = objectMapper.readValue(airlineList, type);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public Airline update(Airline airline) {
        int result = -1;

        for (int i = 0; i < airlines.size(); i++) {
            if (airlines.get(i).getAirlineId().equals(airline.getAirlineId())) {
                //update
                airlines.get(i).setAirlineName(airline.getAirlineName());

                result = i;
            }
        }

        if (result != -1) {
            return airlines.get(result);
        } else {
            System.out.println("no passenger found!");
            return null;
        }
    }

    public void toJSON(){
        AirlineMock airlineMock = new AirlineMock();
        try {
            airlineMock.toJSON((ArrayList<Airline>) airlines, false);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

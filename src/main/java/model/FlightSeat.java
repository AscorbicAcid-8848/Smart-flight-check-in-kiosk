package model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YichenLiu
 * @description: TODO
 * @date 2022/4/30 16:32
 */
public class FlightSeat {

    private Integer flightId;
    private List<Seat> seatList = new ArrayList<>();


    public FlightSeat(){}

    public FlightSeat(Integer flightId, List<Seat> seatList) {
        this.flightId = flightId;
        this.seatList = seatList;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }
}

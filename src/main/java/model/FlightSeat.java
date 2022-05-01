package model;

import java.util.List;

/**
 * @author YichenLiu
 * @description: TODO
 * @date 2022/4/30 16:32
 */
public class FlightSeat {
    private final int seatNum = 100; //100 seats for default
    private Integer flightId;
    private List<Seat> seatList;

    //return a flight seat object with all the seat's occupied=false seatlevel=nul
    //this object does not set its flightID!
    public FlightSeat(){
        for(int i=0; i< seatNum; i++){
            Seat seat = new Seat(i, false, "nul");
            this.getSeatList().add(seat);
        }
    }
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

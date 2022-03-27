package model;

import java.util.Date;

/**
 * @author YichenLiu
 * @description: Bording pass model
 * @date 2022/3/16 16:32
 */
public class BoardingPass {
    private Flight flight;
    private Passenger passenger;


    @Override//格式确定一下
    public String toString() {
        return "BoardingPass{" +
                "flight=" + flight +
                ", passenger=" + passenger +
                '}';
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}

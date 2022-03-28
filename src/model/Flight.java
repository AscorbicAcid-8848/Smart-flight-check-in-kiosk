package model;

import java.util.Date;

/**
 * @author YichenLiu
 * @description: The flight information
 * @date 2022/3/16 16:41
 */
public class Flight {
    private Integer airlineId;
    private Integer flightId;
    private String flightName;
    private Date departureTime;
    private Date fallTime;

    @Override
    public String toString() {
        return "Flight{" +
                "airlineId=" + airlineId +
                ", flightId=" + flightId +
                ", flightName='" + flightName + '\'' +
                ", departureTime=" + departureTime +
                ", fallTime=" + fallTime +
                '}';
    }


    //setter and getter


    public Date getFallTime() {
        return fallTime;
    }

    public void setFallTime(Date fallTime) {
        this.fallTime = fallTime;
    }

    public Integer getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(Integer airlineId) {
        this.airlineId = airlineId;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

}

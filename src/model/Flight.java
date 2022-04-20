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
    private boolean isDelayed;
    private Integer departureGate;
    private String destWeather;
    private String destCOVIDPolicy;
    private String arrivalAirport;
    private Integer arrivalTerminal;





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
    public void setDelayed(boolean delayed) {
        isDelayed = delayed;
    }

    public boolean isDelayed() {
        return isDelayed;
    }
    public Integer getDepartureGate() {
        return departureGate;
    }

    public void setDepartureGate(Integer departureGate) {
        this.departureGate = departureGate;
    }


    public String getDestWeather() {
        return destWeather;
    }

    public void setDestWeather(String destWeather) {
        this.destWeather = destWeather;
    }

    public String getDestCOVIDPolicy() {
        return destCOVIDPolicy;
    }

    public void setDestCOVIDPolicy(String destCOVIDPolicy) {
        this.destCOVIDPolicy = destCOVIDPolicy;
    }


    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }
    public Integer getArrivalTerminal() {
        return arrivalTerminal;
    }

    public void setArrivalTerminal(Integer arrivalTerminal) {
        this.arrivalTerminal = arrivalTerminal;
    }
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

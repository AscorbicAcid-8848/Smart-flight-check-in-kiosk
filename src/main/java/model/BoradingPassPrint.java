package model;/**
 * @author Zihao Ye
 * @version 1.0
 */

import java.util.Date;

/**
 * @projectName: workspace.xml
 * @package: model
 * @className: BoradingPassPrint
 * @author: Zihao YE
 * @description: TODO
 * @date: 2022/5/22 12:59
 * @version: 1.0
 */
public class BoradingPassPrint {
    private String surname;
    private String firstname;
    private Date departureTime;
    private Date fallTime;
    private String flightName;
    private Integer arrivalTerminal;
    private String arrivalAirport;
    private Integer departureGate;

    public String getSurname() {
        return surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public Date getFallTime() {
        return fallTime;
    }

    public String getFlightName() {
        return flightName;
    }

    public Integer getArrivalTerminal() {
        return arrivalTerminal;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public Integer getDepartureGate() {
        return departureGate;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public void setFallTime(Date fallTime) {
        this.fallTime = fallTime;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public void setArrivalTerminal(Integer arrivalTerminal) {
        this.arrivalTerminal = arrivalTerminal;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public void setDepartureGate(Integer departureGate) {
        this.departureGate = departureGate;
    }


}

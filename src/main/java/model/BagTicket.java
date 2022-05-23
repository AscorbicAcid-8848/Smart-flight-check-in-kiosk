package model;

import java.util.Date;

/**
 * @author YichenLiu
 * @description:
 * @date 2022/5/23 19:49
 */
public class BagTicket {
    private String surname;
    private String firstname;
    private Date departureTime;
    private Date fallTime;
    private String flightName;
    private String dropCounter;

    public BagTicket(String surname, String firstname, Date departureTime, Date fallTime, String flightName, String dropCounter) {
        this.surname = surname;
        this.firstname = firstname;
        this.departureTime = departureTime;
        this.fallTime = fallTime;
        this.flightName = flightName;
        this.dropCounter = dropCounter;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getFallTime() {
        return fallTime;
    }

    public void setFallTime(Date fallTime) {
        this.fallTime = fallTime;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getDropCounter() {
        return dropCounter;
    }

    public void setDropCounter(String dropCounter) {
        this.dropCounter = dropCounter;
    }
}

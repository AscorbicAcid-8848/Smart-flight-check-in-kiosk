package model;

import java.util.List;

/**
 * @author YichenLiu
 * @description: User model
 * @date 2022/3/16 16:27
 */
public class Passenger {
    private List<Integer> bookingNumber;//与航班挂钩 五位数
    private List<Integer> flightId;//三位数
    private Integer passengerId;//一位数
    private String surname;
    private String firstname;
    private Integer gender;
    private String seatLevel;
    private Integer seatNumber;
    private Integer meal;
    private Integer IdDocument;
    private Integer creditcardNum;
    private String cardPin;



    @Override
    public String toString() {
        return "Passenger{" +
                "bookingNumber=" + bookingNumber +
                ", flightId=" + flightId +
                ", passengerId=" + passengerId +
                ", surname='" + surname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", gender=" + gender +
                ", seatLevel='" + seatLevel + '\'' +
                ", seatNumber=" + seatNumber +
                ", meal=" + meal +
                ", IdDocument=" + IdDocument +
                ", creditcardNum=" + creditcardNum +
                ", cardPin=" + cardPin +
                '}';
    }

    //setter and getter


    public Integer getCreditcardNum() {
        return creditcardNum;
    }

    public void setCreditcardNum(Integer creditcardNum) {
        this.creditcardNum = creditcardNum;
    }

    public String getCardPin() {
        return cardPin;
    }

    public void setCardPin(String cardPin) {
        this.cardPin = cardPin;
    }

    public List<Integer> getFlightId() {
        return flightId;
    }

    public void setFlightId(List<Integer> flightId) {
        this.flightId = flightId;
    }

    public Integer getIdDocument() {
        return IdDocument;
    }

    public void setIdDocument(Integer idDocument) {
        IdDocument = idDocument;
    }

    public List<Integer> getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(List<Integer> bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public Integer getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Integer passengerId) {
        this.passengerId = passengerId;
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getSeatLevel() {
        return seatLevel;
    }

    public void setSeatLevel(String seatLevel) {
        this.seatLevel = seatLevel;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Integer getMeal() {
        return meal;
    }

    public void setMeal(Integer meal) {
        this.meal = meal;
    }
}

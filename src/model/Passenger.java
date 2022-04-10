package model;

/**
 * @author YichenLiu
 * @description: User model
 * @date 2022/3/16 16:27
 */
public class Passenger {
    private Integer bookingNumber;//与航班挂钩
    private Integer flightId;
    private Integer passengerId;
    private String surname;
    private String firstname;
    private Integer gender;
    private String seatLevel;
    private Integer seatNumber;
    private Integer meal;
    private Integer IdDocument;

    @Override
    public String toString() {
        return "Passenger{" +
                "bookingNumber=" + bookingNumber +
                ", flightId=" + flightId +
                ", passengerId=" + passengerId +
                ", surname='" + surname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", gender='" + gender + '\'' +
                ", seatLevel='" + seatLevel + '\'' +
                ", seatNumber=" + seatNumber +
                ", meal=" + meal +
                ", IdDocument=" + IdDocument +
                '}';
    }

    //setter and getter


    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Integer getIdDocument() {
        return IdDocument;
    }

    public void setIdDocument(Integer idDocument) {
        IdDocument = idDocument;
    }

    public Integer getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(Integer bookingNumber) {
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

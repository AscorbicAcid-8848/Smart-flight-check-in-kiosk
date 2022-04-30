package model;

/**
 * @author YichenLiu
 * @description: TODO
 * @date 2022/4/30 15:13
 */
public class Seat {
    private Integer seatNumber;
    private Boolean occupied;
    private String seatLevel;

    public Seat(Integer seatNumber, Boolean occupied, String seatClass) {
        this.seatNumber = seatNumber;
        this.occupied = occupied;
        this.seatLevel = seatClass;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }

    public String getSeatLevel() {
        return seatLevel;
    }

    public void setSeatLevel(String seatLevel) {
        this.seatLevel = seatLevel;
    }
}

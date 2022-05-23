package model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

/**
 * @author YichenLiu
 * @description:
 * @date 2022/5/23 10:29
 */
public class PassengerTable {
    private Integer flightId;
    private ArrayList<PassengerCheckInStatue> passengerCheckInStatueList = new ArrayList<>();

    public PassengerTable() {}

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public ArrayList<PassengerCheckInStatue> getPassengerCheckInStatueList() {
        return passengerCheckInStatueList;
    }

    public void setPassengerCheckInStatueList(ArrayList<PassengerCheckInStatue> passengerCheckInStatueList) {
        this.passengerCheckInStatueList = passengerCheckInStatueList;
    }



    public Boolean IsChecked(int index) {
        return this.passengerCheckInStatueList.get(index).isChecked();
    }


    public void setChecked(Integer idDocument, Boolean checkStatus) {
        for(int i = 0; i< this.passengerCheckInStatueList.size(); i++){
            if(this.passengerCheckInStatueList.get(i).getIdDocument().equals(idDocument)){
                this.passengerCheckInStatueList.get(i).setChecked(checkStatus);
            }
        }
    }

    @Override
    public String toString() {
        return "PassengerTable{" +
                "flightId=" + flightId +
                ", passengerCheckInStatueList=" + passengerCheckInStatueList +
                '}';
    }
}

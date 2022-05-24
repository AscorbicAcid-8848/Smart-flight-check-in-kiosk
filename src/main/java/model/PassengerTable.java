package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

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



    public Boolean IsChecked(Integer idDocument) {
        int result = -1;

        for (int i=0; i<this.passengerCheckInStatueList.size(); i++){
            if(this.passengerCheckInStatueList.get(i).getIdDocument().equals(idDocument)){
                result = i;
            }
        }

        if (result == -1){
            System.out.println("the passenger not found");
            return false;
        }else {
            return this.passengerCheckInStatueList.get(result).isChecked();
        }

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

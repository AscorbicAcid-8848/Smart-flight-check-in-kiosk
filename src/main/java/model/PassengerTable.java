package model;

import java.util.ArrayList;

/**
 * @author YichenLiu
 * @description:
 * @date 2022/5/23 10:29
 */
public class PassengerTable {
    private Integer flightId;
    private ArrayList<PassengerCheckInStatue> passengerCheckInStatueList;

    public PassengerTable() {
        this.flightId = null;
        this.passengerCheckInStatueList = new ArrayList<>();
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Integer getIdDocument(int index) {

        return this.passengerCheckInStatueList.get(index).getIdDocument();
    }

    public void addIdDocument(Integer idDocument, Boolean checkStatus) {
        PassengerCheckInStatue passengerCheckInStatue = new PassengerCheckInStatue();
        passengerCheckInStatue.setIdDocument(idDocument);
        passengerCheckInStatue.setChecked(checkStatus);
        this.passengerCheckInStatueList.add(passengerCheckInStatue);
    }

    public Boolean IsChecked(int index) {
        return this.passengerCheckInStatueList.get(index).isChecked();
    }

    public void setChecked(Integer idDocument, Boolean checkStatus) {
        for(int i = 0; i< this.passengerCheckInStatueList.size(); i++){
            if(this.passengerCheckInStatueList.get(i).getIdDocument() == idDocument){
                this.passengerCheckInStatueList.get(i).setChecked(checkStatus);
            }
        }
    }
}

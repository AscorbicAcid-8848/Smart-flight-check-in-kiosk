package model;

/**
 * @author YichenLiu
 * @description:
 * @date 2022/5/23 10:29
 */
public class PassengerTable {
    private Integer flightId;
    private Integer idDocument;
    private Boolean isChecked;

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    public Integer getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(Integer idDocument) {
        this.idDocument = idDocument;
    }

    public Boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Boolean isChecked) {
        this.isChecked = isChecked;
    }
}

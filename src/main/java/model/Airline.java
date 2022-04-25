package model;

/**
 * @author YichenLiu ZihaoYe
 * @description: 航空公司
 * @date 2022/3/16 16:34
 */
public class Airline {
    private Integer airlineId;
    private String airlineName;

    @Override
    public String toString(){
        return "ID:" + airlineId.toString() +", Name:" + this.airlineName;
    }

    public Integer getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(Integer airlineId) {
        this.airlineId = airlineId;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }
}

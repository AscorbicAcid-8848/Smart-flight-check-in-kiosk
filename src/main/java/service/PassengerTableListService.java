package service;

import model.PassengerTable;

/**
 * @author YichenLiu
 * @description:
 * @date 2022/5/23 10:52
 */
public interface PassengerTableListService {

    /**
     * get the passenger checkIn status by input corresponding flight id
     * @param flightId: flight id
     * @return: passenger table
     */
    public PassengerTable checkPassengerCheckInStatus(Integer flightId);

    /**
     * method set passenger check status with its flight id, idDocument and update statues isChecked
     * @param flightId :flightId
     * @param idDocument :idDocument
     * @param isChecked :isChecked
     */
    public void setChecked(Integer flightId, Integer idDocument, Boolean isChecked);
}

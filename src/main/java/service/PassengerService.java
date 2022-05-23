package service;

import model.Passenger;

/**
 * @author YichenLiu
 * @description: passenger services interface（对应用户表）
 * @date 2022/3/16 16:26
 */
public interface PassengerService {

    /**
     * get a corresponding passenger by inputting its booking number
     * @param bookingNumber
     * @return Passenger
     */
    Passenger searchByBookingNumber(Integer bookingNumber);

    /**
     * get a corresponding passenger by inputting its Surname and passenger id
     * @param surname
     * @param passengerId
     * @return Passenger
     */
    Passenger searchBySurnameAndPassengerId(String surname, Integer passengerId);

    /**
     * get a corresponding passenger by inputting its idDocument
     * @param idDocument
     * @return Passenger
     */
    Passenger searchByIdDocument(Integer idDocument);

    /**
     * update a passenger by inputting its changed version
     * @param passenger
     * @return Passenger
     */
    Passenger update(Passenger passenger);//前排座位被选的情况
}

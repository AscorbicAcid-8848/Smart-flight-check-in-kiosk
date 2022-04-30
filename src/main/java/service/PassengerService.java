package service;

import model.Passenger;

/**
 * @author YichenLiu
 * @description: passenger services interface（对应用户表）
 * @date 2022/3/16 16:26
 */
public interface PassengerService {
    //通过订票号查询乘客信息
    Passenger searchByBookingNumber(Integer bookingNumber);
    //通过乘客姓氏以及id查询
    Passenger searchBySurnameAndPassengerId(String surname, Integer passengerId);
    //通过乘客id document查询
    Passenger searchByIdDocument(Integer idDocument);
    //2.2中的自定义操作
    Passenger update(Passenger passenger);//前排座位被选的情况
}

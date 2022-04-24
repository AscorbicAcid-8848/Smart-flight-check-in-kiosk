package service.imp;

import model.Passenger;
import service.PassengerService;

/**
 * @author YichenLiu
 * @description: User Service entity
 * @date 2022/3/16 16:26
 */
public class PassengerServiceImp implements PassengerService {
    @Override
    public Passenger searchByBookingNumber(Integer bookingNumber) {
        Passenger passenger = new Passenger();
        //根据IdDocument查找文件中的json数据，并返回给passenger
        return passenger;
    }

    @Override
    public Passenger searchBySurnameAndPassengerId(String surname, Integer passengerId) {
        Passenger passenger = new Passenger();
        //根据IdDocument查找文件中的json数据，并返回给passenger
        return passenger;
    }

    @Override
    public Passenger searchByIdDocument(Integer idDocument) {
        Passenger passenger = new Passenger();
        //根据IdDocument查找文件中的json数据，并返回给passenger
        return passenger;
    }

    @Override
    public Passenger update(Passenger passenger, String seatLevel, Integer meal, Integer seatNumber) {
        passenger.setSeatLevel(seatLevel);
        passenger.setSeatNumber(seatNumber);
        passenger.setMeal(meal);
        //在这里对txt里Json进行操作
        //根据passenger的bookingNumber查找文件内的数据，并且将新的数据替换文件中的数据
        return passenger;
    }
}

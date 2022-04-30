package service;

import model.Seat;

import java.util.List;

/**
 * @author YichenLiu
 * @description: TODO
 * @date 2022/4/30 17:32
 */
public interface FlightSeatService {
    //更改指定座位的状态
    public void update (Integer idDocument, Integer flightId,Integer seatNumber,String seatLevel);
    //展示所在flight的全部座位
    public List<Seat> searchByFlightId(Integer flightId);
}


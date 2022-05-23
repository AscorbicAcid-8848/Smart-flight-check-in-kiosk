package service;

import model.Airline;

/**
 * @author YichenLiu
 * @description: 航空公司设置
 * @date 2022/3/27 21:00
 */
public interface AirlineService {

    /**
     * update an airline
     * @param airline
     * @return
     */
    Airline update(Airline airline);

    Airline search(Integer airlineId);
}

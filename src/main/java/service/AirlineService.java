package service;

import model.Airline;

/**
 * @author YichenLiu
 * @description: 航空公司设置
 * @date 2022/3/27 21:00
 */
public interface AirlineService {
    //更改该值机对应的航空公司(后期可以做改logo和颜色)
    Airline update(String airlineName);
}

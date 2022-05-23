package service;

import model.BoardingPassPrint;
import model.Flight;
import model.Passenger;

/**
 * @author YichenLiu
 * @description:
 * @date 2022/5/23 10:08
 */
public interface BoardingPassService {

    void printBoardingPass(BoardingPassPrint boardingPassPrint);

    void printCarryOnBaggageTag(Passenger passenger, Flight flight);

    void printCheckinBaggageTicket(Passenger passenger, Flight flight);
}

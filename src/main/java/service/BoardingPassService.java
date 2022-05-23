package service;

import model.*;

/**
 * @author YichenLiu
 * @description:
 * @date 2022/5/23 10:08
 */
public interface BoardingPassService {

    void printBoardingPass(BoardingPassPrint boardingPassPrint);

    void printCarryOnBaggageTag(BagTag bagtag);

    void printCheckinBaggageTicket(BagTicket bagTicket);
}

package service.imp;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.*;
import service.BoardingPassService;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author YichenLiu
 * @description:
 * @date 2022/5/23 10:09
 */
public class BoardingPassServiceImp implements BoardingPassService {
    @Override
    public void printBoardingPass(BoardingPassPrint boardingPassPrint){
        ObjectMapper mapper = new ObjectMapper();
        try {
            FileWriter file = new FileWriter("BoardingPass_Tag_Ticket\\boardingPass.json",false);
            file.write("");
            mapper.writeValue(file, boardingPassPrint);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void printCarryOnBaggageTag(BagTag bagtag) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            FileWriter file = new FileWriter("BoardingPass_Tag_Ticket\\bagTag.json",false);
            file.write("");
            mapper.writeValue(file, bagtag);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void printCheckinBaggageTicket(BagTicket bagTicket) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            FileWriter file = new FileWriter("BoardingPass_Tag_Ticket\\bagTicket.json",false);
            file.write("");
            mapper.writeValue(file, bagTicket);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

package service.imp;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.FlightSeat;
import model.IdDocumentCard;
import service.IdDocumentCardService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author YichenLiu
 * @description:
 * @date 2022/5/17 16:18
 */
public class IdDocumentCardServiceImp implements IdDocumentCardService {

    public IdDocumentCardServiceImp() {}

    /**
     * read the json file and return an idDocumentCard object it corresponding to
     * @return idDocumentCard
     */
    @Override
    public IdDocumentCard checkCard() {
        ObjectMapper objectMapper = new ObjectMapper();
        IdDocumentCard idDocumentCard = new IdDocumentCard();
        File idDocumentFile = new File("idDocumentCard\\idDocumentCard.json");

        try {
            idDocumentCard = objectMapper.readValue(idDocumentFile, IdDocumentCard.class);
        }catch (IOException e){
            e.printStackTrace();
        }
        return idDocumentCard;
    }
}

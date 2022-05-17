package mock;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.IdDocumentCard;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Zihao Ye
 * @version 1.0
 */
public class IdDocumentCardMock {
    IdDocumentCard idDocumentCard = new IdDocumentCard();

    public IdDocumentCardMock() {
    }

    public void toJSON(Integer IdDocumentid, String name) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        FileWriter file = new FileWriter("Passenger_IdCard\\"+ name + "\\idDocumentCard.json");

        IdDocumentCard idDocumentCard = new IdDocumentCard();
        idDocumentCard.setId(IdDocumentid);

        try {
            file.write("");
        }catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mapper.writeValue(file, idDocumentCard);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }


    }

}

package mock;

import junit.framework.TestCase;

import java.io.IOException;

/**
 * @author Zihao Ye
 * @version 1.0
 */
public class IdDocumentCardMockTest extends TestCase {

    public void testToJSON() {
        IdDocumentCardMock idDocumentCardMock = new IdDocumentCardMock();

        try {
            idDocumentCardMock.toJSON(1111,"Zihao Ye");
            idDocumentCardMock.toJSON(2222,"Yichen Liu");
            idDocumentCardMock.toJSON(3333,"Ran Xu");
            idDocumentCardMock.toJSON(4444,"Zhihan Zhang");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
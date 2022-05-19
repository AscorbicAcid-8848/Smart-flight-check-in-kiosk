package service.imp;

import junit.framework.TestCase;
import model.IdDocumentCard;

/**
 * @author Zihao Ye
 * @version 1.0
 */
public class IdDocumentCardServiceImpTest extends TestCase {

    public void testCheckCard() {
        IdDocumentCardServiceImp idDocumentCardServiceImp = new IdDocumentCardServiceImp();

        IdDocumentCard idDocumentCard = idDocumentCardServiceImp.checkCard();

        System.out.println();
    }
}
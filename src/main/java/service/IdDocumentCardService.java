package service;

import model.IdDocumentCard;

/**
 * @author YichenLiu
 * @description: id document card searching
 * @date 2022/5/17 16:17
 */
public interface IdDocumentCardService {

    /**
     * read the json file and return an idDocumentCard object it corresponding to
     * @return idDocumentCard
     */
    IdDocumentCard checkCard();
}

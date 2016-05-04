package pl.trainingCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.trainingCompany.model.dbo.Attachment;
import pl.trainingCompany.model.dbo.Offer;
import pl.trainingCompany.model.dto.DtoAttachment;
import pl.trainingCompany.repo.AttachmentRepo;
import pl.trainingCompany.repo.OfferRepo;
import pl.trainingCompany.service.mappers.AttachmentMapper;

/**
 * Created by Kamil S on 2016-03-20.
 */
@Service
public class AttachmentService extends AbstractService<Attachment,DtoAttachment,AttachmentRepo, AttachmentMapper> {

    @Autowired
    OfferRepo offerRepo;

    public void save(String name, String attachmentType, Long offerId){
        DtoAttachment dtoAttachment = new DtoAttachment();
        dtoAttachment.setName(name);
        dtoAttachment.setAttachmentType(attachmentType);
        dtoAttachment.setOfferId(offerId);
        repo.save(mapper.convertToDBO(dtoAttachment));
    }

    public Iterable<DtoAttachment> getAttachementByOfferId(Long offerId) {
        Offer offer = offerRepo.findOne(offerId);
        if(offer==null)
            return null;

        return mapper.convertToDTO(repo.findByOffer(offer));

    }
}

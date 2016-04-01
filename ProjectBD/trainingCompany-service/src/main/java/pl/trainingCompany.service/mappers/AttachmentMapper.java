package pl.trainingCompany.service.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.trainingCompany.model.AttachmentType;
import pl.trainingCompany.model.dbo.Attachment;
import pl.trainingCompany.model.dbo.Offer;
import pl.trainingCompany.model.dto.DtoAttachment;
import pl.trainingCompany.repo.OfferRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kamil S on 2016-03-20.
 */
@Component
public class AttachmentMapper implements MapperInterface<Attachment, DtoAttachment> {

    @Autowired
    OfferRepo offerRepo;

    @Override
    public Attachment convertToDBO(DtoAttachment dtoAttachment) {
        Attachment attachment = new Attachment();
        attachment.setId(dtoAttachment.getId());
        attachment.setName(dtoAttachment.getName());
        attachment.setAttachmentType(AttachmentType.valueOf(dtoAttachment.getAttachmentType()));
        if (dtoAttachment.getOfferId() != null) {
            Offer offer = offerRepo.findOne(dtoAttachment.getOfferId());
            if (offer != null) {
                attachment.setOffer(offer);
            } else {
                //To Do
            }
        }

        return attachment;
    }

    @Override
    public DtoAttachment convertToDTO(Attachment attachment) {
        DtoAttachment dtoAttachment = new DtoAttachment();
        dtoAttachment.setId(attachment.getId());
        dtoAttachment.setName(attachment.getName());
        dtoAttachment.setAttachmentType(attachment.getAttachmentType().toString());
        if (attachment.getOffer() != null)
            dtoAttachment.setOfferId(attachment.getOffer().getId());
        else if(attachment.getPostInTopic() !=null)
            dtoAttachment.setPostInTopicId(attachment.getPostInTopic().getId());
        return dtoAttachment;
    }

    @Override
    public Iterable<Attachment> convertToDBO(Iterable<DtoAttachment> dto) {
        List<Attachment> attachments = new ArrayList<Attachment>();
        for (DtoAttachment dtoAttachment : dto) {
            attachments.add(convertToDBO(dtoAttachment));
        }
        return attachments;
    }

    @Override
    public Iterable<DtoAttachment> convertToDTO(Iterable<Attachment> dbo) {
        List<DtoAttachment> dtoAttachments = new ArrayList<DtoAttachment>();
        for (Attachment attachment : dbo) {
            dtoAttachments.add(convertToDTO(attachment));
        }
        return dtoAttachments;
    }
}

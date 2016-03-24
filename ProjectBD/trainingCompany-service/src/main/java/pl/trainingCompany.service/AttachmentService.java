package pl.trainingCompany.service;

import org.springframework.stereotype.Service;
import pl.trainingCompany.model.dbo.Attachment;
import pl.trainingCompany.model.dto.DtoAttachment;
import pl.trainingCompany.repo.AttachmentRepo;
import pl.trainingCompany.service.mappers.AttachmentMapper;

/**
 * Created by Kamil S on 2016-03-20.
 */
@Service
public class AttachmentService extends AbstractService<Attachment,DtoAttachment,AttachmentRepo, AttachmentMapper> {
    public void save(String name, String attachmentType, Long offerId){
        DtoAttachment dtoAttachment = new DtoAttachment();
        dtoAttachment.setName(name);
        dtoAttachment.setAttachmentType(attachmentType);
        dtoAttachment.setOfferId(offerId);
        repo.save(mapper.convertToDBO(dtoAttachment));
    }
}

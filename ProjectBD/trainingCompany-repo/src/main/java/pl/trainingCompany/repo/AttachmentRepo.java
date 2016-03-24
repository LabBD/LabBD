package pl.trainingCompany.repo;

import org.springframework.data.repository.CrudRepository;
import pl.trainingCompany.model.dbo.Attachment;

/**
 * Created by Kamil S on 2016-03-20.
 */
public interface AttachmentRepo extends CrudRepository<Attachment,Long> {
}

package pl.trainingCompany.repo;

import org.springframework.data.repository.CrudRepository;
import pl.trainingCompany.model.dbo.Section;

/**
 * Created by Pawel on 24-Mar-16.
 */
public interface SectionRepo extends CrudRepository<Section,Long > {
    public Section findByName(String name);
}

package pl.trainingCompany.repo;

import org.springframework.data.repository.CrudRepository;
import pl.trainingCompany.model.dbo.Photo;

/**
 * Created by Kamil S on 2016-03-20.
 */
public interface PhotoRepo extends CrudRepository<Photo,Long> {
}

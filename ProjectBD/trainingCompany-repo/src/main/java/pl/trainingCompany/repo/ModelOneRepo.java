package pl.trainingCompany.repo;

import org.springframework.data.repository.CrudRepository;
import pl.trainingCompany.model.dbo.ModelOne;

/**
 * Created by Kamil S on 2016-03-17.
 */
public interface ModelOneRepo extends CrudRepository<ModelOne,Long> {
}

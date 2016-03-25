package pl.trainingCompany.repo;

import org.springframework.data.repository.CrudRepository;
import pl.trainingCompany.model.dbo.Topic;

/**
 * Created by Pawel on 24-Mar-16.
 */
public interface TopicRepo extends CrudRepository<Topic, Long> {
    public Topic findByName(String name);
}

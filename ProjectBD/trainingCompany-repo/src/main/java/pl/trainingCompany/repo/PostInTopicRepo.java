package pl.trainingCompany.repo;

import org.springframework.data.repository.CrudRepository;
import pl.trainingCompany.model.dbo.PostInTopic;

/**
 * Created by PM on 28.03.2016.
 */
public interface PostInTopicRepo extends CrudRepository<PostInTopic, Long> {
}

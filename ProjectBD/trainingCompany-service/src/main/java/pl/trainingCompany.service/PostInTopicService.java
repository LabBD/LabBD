package pl.trainingCompany.service;

import org.springframework.stereotype.Service;
import pl.trainingCompany.model.dbo.PostInTopic;
import pl.trainingCompany.model.dto.DtoPostInTopic;
import pl.trainingCompany.repo.PostInTopicRepo;
import pl.trainingCompany.service.mappers.PostInTopicMapper;

/**
 * Created by PM on 28.03.2016.
 */
@Service
public class PostInTopicService extends AbstractService<PostInTopic, DtoPostInTopic,PostInTopicRepo,PostInTopicMapper>  {
}

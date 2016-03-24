package pl.trainingCompany.service;

import org.springframework.stereotype.Service;
import pl.trainingCompany.model.dbo.Topic;
import pl.trainingCompany.model.dto.DtoTopic;
import pl.trainingCompany.repo.TopicRepo;
import pl.trainingCompany.service.mappers.TopicMapper;

/**
 * Created by Pawel on 24-Mar-16.
 */
@Service
public class TopicService extends AbstractService<Topic, DtoTopic, TopicRepo, TopicMapper> {

}

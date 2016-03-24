package pl.trainingCompany.service.mappers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.trainingCompany.model.dbo.Topic;
import pl.trainingCompany.model.dto.DtoTopic;
import pl.trainingCompany.repo.SectionRepo;
import pl.trainingCompany.repo.UserRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pawel on 24-Mar-16.
 */
@Component

public class TopicMapper implements MapperInterface<Topic, DtoTopic> {

    @Autowired
    UserRepo userRepo;
    @Autowired
    SectionRepo sectionRepo;

    @Override
    public Topic convertToDBO(DtoTopic dtoTopic) {
        Topic topic = new Topic();
        topic.setId(dtoTopic.getId());
        topic.setName(dtoTopic.getName());
        topic.setAuthor(userRepo.findByusername(dtoTopic.getAuthorName()));
        topic.setSection(sectionRepo.findByName(dtoTopic.getSectionName()));
        return topic;
    }

    @Override
    public DtoTopic convertToDTO(Topic topic) {
        DtoTopic dtoTopic = new DtoTopic();
        dtoTopic.setId(topic.getId());
        dtoTopic.setName(topic.getName());
        dtoTopic.setAuthorName(topic.getAuthor().getUsername());
        dtoTopic.setSectionName(topic.getSection().getName());
        return dtoTopic;
    }

    @Override
    public Iterable<Topic> convertToDBO(Iterable<DtoTopic> dto) {
        List<Topic> topics = new ArrayList<Topic>();
        for (DtoTopic dtoTopic : dto) {
            topics.add(convertToDBO(dtoTopic));
        }
        return topics;
    }

    @Override
    public Iterable<DtoTopic> convertToDTO(Iterable<Topic> dbo) {
        List<DtoTopic> dtoTopics = new ArrayList<DtoTopic>();
        for (Topic topic : dbo) {
            dtoTopics.add(convertToDTO(topic));
        }
        return dtoTopics;
    }
}

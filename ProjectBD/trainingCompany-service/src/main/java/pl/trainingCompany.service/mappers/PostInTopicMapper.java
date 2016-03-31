package pl.trainingCompany.service.mappers;

import pl.trainingCompany.model.dbo.PostInTopic;
import pl.trainingCompany.model.dto.DtoPostInTopic;

import org.springframework.stereotype.Component;

/**
 * Created by PM on 28.03.2016.
 */

@Component
public class PostInTopicMapper implements MapperInterface<PostInTopic,DtoPostInTopic> {
    @Override
    public PostInTopic convertToDBO(DtoPostInTopic dtoPostInTopic) {
        return null;
    }

    @Override
    public DtoPostInTopic convertToDTO(PostInTopic postInTopic) {
        return null;
    }

    @Override
    public Iterable<PostInTopic> convertToDBO(Iterable<DtoPostInTopic> dto) {
        return null;
    }

    @Override
    public Iterable<DtoPostInTopic> convertToDTO(Iterable<PostInTopic> dbo) {
        return null;
    }
}

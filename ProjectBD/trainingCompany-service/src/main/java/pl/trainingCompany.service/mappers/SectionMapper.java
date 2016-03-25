package pl.trainingCompany.service.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.trainingCompany.model.dbo.Section;
import pl.trainingCompany.model.dbo.Topic;
import pl.trainingCompany.model.dto.DtoSection;
import pl.trainingCompany.repo.TopicRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pawel on 24-Mar-16.
 */
@Component
public class SectionMapper implements MapperInterface<Section, DtoSection> {

    @Autowired
    TopicRepo topicRepo;

    @Override
    public Section convertToDBO(DtoSection dtoSection) {
        Section section = new Section();
        section.setId(dtoSection.getId());
        section.setName(dtoSection.getName());
        section.setDescription(dtoSection.getDescription());
        List<Topic> topicList = new ArrayList<>();
        dtoSection.getTopicNamesList().forEach(t -> topicList.add(topicRepo.findByName(t)));
        section.setTopicList(topicList);
        return section;
    }

    @Override
    public DtoSection convertToDTO(Section section) {
        DtoSection dtoSection = new DtoSection();
        dtoSection.setId(section.getId());
        dtoSection.setName(section.getName());
        dtoSection.setDescription(section.getDescription());
        List<String> topicNames = new ArrayList<>();
        section.getTopicList().forEach(t -> topicNames.add(t.getName()));
        dtoSection.setTopicNamesList(topicNames);
        return dtoSection;
    }

    @Override
    public Iterable<Section> convertToDBO(Iterable<DtoSection> dto) {
        List<Section> sections = new ArrayList<Section>();
        for (DtoSection dtoSection : dto) {
            sections.add(convertToDBO(dtoSection));
        }
        return sections;
    }

    @Override
    public Iterable<DtoSection> convertToDTO(Iterable<Section> dbo) {
        List<DtoSection> dtoSections = new ArrayList<DtoSection>();
        for (Section section : dbo) {
            dtoSections.add(convertToDTO(section));
        }
        return dtoSections;
    }
}

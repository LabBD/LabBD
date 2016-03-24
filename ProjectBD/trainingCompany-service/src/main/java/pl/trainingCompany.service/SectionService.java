package pl.trainingCompany.service;

import org.springframework.stereotype.Service;
import pl.trainingCompany.model.dbo.Section;
import pl.trainingCompany.model.dto.DtoSection;
import pl.trainingCompany.repo.SectionRepo;
import pl.trainingCompany.service.mappers.SectionMapper;

/**
 * Created by Pawel on 24-Mar-16.
 */
@Service
public class SectionService extends AbstractService<Section, DtoSection, SectionRepo, SectionMapper>{

}

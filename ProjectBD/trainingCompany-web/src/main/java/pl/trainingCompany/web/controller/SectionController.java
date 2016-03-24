package pl.trainingCompany.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.trainingCompany.model.dbo.Section;
import pl.trainingCompany.model.dto.DtoSection;
import pl.trainingCompany.service.SectionService;

/**
 * Created by Pawel on 24-Mar-16.
 */
@RestController
@RequestMapping("/section")
public class SectionController extends AbstractController<Section, DtoSection, SectionService> {

}

package pl.trainingCompany.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.trainingCompany.model.dbo.Topic;
import pl.trainingCompany.model.dto.DtoTopic;
import pl.trainingCompany.service.TopicService;

/**
 * Created by Pawel on 24-Mar-16.
 */
@RestController
@RequestMapping("/topic")
public class TopicController extends AbstractController<Topic, DtoTopic, TopicService> {

}

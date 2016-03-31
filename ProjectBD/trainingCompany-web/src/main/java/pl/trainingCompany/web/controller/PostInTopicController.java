package pl.trainingCompany.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.trainingCompany.model.dbo.PostInTopic;
import pl.trainingCompany.model.dto.DtoPostInTopic;
import pl.trainingCompany.service.PostInTopicService;

/**
 * Created by PM on 28.03.2016.
 */
@RestController
@RequestMapping("/postInTopic")
public class PostInTopicController extends AbstractController<PostInTopic, DtoPostInTopic, PostInTopicService>{
}

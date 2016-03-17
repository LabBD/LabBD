package pl.trainingCompany.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.trainingCompany.model.dbo.Greeting;
import pl.trainingCompany.service.GreetingService;

/**
 * Created by Kamil S on 2016-03-17.
 */
@RestController
@RequestMapping("/gret")
public class GreetingController extends AbstractController<Greeting,Greeting,GreetingService> {
}

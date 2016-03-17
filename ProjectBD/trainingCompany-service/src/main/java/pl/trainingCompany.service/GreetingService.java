package pl.trainingCompany.service;

import pl.trainingCompany.service.mappers.AbstractMapper;
import org.springframework.stereotype.Service;
import pl.trainingCompany.model.dbo.Greeting;
import pl.trainingCompany.repo.GreetingRepo;
import pl.trainingCompany.service.mappers.GreetingMapper;

/**
 * Created by Kamil S on 2016-03-17.
 */
@Service
public class GreetingService extends AbstractService<Greeting,Greeting,GreetingRepo, GreetingMapper> {
}

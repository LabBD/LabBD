package pl.trainingCompany.service.mappers;

import org.springframework.stereotype.Component;
import pl.trainingCompany.model.dbo.Greeting;

/**
 * Created by Kamil S on 2016-03-17.
 */
@Component
public class GreetingMapper implements MapperInterface<Greeting,Greeting> {

    @Override
    public Greeting convertToDBO(Greeting greeting) {
        return greeting;
    }

    @Override
    public Greeting convertToDTO(Greeting greeting) {
        return greeting;
    }

    @Override
    public Iterable<Greeting> convertToDBO(Iterable<Greeting> dto) {
        return dto;
    }

    @Override
    public Iterable<Greeting> convertToDTO(Iterable<Greeting> dbo) {
        return dbo;
    }
}

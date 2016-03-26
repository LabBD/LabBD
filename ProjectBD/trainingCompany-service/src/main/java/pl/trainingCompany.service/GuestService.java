package pl.trainingCompany.service;

import org.springframework.stereotype.Service;
import pl.trainingCompany.model.dbo.Guest;
import pl.trainingCompany.model.dto.DtoGuest;
import pl.trainingCompany.repo.GuestRepo;
import pl.trainingCompany.service.mappers.GuestMapper;

/**
 * Created by Sebastian on 2016-03-25.
 */
@Service
public class GuestService extends AbstractService<Guest,DtoGuest,GuestRepo, GuestMapper> {
}

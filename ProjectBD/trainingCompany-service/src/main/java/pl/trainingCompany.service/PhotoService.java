package pl.trainingCompany.service;

import org.springframework.stereotype.Service;
import pl.trainingCompany.model.dbo.Photo;
import pl.trainingCompany.model.dto.DtoPhoto;
import pl.trainingCompany.repo.PhotoRepo;
import pl.trainingCompany.service.mappers.PhotoMapper;

/**
 * Created by Kamil S on 2016-03-20.
 */
@Service
public class PhotoService extends AbstractService<Photo,DtoPhoto,PhotoRepo,PhotoMapper> {
}

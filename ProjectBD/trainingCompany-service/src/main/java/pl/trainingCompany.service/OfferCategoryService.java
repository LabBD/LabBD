package pl.trainingCompany.service;

import org.springframework.stereotype.Service;
import pl.trainingCompany.model.dbo.OfferCategory;
import pl.trainingCompany.model.dto.DtoOfferCategory;
import pl.trainingCompany.repo.OfferCategoryRepo;
import pl.trainingCompany.service.mappers.OfferCategoryMapper;

/**
 * Created by Mateusz on 2016-03-26.
 */
@Service
public class OfferCategoryService extends AbstractService<OfferCategory, DtoOfferCategory, OfferCategoryRepo, OfferCategoryMapper>{

}

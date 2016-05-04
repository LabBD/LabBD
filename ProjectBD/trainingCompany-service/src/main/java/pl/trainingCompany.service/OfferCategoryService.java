package pl.trainingCompany.service;

import org.springframework.stereotype.Service;
import pl.trainingCompany.model.dbo.OfferCategory;
import pl.trainingCompany.model.dto.DtoOfferCategory;
import pl.trainingCompany.repo.OfferCategoryRepo;
import pl.trainingCompany.service.mappers.OfferCategoryMapper;

/**
 * Created by Se obastiann 2016-03-26.
 */
@Service
public class OfferCategoryService extends AbstractService<OfferCategory,DtoOfferCategory,OfferCategoryRepo,OfferCategoryMapper> {

    public void save(String name, String description) {
        OfferCategory offerCategory= new OfferCategory();
        offerCategory.setName(name);
        offerCategory.setDescription(description);
        repo.save(offerCategory);
    }
}

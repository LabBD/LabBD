package pl.trainingCompany.service.mappers;

import org.springframework.stereotype.Component;
import pl.trainingCompany.model.dbo.OfferCategory;
import pl.trainingCompany.model.dto.DtoOfferCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateusz on 2016-03-26.
 */
@Component
public class OfferCategoryMapper implements MapperInterface<OfferCategory, DtoOfferCategory> {

    @Override
    public OfferCategory convertToDBO(DtoOfferCategory dtoOfferCategory) {
        OfferCategory offerCategory = new OfferCategory();
        offerCategory.setId(dtoOfferCategory.getId());
        offerCategory.setName(dtoOfferCategory.getName());
        offerCategory.setDescription(dtoOfferCategory.getDescription());

        return offerCategory;
    }

    @Override
    public DtoOfferCategory convertToDTO(OfferCategory offerCategory) {
        DtoOfferCategory dtoOfferCategory = new DtoOfferCategory();
        dtoOfferCategory.setId(offerCategory.getId());
        dtoOfferCategory.setName(offerCategory.getName());
        dtoOfferCategory.setDescription(offerCategory.getDescription());

        return dtoOfferCategory;
    }

    @Override
    public Iterable<OfferCategory> convertToDBO(Iterable<DtoOfferCategory> dto) {
        List<OfferCategory> offerCategories = new ArrayList<OfferCategory>();
        for (DtoOfferCategory dtoOfferCategory : dto) {
            offerCategories.add(convertToDBO(dtoOfferCategory));
        }

        return offerCategories;
    }

    @Override
    public Iterable<DtoOfferCategory> convertToDTO(Iterable<OfferCategory> dbo) {
        List<DtoOfferCategory> dtoOfferCategories = new ArrayList<DtoOfferCategory>();
        for (OfferCategory offerCategory : dbo) {
            dtoOfferCategories.add(convertToDTO(offerCategory));
        }
        return dtoOfferCategories;
    }
}

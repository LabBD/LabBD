package pl.trainingCompany.service.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.trainingCompany.model.dbo.OfferCategory;
import pl.trainingCompany.model.dto.DtoOfferCategory;
import pl.trainingCompany.repo.OfferCategoryRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastian on 2016-03-26.
 */
@Component
public class OfferCategoryMapper implements  MapperInterface<OfferCategory,DtoOfferCategory> {

    @Autowired
    OfferCategoryRepo offerCategoryRepo;

    @Override
    public OfferCategory convertToDBO(DtoOfferCategory dtoOfferCategory) {

        OfferCategory offerCategory = new OfferCategory();
        offerCategory.setId(dtoOfferCategory.getId());
        offerCategory.setName(dtoOfferCategory.getName());
        offerCategory.setDescription(dtoOfferCategory.getDescription());
        if(dtoOfferCategory.getParentCategoryId() != null) {
            OfferCategory oc = offerCategoryRepo.findOne(dtoOfferCategory.getParentCategoryId());
            if(oc != null) {
                offerCategory.setOfferCategoryParent(oc);
            } else {
                //ToDo
            }
        }
        return offerCategory;
    }

    @Override
    public DtoOfferCategory convertToDTO(OfferCategory offerCategory) {
        DtoOfferCategory doc = new DtoOfferCategory();
        doc.setId(offerCategory.getId());
        doc.setName(offerCategory.getName());
        doc.setDescription(offerCategory.getDescription());
        if(offerCategory.getOfferCategoryParent() != null) {
            doc.setParentCategoryId(offerCategory.getOfferCategoryParent().getId());
        }
        return doc;
    }

    @Override
    public Iterable<OfferCategory> convertToDBO(Iterable<DtoOfferCategory> dto) {
        List<OfferCategory> ocs = new ArrayList<OfferCategory>();
        for(DtoOfferCategory doc : dto) {
            ocs.add(convertToDBO(doc));
        }
        return ocs;
    }

    @Override
    public Iterable<DtoOfferCategory> convertToDTO(Iterable<OfferCategory> dbo) {
        List<DtoOfferCategory> docs = new ArrayList<DtoOfferCategory>();
        for(OfferCategory oc: dbo) {
            docs.add(convertToDTO(oc));
        }
        return  docs;
    }
}

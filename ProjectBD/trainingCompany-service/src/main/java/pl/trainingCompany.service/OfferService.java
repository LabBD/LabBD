package pl.trainingCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.trainingCompany.model.dbo.Offer;
import pl.trainingCompany.model.dbo.OfferCategory;
import pl.trainingCompany.model.dto.DtoOffer;
import pl.trainingCompany.model.dto.DtoOfferCategory;
import pl.trainingCompany.repo.OfferCategoryRepo;
import pl.trainingCompany.repo.OfferRepo;
import pl.trainingCompany.service.mappers.OfferCategoryMapper;
import pl.trainingCompany.service.mappers.OfferMapper;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Kamil S on 2016-03-24.
 */
@Service
public class OfferService extends AbstractService<Offer, DtoOffer, OfferRepo, OfferMapper> {

    @Autowired
    OfferCategoryRepo offerCategoryRepo;

    @Autowired
    OfferCategoryMapper offerCategoryMapper;

    private final static int NUMBER_OFFER_ON_PAGE = 10;

    public void save(String name,String description,Double price,Long quantity, int offerCategoryId) {
        Offer offer = new Offer();
        offer.setName(name);
        offer.setDescription(description);
        offer.setPrice(price);
        offer.setQuantity(quantity);
        offer.setOfferCategory(offerCategoryRepo.findOne(new Long(offerCategoryId+1)));
        repo.save(offer);
    }

    public Iterable<DtoOffer> getOfferPage(String namedQuery, int pageNumber, List<DtoOfferCategory> selectedDtoOfferCategory) {
        if (pageNumber < 0)
            return null;
        PageRequest pageRequest = new PageRequest(pageNumber, NUMBER_OFFER_ON_PAGE);
        Specification<Offer> offerSpecification = new OfferRequestSpecification(selectedDtoOfferCategory, namedQuery);
        Iterable<Offer> offers = repo.findAll(offerSpecification, pageRequest);
        for(Offer offer:offers){
            if(offer.getDescription().length()>255)
            offer.setDescription(offer.getDescription().substring(0,255)+"...");
        }
        return mapper.convertToDTO(offers);
    }

    public Long getOfferPageCount(String namedQuery, List<DtoOfferCategory> selectedDtoOfferCategory) {
        Specification<Offer> offerSpecification = new OfferRequestSpecification(selectedDtoOfferCategory, namedQuery);
        Long offersNumber = repo.count(offerSpecification);
        Long pageNmber = offersNumber / NUMBER_OFFER_ON_PAGE;
        if (offersNumber % NUMBER_OFFER_ON_PAGE != 0)
            pageNmber++;
        return pageNmber;
    }

    public Offer findOfferDbo(Long id) {
        if (id == null)
            return null;
        return repo.findOne(id);
    }

    public class OfferRequestSpecification implements Specification<Offer> {

        private final List<DtoOfferCategory> selectedDtoOfferCategory;
        private final String namedQuery;

        public OfferRequestSpecification(List<DtoOfferCategory> selectedDtoOfferCategory, String namedQuery) {
            this.selectedDtoOfferCategory = selectedDtoOfferCategory;
            this.namedQuery = namedQuery;
        }

        @Override
        public Predicate toPredicate(Root<Offer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
            Predicate predicate = null;
            List<OfferCategory> selectedOfferCategory = (List<OfferCategory>) offerCategoryMapper.convertToDBO(selectedDtoOfferCategory);
            for (OfferCategory offerCategory : selectedOfferCategory) {
                if (predicate == null) {
                    predicate = cb.equal(root.get("offerCategory"), offerCategory);
                } else {
                    predicate = cb.or(predicate, cb.equal(root.get("offerCategory"), offerCategory));
                }

            }
            if (namedQuery != null) {
                if (predicate == null) {
                    predicate = cb.like(root.<String>get("name"), "%" + namedQuery + "%");

                } else {
                    predicate = cb.and(predicate, cb.like(root.<String>get("name"), "%" + namedQuery + "%"));
                }
            }
            return predicate;
        }
    }


}

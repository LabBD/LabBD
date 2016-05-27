package pl.trainingCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.trainingCompany.model.dbo.Company;
import pl.trainingCompany.model.dbo.Offer;
import pl.trainingCompany.model.dbo.OfferCategory;
import pl.trainingCompany.model.dto.DtoOffer;
import pl.trainingCompany.model.dto.DtoOfferCategory;
import pl.trainingCompany.repo.OfferRepo;
import pl.trainingCompany.service.mappers.OfferCategoryMapper;
import pl.trainingCompany.service.mappers.OfferMapper;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

/**
 * Created by Kamil S on 2016-03-24.
 */
@Service
public class OfferService extends AbstractService<Offer, DtoOffer, OfferRepo, OfferMapper> {

    @Autowired
    OfferCategoryMapper offerCategoryMapper;

    @Autowired
    CompanyService companyService;

    private final static int NUMBER_OFFER_ON_PAGE = 10;

    public long save(String name, String description, Double price, Long quantity, Date endDate, OfferCategory offerCategoryId) {
        Offer offer = new Offer();
        offer.setName(name);
        offer.setDescription(description);
        offer.setPrice(price);
        offer.setQuantity(quantity);
        offer.setEndDate(endDate);
        offer.setOfferCategory(offerCategoryId);
        repo.save(offer);
        return offer.getId();
    }

    public long save(DtoOffer offer,OfferCategory category) {
        Offer of = new Offer();
        of.setId(offer.getId());
        of.setName(offer.getName());
        of.setQuantity(offer.getQuantity());
        of.setPrice(offer.getPrice());
        of.setEndDate(offer.getEndDate());
        of.setOfferCategory(category);
        of.setDescription(offer.getDescription());
        repo.save(of);
        return offer.getId();
    }

    public Iterable<Offer> getOfferPageDBO(String namedQuery, int pageNumber, List<DtoOfferCategory> selectedDtoOfferCategory,Company company) {
        if (pageNumber < 0)
            return null;
        PageRequest pageRequest = new PageRequest(pageNumber, NUMBER_OFFER_ON_PAGE);


        Specification<Offer> offerSpecification = new OfferRequestSpecification(selectedDtoOfferCategory, namedQuery,company);
        Iterable<Offer> offers = repo.findAll(offerSpecification, pageRequest);
        for(Offer offer:offers){
            if(offer.getDescription().length()>255)
                offer.setDescription(offer.getDescription().substring(0,255)+"...");
        }
        return offers;
    }

    public Iterable<DtoOffer> getOfferPage(String namedQuery, int pageNumber, List<DtoOfferCategory> selectedDtoOfferCategory,Company company) {
        Iterable<Offer> offers = getOfferPageDBO(namedQuery,pageNumber,selectedDtoOfferCategory,company);
        if(offers==null)
            return null;
        return mapper.convertToDTO(offers);
    }

    public Long getOfferPageCount(String namedQuery, List<DtoOfferCategory> selectedDtoOfferCategory,Company company) {
        Specification<Offer> offerSpecification = new OfferRequestSpecification(selectedDtoOfferCategory, namedQuery, company);
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
        private final Company company;

        public OfferRequestSpecification(List<DtoOfferCategory> selectedDtoOfferCategory, String namedQuery, Company company) {
            this.selectedDtoOfferCategory = selectedDtoOfferCategory;
            this.namedQuery = namedQuery;
            this.company = company;
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

            if (company != null) {
                if (predicate == null) {
                    predicate = cb.equal(root.get("company"),company);

                } else {
                    predicate = cb.and(predicate, cb.equal(root.get("company"), company));
                }
            }



            return predicate;
        }
    }

    public void reduceOfferQuantity(Long quantityToReduce, Long offerId) {
        Offer offer = repo.findOne(offerId);
        offer.setQuantity(offer.getQuantity() - quantityToReduce);
        repo.save(offer);
    }

}

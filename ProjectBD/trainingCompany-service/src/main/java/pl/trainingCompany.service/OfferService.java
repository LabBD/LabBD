package pl.trainingCompany.service;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import pl.trainingCompany.model.dbo.Offer;
import pl.trainingCompany.model.dto.DtoOffer;
import pl.trainingCompany.repo.OfferRepo;
import pl.trainingCompany.service.mappers.OfferMapper;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Kamil S on 2016-03-24.
 */
@Service
public class OfferService extends AbstractService<Offer,DtoOffer,OfferRepo,OfferMapper> {

    public Iterable<DtoOffer> getOfferPage(int pageNumber){
        if(pageNumber<0)
            return null;
        PageRequest pageRequest=  new PageRequest(pageNumber, 1);
        Specification<Offer> offerSpecification= new Specification<Offer>() {
            @Override
            public Predicate toPredicate(Root<Offer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return null;
            }
        };
        Iterable<Offer> offers= repo.findAll(offerSpecification,pageRequest);

        return mapper.convertToDTO(offers);
    }

}

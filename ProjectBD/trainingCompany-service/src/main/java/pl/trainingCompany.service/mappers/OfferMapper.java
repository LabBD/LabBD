package pl.trainingCompany.service.mappers;

import org.springframework.stereotype.Component;
import pl.trainingCompany.model.dbo.Offer;
import pl.trainingCompany.model.dto.DtoOffer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Kamil S on 2016-03-24.
 */
@Component
public class OfferMapper implements MapperInterface<Offer, DtoOffer> {
    @Override
    public Offer convertToDBO(DtoOffer dtoOffer) {
        Offer offer = new Offer();
        offer.setId(dtoOffer.getId());
        offer.setName(dtoOffer.getName());
        offer.setDescription(dtoOffer.getDescription());
        offer.setPrice(dtoOffer.getPrice());
        offer.setQuantity(dtoOffer.getQuantity());
        if (dtoOffer.getEndDate() == null)
            offer.setEndDate(new Date());
        else
            offer.setEndDate(dtoOffer.getEndDate());
        return offer;
    }

    @Override
    public DtoOffer convertToDTO(Offer offer) {
        DtoOffer dtoOffer = new DtoOffer();
        dtoOffer.setId(offer.getId());
        dtoOffer.setName(offer.getName());
        dtoOffer.setDescription(offer.getDescription());
        dtoOffer.setPrice(offer.getPrice());
        dtoOffer.setQuantity(offer.getQuantity());
        dtoOffer.setEndDate(offer.getEndDate());
        dtoOffer.setOfferCategoryName(offer.getOfferCategory().getName());
        if(offer.getAttachments()!=null && offer.getAttachments().size()>0 ){
            dtoOffer.setMainPhoto(offer.getId()+"/"+offer.getAttachments().get(0).getName());
        }
        return dtoOffer;
    }

    @Override
    public Iterable<Offer> convertToDBO(Iterable<DtoOffer> dto) {
        List<Offer> offers = new ArrayList<Offer>();
        for (DtoOffer dtoOffer : dto) {
            offers.add(convertToDBO(dtoOffer));
        }
        return offers;
    }

    @Override
    public Iterable<DtoOffer> convertToDTO(Iterable<Offer> dbo) {
        List<DtoOffer> dtoOffers = new ArrayList<DtoOffer>();
        for (Offer offer : dbo) {
            dtoOffers.add(convertToDTO(offer));
        }
        return dtoOffers;
    }
}

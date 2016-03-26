package pl.trainingCompany.service.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.trainingCompany.model.dbo.Guest;
import pl.trainingCompany.model.dbo.Offer;
import pl.trainingCompany.model.dto.DtoGuest;
import pl.trainingCompany.repo.OfferRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastian on 2016-03-25.
 */
@Component
public class GuestMapper implements  MapperInterface<Guest,DtoGuest> {

    @Autowired
    OfferRepo offerRepo;

    @Override
    public Guest convertToDBO(DtoGuest dtoGuest) {

        Guest guest = new Guest();
        guest.setId(dtoGuest.getId());
        guest.setDate(dtoGuest.getDate());
        if(dtoGuest.getOfferId() != null) {
            Offer offer = offerRepo.findOne(dtoGuest.getOfferId());
            if (offer != null) {
                guest.setOffer(offer);
            } else {
                //ToDo
            }
        }
        //dodanie session Id

        return guest;

    }

    @Override
    public DtoGuest convertToDTO(Guest guest) {

        DtoGuest dtoGuest = new DtoGuest();
        dtoGuest.setId(guest.getId());
        dtoGuest.setDate(guest.getDate());
        if(guest.getOffer() != null) {
            dtoGuest.setOfferId(guest.getOffer().getId());
        }
        //dodanie session Id

        return dtoGuest;

    }

    @Override
    public Iterable<Guest> convertToDBO(Iterable<DtoGuest> dto) {

        List<Guest> guests = new ArrayList<Guest>();
        for (DtoGuest dtoGuest : dto) {
            guests.add(convertToDBO(dtoGuest));
        }
        return guests;
    }

    @Override
    public Iterable<DtoGuest> convertToDTO(Iterable<Guest> dbo) {

        List<DtoGuest> dtoGuests = new ArrayList<DtoGuest>();
        for (Guest guest : dbo) {
            dtoGuests.add(convertToDTO(guest));
        }
        return dtoGuests;
    }

}

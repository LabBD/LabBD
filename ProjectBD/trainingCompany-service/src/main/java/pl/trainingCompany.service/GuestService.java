package pl.trainingCompany.service;

import org.springframework.stereotype.Service;
import pl.trainingCompany.model.dbo.Guest;
import pl.trainingCompany.model.dbo.Offer;
import pl.trainingCompany.model.dto.DtoGuest;
import pl.trainingCompany.repo.GuestRepo;
import pl.trainingCompany.service.mappers.GuestMapper;

import java.util.Date;

/**
 * Created by Sebastian on 2016-03-25.
 */
@Service
public class GuestService extends AbstractService<Guest,DtoGuest,GuestRepo, GuestMapper> {


    public void checkExistsAndSave(Long offerId, String sessionId, Offer offer) {
        Guest guestFromDb =repo.findBySessionIdAndOffer(sessionId,offer);
        if(guestFromDb!=null)
            return;
        Guest guest = new Guest();
        guest.setSessionId(sessionId);
        guest.setDate(new Date());
        guest.setOffer(offer);
        repo.save(guest);
    }
}

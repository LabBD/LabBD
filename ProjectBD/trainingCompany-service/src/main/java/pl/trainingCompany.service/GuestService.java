package pl.trainingCompany.service;

import org.springframework.stereotype.Service;
import pl.trainingCompany.model.dbo.Guest;
import pl.trainingCompany.model.dbo.Offer;
import pl.trainingCompany.model.dto.DtoGuest;
import pl.trainingCompany.repo.GuestRepo;
import pl.trainingCompany.service.mappers.GuestMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Sebastian on 2016-03-25.
 */
@Service
public class GuestService extends AbstractService<Guest, DtoGuest, GuestRepo, GuestMapper> {


    public void checkExistsAndSave(Long offerId, String sessionId, Offer offer) {
        Guest guestFromDb = repo.findBySessionIdAndOffer(sessionId, offer);
        if (guestFromDb != null)
            return;
        Guest guest = new Guest();
        guest.setSessionId(sessionId);
        guest.setDate(new Date());
        guest.setOffer(offer);
        repo.save(guest);
    }

    public List<OfferStatistic> getOfferPageStatistic(Iterable<Offer> offers) {

        List<OfferStatistic> offerStatistics = new ArrayList<>();
        for (Offer offer : offers) {
            GregorianCalendar actualDate = new GregorianCalendar();

            GregorianCalendar startDate = new GregorianCalendar();
            Long milisecInWeek = new Long(1000 * 60 * 60 * 24 * 7);
            startDate.setTimeInMillis(offer.getEndDate().getTime() - milisecInWeek * 4);

            OfferStatistic offerStatistic = new OfferStatistic();

            GregorianCalendar date = new GregorianCalendar();
            date.setTime(startDate.getTime());

            offerStatistic.dates.add(new Date(date.getTimeInMillis()));
            for (int i = 0; i < 4; i++) {
                date.setTimeInMillis(startDate.getTimeInMillis() + milisecInWeek);
                if (date.after(actualDate)) {
                    offerStatistic.dates.add(new Date(actualDate.getTimeInMillis()));
                    offerStatistic.numberOfVisits.add(repo.countByOfferAndDateBetween(offer, startDate.getTime(), actualDate.getTime()));
                    break;
                }
                offerStatistic.dates.add(new Date(date.getTimeInMillis()));
                offerStatistic.numberOfVisits.add(repo.countByOfferAndDateBetween(offer, startDate.getTime(), date.getTime()));
                startDate.setTime(date.getTime());
            }
            offerStatistic.offerName= offer.getName();
            offerStatistics.add(offerStatistic);

        }
        return offerStatistics;
    }

    public class OfferStatistic {
        public String offerName;
        public List<Date> dates = new ArrayList<>();
        public List<Integer> numberOfVisits = new ArrayList<>();

    }
}

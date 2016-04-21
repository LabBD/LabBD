package pl.trainingCompany.repo;

import org.springframework.data.repository.CrudRepository;
import pl.trainingCompany.model.dbo.Guest;
import pl.trainingCompany.model.dbo.Offer;

import java.util.List;

/**
 * Created by Sebastian on 2016-03-25.
 */
public interface GuestRepo extends CrudRepository<Guest,Long> {

    public Guest findBySessionIdAndOffer(String sessionId, Offer offer);

}


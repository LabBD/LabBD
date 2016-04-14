package pl.trainingCompany.repo;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import pl.trainingCompany.model.dbo.Offer;

/**
 * Created by Kamil S on 2016-03-20.
 */
public interface OfferRepo extends CrudRepository<Offer,Long>, JpaSpecificationExecutor {

    public Offer getOfferByName(String name);

//    public Long countAll();
}

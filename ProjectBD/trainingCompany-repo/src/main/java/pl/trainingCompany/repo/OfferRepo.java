package pl.trainingCompany.repo;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import pl.trainingCompany.model.dbo.Company;
import pl.trainingCompany.model.dbo.Offer;
import pl.trainingCompany.model.dto.DtoOffer;

/**
 * Created by Kamil S on 2016-03-20.
 */
public interface OfferRepo extends CrudRepository<Offer,Long>, JpaSpecificationExecutor {

    public Offer getOfferByName(String name);

    Iterable<Offer> getOfferByCompany(Company company);

}

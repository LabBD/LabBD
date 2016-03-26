package pl.trainingCompany.repo;

import org.springframework.data.repository.CrudRepository;
import pl.trainingCompany.model.dbo.OfferCategory;

/**
 * Created by Mateusz on 2016-03-26.
 */
public interface OfferCategoryRepo extends CrudRepository<OfferCategory, Long> {
    public OfferCategory findByName(String name);
}

package pl.trainingCompany.repo;

import org.springframework.data.repository.CrudRepository;
import pl.trainingCompany.model.dbo.Basket;

/**
 * Created by Sebastian on 2016-03-25.
 */
public interface BasketRepo extends CrudRepository <Basket, Long> {
}

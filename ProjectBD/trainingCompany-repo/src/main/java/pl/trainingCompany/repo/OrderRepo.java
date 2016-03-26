package pl.trainingCompany.repo;

import org.springframework.data.repository.CrudRepository;
import pl.trainingCompany.model.dbo.Order;

/**
 * Created by Sebastian on 2016-03-25.
 */
public interface OrderRepo extends CrudRepository<Order, Long> {
}

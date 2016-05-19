package pl.trainingCompany.repo;

import org.springframework.data.repository.CrudRepository;
import pl.trainingCompany.model.dbo.Account;
import pl.trainingCompany.model.dbo.Basket;
import pl.trainingCompany.model.dbo.Order;

import java.util.List;

/**
 * Created by Sebastian on 2016-03-25.
 */
public interface OrderRepo extends CrudRepository<Order, Long> {
    public List<Order> findByAccount(Account account);
}

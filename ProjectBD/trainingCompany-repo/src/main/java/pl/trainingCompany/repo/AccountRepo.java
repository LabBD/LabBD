package pl.trainingCompany.repo;

import org.springframework.data.repository.CrudRepository;
import pl.trainingCompany.model.dbo.Account;

/**
 * Created by Kamil S on 2016-03-31.
 */
public interface AccountRepo extends CrudRepository<Account,Long> {

    public Account findByUsername(String userName);
}

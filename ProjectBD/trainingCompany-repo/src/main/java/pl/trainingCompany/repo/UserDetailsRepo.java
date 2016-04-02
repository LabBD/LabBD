package pl.trainingCompany.repo;

import org.springframework.data.repository.CrudRepository;
import pl.trainingCompany.model.dbo.UserDetails;

/**
 * Created by Daniel Palonek on 2016-04-02.
 */
public interface UserDetailsRepo extends CrudRepository<UserDetails, Long> {
}

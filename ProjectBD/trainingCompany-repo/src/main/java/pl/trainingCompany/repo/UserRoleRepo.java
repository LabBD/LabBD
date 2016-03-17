package pl.trainingCompany.repo;

import org.springframework.data.repository.CrudRepository;
import pl.trainingCompany.model.dbo.UserRole;

/**
 * Created by Kamil S on 2016-03-05.
 */
public interface UserRoleRepo extends CrudRepository<UserRole,Long> {
}

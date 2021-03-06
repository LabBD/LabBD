package pl.trainingCompany.repo;

import org.springframework.data.repository.CrudRepository;
import pl.trainingCompany.model.dbo.User;

/**
 * Created by Kamil S on 2016-03-05.
 */
public interface UserRepo extends CrudRepository<User, Long> {
    public User findByusername(String name);
}

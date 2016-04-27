package pl.trainingCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.trainingCompany.model.dbo.User;
import pl.trainingCompany.model.dbo.UserRole;
import pl.trainingCompany.model.dto.DtoUser;
import pl.trainingCompany.repo.UserRepo;
import pl.trainingCompany.repo.UserRoleRepo;
import pl.trainingCompany.service.mappers.UserMapper;

/**
 * Created by Kamil S on 2016-03-25.
 */
@Service
public class UserService extends AbstractService<User,DtoUser,UserRepo,UserMapper> {

    @Autowired
    UserRoleRepo userRoleRepo;

    public void save (String username, String password, String email) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEnabled(true);

        UserRole userRole = new UserRole();
        userRole.setRole("ROLE_USER");

        user.getUserRole().add(userRole);
        userRole.setUser(user);

        repo.save(user);
        userRoleRepo.save(userRole);
    }
}

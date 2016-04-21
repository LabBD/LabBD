package pl.trainingCompany.service.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.trainingCompany.model.dbo.User;
import pl.trainingCompany.model.dto.DtoUser;
import pl.trainingCompany.repo.BasketRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kamil S on 2016-03-25.
 */
@Component
public class UserMapper implements MapperInterface<User,DtoUser> {

    @Autowired
    BasketRepo basketRepo;

    @Override
    public User convertToDBO(DtoUser dtoUser) {
        User user = new User();
        user.setUsername(dtoUser.getUsername());
        user.setPassword(dtoUser.getPassword());

        return user;
    }

    @Override
    public DtoUser convertToDTO(User user) {
        DtoUser dtoUser = new DtoUser();
        dtoUser.setUsername(user.getUsername());
        dtoUser.setPassword(user.getPassword());
//        if(user.getBasket() != null) {
//            dtoUser.setBasketId(user.getBasket().getId());
//        }
        return dtoUser;
    }

    @Override
    public Iterable<User> convertToDBO(Iterable<DtoUser> dto) {
        List<User> users = new ArrayList<User>();
        for (DtoUser dtoUser : dto) {
            users.add(convertToDBO(dtoUser));
        }
        return users;
    }

    @Override
    public Iterable<DtoUser> convertToDTO(Iterable<User> dbo) {
        List<DtoUser> DtoUsers = new ArrayList<DtoUser>();
        for (User user : dbo) {
            DtoUsers.add(convertToDTO(user));
        }
        return DtoUsers;
    }
}

package pl.trainingCompany.service.mappers;

import org.springframework.stereotype.Component;
import pl.trainingCompany.model.dbo.Attachment;
import pl.trainingCompany.model.dbo.User;
import pl.trainingCompany.model.dto.DtoAttachment;
import pl.trainingCompany.model.dto.DtoUser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kamil S on 2016-03-25.
 */
@Component
public class UserMapper implements MapperInterface<User,DtoUser> {
    @Override
    public User convertToDBO(DtoUser dtoUser) {
        User user = new User();
        user.setUsername(dtoUser.getUsername());
        user.setPassword(dtoUser.getPassword());
        user.setEmail(dtoUser.getEmail());
        return user;
    }

    @Override
    public DtoUser convertToDTO(User user) {
        DtoUser dtoUser = new DtoUser();
        dtoUser.setUsername(user.getUsername());
        dtoUser.setPassword(user.getPassword());
        dtoUser.setEmail(user.getEmail());
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

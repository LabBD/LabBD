package pl.trainingCompany.service;

import org.springframework.stereotype.Service;
import pl.trainingCompany.model.dbo.User;
import pl.trainingCompany.model.dto.DtoUser;
import pl.trainingCompany.repo.UserRepo;
import pl.trainingCompany.service.mappers.UserMapper;

/**
 * Created by Kamil S on 2016-03-25.
 */
@Service
public class UserService extends AbstractService<User,DtoUser,UserRepo,UserMapper> {
}

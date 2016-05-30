package pl.trainingCompany.web.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.trainingCompany.model.dbo.User;
import pl.trainingCompany.model.dto.DtoUser;
import pl.trainingCompany.service.UserService;

/**
 * Created by Kamil S on 2016-03-25.
 */
@RestController
@RequestMapping("/user")
public class UserController extends AbstractController<User,DtoUser,UserService> {
	
	
}

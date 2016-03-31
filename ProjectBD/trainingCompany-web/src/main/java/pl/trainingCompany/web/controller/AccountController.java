package pl.trainingCompany.web.controller;

import org.springframework.web.bind.annotation.RestController;
import pl.trainingCompany.model.dbo.Account;
import pl.trainingCompany.model.dto.DTOAccount;
import pl.trainingCompany.service.AccountService;

/**
 * Created by Kamil S on 2016-03-31.
 */
@RestController
public class AccountController extends AbstractController<Account,DTOAccount,AccountService> {
}

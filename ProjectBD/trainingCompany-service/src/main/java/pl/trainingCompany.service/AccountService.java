package pl.trainingCompany.service;

import org.springframework.stereotype.Service;
import pl.trainingCompany.model.dbo.Account;
import pl.trainingCompany.model.dto.DTOAccount;
import pl.trainingCompany.repo.AccountRepo;
import pl.trainingCompany.service.mappers.AccountMapper;

/**
 * Created by Kamil S on 2016-03-31.
 */
@Service
public class AccountService extends AbstractService<Account,DTOAccount,AccountRepo,AccountMapper>{
}

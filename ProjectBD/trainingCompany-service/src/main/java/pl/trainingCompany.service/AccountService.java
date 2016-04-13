package pl.trainingCompany.service;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import pl.trainingCompany.model.dbo.Account;
import pl.trainingCompany.model.dto.DTOAccount;
import pl.trainingCompany.repo.AccountRepo;
import pl.trainingCompany.service.mappers.AccountMapper;

/**
 * Created by Kamil S on 2016-03-31.
 */
@Service
public class AccountService extends AbstractService<Account,DTOAccount,AccountRepo,AccountMapper>{

    public void save(MultiValueMap<String, String > data){
        DTOAccount dtoAccount = new DTOAccount();
        dtoAccount.setUsername(data.getFirst("username"));
        dtoAccount.setEmail(data.getFirst("email"));
        dtoAccount.setPassword(data.getFirst("password"));
        repo.save(mapper.convertToDBO(dtoAccount));
    }

    public Long findAccountIdByName(String username) {
        DTOAccount account = mapper.convertToDTO(repo.findByUsername(username));
        if (account.getId() > 0) {
            return account.getId();
        }
        else
            return -1L;

    }
}

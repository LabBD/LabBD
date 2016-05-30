package pl.trainingCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class AccountService extends AbstractService<Account, DTOAccount, AccountRepo, AccountMapper> {

    @Autowired
    CompanyService companyService;

    @Autowired
    UserService userService;

    public boolean saveUser(MultiValueMap<String, String> data) {

        if (findAccountIdByUsername(data.getFirst("username")) != -1) {
            return false;
        }
        DTOAccount dtoAccount = new DTOAccount();
        dtoAccount.setUsername(data.getFirst("username"));
        dtoAccount.setEmail(data.getFirst("email"));
        dtoAccount.setPassword(data.getFirst("password"));
        dtoAccount.setFirstName(data.getFirst("firstName"));
        dtoAccount.setLastName(data.getFirst("lastName"));
        dtoAccount.setPhoneNumber(data.getFirst("phone"));
        dtoAccount.setCity(data.getFirst("city"));
        dtoAccount.setAddress(data.getFirst("address"));

        repo.save(mapper.convertToDBO(dtoAccount));
        userService.save(data.getFirst("username"), data.getFirst("password"), data.getFirst("email"));

        if ((data.getFirst("companyName").length() != 0) && (data.getFirst("companyDesc").length() != 0)) {
            Long accountId = findAccountIdByUsername(data.getFirst("username"));
            if (accountId == -1L) {
                return false;
            } else {
                companyService.save(accountId, data.getFirst("companyName"), data.getFirst("companyDesc"));
            }
        }

        return true;
    }

    public Long findAccountIdByUsername(String username) {
        Account account = repo.findByUsername(username);
        if(account != null) {
            return account.getId();
        }
        else
            return -1L;

    }

    public String getLoggedAccountName(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName(); //get logged in username
        if("anonymousUser".equals(name))
            return null;
        return name;
    }

    public Long getLoggedAccountId() {
        String username = getLoggedAccountName();
        if (username != null) {
            Long id = findAccountIdByUsername(username);
            return id;
        } else
            return -1L;
    }

    public Account getLoggedAccount(){
        String username = getLoggedAccountName();
        if(username==null)
            return null;
        return repo.findByUsername(username);
    }

	
    public void update(DTOAccount dtoAccount) {
        Account account = repo.findOne(dtoAccount.getId());
        account = mapper.convertToDBO(dtoAccount);
    }
}

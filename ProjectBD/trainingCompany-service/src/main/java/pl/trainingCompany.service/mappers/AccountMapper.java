package pl.trainingCompany.service.mappers;

import org.springframework.stereotype.Component;
import pl.trainingCompany.model.dbo.Account;
import pl.trainingCompany.model.dto.DTOAccount;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kamil S on 2016-03-31.
 */
@Component
public class AccountMapper implements MapperInterface<Account,DTOAccount> {
    @Override
    public Account convertToDBO(DTOAccount dtoAccount) {
        Account account = new Account();
        account.setId(dtoAccount.getId());
        account.setUsername(dtoAccount.getUsername());
        account.setPassword(dtoAccount.getPassword());
        account.setEmail(dtoAccount.getEmail());
        return account;
    }

    @Override
    public DTOAccount convertToDTO(Account account) {
        DTOAccount dtoAccount = new DTOAccount();
        dtoAccount.setId(account.getId());
        dtoAccount.setUsername(account.getUsername());
        dtoAccount.setPassword(account.getPassword());
        dtoAccount.setEmail(account.getEmail());
        return dtoAccount;
    }

    @Override
    public Iterable<Account> convertToDBO(Iterable<DTOAccount> dto) {
        List<Account> accounts = new ArrayList<>();
        for(DTOAccount dtoAccount:dto){
            accounts.add(convertToDBO(dtoAccount));
        }
        return accounts;
    }

    @Override
    public Iterable<DTOAccount> convertToDTO(Iterable<Account> dbo) {
        List<DTOAccount> dtoAccounts = new ArrayList<>();
        for(Account account:dbo){
            dtoAccounts.add(convertToDTO(account));
        }
        return dtoAccounts;
    }
}

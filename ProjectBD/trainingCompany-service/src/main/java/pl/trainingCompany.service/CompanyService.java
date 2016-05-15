package pl.trainingCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.trainingCompany.model.dbo.Account;
import pl.trainingCompany.model.dbo.Company;
import pl.trainingCompany.model.dto.DtoCompany;
import pl.trainingCompany.repo.CompanyRepo;
import pl.trainingCompany.service.mappers.CompanyMapper;

/**
 * Created by Mateusz on 2016-03-26.
 */
@Service
public class CompanyService extends AbstractService<Company, DtoCompany, CompanyRepo, CompanyMapper> {

    @Autowired
    private AccountService accountService;

    public void save(Long accountId, String companyName, String companyDesc) {
        DtoCompany dtoCompany = new DtoCompany();
        dtoCompany.setAccountId(accountId);
        dtoCompany.setNameCompany(companyName);
        dtoCompany.setDescription(companyDesc);
        repo.save(mapper.convertToDBO(dtoCompany));
    }

    public Company getLoggedCompany() {
        Account loggedAccount = accountService.getLoggedAccount();
        if (loggedAccount == null)
            return null;
        return loggedAccount.getCompany();
    }

    public Company getLoggedCompanyByName(String name) {
        if (name == null)
            return null;

        Account loggedAccount = accountService.getLoggedAccount();
        if (loggedAccount == null)
            return null;

        if (name.equals(loggedAccount.getCompany().getCompanyName()))
            return loggedAccount.getCompany();
        else
            return null;
    }

    public String getLoggedCompanyName() {
        Company company = getLoggedCompany();
        if(company==null)
            return null;
        return company.getCompanyName();
    }

}

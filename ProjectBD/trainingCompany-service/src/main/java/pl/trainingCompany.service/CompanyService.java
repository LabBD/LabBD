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
	
	   public DtoCompany getDetails() {
        Company company = getLoggedCompany();
        if (company != null) {
            DtoCompany dtoCompany = mapper.convertToDTO(company);
            return dtoCompany;
        } else {
            DtoCompany dtoCompany = new DtoCompany();
            dtoCompany.setId(-1);
            dtoCompany.setAccountId(-1);
            dtoCompany.setNameCompany("-1");
            dtoCompany.setDescription("-1");
            return dtoCompany;
        }

    }

    public void update(DtoCompany dtoCompany) {
        Company company = repo.findOne(dtoCompany.getId());
        company = mapper.convertToDBO(dtoCompany);
    }

}

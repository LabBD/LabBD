package pl.trainingCompany.service.mappers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.trainingCompany.model.dbo.Account;
import pl.trainingCompany.model.dbo.Company;
import pl.trainingCompany.model.dbo.User;
import pl.trainingCompany.model.dto.DtoCompany;
import pl.trainingCompany.repo.AccountRepo;
import pl.trainingCompany.repo.UserRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateusz on 2016-03-26.
 */
@Component
public class CompanyMapper implements MapperInterface<Company, DtoCompany> {

    @Autowired
    AccountRepo accountRepo;

    @Override
    public Company convertToDBO(DtoCompany dtoCompany){
        Company company = new Company();
        company.setId(dtoCompany.getId());
        company.setCompanyName(dtoCompany.getNameCompany());
        company.setDescription(dtoCompany.getDescription());
        if(dtoCompany.getAccountId() != null) {
            Account account = accountRepo.findOne(dtoCompany.getAccountId());
            if(account != null) {
                company.setAccount(account);
            } else {
                //ToDo
            }
        }

        return company;
    }

    @Override
    public DtoCompany convertToDTO(Company company) {
        DtoCompany dtoCompany = new DtoCompany();
        dtoCompany.setId(company.getId());
        dtoCompany.setNameCompany(company.getCompanyName());
        dtoCompany.setDescription(company.getDescription());
        if(company.getAccount() != null){
            dtoCompany.setAccountId(company.getAccount().getId());
        }

        return dtoCompany;
    }

    @Override
    public Iterable<Company> convertToDBO(Iterable<DtoCompany> dto) {
        List<Company> companies = new ArrayList<Company>();
        for (DtoCompany dtoCompany : dto) {
            companies.add(convertToDBO(dtoCompany));
        }

        return companies;
    }

    @Override
    public Iterable<DtoCompany> convertToDTO(Iterable<Company> dbo) {
        List<DtoCompany> dtoCompanies = new ArrayList<DtoCompany>();
        for (Company company : dbo) {
            dtoCompanies.add(convertToDTO(company));
        }
        return dtoCompanies;
    }

}

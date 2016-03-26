package pl.trainingCompany.service.mappers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.trainingCompany.model.dbo.Company;
import pl.trainingCompany.model.dbo.User;
import pl.trainingCompany.model.dto.DtoCompany;
import pl.trainingCompany.repo.UserRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateusz on 2016-03-26.
 */
@Component
public class CompanyMapper implements MapperInterface<Company, DtoCompany> {

    @Autowired
    UserRepo userRepo;

    @Override
    public Company convertToDBO(DtoCompany dtoCompany){
        Company company = new Company();
        company.setId(dtoCompany.getId());
        company.setNameCompany(dtoCompany.getNameCompany());
        company.setDescription(dtoCompany.getDescription());
        if(dtoCompany.getUserId() != null) {
            User user = userRepo.findOne(dtoCompany.getUserId());
            if(user != null) {
                company.setUser(user);
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
        dtoCompany.setNameCompany(company.getNameCompany());
        dtoCompany.setDescription(company.getDescription());
        if(company.getUser() != null){
            dtoCompany.setUserId(company.getUser().getId());
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

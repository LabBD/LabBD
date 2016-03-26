package pl.trainingCompany.service.mappers;


import org.springframework.stereotype.Component;
import pl.trainingCompany.model.dbo.Company;
import pl.trainingCompany.model.dto.DtoCompany;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mateusz on 2016-03-26.
 */
@Component
public class CompanyMapper implements MapperInterface<Company, DtoCompany> {

    @Override
    public Company convertToDBO(DtoCompany dtoCompany){
        Company company = new Company();
        company.setCompanyId(dtoCompany.getCompanyId());
        company.setId(dtoCompany.getId());
        company.setNameCompany(dtoCompany.getNameCompany());
        company.setDescription(dtoCompany.getDescription());

        return company;
    }

    @Override
    public DtoCompany convertToDTO(Company company) {
        DtoCompany dtoCompany = new DtoCompany();
        dtoCompany.setCompanyId(company.getCompanyId());
        dtoCompany.setId(company.getId());
        dtoCompany.setNameCompany(company.getNameCompany());
        dtoCompany.setDescription(company.getDescription());
        return null;
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

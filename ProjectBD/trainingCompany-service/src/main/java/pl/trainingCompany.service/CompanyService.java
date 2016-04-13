package pl.trainingCompany.service;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Service;
import pl.trainingCompany.model.dbo.Company;
import pl.trainingCompany.model.dto.DtoCompany;
import pl.trainingCompany.repo.CompanyRepo;
import pl.trainingCompany.service.mappers.CompanyMapper;

/**
 * Created by Mateusz on 2016-03-26.
 */
@Service
public class CompanyService extends AbstractService<Company, DtoCompany, CompanyRepo, CompanyMapper>{

    public void save(Long accountId, String companyName, String companyDesc) {
        DtoCompany dtoCompany = new DtoCompany();
        dtoCompany.setAccountId(accountId);
        dtoCompany.setNameCompany(companyName);
        dtoCompany.setDescription(companyDesc);
        repo.save(mapper.convertToDBO(dtoCompany));
    }

}

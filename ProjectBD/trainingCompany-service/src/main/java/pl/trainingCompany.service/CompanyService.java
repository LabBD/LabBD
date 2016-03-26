package pl.trainingCompany.service;

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

}

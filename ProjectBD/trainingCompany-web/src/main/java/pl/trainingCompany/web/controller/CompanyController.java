package pl.trainingCompany.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.trainingCompany.model.dbo.Company;
import pl.trainingCompany.model.dto.DtoCompany;
import pl.trainingCompany.service.CompanyService;

/**
 * Created by Mateusz on 2016-03-26.
 */
@RestController
@RequestMapping("/company")
public class CompanyController extends AbstractController<Company, DtoCompany, CompanyService> {

}

package pl.trainingCompany.web.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		
	@RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
    public void updateAccountDetails(@RequestBody DtoCompany dtoCompany) {
        service.save(dtoCompany);
    }

    @RequestMapping(value = "/details", method = RequestMethod.POST)
    public DtoCompany getCompanyDetails() {
        DtoCompany dtoCompany = service.getDetails();
        return dtoCompany;
    }

}

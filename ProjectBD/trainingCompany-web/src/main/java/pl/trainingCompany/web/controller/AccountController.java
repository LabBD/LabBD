package pl.trainingCompany.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pl.trainingCompany.model.dbo.Account;
import pl.trainingCompany.model.dto.DTOAccount;
import pl.trainingCompany.service.AccountService;
import pl.trainingCompany.service.CompanyService;

/**
 * Created by Kamil S on 2016-03-31.
 */
@RestController
@RequestMapping("/account")
public class AccountController extends AbstractController<Account,DTOAccount,AccountService> {

    @Autowired
    CompanyService companyService;

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    public ModelAndView register(@RequestBody final MultiValueMap<String, String > data) {

        if(!data.isEmpty()) {
            if(service.findAccountIdByName(data.getFirst("username")) > 0){
                //uzytkownik o podanym username juz istnieje, redirect do jakiejs strony z informacja o bledzie
            }
            else {
                service.save(data);

                if(!data.getFirst("companyName").isEmpty() && !data.getFirst("companyDesc").isEmpty()) {
                    Long accountId = service.findAccountIdByName(data.getFirst("username"));
                    if(accountId != -1L) {
                        companyService.save(accountId, data.getFirst("companyName"), data.getFirst("companyDesc"));
                    } else {
                        //To Do  nie odnaleziono uzytkownika o podanym username (nie udalo sie wyzej zapisac uzytkownika do bazy)
                    }
                }
            }
        }
        return new ModelAndView("redirect:/");
    }
}

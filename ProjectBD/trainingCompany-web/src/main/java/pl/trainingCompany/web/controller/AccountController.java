package pl.trainingCompany.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.trainingCompany.model.ValueWrapper;
import pl.trainingCompany.model.dbo.Account;
import pl.trainingCompany.model.dto.DTOAccount;
import pl.trainingCompany.service.AccountService;
import pl.trainingCompany.service.CompanyService;
import pl.trainingCompany.service.UserService;

/**
 * Created by Kamil S on 2016-03-31.
 */
@RestController
@RequestMapping("/account")
public class AccountController extends AbstractController<Account, DTOAccount, AccountService> {

    @Autowired
    CompanyService companyService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/logged/name")
    public ValueWrapper<String> getLoggedUserame() {
        return new ValueWrapper(service.getLoggedAccountName());
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    public ModelAndView register(@RequestBody final MultiValueMap<String, String> data) {

        if (!service.saveUser(data)) {
            return new ModelAndView("redirect:http://localhost:8080/#/error/userExisted");
        }

        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/checkUsername/{username}", method = RequestMethod.GET)
    public ValueWrapper<Boolean> checkUsername(@PathVariable String username) {
        Long id = service.findAccountIdByUsername(username);

        if (id == null || id != -1L) {
            return new ValueWrapper<Boolean>(true);
        }
        return new ValueWrapper<Boolean>(false);
    }
}

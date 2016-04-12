package pl.trainingCompany.web.controller;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pl.trainingCompany.model.dbo.Account;
import pl.trainingCompany.model.dto.DTOAccount;
import pl.trainingCompany.service.AccountService;

/**
 * Created by Kamil S on 2016-03-31.
 */
@RestController
@RequestMapping("/account")
public class AccountController extends AbstractController<Account,DTOAccount,AccountService> {
    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded")
    public ModelAndView register(@RequestBody final MultiValueMap<String, String > data) {

        System.out.println("test");
        return new ModelAndView("redirect:/");

    }
}

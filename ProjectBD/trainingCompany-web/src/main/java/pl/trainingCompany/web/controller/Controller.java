package pl.trainingCompany.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.trainingCompany.model.dbo.Greeting;
import pl.trainingCompany.model.dbo.User;
import pl.trainingCompany.repo.GreetingRepo;

import java.util.Map;

/**
 * Created by Kamil S on 2016-03-03.
 */
@RestController
public class Controller {



    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("public/index");
    }

    @RequestMapping("/user/")
    public ModelAndView getUserIndex() {
        return new ModelAndView("user/userIndex");
    }

    @RequestMapping("/login")
    public ModelAndView getLoginPage() {
        return new ModelAndView("public/login");
    }


}

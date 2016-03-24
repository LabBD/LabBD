package pl.trainingCompany.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.trainingCompany.model.dbo.Greeting;
import pl.trainingCompany.model.dbo.User;
import pl.trainingCompany.repo.GreetingRepo;

/**
 * Created by Kamil S on 2016-03-03.
 */
@RestController
public class Controller {

    @Autowired
    private GreetingRepo repo;

    @RequestMapping("/users/{id}")
    public Greeting get(@PathVariable("id") int id) {

        System.out.print(id);
        return repo.findOne(1L);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void post(@RequestBody User user) {


    }

    @RequestMapping("/c")
    public void take() {
        repo.save(new Greeting());
    }

    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

}

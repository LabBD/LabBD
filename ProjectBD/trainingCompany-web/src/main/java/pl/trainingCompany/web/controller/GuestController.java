package pl.trainingCompany.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.trainingCompany.model.dbo.Guest;
import pl.trainingCompany.model.dto.DtoGuest;
import pl.trainingCompany.service.GuestService;

import javax.servlet.http.HttpSession;

/**
 * Created by Sebastian on 2016-03-25.
 */
@RestController
@RequestMapping("/guest")
public class GuestController extends AbstractController<Guest, DtoGuest, GuestService> {

}

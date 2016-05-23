package pl.trainingCompany.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.trainingCompany.model.GetOfferPageRequestBody;
import pl.trainingCompany.model.dbo.Company;
import pl.trainingCompany.model.dbo.Guest;
import pl.trainingCompany.model.dbo.Offer;
import pl.trainingCompany.model.dto.DtoGuest;
import pl.trainingCompany.model.dto.DtoOffer;
import pl.trainingCompany.service.CompanyService;
import pl.trainingCompany.service.GuestService;
import pl.trainingCompany.service.OfferService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Sebastian on 2016-03-25.
 */
@RestController
@RequestMapping("/guest")
public class GuestController extends AbstractController<Guest, DtoGuest, GuestService> {

    @Autowired
    OfferService offerService;

    @Autowired
    CompanyService companyService;

    @RequestMapping(value = "/statistic/my/page/{pageNumber}", method = RequestMethod.POST)
    public List<GuestService.OfferStatistic> getOfferPageStatistic(@RequestBody GetOfferPageRequestBody requestBody, @PathVariable int pageNumber) {

        Company loggedCompany = companyService.getLoggedCompany();
        if (loggedCompany == null)
            return null;

        Iterable<Offer> offers=  offerService.getOfferPageDBO(requestBody.getQuery(), pageNumber - 1, requestBody.getSelectedOfferCategory(), loggedCompany);
        return service.getOfferPageStatistic(offers);
    }

}

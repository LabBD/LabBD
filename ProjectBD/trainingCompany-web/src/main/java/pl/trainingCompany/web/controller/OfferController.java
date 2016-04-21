package pl.trainingCompany.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import pl.trainingCompany.model.GetOfferPageRequestBody;
import pl.trainingCompany.model.dbo.Offer;
import pl.trainingCompany.model.dto.DtoGuest;
import pl.trainingCompany.model.dto.DtoOffer;
import pl.trainingCompany.model.dto.DtoOfferCategory;
import pl.trainingCompany.service.GuestService;
import pl.trainingCompany.service.OfferService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Kamil S on 2016-03-24.
 */
@RestController
@RequestMapping("/offer")
public class OfferController extends AbstractController<Offer, DtoOffer, OfferService> {

    @Autowired
    GuestService guestService;

    @Override
    public DtoOffer findOne(@PathVariable int id,HttpServletRequest request) {
        Offer offer = service.findOfferDbo(new Long(id));
        if(offer==null)
            return null;
        guestService.checkExistsAndSave(new Long(id),request.getSession().getId(),offer);
        return service.getMapper().convertToDTO(offer);
    }

    @RequestMapping(value = "/page/{pageNumber}", method = RequestMethod.POST)
    public Iterable<DtoOffer> getOfferPage(@RequestBody GetOfferPageRequestBody requestBody, @PathVariable int pageNumber) {
        for (DtoOfferCategory dtoOfferCategory : requestBody.getSelectedOfferCategory()) {
            System.out.println(dtoOfferCategory.getName());
        }
        System.out.println();
        return service.getOfferPage(requestBody.getQuery(),pageNumber - 1,requestBody.getSelectedOfferCategory());
    }

    @RequestMapping(value = "/page/count", method = RequestMethod.POST)
    public LongWraper getOfferPageCount(@RequestBody GetOfferPageRequestBody requestBody) {
        LongWraper longWraper= new  LongWraper();
        longWraper.value=service.getOfferPageCount(requestBody.getQuery(),requestBody.getSelectedOfferCategory());
        return longWraper;
    }
    class LongWraper{
        public Long value;
    }

}

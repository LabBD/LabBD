package pl.trainingCompany.web.controller;

import org.springframework.web.bind.annotation.*;
import pl.trainingCompany.model.dbo.Offer;
import pl.trainingCompany.model.dto.DtoOffer;
import pl.trainingCompany.model.dto.DtoOfferCategory;
import pl.trainingCompany.service.OfferService;

import java.util.List;

/**
 * Created by Kamil S on 2016-03-24.
 */
@RestController
@RequestMapping("/offer")
public class OfferController extends AbstractController<Offer,DtoOffer,OfferService> {

    @RequestMapping(value = "/page/{pageNumber}" ,method = RequestMethod.POST)
    public Iterable<DtoOffer> getOfferPage(@RequestBody List<DtoOfferCategory> dtoOfferCategories, @PathVariable int pageNumber){
       for(DtoOfferCategory dtoOfferCategory: dtoOfferCategories){
           System.out.println(dtoOfferCategory.getName());
       }
        System.out.println();
        return service.getOfferPage(pageNumber-1);
    }

}

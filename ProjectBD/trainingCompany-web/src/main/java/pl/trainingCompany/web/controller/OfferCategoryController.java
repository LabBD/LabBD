package pl.trainingCompany.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.trainingCompany.model.dbo.OfferCategory;
import pl.trainingCompany.model.dto.DtoOfferCategory;
import pl.trainingCompany.service.OfferCategoryService;

/**
 * Created by dell on 2016-03-26.
 */
@RestController
@RequestMapping("/offerCategory")
public class OfferCategoryController extends AbstractController<OfferCategory,DtoOfferCategory,OfferCategoryService>{

}

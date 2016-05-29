package pl.trainingCompany.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.trainingCompany.model.dbo.Basket;
import pl.trainingCompany.model.dto.DtoBasket;
import pl.trainingCompany.service.BasketService;
import pl.trainingCompany.service.OfferService;

/**
 * Created by Sebastian on 2016-03-25.
 */

@RestController
@RequestMapping("/basket")
public class BasketController extends AbstractController<Basket,DtoBasket, BasketService> {
}

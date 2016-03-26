package pl.trainingCompany.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.trainingCompany.model.dbo.Offer;
import pl.trainingCompany.model.dto.DtoOffer;
import pl.trainingCompany.service.OfferService;

/**
 * Created by Kamil S on 2016-03-24.
 */
@RestController
@RequestMapping("/offer")
public class OfferController extends AbstractController<Offer,DtoOffer,OfferService> {

}

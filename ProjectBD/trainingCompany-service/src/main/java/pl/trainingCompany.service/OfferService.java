package pl.trainingCompany.service;

import org.springframework.stereotype.Service;
import pl.trainingCompany.model.dbo.Offer;
import pl.trainingCompany.model.dto.DtoOffer;
import pl.trainingCompany.repo.OfferRepo;
import pl.trainingCompany.service.mappers.OfferMapper;

/**
 * Created by Kamil S on 2016-03-24.
 */
@Service
public class OfferService extends AbstractService<Offer,DtoOffer,OfferRepo,OfferMapper> {
}

package pl.trainingCompany.service;

import org.springframework.stereotype.Service;
import pl.trainingCompany.model.dbo.Basket;
import pl.trainingCompany.model.dto.DtoBasket;
import pl.trainingCompany.repo.BasketRepo;
import pl.trainingCompany.service.mappers.BasketMapper;

/**
 * Created by Sebastian on 2016-03-25.
 */
@Service
public class BasketService extends AbstractService<Basket, DtoBasket, BasketRepo, BasketMapper> {

}

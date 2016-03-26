package pl.trainingCompany.service.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.trainingCompany.model.dbo.Basket;
import pl.trainingCompany.model.dbo.User;
import pl.trainingCompany.model.dto.DtoBasket;
import pl.trainingCompany.repo.UserRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastian on 2016-03-25.
 */
@Component
public class BasketMapper implements MapperInterface<Basket, DtoBasket> {

    @Autowired
    UserRepo userRepo;

    @Override
    public Basket convertToDBO(DtoBasket dtoBasket) {
        Basket basket = new Basket();
        basket.setId(dtoBasket.getId());
        if(dtoBasket.getUserId() != null) {
            User user = userRepo.findOne(dtoBasket.getUserId());
            if(user != null) {
                basket.setUser(user);
            }else {
                //ToDo
            }
        }
        return basket;
    }

    @Override
    public DtoBasket convertToDTO(Basket basket) {
        DtoBasket dtoBasket = new DtoBasket();
        dtoBasket.setId(basket.getId());
        if(basket.getUser() != null) {
            dtoBasket.setUserId(basket.getUser().getId());
        }
        return dtoBasket;
    }

    @Override
    public Iterable<Basket> convertToDBO(Iterable<DtoBasket> dto) {
        List<Basket> baskets = new ArrayList<Basket>();
        for(DtoBasket dtoBasket : dto) {
            baskets.add(convertToDBO(dtoBasket));
        }
        return baskets;
    }

    @Override
    public Iterable<DtoBasket> convertToDTO(Iterable<Basket> dbo) {
        List<DtoBasket> baskets = new ArrayList<DtoBasket>();
        for(Basket basket : dbo) {
            baskets.add(convertToDTO(basket));
        }
        return baskets;
    }
}

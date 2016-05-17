package pl.trainingCompany.service.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.trainingCompany.model.dbo.Basket;
import pl.trainingCompany.model.dbo.Offer;
import pl.trainingCompany.model.dbo.Order;
import pl.trainingCompany.model.dto.DtoOrder;
import pl.trainingCompany.repo.BasketRepo;
import pl.trainingCompany.repo.OfferRepo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastian on 2016-03-25.
 */
@Component
public class OrderMapper implements MapperInterface<Order,DtoOrder> {

    @Autowired
    BasketRepo basketRepo;
    @Autowired
    OfferRepo offerRepo;

    @Override
    public Order convertToDBO(DtoOrder dtoOrder) {
        Order order = new Order();
        order.setId(dtoOrder.getId());
        order.setAmount(dtoOrder.getAmount());
        if(dtoOrder.getBasketId() != null) {
            Basket basket = basketRepo.findOne(dtoOrder.getBasketId());
            if(basket != null) {
                order.setBasket(basket);
            }else {
                //ToDo
            }
        }
        if(dtoOrder.getOfferId() != null) {
            Offer offer = offerRepo.findOne(dtoOrder.getOfferId());
            if (offer != null) {
                order.setOffer(offer);
            } else {
                //ToDo
            }
        }
        order.setDatePayment(dtoOrder.getDatePayment());
        return order;
    }

    @Override
    public DtoOrder convertToDTO(Order order) {
        DtoOrder dtoOrder = new DtoOrder();
        dtoOrder.setId(order.getId());
        dtoOrder.setOfferName(order.getOffer().getName());
        dtoOrder.setOfferPrice(order.getOffer().getPrice());
        dtoOrder.setOfferQuantity(order.getOffer().getQuantity());
        dtoOrder.setAmount(order.getAmount());
        dtoOrder.setDatePayment(order.getDatePayment());
        if(order.getBasket() != null) {
            dtoOrder.setBasketId(order.getBasket().getId());
        }
        if(order.getOffer() != null) {
            dtoOrder.setOfferId(order.getOffer().getId()); //id oznacza offerId
        }
        return dtoOrder;
    }

    @Override
    public Iterable<Order> convertToDBO(Iterable<DtoOrder> dto) {
        List<Order> orders = new ArrayList<Order>();
        for(DtoOrder dtoOrder : dto) {
            orders.add(convertToDBO(dtoOrder));
        }
        return orders;
    }

    @Override
    public Iterable<DtoOrder> convertToDTO(Iterable<Order> dbo) {
        List<DtoOrder> orders = new ArrayList<DtoOrder>();
        for(Order order: dbo) {
            orders.add(convertToDTO(order));
        }
        return orders;
    }
}

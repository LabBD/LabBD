package pl.trainingCompany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.trainingCompany.model.dbo.Offer;
import pl.trainingCompany.model.dbo.Order;
import pl.trainingCompany.model.dto.DtoOffer;
import pl.trainingCompany.model.dto.DtoOrder;
import pl.trainingCompany.repo.OrderRepo;
import pl.trainingCompany.service.mappers.OfferMapper;
import pl.trainingCompany.service.mappers.OrderMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastian on 2016-03-25.
 */
@Service
public class OrderService extends AbstractService<Order, DtoOrder,OrderRepo,OrderMapper> {

    public Iterable<DtoOrder> getAllOfferFromOrder(Long idBasket){
        List<Order> orders = (List<Order>) repo.findAll();
        return mapper.convertToDTO(orders);
    }
}

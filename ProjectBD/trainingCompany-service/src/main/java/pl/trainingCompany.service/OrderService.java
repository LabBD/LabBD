package pl.trainingCompany.service;

import org.springframework.stereotype.Service;
import pl.trainingCompany.model.dbo.Order;
import pl.trainingCompany.model.dto.DtoOrder;
import pl.trainingCompany.repo.OrderRepo;
import pl.trainingCompany.service.mappers.OrderMapper;

/**
 * Created by Sebastian on 2016-03-25.
 */
@Service
public class OrderService extends AbstractService<Order, DtoOrder,OrderRepo,OrderMapper> {

}

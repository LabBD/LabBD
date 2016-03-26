package pl.trainingCompany.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.trainingCompany.model.dbo.Order;
import pl.trainingCompany.model.dto.DtoOrder;
import pl.trainingCompany.service.OrderService;

/**
 * Created by Sebastian on 2016-03-25.
 */
@RestController
@RequestMapping("/order")
public class OrderController extends AbstractController<Order, DtoOrder, OrderService> {

}

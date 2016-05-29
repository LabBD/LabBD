package pl.trainingCompany.web.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pl.trainingCompany.model.dbo.Order;
import pl.trainingCompany.model.dto.DtoOrder;
import pl.trainingCompany.service.OrderService;

/**
 * Created by Sebastian on 2016-03-25.
 */
@RestController
@RequestMapping("/order")
public class OrderController extends AbstractController<Order, DtoOrder, OrderService> {


    @RequestMapping("/offers")
    public Iterable<DtoOrder> getAllOfferFromOrder(Long idBasket){
        return service.getAllOfferFromOrder(1L);
    }

    @RequestMapping(value = "/addToBasket",  method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
    public ModelAndView register(@RequestBody DtoOrder dtoOrder) {

        if(service.saveOrder(dtoOrder)) {
//            return true;
            return new ModelAndView("redirect:/");
        } else
            return new ModelAndView("redirect:http://localhost:8080/#/error/order");
//            return false;
    }

    @RequestMapping("/my")
    public Iterable<DtoOrder> getOrdersFromLoggedAccount(){
        return service.getOrdersFromLoggedAccount();
    }



}

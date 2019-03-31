package org.ms.order.web;

import java.util.List;
import javax.annotation.PostConstruct;
import org.ms.order.domain.Order;
import org.ms.order.service.OrderService;
import org.ms.service.IOrderService;
import org.ms.service.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Zhenglai Zhang
 * @create: 2019-03-31 12:51
 **/
@RestController
@RequestMapping("/api/orders")
public class OrderController implements IOrderService {

    @PostConstruct
    public void init() {
        var order = Order.builder()
                .title("MyOrder")
                .detail("My order detail")
                .amount(100)
                .build();
        orderService.create(order);
    }

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order create(Order order) {
        return orderService.create(order);
    }

    @GetMapping
    public List<Order> getAll() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    @Override
    public OrderDTO getMyOrder(@PathVariable Long id) {
        var order = orderService.findOne(id);
        var dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setDetail(order.getDetail());
        dto.setAmount(order.getAmount());
        dto.setTitle(order.getTitle());
        return dto;
    }
}

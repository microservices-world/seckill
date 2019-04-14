package org.ms.order.web;

import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.ms.common.utils.TokenUtils;
import org.ms.order.domain.Order;
import org.ms.order.service.OrderService;
import org.ms.service.IOrderService;
import org.ms.service.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

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
        var order = Order.builder().title("MyOrder").detail("My order detail").amount(100).build();
        orderService.create(order);
    }

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order create(@RequestBody Order order, HttpServletRequest request) {
        var token = request.getHeader("token");
        Assert.hasText(token, "token missing");
        if (!TokenUtils.foundToken(token)) {
            throw new RuntimeException("Repeated submit");
        }
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

package org.ms.order.service;

import java.util.List;
import org.ms.order.dao.OrderRepository;
import org.ms.order.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Zhenglai Zhang
 * @create: 2019-03-31 12:50
 **/
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order create(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findOne(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

}

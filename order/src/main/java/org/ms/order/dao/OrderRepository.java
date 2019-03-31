package org.ms.order.dao;

import org.ms.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description:
 * @author: Zhenglai Zhang
 * @create: 2019-03-31 12:49
 **/
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findOneByTitle(String title);
}

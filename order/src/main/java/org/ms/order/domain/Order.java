package org.ms.order.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @description:
 * @author: Zhenglai Zhang
 * @create: 2019-03-31 12:48
 **/
@Entity(name = "customer_order")
public class Order {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String detail;
    private Integer amount;
}

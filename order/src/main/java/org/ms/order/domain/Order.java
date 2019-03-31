package org.ms.order.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: Zhenglai Zhang
 * @create: 2019-03-31 12:48
 **/
@Entity(name = "customer_order")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String detail;
    private Integer amount;
}

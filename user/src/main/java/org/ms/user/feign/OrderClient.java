package org.ms.user.feign;

import org.ms.service.IOrderService;
import org.ms.service.dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description:
 * @author: Zhenglai Zhang
 * @create: 2019-03-31 14:44
 **/
@FeignClient(value = "order", path = "/api/orders")
public interface OrderClient extends IOrderService {

    @GetMapping("/{id}")
    @Override
    OrderDTO getMyOrder(@PathVariable Long id);
}

package org.ms.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @description:
 * @author: Zhenglai Zhang
 * @create: 2019-03-31 14:44
 **/
@FeignClient(value = "order", path = "/api/orders")
public interface OrderClient {

    @GetMapping("/{id}")
    String getMyOrder(@PathVariable Long id);
}

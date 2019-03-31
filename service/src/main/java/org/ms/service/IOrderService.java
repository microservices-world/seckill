package org.ms.service;

import org.ms.service.dto.OrderDTO;

/**
 * @description:
 * @author: Zhenglai Zhang
 * @create: 2019-03-31 15:12
 **/
public interface IOrderService {

    OrderDTO getMyOrder(Long id);
}

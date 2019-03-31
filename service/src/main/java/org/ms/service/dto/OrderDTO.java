package org.ms.service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: Zhenglai Zhang
 * @create: 2019-03-31 15:07
 **/
@Data
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private String title;
    private String detail;
    private Integer amount;
}

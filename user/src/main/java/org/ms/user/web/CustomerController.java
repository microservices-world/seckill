package org.ms.user.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.ms.user.domain.Customer;
import org.ms.user.feign.OrderClient;
import org.ms.user.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Zhenglai Zhang
 * @create: 2019-03-31 12:29
 **/
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @PostConstruct
    public void init() {
        var customer = Customer.builder()
                .userName("test")
                .role("USER")
                .build();
        customerService.create(customer);
    }

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderClient orderClient;

    @GetMapping
    //TODO 2019-03-31 Zhenglai Zhang: verify hystrix dashboard
    @HystrixCommand
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer) {
        return customerService.create(customer);
    }

    @GetMapping("/my")
    public Map getMyInfo(@RequestParam String userName) {
        var customer = customerService.findBy(userName);
        var order = orderClient.getMyOrder(1L);
        var result = new HashMap();
        result.put("customer", customer);
        result.put("order", order);
        return result;
    }
}

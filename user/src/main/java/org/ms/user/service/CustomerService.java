package org.ms.user.service;

import java.util.List;
import org.ms.user.dao.CustomerRepository;
import org.ms.user.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Zhenglai Zhang
 * @create: 2019-03-31 12:28
 **/
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findBy(String name) {
        return customerRepository.findOneByUserName(name);
    }
}

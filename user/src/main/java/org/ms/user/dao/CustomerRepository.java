package org.ms.user.dao;

import org.ms.user.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description:
 * @author: Zhenglai Zhang
 * @create: 2019-03-31 12:28
 **/
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findOneByUserName(String name);
}

package org.ms.user.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: Zhenglai Zhang
 * @create: 2019-03-31 12:40
 **/
@RestController
public class HomeController {

    @GetMapping("/home")
    public String hello() {
        return "Hello User Service";
    }
}

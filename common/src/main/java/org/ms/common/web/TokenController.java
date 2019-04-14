package org.ms.common.web;

import org.ms.common.utils.TokenUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zhenglai
 * @since 2019-04-14 18:39
 */
@RestController
public class TokenController {
    @GetMapping("/tokens")
    public String getToken() {
        return TokenUtils.getToken();
    }
}

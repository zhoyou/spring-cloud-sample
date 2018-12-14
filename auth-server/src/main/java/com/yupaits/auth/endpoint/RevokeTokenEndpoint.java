package com.yupaits.auth.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yupaits
 * @date 2018/12/14
 */
@FrameworkEndpoint
public class RevokeTokenEndpoint {

    @Autowired
    @Qualifier("consumerTokenServices")
    private ConsumerTokenServices consumerTokenServices;

    @DeleteMapping("/oauth/token")
    @ResponseBody
    public String revokeToken(String accessToken) {
        return consumerTokenServices.revokeToken(accessToken) ? "注销成功" : "注销失败";
    }
}

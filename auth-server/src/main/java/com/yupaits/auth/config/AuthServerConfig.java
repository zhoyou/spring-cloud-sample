package com.yupaits.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * @author yupaits
 * @date 2018/12/14
 */
@Configuration
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {

    private final RedisConnectionFactory redisConnectionFactory;
    private final AuthenticationManager authenticationManager;

    private RedisTokenStore tokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }

    @Autowired
    public AuthServerConfig(RedisConnectionFactory redisConnectionFactory, AuthenticationManager authenticationManager) {
        this.redisConnectionFactory = redisConnectionFactory;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .tokenStore(tokenStore());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients().tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("app")
                .scopes("all")
                .secret("secret")
                .autoApprove(false)
                .authorizedGrantTypes("authorization_code");
    }
}

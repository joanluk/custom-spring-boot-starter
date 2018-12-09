package org.emaginalabs.jwt.configure;

import org.emaginalabs.commons.TimeProvider;
import org.emaginalabs.security.jwt.TokenHelper;
import org.emaginalabs.security.jwt.auth.RestAuthenticationEntryPoint;
import org.emaginalabs.security.jwt.config.JwtWebSecurityConfig;
import org.emaginalabs.security.jwt.repository.UserRepository;
import org.emaginalabs.security.jwt.service.UserService;
import org.emaginalabs.security.jwt.service.impl.CustomUserDetailsService;
import org.emaginalabs.security.jwt.service.impl.UserServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "org.emaginalabs.security.jwt.repository")
@EntityScan(value = "org.emaginalabs.security.jwt.repository.model")
@Import(JwtWebSecurityConfig.class)
public class JwtAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public CustomUserDetailsService customUserDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    @ConditionalOnMissingBean
    public RestAuthenticationEntryPoint restAuthenticationEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

    @Bean
    @ConditionalOnMissingBean
    public TokenHelper tokenHelper() {
        return new TokenHelper();
    }

    @Bean
    @ConditionalOnMissingBean
    public TimeProvider timeProvider() {
        return new TimeProvider();
    }

    @Bean
    @ConditionalOnMissingBean
    public UserService userService(UserRepository userRepository) {
        return new UserServiceImpl(userRepository);

    }

}

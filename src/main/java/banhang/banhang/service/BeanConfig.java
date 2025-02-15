package banhang.banhang.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanConfig {
    @Bean("CS1")
    public CookieService getCookieService(){
        return new CookieService("abc");
    }

    @Bean("CS2")
    public CookieService getCookieService2(){
        return new CookieService("xyz");
    }

}

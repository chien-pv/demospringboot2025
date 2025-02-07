package banhang.banhang;

import java.time.Duration;
import java.util.Locale;

import org.apache.tomcat.util.descriptor.LocalResolver;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class MessageConfig implements WebMvcConfigurer {
    @Bean("messageSource")
    public MessageSource getMessageSource(){
        ReloadableResourceBundleMessageSource ms =  new ReloadableResourceBundleMessageSource();
        ms.setBasename("classpath:i18n/layout");
        ms.setDefaultEncoding("utf-8");
        return ms;
    }

    @Override
    public void addInterceptors( InterceptorRegistry registry){
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        registry.addInterceptor(interceptor);
    }

    @Bean("localeResolver")
    public CookieLocaleResolver getLocalResolver(){
        CookieLocaleResolver localeResolver =  new CookieLocaleResolver();
        localeResolver.setCookiePath("/");
        localeResolver.setCookieMaxAge(Duration.ofDays(20));
        localeResolver.setDefaultLocale(new Locale("vi"));
        return localeResolver;
    }
}

package codegym.configuration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.spi.ResourceBundleControlProvider;

@Configuration
public class ApplicatioinConfig {

    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("validate Mess");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
}

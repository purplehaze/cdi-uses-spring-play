package net.smart4life.cdiusesspringplay.config;

import net.smart4life.cdiusesspringplay.service.UserService;
import net.smart4life.cdiusesspringplay.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by roman on 19.03.2015.
 */
@Configuration
public class ServicesConfig {

    @Bean
    public UserService userService(){
        return new UserServiceImpl();
    }
}

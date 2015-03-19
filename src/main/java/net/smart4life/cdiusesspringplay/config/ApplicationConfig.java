package net.smart4life.cdiusesspringplay.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.*;


/**
 * Created by roman on 30.12.2014.
 */
@Configuration
@Import(ServicesConfig.class)
public class ApplicationConfig implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

//    @Bean
//    public CommonAnnotationBeanPostProcessor beanPostProcessor(){
//        return new CommonAnnotationBeanPostProcessor();
//    }
}

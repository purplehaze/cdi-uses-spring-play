package net.smart4life.cdiusesspringplay.cdi;

import net.smart4life.cdiusesspringplay.config.ApplicationConfig;
import net.smart4life.cdiusesspringplay.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

/**
 * Created by roman on 19.03.2015.
 */
public class SpringBeanProducer {

    private AnnotationConfigWebApplicationContext springCtx;

    @PostConstruct
    private void init(){
        springCtx = new AnnotationConfigWebApplicationContext();
        springCtx.register(ApplicationConfig.class);
        springCtx.refresh();
    }

//    private ApplicationContext getSpringContext(){
//        AnnotationConfigWebApplicationContext springCtx = new AnnotationConfigWebApplicationContext();
//        springCtx.register(ApplicationConfig.class);
//        springCtx.refresh();
//        return springCtx;
//    }

    @Produces
    @SpringBean
    @ApplicationScoped
    public UserService getUserService(){
        return springCtx.getBean(UserService.class);
    }
}

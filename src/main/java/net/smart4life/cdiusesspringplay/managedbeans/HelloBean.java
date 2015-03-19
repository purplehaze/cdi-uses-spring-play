package net.smart4life.cdiusesspringplay.managedbeans;

import net.smart4life.cdiusesspringplay.service.GreetingService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;


/**
 * Created by roman on 10.03.2015.
 */
@Named
@RequestScoped
public class HelloBean {
    @Inject
    private GreetingService greetingService;

    @PostConstruct
    public void init() {

    }

    private String name;

    public String send(){
        return "result.xhtml";
    }

    public String getGreeting()
    {
        return greetingService.createGreeting(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GreetingService getGreetingService() {
        return greetingService;
    }

    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
}

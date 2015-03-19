package net.smart4life.cdiusesspringplay.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by roman on 15.03.2015.
 */
@Named
@ApplicationScoped
public class NavigationController {

    public void redirect(String outcome){
        navigate(outcome, true);
    }

    public void navigate(String outcome, boolean redirect){
        navigate(outcome, redirect, null);
    }

    public void navigate(String outcome, boolean redirect, Map<String, String> params){
        FacesContext fCtx = FacesContext.getCurrentInstance();
        if(params == null){
            params = new HashMap<>();
        }
        params.put("faces-redirect", ""+redirect);
        StringBuilder sb = new StringBuilder();
        sb.append(outcome+"?");
        for(Map.Entry<String, String> entry: params.entrySet()){
            if(!sb.toString().endsWith("?")){
                sb.append("&");
            }
            sb.append(entry.getKey()+"="+entry.getValue());
        }
        NavigationHandler myNav = fCtx.getApplication().getNavigationHandler();
        myNav.handleNavigation(fCtx, null, sb.toString());
    }
}

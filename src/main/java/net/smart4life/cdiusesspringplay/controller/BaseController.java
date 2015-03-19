package net.smart4life.cdiusesspringplay.controller;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by roman on 06.03.2015.
 */
public abstract class BaseController implements Serializable {
    public static final String ID_PARAM = "id";

    @Inject
    private NavigationController navigationController;

    protected void navigate(String outcome, String idValue, boolean redirect){
        Map<String, String> params = new HashMap<>();
        params.put(ID_PARAM, idValue);

        navigationController.navigate(outcome, redirect, params);
    }

    protected String getIdAsString(){
        Map<String, String> paramMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String idStr = paramMap.get(ID_PARAM);
       return idStr;
    }
}

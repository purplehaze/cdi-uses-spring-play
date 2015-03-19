package net.smart4life.cdiusesspringplay.cdi;

import org.apache.deltaspike.jsf.api.config.JsfModuleConfig;
import org.apache.deltaspike.jsf.spi.scope.window.ClientWindowConfig;

import javax.enterprise.inject.Specializes;

/**
 * Created by roman on 16.03.2015.
 */
@Specializes
public class MyJsfModuleConfig extends JsfModuleConfig
{
    @Override
    public ClientWindowConfig.ClientWindowRenderMode getDefaultWindowMode()
    {
        return ClientWindowConfig.ClientWindowRenderMode.CLIENTWINDOW;
    }
}
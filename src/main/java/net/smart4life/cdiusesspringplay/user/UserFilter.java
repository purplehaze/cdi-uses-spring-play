package net.smart4life.cdiusesspringplay.user;


import net.smart4life.cdiusesspringplay.datamodel.BaseFilter;

/**
 * Created by roman on 06.03.2015.
 */
public class UserFilter extends BaseFilter {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

package net.smart4life.cdiusesspringplay.service;

import net.smart4life.cdiusesspringplay.entity.User;
import net.smart4life.cdiusesspringplay.user.UserFilter;

import java.util.List;

/**
 * Created by roman on 18.03.2015.
 */
public interface UserService extends DataModelFindAble<User, UserFilter>{
    List<User> getUsers();
    User getById(Long id);
}

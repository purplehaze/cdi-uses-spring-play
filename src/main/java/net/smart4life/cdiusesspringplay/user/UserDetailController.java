package net.smart4life.cdiusesspringplay.user;

import net.smart4life.cdiusesspringplay.cdi.SpringBean;
import net.smart4life.cdiusesspringplay.controller.BaseController;
import net.smart4life.cdiusesspringplay.controller.NavigationController;
import net.smart4life.cdiusesspringplay.entity.User;
import net.smart4life.cdiusesspringplay.service.UserService;
import net.smart4life.cdiusesspringplay.service.UserServiceImpl;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by roman on 16.02.2015.
 */
@Named
@ViewAccessScoped
public class UserDetailController extends BaseController implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(UserDetailController.class);
    public static final String PAGE_LIST = "userList.xhtml";

    @Inject
    @SpringBean
    private UserService userService;

	@Inject
	private UserListController userListController;

	@Inject
	private UserFilterController userFilterController;

    @Inject
    private NavigationController navigationController;

    @PostConstruct
    private void init(){
        String idStr = getIdAsString();
        if(idStr != null && !idStr.isEmpty()) {
            Long id = Long.parseLong(idStr);
            entity = userService.getById(id);
        }

		User selElem = userListController.getSelectedElement();
		logger.debug("selectedElement={}", selElem);
		UserFilter uf = userFilterController.getFilter();
		logger.debug("userFilter.name={}", uf.getName());
    }

   private User entity;

    public User getEntity() {
        return entity;
    }

    public void setEntity(User entity) {
        this.entity = entity;
    }

    public void save(){
        logger.debug("do save()");
    }

    public void toList(){
        navigationController.navigate(PAGE_LIST, true);
    }
}

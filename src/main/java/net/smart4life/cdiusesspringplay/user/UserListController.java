package net.smart4life.cdiusesspringplay.user;

import net.smart4life.cdiusesspringplay.cdi.SpringBean;
import net.smart4life.cdiusesspringplay.controller.BaseController;
import net.smart4life.cdiusesspringplay.datamodel.GenericLazyDataModel;
import net.smart4life.cdiusesspringplay.entity.User;
import net.smart4life.cdiusesspringplay.service.UserService;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.primefaces.event.SelectEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.faces.model.DataModel;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by roman on 16.02.2015.
 */
@Named
@ViewAccessScoped
public class UserListController extends BaseController implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(UserListController.class);

    public static final String PAGE_DETAIL = "userDetail.xhtml";

    @Inject
    @SpringBean
    private UserService userService;

    @Inject
    private UserFilterController userFilterController;

    private User selectedElement;
    private DataModel<User> dataModel;

    @PostConstruct
    private void init(){
        createDataModel();
    }

	// create non lazy data model
//	private void createDataModel(){
//		List<User> users = userService.getUsers();
//		String name = userFilterController.getFilter().getName();
//		if(name != null && !name.isEmpty()){
//			List<User> tmp = new ArrayList<>();
//			for (User u : users){
//				if(u.getLoginname().toLowerCase().startsWith(name.toLowerCase())){
//					tmp.add(u);
//				}
//			}
//			users = tmp;
//		}
//		dataModel = new GenericIdableListDataModel<>(users);
//	}

	// create lazy data model
	private void createDataModel(){
		dataModel = new GenericLazyDataModel(userService) {
			@Override
			public UserFilter getFilter() {
				return userFilterController.getFilter();
			}
		};
	}

    public void onRowSelect(SelectEvent event) {
        User u = (User) event.getObject();

        navigate(PAGE_DETAIL, ""+selectedElement.getId(), true);
    }

    public void search(){
        createDataModel();
    }

    public void reset(){
        userFilterController.reset();
        search();
    }

    public User getSelectedElement() {
        return selectedElement;
    }

    public void setSelectedElement(User selectedElement) {
        this.selectedElement = selectedElement;
    }

    public DataModel<User> getDataModel() {
        return dataModel;
    }
}

package net.smart4life.cdiusesspringplay.user;

import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.primefaces.model.SortOrder;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by roman on 06.03.2015.
 */
@Named
@ViewAccessScoped
public class UserFilterController implements Serializable {

    private UserFilter filter;
	private String sortField;
	private String sortOrder = SortOrder.ASCENDING.name();

    @PostConstruct
    private void init(){
        filter = new UserFilter();
    }

    public void reset(){
        init();
    }

    public UserFilter getFilter() {
        return filter;
    }

    public void setFilter(UserFilter filter) {
        this.filter = filter;
    }

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}
}

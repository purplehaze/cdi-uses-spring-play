package net.smart4life.cdiusesspringplay.service;


import net.smart4life.cdiusesspringplay.datamodel.BaseFilter;
import net.smart4life.cdiusesspringplay.entity.Idable;

import java.util.List;

/**
 * Created by ILIN02 on 09.03.2015.
 */
public interface DataModelFindAble<T extends Idable, F extends BaseFilter> {

	List<T> findByFilter(F filter, int first, int pageSize);
	Long countByFilter(F filter);
}

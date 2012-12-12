package org.travelplan.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.travelplan.dao.CommonDAO;
import org.travelplan.dao.CostsDAO;
import org.travelplan.service.CommonService;

public class CommonServiceImpl<T extends CommonDAO> implements CommonService<T> {
	
	@Inject
    private T objDAO;
	
	@SuppressWarnings("unchecked")
	public List<T> getList() {
		return objDAO.getList();
	}

	@SuppressWarnings("unchecked")
	public void add(T obj) {
		objDAO.add(obj);
	}

	public void remove(Integer id) {
		objDAO.remove(id);		
	}

	@SuppressWarnings("unchecked")
	public void update(T obj) {
		objDAO.update(obj);
	}

	@SuppressWarnings("unchecked")
	public T findById(Integer id) {
		return (T) objDAO.findById(id);
	}
	

}

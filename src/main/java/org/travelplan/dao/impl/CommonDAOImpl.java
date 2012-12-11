package org.travelplan.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.travelplan.dao.CommonDAO;
import org.travelplan.entity.Costs;

@Transactional
public class CommonDAOImpl<T> implements CommonDAO<T>  {
	
    @Autowired
    private SessionFactory sessionFactory;
    
    private Class<T> ClassType;
    
    public Session getSession() {
    	return sessionFactory.getCurrentSession();
    }

	public void add(T obj) {
		getSession().save(obj);		
	}

	@SuppressWarnings("unchecked")
	public List<T> getList() {
		return getSession().createCriteria(ClassType).list();
	}
	
	@SuppressWarnings("unchecked")
	public void remove(Integer id) {		
		T obj = (T) getSession().get(ClassType, id);
        if (obj != null)
          getSession().delete(obj);	
	}

	public void update(T obj) {
		getSession().update(obj);		
	}

	public T findById(Integer id) {
       return ClassType.cast(getSession().get(ClassType, id));
	}
	
	public T findById(Class<T> cls, Integer id) {
	       return ClassType.cast(getSession().get(cls, id));
		}	
}

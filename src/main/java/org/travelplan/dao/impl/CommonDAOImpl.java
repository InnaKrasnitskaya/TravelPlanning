package org.travelplan.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.travelplan.dao.CommonDAO;

@Transactional
public class CommonDAOImpl<T> implements CommonDAO<T>  {
	
    @Autowired
    private SessionFactory sessionFactory;
    
    private Class<T> ClassType;
    
    public CommonDAOImpl(Class<T> classType) {
    	ClassType = classType;
    }
    
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
	public List<T> getList(boolean ascOrder, String fieldOrder) {
		Order order;
		if (ascOrder)
			order = Order.asc(fieldOrder);
		else
			order = Order.desc(fieldOrder);
        return (List<T>) getSession().createCriteria(ClassType).
        		addOrder(order).list();
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
	
	@SuppressWarnings("unchecked")
	public T findById(Integer id) {
	   return (T) getSession().get(ClassType, id);
	}	
}

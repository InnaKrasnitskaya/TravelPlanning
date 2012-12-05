package org.travelplan.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.travelplan.dao.CityDAO;
import org.travelplan.entity.City;

@Repository("cityDAO")
@Transactional
public class CityDAOImpl implements CityDAO {
	
	private static final String CitySelect = "SELECT p FROM City p ";
	private static final String CityOrder = "ORDER BY name DESC";
	private static final String CityIdCondition = " where idCity=%d";
	
    @Autowired
    private SessionFactory sessionFactory;	
	
    @SuppressWarnings("unchecked")
	public List<City> getList() {
        return sessionFactory.getCurrentSession().
        		createQuery(CitySelect.concat(CityOrder)).list();		
	}
    
    public void add(City city) {
    	sessionFactory.getCurrentSession().save(city);
    }
    
    public void update(City city) {
    	sessionFactory.getCurrentSession().update(city);
    }    
    
    public void remove(Integer id) {
        City city = (City) sessionFactory.
        		getCurrentSession().load(City.class, id);
        if (null !=city) {
          sessionFactory.getCurrentSession().delete(city);
        }    	
    }
    
    public City findById(Integer id) {
        return (City) sessionFactory.getCurrentSession().createQuery(
        		CitySelect.concat(String.format(CityIdCondition, id))).uniqueResult();    	
    }
}

package org.travelplan.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.travelplan.dao.CostsDAO;
import org.travelplan.entity.Costs;
import org.travelplan.entity.CostsList;
import org.travelplan.entity.TravelRoute;

@Repository("costsDAO")
@Transactional
public class CostsDAOImpl extends CommonDAOImpl<Costs> implements CostsDAO {

	private static final String CostsSelect = "SELECT c FROM Costs c";
	private static final String IdTravelRouteCond = " JOIN c.travelRoute tr WHERE tr.idTravelRoute=%d";
	
   /* @Autowired
    private SessionFactory sessionFactory;	 
	
    @SuppressWarnings("unchecked")
	public List<Costs> getList() {
        //return sessionFactory.getCurrentSession().createQuery(CostsSelect).list();
    	return sessionFactory.getCurrentSession().createCriteria(Costs.class).list();
	}
    
    public void add(Costs costs) {
    	sessionFactory.getCurrentSession().save(costs);
    }
    
    public void update(Costs Costs) {
    	sessionFactory.getCurrentSession().update(Costs);
    }    
    
    public void remove(Integer id) {
        Costs costs = (Costs) sessionFactory.
        		getCurrentSession().load(Costs.class, id);
        if (null != costs) {
          sessionFactory.getCurrentSession().delete(costs);
        }    	
    }
    
 
    public Costs findById(Integer id) {
    	return (Costs) sessionFactory.getCurrentSession().get(Costs.class, id);
       // return (Costs)sessionFactory.getCurrentSession().
       // 	createCriteria(Costs.class).add(Restrictions.sqlRestriction("\"IdCosts\" = ".concat(id.toString()))).uniqueResult();  
       // return (Costs)sessionFactory.getCurrentSession().createQuery(
            	//CostsSelect.concat(String.format(IdCostsCond, id))).uniqueResult();  
    }*/
	
    @SuppressWarnings("unchecked")
    public List<Costs> findByTravelRoute(Integer idTravelRoute) {
        return getSession().createQuery(
        	CostsSelect.concat(String.format(IdTravelRouteCond, idTravelRoute))).list();      	
    }	
}

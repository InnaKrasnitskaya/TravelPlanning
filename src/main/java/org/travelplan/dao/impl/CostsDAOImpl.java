package org.travelplan.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.travelplan.dao.CostsDAO;
import org.travelplan.entity.Costs;

@Repository("costsDAO")
@Transactional
public class CostsDAOImpl implements CostsDAO {

	private static final String CostsSelect = "SELECT c FROM Costs c";
	private static final String IdTravelRouteCond = " JOIN c.travelRoute tr WHERE tr.idTravelRoute=%d";
	private static final String IdCostsCond = " WHERE idCosts=%d";
	
    @Autowired
    private SessionFactory sessionFactory;	
	
    @SuppressWarnings("unchecked")
	public List<Costs> getList() {
        return sessionFactory.getCurrentSession().createQuery(CostsSelect).list();		
	}
    
    public void add(Costs costs) {
    	sessionFactory.getCurrentSession().save(costs);
    }
    
    public void update(Costs Costs) {
    	sessionFactory.getCurrentSession().update(Costs);
    }    
    
    public void remove(Integer id) {
        Costs Costs = (Costs) sessionFactory.
        		getCurrentSession().load(Costs.class, id);
        if (Costs != null) {
          sessionFactory.getCurrentSession().delete(Costs);
        }    	
    }
    
    @SuppressWarnings("unchecked")
    public List<Costs> findByTravelRoute(Integer idTravelRoute) {
        return sessionFactory.getCurrentSession().createQuery(
        	CostsSelect.concat(String.format(IdTravelRouteCond, idTravelRoute))).list();      	
    }
    
    public Costs findById(Integer id) {
        return (Costs)sessionFactory.getCurrentSession().createQuery(
            	CostsSelect.concat(String.format(IdCostsCond, id))).uniqueResult();  
    }
}

package org.travelplan.dao.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.travelplan.dao.CostsDAO;
import org.travelplan.entity.Costs;

@Repository("costsDAO")
@Transactional
public class CostsDAOImpl extends CommonDAOImpl<Costs> implements CostsDAO {
	
	public CostsDAOImpl() {
		super(Costs.class);
	}
	
    @SuppressWarnings("unchecked")
    public List<Costs> findByTravelRoute(Integer idTravelRoute) {
    	return (List<Costs>) getSession().createCriteria(Costs.class).
    			createAlias("travelRoute", "tr").
    			createAlias("costsList", "cl").
    			add(Restrictions.eq("tr.idTravelRoute", idTravelRoute)).
    			addOrder(Order.asc("cl.name")).
    			list();
    }	
}

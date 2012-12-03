package org.travelplan.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.travelplan.dao.CostsListDAO;
import org.travelplan.entity.CostsList;

@Repository("costsListDAO")
@Transactional
public class CostsListDAOImpl implements CostsListDAO {
	private static final String CostsListSelect = "SELECT cl FROM CostsList cl";
	private static final String NameCond = " WHERE cl.name=%s";
	
    @Autowired
    private SessionFactory sessionFactory;	
	
	public void add(CostsList costsList) {
		sessionFactory.getCurrentSession().save(costsList);
	}
	
	public Integer findByName(String name) {
		return ((CostsList)sessionFactory.getCurrentSession().createQuery(
			CostsListSelect.concat(String.format(NameCond, name))).list().get(0)).getIdCostsList();
	}

}

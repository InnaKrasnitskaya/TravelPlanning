package org.travelplan.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.travelplan.dao.CostsListDAO;
import org.travelplan.entity.CostsList;

@Repository("costsListDAO")
@Transactional
public class CostsListDAOImpl extends CommonDAOImpl<CostsList> implements CostsListDAO {
	
	public CostsListDAOImpl() {
		super(CostsList.class);
	}

	public Integer getId(String name) {
		return (Integer)getSession().createCriteria(CostsList.class).
				add(Restrictions.eq("name", name)).list().get(0);
	}

}

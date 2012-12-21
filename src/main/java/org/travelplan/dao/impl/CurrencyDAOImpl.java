package org.travelplan.dao.impl;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.travelplan.dao.CurrencyDAO;
import org.travelplan.entity.Currency;

@Repository("currencyDAO")
@Transactional
public class CurrencyDAOImpl extends CommonDAOImpl<Currency> implements CurrencyDAO{

	public CurrencyDAOImpl() {
		super(Currency.class);
	}
	
	public Currency findByValue(String value) {
		return (Currency) getSession().createCriteria(Currency.class).
		  add(Restrictions.eq("value", value)).list().get(0);
	}

}

package org.travelplan.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import org.travelplan.dao.CurrencyDAO;
import org.travelplan.entity.Currency;
import org.travelplan.service.CurrencyService;

@Named
@Scope("session")
public class CurrencyServiceImpl implements CurrencyService {
	
	@Inject
	private CurrencyDAO currencyDAO;
	
	public void add(Currency currency) {
		currencyDAO.add(currency);
	}
	
	public List<Currency> getList() {
		return currencyDAO.getList();
	}

	public void remove(Integer id) {
		currencyDAO.remove(id);		
	}

	public void update(Currency obj) {
		currencyDAO.update(obj);		
	}

	public Currency findById(Integer id) {
		return currencyDAO.findById(id);
	}
	
	public Currency findByValue(String value) {
		return currencyDAO.findByValue(value);
	}	
}

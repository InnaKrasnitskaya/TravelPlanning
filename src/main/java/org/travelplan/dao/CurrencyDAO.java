package org.travelplan.dao;

import org.travelplan.entity.Currency;

public interface CurrencyDAO extends CommonDAO<Currency> {
	public Currency findByValue(String value);

}
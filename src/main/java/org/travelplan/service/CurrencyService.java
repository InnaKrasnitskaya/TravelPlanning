package org.travelplan.service;

import org.travelplan.entity.Currency;

public interface CurrencyService extends CommonService<Currency> {
	public Currency findByValue(String value);
}

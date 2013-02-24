package org.travelplan.bean;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import org.travelplan.entity.Currency;
import org.travelplan.service.CurrencyService;

@Named
@Scope("session")
public class CurrencyBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	CurrencyService currencyService;

	public List<Currency> getList() {
		return currencyService.getList();
	}		
}

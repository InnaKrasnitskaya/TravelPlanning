package org.travelplan.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;
import org.springframework.context.annotation.Scope;
import org.travelplan.entity.Costs;
import org.travelplan.entity.CostsList;
import org.travelplan.service.CostsListService;
import org.travelplan.service.CostsService;
import org.travelplan.service.CurrencyService;
import org.travelplan.service.TravelRouteService;

@Named
@Scope("session")
public class CostsBean {
		
	private String currencyValue;
	private String currencySumPlace;
	private String currencySum;
	private Costs costs;
	private CostsList costsList;

	@Inject
	private CostsService costsService;
	
	@Inject
	private TravelRouteService travelRoute;
	
	@Inject
	private CostsListService costsListService;
	
	@Inject
	private CurrencyService currencyService;
	
	public CostsBean() {
		currencySumPlace = "USD"; //default value
		currencySum = "USD";
	}
	
	private void update(Costs costs) {
		costs.setCurrency(currencyService.findByValue(currencyValue));
		costsService.update(costs);
	}

	public String getCurrencySumPlace() {
		return currencySumPlace;
	}

	public void setCurrencySumPlace(String currencySumPlace) {
		this.currencySumPlace = currencySumPlace;
	}	

	public String getCurrencySum() {
		return currencySum;
	}

	public void setCurrencySum(String currencySum) {
		this.currencySum = currencySum;
	}
	
	public Costs getCosts() {
		if (costs == null)
			costs = new Costs();
		return costs;	
	}
	
	public void setCosts(Costs costs) {
		this.costs = costs; 
		currencyValue = costs.getCurrency().getValue();
	}
	
	public CostsList getCostsList() {
		if (costsList == null)
			costsList = new CostsList();
		return costsList;	
	}	
	
	public void newData(ActionEvent actionEvent){
		costs = new Costs();
	}	
	
	public void add(ActionEvent actionEvent) {
		costs.setTravelRoute(travelRoute.findById(69));
		costsListService.add(costsList);
		costs.setCostsList(costsList);
		costs.setCurrency(currencyService.findByValue(currencyValue));
		costsService.add(costs);		
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("", "Запись сохранена"));
	}
	
	public String getCurrencyValue() {
		return currencyValue;
	}

	public void setCurrencyValue(String currency) {
		this.currencyValue = currency;
	}	
	
	public Float getSumTravelRoute(Integer idTravelRoute) {
		return costsService.getSumTravelRoute(currencySumPlace, idTravelRoute);
	}
	
	public Float getSum(Integer idProfile) {
		return costsService.getSum(currencySum, idProfile);
	}
	
	public void onEdit(RowEditEvent event) {  
		update(costs);
        FacesMessage msg = new FacesMessage("Costs edited", 
        		((Costs) event.getObject()).getCostsList().getName());   
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  
	
	public void onEditCancel(RowEditEvent event) {  
        FacesMessage msg = new FacesMessage("Costs cancelled", 
        		((Costs) event.getObject()).getCostsList().getName());    
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    } 
}

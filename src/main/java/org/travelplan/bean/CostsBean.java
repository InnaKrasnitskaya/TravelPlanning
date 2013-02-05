package org.travelplan.bean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessException;
import org.travelplan.entity.Costs;
import org.travelplan.entity.CostsList;
import org.travelplan.service.CostsListService;
import org.travelplan.service.CostsService;
import org.travelplan.service.CurrencyService;
import org.travelplan.service.TravelRouteService;

@Named
@Scope("session")
public class CostsBean {
		
	private String name;
	private float price;
	private String note;
	private boolean prAdd;
	private String currencyValue;
	private String currencySumPlace;
	private String currencySum;
	
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
	
	public boolean isPrAdd() {
		return prAdd;
	}

	public void setPrAdd(boolean prAdd) {
		this.prAdd = prAdd;
	}	

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
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

	public void add() {
		prAdd = true;
	}
	
	public void clear(){
		prAdd = false;
	}
	
	public void update(Costs costs) {
		setData(costs);
		costsService.update(costs);
	}
	
	public void onBeforeEdit(Integer idCosts) {
		Costs costs = costsService.findById(idCosts);
		if (costs != null) {
			price = costs.getPrice();
			note = costs.getNote();
			currencyValue = costs.getCurrency().getValue();
		}		
	}
	
	private void setData(Costs costs) {
		costs.setNote(note);
		costs.setPrice(price);	
		costs.setCurrency(currencyService.findByValue(currencyValue));
		if (prAdd) {
		  CostsList costsList = new CostsList();
		  costsList.setName(name);
		  costsListService.add(costsList);	
		  costs.setCostsList(costsList);
		}			
	}
	
	public void save(Integer idTravelRoute) {
    	try {
    		if (prAdd) {
    			Costs costs = new Costs();
    			costs.setTravelRoute(travelRoute.findById(idTravelRoute));
    			setData(costs);
    			costsService.add(costs);
    			prAdd = false;    			
    		} 		
    	}
    	catch (DataAccessException e) {
    		e.printStackTrace();    	
    	}		
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
		update((Costs) event.getObject());
        FacesMessage msg = new FacesMessage("Costs edited", ((Costs) event.getObject()).getCostsList().getName());   
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }  

}

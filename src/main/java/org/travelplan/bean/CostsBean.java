package org.travelplan.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import org.travelplan.entity.Costs;
import org.travelplan.entity.CostsList;
import org.travelplan.entity.Currency;
import org.travelplan.service.CostsListService;
import org.travelplan.service.CostsService;
import org.travelplan.service.CurrencyService;
import org.travelplan.service.TravelRouteService;

@Named
@Scope("session")
public class CostsBean {
		
	private String currencySumPlace;
	private String currencySum;
	private Costs selectedCosts;
	private boolean addingData; 
	private int idTravelRoute;

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
	
	public Costs getSelectedCosts() {
		if (selectedCosts == null) {
			selectedCosts = new Costs();
			selectedCosts.setCostsList(new CostsList());
			selectedCosts.setCurrency(new Currency());
		}
		return selectedCosts;	
	}
	
	public void setSelectedCosts(Costs selectedCosts) {
		this.selectedCosts = selectedCosts; 
	}
	
	public void newData(int idTravelRoute){
		addingData = true;
   	    selectedCosts = null;
		this.idTravelRoute = idTravelRoute; 
	}	
	
	public void deleteData(ActionEvent actionEvent) {
		Integer selectedId = selectedCosts.getIdCosts(); 
		if (selectedId != null) 
		  costsService.remove(selectedId);
		
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("", "Запись удалена"));
	}
	
	public List<String> getCostsNameList() {
		List<String> costsNameList = new ArrayList<String>();
		for (int i = 0; i < costsListService.getList().size(); i++)
			costsNameList.add(costsListService.getList().get(i).getName());
		return costsNameList;
	}
	
	public void saveCosts(ActionEvent actionEvent) {
		Integer idCostsList = costsListService.getId(selectedCosts.getCostsList().getName());
		if (idCostsList == null) {
			costsListService.add(selectedCosts.getCostsList());
			selectedCosts.setCostsList(selectedCosts.getCostsList());
		} else
			selectedCosts.setCostsList(costsListService.findById(idCostsList));
		
		selectedCosts.setCurrency(currencyService.findByValue(selectedCosts.getCurrency().getValue()));
		
		if (addingData) {
			selectedCosts.setTravelRoute(travelRoute.findById(idTravelRoute));		
			costsService.add(selectedCosts);
		}
		else 
			costsService.update(selectedCosts);

		addingData = false;
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("", "Запись сохранена"));
	}		
	
	public Float getSumTravelRoute(Integer idTravelRoute) {
		return costsService.getSumTravelRoute(currencySumPlace, idTravelRoute);
	}
	
	public Float getSum(Integer idProfile) {
		return costsService.getSum(currencySum, idProfile);
	}
}

package org.travelplan.bean;

import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;
import org.travelplan.dao.CostsDAO;
import org.travelplan.entity.Costs;
import org.travelplan.service.TravelRouteService;


@Named
@Scope("session")
public class CostsBean {
		
	private String name;
	private float price;
	private String note;
	private boolean isAdd;
	
	@Inject
	private CostsDAO costsDAO;
	
	@Inject
	private TravelRouteService travelRoute;
	
	public boolean isAdd() {
		return isAdd;
	}

	public void setAdd(boolean isAdd) {
		this.isAdd = isAdd;
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
	
	public void add() { //
		/*newCosts = new Costs();
		costsDAO.add(newCosts);*/
		isAdd = true;
	}
	
	public void save(Integer idTravelRoute) {	
		Costs costs = new Costs();
		costs.setTravelRoute(travelRoute.findById(idTravelRoute));
		costs.setNote(note);
		costs.setPrice(price);
		costsDAO.add(costs);
		isAdd = false;
	}
}

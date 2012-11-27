package org.travelplan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "\"Costs\"")
public class Costs {
	
    @Id
    @Column(name = "\"IdCosts\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer idCosts;
    
    @ManyToOne
	@JoinColumn(name="\"IdTravelRoute\"")
    private TravelRoute travelRoute;
    
    @ManyToOne
	@JoinColumn(name="\"IdCostsList\"")
    private CostsList costsList;    
    
    @Column(name = "\"Price\"")
    private Integer price;
    
    @Column(name = "\"Note\"")
    private Integer note;

	public Integer getIdCosts() {
		return idCosts;
	}

	public void setIdCosts(Integer idCosts) {
		this.idCosts = idCosts;
	}

	public TravelRoute getTravelRoute() {
		return travelRoute;
	}

	public void setTravelRoute(TravelRoute travelRoute) {
		this.travelRoute = travelRoute;
	}

	public CostsList getCostsList() {
		return costsList;
	}

	public void setCostsList(CostsList costsList) {
		this.costsList = costsList;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	} 
}

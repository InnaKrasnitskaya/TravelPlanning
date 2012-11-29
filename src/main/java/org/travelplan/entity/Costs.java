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
    private float price;
    
    @Column(name = "\"Note\"")
    private String note;

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
}

package org.travelplan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "\"CostsList\"")
public class CostsList {
	
    @Id
    @Column(name = "\"IdCostsList\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer idCostsList;
    
	@Column(name = "\"Name\"")
	@NotNull
    private String name;

    public Integer getIdCostsList() {
		return idCostsList;
	}

	public void setIdCostsList(Integer idCostsList) {
		this.idCostsList = idCostsList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

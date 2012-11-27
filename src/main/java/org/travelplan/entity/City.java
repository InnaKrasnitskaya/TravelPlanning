package org.travelplan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"City\"")
public class City {

    @Id
    @Column(name = "\"IdCity\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer idCity;
    
	@Column(name = "\"Name\"")
    private String name;
	
	public City() {}

    public Integer getIdCity() {
		return idCity;
	}

	public void setIdCity(Integer idCity) {
		this.idCity = idCity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

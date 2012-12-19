package org.travelplan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"Currency\"")
public class Currency {

    @Id
    @Column(name = "\"IdCurrency\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer idCurrency;	
    
    @Column(name = "\"Name\"")
    private String name;
    
    @Column(name = "\"Value\"")
    private String value;

	public Integer getIdCurrency() {
		return idCurrency;
	}

	public void setIdCurrency(Integer idCurrency) {
		this.idCurrency = idCurrency;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}    
}

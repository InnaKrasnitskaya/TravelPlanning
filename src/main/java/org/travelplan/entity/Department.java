package org.travelplan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"Department\"")
public class Department {

    @Id
    @Column(name = "\"IdDepartment\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer idDepartment;
    
    @Column(name = "\"Name\"")
    private String name;

	public Integer getIdDepartment() {
		return idDepartment;
	}

	public void setIdDepartment(Integer idDepartment) {
		this.idDepartment = idDepartment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
     
}

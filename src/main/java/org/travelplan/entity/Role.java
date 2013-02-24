package org.travelplan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "\"Role\"")
public class Role {
	
    @Id
    @Column(name = "\"IdRole\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer idRole;

    @Column(name = "\"Name\"")
    @NotNull
    private String name;
    
    public Role() {}   
    
    public void setIdRole(Integer idRole) {
    	this.idRole = idRole;
    }     
     
    public Integer getIdRole() {
    	return idRole;
    }         
    
    public void setName(String name) {
    	this.name = name;
    }    

    public String getName() {
    	return name;
    }
    
}

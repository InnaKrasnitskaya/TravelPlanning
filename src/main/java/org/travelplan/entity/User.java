package org.travelplan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "\"User\"")
public class User {

    @Id
    @Column(name = "\"IdUser\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer idUser;

    @Column(name = "\"Name\"")
    @NotNull
    private String name;

    @Column(name = "\"Password\"")
    @Size(min = 5, max = 20)
    @NotNull
    private String password;
    
    @Column(name = "\"Email\"")
    private String email;
    
	public User() {}     
     
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
   
    public void setIdUser(Integer idUser) {
    	this.idUser = idUser;
    }     
     
    public Integer getIdUser() {
    	return idUser;
    }         
    
    public void setName(String name) {
    	this.name = name;
    }    

    public String getName() {
    	return name;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }       
    
    public String getPassword() {
    	return password;
    }
}
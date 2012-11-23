package org.travelplan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"User\"")
public class User {

    @Id
    @Column(name = "\"IdUser\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer idUser;

    @Column(name = "\"Name\"")
    private String name;

    @Column(name = "\"Password\"")
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
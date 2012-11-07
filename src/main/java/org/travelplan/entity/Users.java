package org.travelplan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"Users\"")
public class Users {

    @Id
    @Column(name = "\"IdUser\"")
    @GeneratedValue
    private Integer idUser;

    @Column(name = "\"Name\"")
    private String name;

    @Column(name = "\"Password\"")
    private String password;
    
    public Users() {}   
    
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
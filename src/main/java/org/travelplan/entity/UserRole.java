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
@Table(name = "\"UserRole\"")
public class UserRole {

    @Id
    @Column(name = "\"IdUserRole\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUserRole;	
    
 /*   @Column(name = "\"IdUser\"")
    private Integer idUser;	  
    
    @Column(name = "\"IdRole\"")
    private Integer idRole;	   */ 
    
    @ManyToOne
	@JoinColumn(name="\"IdUser\"")
	private User user;    
    
    @ManyToOne
	@JoinColumn(name="\"IdRole\"")
	private Role role;     
    
    public UserRole() {}     
    
    public void setIdUserRole(Integer IdUserRole) {
    	this.idUserRole = IdUserRole;
    }     
     
    public Integer getIdUserRole() {
    	return idUserRole;
    }   
    
	public User getUser() {
		return user;
	}    
	
	public Role getRole() {
		return role;
	}   	
    
 /*   public void setIdUser(Integer IdUser) {
    	this.idUser = IdUser;
    }     
     
    public Integer getIdUser() {
    	return idUser;
    }   
    
    public void setIdRole(Integer IdRole) {
    	this.idRole = IdRole;
    }     
     
    public Integer getIdRole() {
    	return idRole;
    }       */
}

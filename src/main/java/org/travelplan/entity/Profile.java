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
@Table(name = "\"Profile\"")
public class Profile {
	
    @Id
    @Column(name = "\"IdProfile\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProfile;	

    @Column(name = "\"Name\"")
    private String name;

	@Column(name = "\"CreationDate\"")
    private String creationDate;    
	
    @ManyToOne
	@JoinColumn(name="\"IdUser\"")
    private User user;  	
    
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Profile() {} 
    
    public Integer getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(Integer idProfile) {
		this.idProfile = idProfile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}       
}

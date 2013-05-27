package org.travelplan.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "\"ProfileUser\"")
public class ProfileUser {
	
    @ManyToOne
	@JoinColumn(name="\"IdProfile\"")
    private Profile idProfile;
    
    @ManyToOne
	@JoinColumn(name="\"IdUser\"")
    private Profile idUser;

	public Profile getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(Profile idProfile) {
		this.idProfile = idProfile;
	}

	public Profile getIdUser() {
		return idUser;
	}

	public void setIdUser(Profile idUser) {
		this.idUser = idUser;
	}
}

package org.travelplan.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "\"ProfileEmployee\"")
public class ProfileEmployee {
	
    @ManyToOne
	@JoinColumn(name="\"IdProfile\"")
    private Profile idProfile;
    
    @ManyToOne
	@JoinColumn(name="\"IdEmployee\"")
    private Profile idEmployee;

	public Profile getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(Profile idProfile) {
		this.idProfile = idProfile;
	}

	public Profile getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(Profile idEmployee) {
		this.idEmployee = idEmployee;
	}    
    
}

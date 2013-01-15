package org.travelplan.entity;

import java.text.ParseException;
import java.util.Date;
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
    private Date creationDate;    
	
	@Column(name = "\"StartDate\"")
    private Date startDate;    
	
	@Column(name = "\"EndDate\"")
    private Date endDate; 
	
    @ManyToOne
	@JoinColumn(name="\"IdUser\"")
    private User user; 
    
	@Column(name = "\"Price\"")
    private Float price;
	
	@Column(name = "\"PeopleCount\"")
    private Integer peopleCount;

    @ManyToOne
	@JoinColumn(name="\"IdCurrency\"")
    private Currency currency; 
    
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}	
    
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

	public Date getCreationDate() throws ParseException {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getPeopleCount() {
		return peopleCount;
	}

	public void setPeopleCount(Integer peopleCount) {
		this.peopleCount = peopleCount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
}

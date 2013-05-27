package org.travelplan.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "\"Employee\"")
public class Employee {
	
    @Id
    @Column(name = "\"IdEmployee\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer idEmployee;
    
    @ManyToOne
	@JoinColumn(name="\"IdDepartment\"")
    private Department idDepartment;
    
    @Column(name = "\"Surname\"")
    private String surname;  
    
    @Column(name = "\"Name\"")
    private String name;
    
    @Column(name = "\"LastName\"")
    private String lastName;            
    	
    @Column(name = "\"PassportSeria\"")
    private String passportSeria;        
    
    @Column(name = "\"PassportNumber\"")
    private String passportNumber;  
    
    @Column(name = "\"PassportProducer\"")
    private String passportProducer;       
    
    @Column(name = "\"PassportStartDate\"")
    private Date passportStartDate;   
    
    @Column(name = "\"PassportEndDate\"")
    private Date passportEndDate;       

    @Column(name = "\"Active\"")
    private boolean active;

	public Integer getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(Integer idEmployee) {
		this.idEmployee = idEmployee;
	}

	public Department getIdDepartment() {
		return idDepartment;
	}

	public void setIdDepartment(Department idDepartment) {
		this.idDepartment = idDepartment;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassportSeria() {
		return passportSeria;
	}

	public void setPassportSeria(String passportSeria) {
		this.passportSeria = passportSeria;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getPassportProducer() {
		return passportProducer;
	}

	public void setPassportProducer(String passportProducer) {
		this.passportProducer = passportProducer;
	}

	public Date getPassportStartDate() {
		return passportStartDate;
	}

	public void setPassportStartDate(Date passportStartDate) {
		this.passportStartDate = passportStartDate;
	}

	public Date getPassportEndDate() {
		return passportEndDate;
	}

	public void setPassportEndDate(Date passportEndDate) {
		this.passportEndDate = passportEndDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}     
    
    
}

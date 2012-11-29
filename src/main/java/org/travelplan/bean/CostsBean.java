package org.travelplan.bean;

import javax.inject.Named;
import org.springframework.context.annotation.Scope;

@Named
@Scope("session")
public class CostsBean {
	
	private String name;
	private float price;
	private String note;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}

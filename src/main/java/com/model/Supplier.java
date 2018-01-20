package com.model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@SuppressWarnings("serial")
@Component
@Entity
public class Supplier implements Serializable{
	
	@Id
	@GeneratedValue
	int sid;
	String supname;
	
	@OneToMany(targetEntity=Product.class,fetch=FetchType.EAGER, mappedBy="supplier")
	private Set<Product> product = new HashSet<Product>(0);
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSupname() {
		return supname;
	}
	public void setSupname(String supname) {
		this.supname = supname;
	}
	
	
}

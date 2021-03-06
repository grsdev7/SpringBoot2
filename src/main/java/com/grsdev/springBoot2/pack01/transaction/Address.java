package com.grsdev.springBoot2.pack01.transaction;

import com.fasterxml.jackson.databind.JsonNode;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Address {
	
	@Id
	@GeneratedValue
	private BigDecimal addressId;
	
	private String street;
	
	@JoinColumn(name="customer_id",nullable=false)
	@OneToOne
	private Customer customer;
	
	public Address() {
		
	}
	
	public Address(JsonNode request) {
		this.setStreet(request.findPath("street").asText());
	}

	public Address(String string) {
		this.street=string;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BigDecimal getAddressId() {
		return addressId;
	}

	public void setAddressId(BigDecimal addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + "]";
	}
	
}

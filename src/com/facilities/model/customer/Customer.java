package com.facilities.model.customer;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String customerId;
	private String lastName;
	private String firstName;
	private Address billingAddress;
	private Address shippingAddress;
	private List<Account> accounts = new ArrayList<Account>();
	private List<Card> debitCards = new ArrayList<Card>();

	public Customer(String customerId, String lastName, String firstName, Address billingAddress,
			Address shippingAddress) {
		this.customerId = customerId;
		this.lastName = lastName;
		this.firstName = firstName;
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public List<Card> getDebitCards() {
		return debitCards;
	}

	public void setDebitCards(List<Card> debitCards) {
		this.debitCards = debitCards;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String id) {
		this.customerId = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}

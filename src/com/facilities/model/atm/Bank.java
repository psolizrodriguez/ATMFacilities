package com.facilities.model.atm;

import java.util.ArrayList;
import java.util.List;

import com.facilities.model.customer.Customer;
import com.facilities.model.customer.DebitCard;

public class Bank {
	private List<ATM> atms = new ArrayList<ATM>();
	private List<DebitCard> debitCards = new ArrayList<DebitCard>();
	private List<Customer> customers = new ArrayList<Customer>();

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<DebitCard> getDebitCards() {
		return debitCards;
	}

	public void setDebitCards(List<DebitCard> debitCards) {
		this.debitCards = debitCards;
	}

	public List<ATM> getAtms() {
		return atms;
	}

	public void setAtms(List<ATM> atms) {
		this.atms = atms;
	}

}

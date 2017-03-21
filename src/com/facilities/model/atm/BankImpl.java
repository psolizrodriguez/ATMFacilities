package com.facilities.model.atm;

import java.util.ArrayList;
import java.util.List;

import com.facilities.model.customer.Card;
import com.facilities.model.customer.Customer;

public class BankImpl implements Bank {
	private List<ATM> atms = new ArrayList<ATM>();
	private List<Card> debitCards = new ArrayList<Card>();
	private List<Customer> customers = new ArrayList<Customer>();
	private String bankName;

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Card> getDebitCards() {
		return debitCards;
	}

	public void setDebitCards(List<Card> debitCards) {
		this.debitCards = debitCards;
	}

	public List<ATM> getAtms() {
		return atms;
	}

	public void setAtms(List<ATM> atms) {
		this.atms = atms;
	}

}

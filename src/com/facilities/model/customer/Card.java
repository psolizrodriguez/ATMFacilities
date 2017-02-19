package com.facilities.model.customer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public abstract class Card {
	private Customer owner;
	private int cardNumber;
	private int pinNumber;
	private int securityCode;
	private Calendar validDate;
	private Address address;
	private List<Account> accounts = new ArrayList<Account>();

	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}

	public int getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}

	public Calendar getValidDate() {
		return validDate;
	}

	public void setValidDate(Calendar validDate) {
		this.validDate = validDate;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
}

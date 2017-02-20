package com.facilities.model.customer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public abstract class Card {
	private Customer owner;
	private String cardNumber;
	private String pinNumber;
	private String securityCode;
	private Calendar validDate;
	private Address address;
	private List<Account> accounts = new ArrayList<Account>();

	public Card(Customer owner, String cardNumber, String pinNumber, String securityCode, Calendar validDate,
			Address address, List<Account> accounts) {
		this.owner = owner;
		this.cardNumber = cardNumber;
		this.pinNumber = pinNumber;
		this.securityCode = securityCode;
		this.validDate = validDate;
		this.address = address;
		this.accounts = accounts;
	}

	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(String pinNumber) {
		this.pinNumber = pinNumber;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
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

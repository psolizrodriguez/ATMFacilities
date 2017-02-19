package com.facilities.model.customer;

public abstract class Account {
	private Customer owner;
	private String type;
	private String accountNumber;
	private Double balance;

	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public abstract boolean credit(Double ammount);

	public abstract boolean debit(Double ammount);
}

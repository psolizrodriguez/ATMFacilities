package com.facilities.model.customer;

public class SavingAccount implements Account {

	private Customer owner;
	private String type;
	private String accountNumber;
	private Double balance;

	public SavingAccount(Customer owner, String accountNumber, Double balance) {
		this.owner = owner;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.type = "Savings";
	}

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

	@Override
	public boolean credit(Double ammount) {
		this.setBalance(this.getBalance() + ammount);
		return true;
	}

	@Override
	public boolean debit(Double ammount) {
		this.setBalance(this.getBalance() - ammount);
		return true;
	}

}

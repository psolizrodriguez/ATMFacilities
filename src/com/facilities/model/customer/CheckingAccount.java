package com.facilities.model.customer;

public class CheckingAccount extends Account {

	public CheckingAccount(Customer owner, String accountNumber, Double balance) {
		super(owner, accountNumber, balance);
		setType("Checking");
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

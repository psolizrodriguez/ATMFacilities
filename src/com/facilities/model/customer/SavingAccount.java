package com.facilities.model.customer;

public class SavingAccount extends Account {

	public SavingAccount(Customer owner, String accountNumber, Double balance) {
		super(owner, accountNumber, balance);
		setType("Savings");
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

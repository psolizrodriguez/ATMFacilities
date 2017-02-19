package com.facilities.model.customer;

public class CheckingAccount extends Account {

	@Override
	public boolean credit(Double ammount) {
		this.setBalance(this.getBalance() + ammount);
		return false;
	}

	@Override
	public boolean debit(Double ammount) {
		this.setBalance(this.getBalance() - ammount);
		return false;
	}

}

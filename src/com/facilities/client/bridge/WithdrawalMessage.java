package com.facilities.client.bridge;

import com.facilities.model.customer.Account;

/** "Refined Abstraction" */
public class WithdrawalMessage extends Message {
	private Account account;
	private Double ammount;

	public WithdrawalMessage(final FormatMessage formatMessage, Account account, Double ammount) {
		super(formatMessage);
		this.account = account;
		this.ammount = ammount;
	}

	@Override
	public void format() {
		formatMessage.prepareMessage(account, ammount, this);
	}

}

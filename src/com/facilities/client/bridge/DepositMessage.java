package com.facilities.client.bridge;

import com.facilities.model.customer.Account;

/** "Refined Abstraction" */
public class DepositMessage extends Message {
	private Account account;
	private Double ammount;

	public DepositMessage(final FormatMessage formatMessage, Account account, Double ammount) {
		super(formatMessage);
		this.account = account;
		this.ammount = ammount;
	}

	@Override
	public void format() {
		formatMessage.prepareMessage(account, ammount, this);
	}

}

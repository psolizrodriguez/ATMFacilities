package com.facilities.client.observer;

import com.facilities.model.customer.Account;

public class DepositAlert implements Observer {
	@Override
	public void update(Double ammount, Account account, String operationType) {
		if (operationType.equals("credit")) {
			System.out.println("*************************This is an Alert of a Deposit************************");
			System.out.println("A Deposit is being made to the account : " + account.getAccountNumber());
			System.out.println(
					"for the customer : " + account.getOwner().getFirstName() + " " + account.getOwner().getLastName());
			System.out.println("for the ammount of : " + ammount);
			System.out.println("leaving a total balance of : " + account.getBalance());
			System.out.println("*************************This is an Alert of a Deposit************************");
		}
	}
}
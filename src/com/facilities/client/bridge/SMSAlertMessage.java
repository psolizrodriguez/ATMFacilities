package com.facilities.client.bridge;

import com.facilities.model.customer.Account;

public class SMSAlertMessage implements FormatMessage {

	@Override
	public void prepareMessage(Account account, Double ammount, Message message) {
		if (message instanceof DepositMessage) {
			System.out.println("--SMS ALERT OF DEPOSIT--");
			System.out.println("A Deposit is being made to the account : " + account.getAccountNumber()
					+ " for the ammount of : " + ammount + " leaving a total balance of : " + account.getBalance());
			System.out.println("--SMS ALERT OF DEPOSIT--");
		} else {
			System.out.println("--SMS ALERT OF WITHDRAWAL--");
			System.out.println("A Withdrawal is being made to the account : " + account.getAccountNumber()
					+ " for the ammount of : " + ammount + " leaving a total balance of : " + account.getBalance());
			System.out.println("--SMS ALERT OF WITHDRAWAL--");
		}
	}

}

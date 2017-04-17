package com.facilities.client.bridge;

import com.facilities.model.customer.Account;

public class EmailAlertMessage implements FormatMessage {

	@Override
	public void prepareMessage(Account account, Double ammount, Message message) {
		if (message instanceof DepositMessage) {
			System.out.println("*************************EMAIL ALERT OF DEPOSIT************************");
			System.out.println("A Deposit is being made to the account : " + account.getAccountNumber());
			System.out.println(
					"for the customer : " + account.getOwner().getFirstName() + " " + account.getOwner().getLastName());
			System.out.println("for the ammount of : " + ammount);
			System.out.println("leaving a total balance of : " + account.getBalance());
			System.out.println("*************************EMAIL ALERT OF DEPOSIT************************");
		}else{
			System.out.println("*************************EMAIL ALERT OF WITHDRAWAL************************");
			System.out.println("A Withdrawal is being made to the account : " + account.getAccountNumber());
			System.out.println(
					"for the customer : " + account.getOwner().getFirstName() + " " + account.getOwner().getLastName());
			System.out.println("for the ammount of : " + ammount);
			System.out.println("leaving a total balance of : " + account.getBalance());
			System.out.println("*************************EMAIL ALERT OF WITHDRAWAL************************");
		}
	}

}

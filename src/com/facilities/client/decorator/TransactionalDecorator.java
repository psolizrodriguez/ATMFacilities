package com.facilities.client.decorator;

import com.facilities.client.bridge.FormatMessage;
import com.facilities.client.bridge.Message;
import com.facilities.model.customer.Account;

public class TransactionalDecorator extends Decorator {

	public TransactionalDecorator(FormatMessage formatMessage) {
		super(formatMessage);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void prepareMessage(Account account, Double ammount, Message message) {
		formatMessage.prepareMessage(account, ammount, message);
		setNotification(account, ammount, message);
	}
	
	private void setNotification(Account account, Double ammount, Message message) {
		System.out.println("*************************AN AUTOMATED TRANSACTION ALERT************************");
		System.out.println("The : " + account.getAccountNumber());
		System.out.println(
				"for the customer : " + account.getOwner().getFirstName() + " " + account.getOwner().getLastName());
		System.out.println("is modified for an ammount of : " + ammount);
		System.out.println("leaving a total balance of : " + account.getBalance());
		System.out.println("This is an automated transaction alert for your recent transaction");
		System.out.println("*************************AN AUTOMATED TRANSACTION ALERT************************");
		
	}

}

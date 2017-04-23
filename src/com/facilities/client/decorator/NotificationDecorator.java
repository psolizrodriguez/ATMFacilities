package com.facilities.client.decorator;

import com.facilities.client.bridge.FormatMessage;
import com.facilities.client.bridge.Message;
import com.facilities.model.customer.Account;

public class NotificationDecorator extends Decorator {

	public NotificationDecorator(FormatMessage formatMessage) {
		super(formatMessage);
	}
	@Override
	public void prepareMessage(Account account, Double ammount, Message message) {
		formatMessage.prepareMessage(account, ammount, message);
		setNotification(account, ammount, message);
	}
	
	private void setNotification(Account account, Double ammount, Message message) {
		System.out.println("*************************!!!!!HIGH ALERT NOTIFICATION!!!!!!!************************");
		System.out.println("A modification happened to the account : " + account.getAccountNumber());
		System.out.println(
				"for the customer : " + account.getOwner().getFirstName() + " " + account.getOwner().getLastName());
		System.out.println("for an ammount of : " + ammount);
		System.out.println("leaving a total balance of : " + account.getBalance());
		System.out.println("*************************CONTACT THE BANK IMMEDIATELY @XXXXXXX IF THIS CHANGE IS NOT INTENDED************************");
		System.out.println("*************************!!!!!HIGH ALERT NOTIFICATION!!!!!!!************************");
		
	}

}

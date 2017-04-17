package com.facilities.client.bridge;

import com.facilities.model.customer.Customer;

public class SMSAlertMessage  implements AlertMessage{

	@Override
	public void sendAlert(Customer customer, String operationType) {
		System.out.println("The SMS Alert is sent"  +  customer.getFirstName() + 
				" for the transaction " + operationType);
	}

}

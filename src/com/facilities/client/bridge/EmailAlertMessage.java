package com.facilities.client.bridge;

import com.facilities.model.customer.Customer;

public class EmailAlertMessage implements AlertMessage{

	@Override
	public void sendAlert(Customer customer, String operationType) {
		System.out.println("The Email Alert is sent from the " +  customer.getFirstName() + 
				" for the transaction " + operationType);
	}

}

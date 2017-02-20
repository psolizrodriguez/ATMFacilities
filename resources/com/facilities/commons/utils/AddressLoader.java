package com.facilities.commons.utils;

import com.facilities.model.customer.Address;

public class AddressLoader {
	public static Address getAddress_01() {
		Address address = new Address("ADDRESS001", "E Pearson St", "26", "Chicago", "IL", "60611");
		return address;
	}

	public static Address getAddress_02() {
		Address address = new Address("ADDRESS002", "W Granville Ave", "1068", "Chicago", "IL", "60660");
		return address;
	}
}

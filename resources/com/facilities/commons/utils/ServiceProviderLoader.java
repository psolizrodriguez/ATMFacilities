package com.facilities.commons.utils;

import com.facilities.model.maintenance.ServiceProvider;

public class ServiceProviderLoader {
	static ServiceProvider pls247 = new ServiceProvider("PLS247", 3);
	static ServiceProvider brinks = new ServiceProvider("BRINKS", 3);

	public static ServiceProvider getPls247() {
		return pls247;
	}

	public static ServiceProvider getBrinks() {
		return brinks;
	}

}

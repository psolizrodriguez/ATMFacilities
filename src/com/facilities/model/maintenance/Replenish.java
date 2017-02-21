package com.facilities.model.maintenance;

import java.util.Calendar;

import com.facilities.model.atm.ATM;

public class Replenish extends MaintenanceRequest {

	public Replenish(ATM atm, String description, Double amountToReplenish) {
		super(atm, description);
		this.setAverageHours(2);
		this.setAverageCost(500.0);
		this.setMaintenanceType("REPLENISH");
		this.setAmountToReplenish(amountToReplenish);
	}

	@Override
	public boolean calculateCosts(ServiceProvider serviceProvider, Calendar startDate, Calendar enDate) {
		return serviceProvider.calculateCosts(this, startDate, enDate);
	}
}

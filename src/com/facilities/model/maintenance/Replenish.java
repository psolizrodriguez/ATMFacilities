package com.facilities.model.maintenance;

import java.util.Calendar;

import com.facilities.model.atm.ATM;

public class Replenish extends MaintenanceRequest {
	public Replenish(ATM atm, String description) {
		super(atm, description);
		this.setAverageHours(2);
		this.setAverageCost(500.0);
		this.setMaintenanceType("REPLENISH");
	}

	@Override
	public boolean calculateCosts(ServiceProvider serviceProvider, Calendar startDate, Calendar enDate) {
		return serviceProvider.calculateCosts(this, startDate, enDate);
	}
}

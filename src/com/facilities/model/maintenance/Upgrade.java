package com.facilities.model.maintenance;

import java.util.Calendar;

import com.facilities.model.atm.ATM;

public class Upgrade extends MaintenanceRequest {
	public Upgrade(ATM atm, String description) {
		super(atm, description);
		this.setAverageHours(1);
		this.setAverageCost(700.0);
		this.setMaintenanceType("UPGRADE");
	}

	@Override
	public boolean calculateCosts(ServiceProvider serviceProvider, Calendar startDate, Calendar enDate) {
		return serviceProvider.calculateCosts(this, startDate, enDate);
	}
}

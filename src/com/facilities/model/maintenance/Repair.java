package com.facilities.model.maintenance;

import java.util.Calendar;

import com.facilities.model.atm.ATM;

public class Repair extends MaintenanceRequest {
	public Repair(ATM atm, String description) {
		super(atm, description);
		this.setAverageHours(8);
		this.setAverageCost(2000.0);
		this.setMaintenanceType("REPAIR");
	}

	@Override
	public boolean calculateCosts(ServiceProvider serviceProvider, Calendar startDate, Calendar enDate) {
		return serviceProvider.calculateCosts(this, startDate, enDate);
	}
}

package com.facilities.model.maintenance;

import java.util.Calendar;

import com.facilities.model.atm.ATM;

public class Diagnostic extends MaintenanceRequest {

	public Diagnostic(ATM atm, String description) {
		super(atm, description);
		this.setAverageHours(4);
		this.setAverageCost(1000.0);
	}

	@Override
	public boolean calculateCosts(ServiceProvider serviceProvider, Calendar startDate, Calendar enDate) {
		return serviceProvider.calculateCosts(this, startDate, enDate);
	}

}

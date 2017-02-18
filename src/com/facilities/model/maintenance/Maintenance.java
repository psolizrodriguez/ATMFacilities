package com.facilities.model.maintenance;

import com.facilities.model.atm.ATM;

public class Maintenance {
	private ServiceProvider serviceProvider;
	private ATM atm;
	private MaintenanceType maintenance;

	public MaintenanceType getMaintenance() {
		return maintenance;
	}

	public void setMaintenance(MaintenanceType maintenance) {
		this.maintenance = maintenance;
	}

	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public ATM getAtm() {
		return atm;
	}

	public void setAtm(ATM atm) {
		this.atm = atm;
	}

}

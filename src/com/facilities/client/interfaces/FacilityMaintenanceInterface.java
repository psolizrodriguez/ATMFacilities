package com.facilities.client.interfaces;

import java.util.Calendar;

import com.facilities.model.maintenance.MaintenanceRequest;
import com.facilities.model.maintenance.ServiceProvider;

public interface FacilityMaintenanceInterface {
	// Method to make a Maintenance Request(refill, repair,etc)
	public boolean makeFacilityMaintRequest(MaintenanceRequest maintenanceRequest, ServiceProvider serviceProvider,
			Calendar startDate, Calendar enDate);

	//Method to accept the Maintenance Cost and Schedule it
	public boolean scheduleMaintenance();

	public Object calcMaintenanceCostForFacility();

	public Object calcProblemRateForFacility();

	public Object calcDownTimeForFacility();

	public Object listMaintRequests();

	public Object listMaintenance();

	public Object listFacilityProblems();
}

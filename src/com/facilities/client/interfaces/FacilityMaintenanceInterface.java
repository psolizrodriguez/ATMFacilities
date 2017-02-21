package com.facilities.client.interfaces;

import java.util.Calendar;
import java.util.List;

import com.facilities.model.atm.ATM;
import com.facilities.model.maintenance.MaintenanceCost;
import com.facilities.model.maintenance.MaintenanceRequest;
import com.facilities.model.maintenance.ServiceProvider;

public interface FacilityMaintenanceInterface {
	// Method to make a Maintenance Request(refill, repair,etc)
	public boolean makeFacilityMaintRequest(MaintenanceRequest maintenanceRequest, ServiceProvider serviceProvider,
			Calendar startDate, Calendar enDate);

	// Method to accept the Maintenance Cost and Schedule it
	public boolean scheduleMaintenance(MaintenanceRequest maintenanceRequest, MaintenanceCost maintenanceCost);

	// Cost of all the maintenance in an specific ATM
	public Double calcMaintenanceCostForFacility(ATM atm, List<MaintenanceRequest> listMaintenanceRequest);

	// Total times and ATM has been to maintenance
	public long calcProblemRateForFacility(ATM atm, List<MaintenanceRequest> listMaintenanceOrder);

	// Total hours of maintenance for facility
	public long calcDownTimeForFacility(ATM atm, List<MaintenanceRequest> listMaintenanceOrder);

	// All maintenance Request on a ATM
	public List<MaintenanceRequest> listMaintRequests(ATM atm, List<MaintenanceRequest> MaintenanceRequest);

	// List all Maintenance Orders in a Specific ATM
	public List<MaintenanceRequest> listMaintenance(ATM atm, List<MaintenanceRequest> listMaintenanceOrder);

	// List all Maintenance Orders of an specific type of an ATM
	public List<MaintenanceRequest> listFacilityProblems(ATM atm, List<MaintenanceRequest> listMaintenanceOrder,
			String maintenanceType);
}

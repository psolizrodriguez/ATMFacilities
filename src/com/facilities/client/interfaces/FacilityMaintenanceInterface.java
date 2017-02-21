package com.facilities.client.interfaces;

import java.util.Calendar;
import java.util.List;

import com.facilities.model.atm.ATM;
import com.facilities.model.maintenance.MaintenanceCost;
import com.facilities.model.maintenance.MaintenanceOrder;
import com.facilities.model.maintenance.MaintenanceRequest;
import com.facilities.model.maintenance.ServiceProvider;

public interface FacilityMaintenanceInterface {
	// Method to make a Maintenance Request(refill, repair,etc)
	public boolean makeFacilityMaintRequest(MaintenanceRequest maintenanceRequest, ServiceProvider serviceProvider,
			Calendar startDate, Calendar enDate);

	// Method to accept the Maintenance Cost and Schedule it
	public boolean scheduleMaintenance(MaintenanceRequest maintenanceRequest, MaintenanceCost maintenanceCost);

	// Cost of all the maintenance in an specific ATM
	public Double calcMaintenanceCostForFacility(ATM atm, List<MaintenanceOrder> listMaintenanceOrder);

	// Total times and ATM has been to maintenance
	public long calcProblemRateForFacility(ATM atm, List<MaintenanceOrder> listMaintenanceOrder);

	// Total hours of maintenance for facility
	public long calcDownTimeForFacility(ATM atm, List<MaintenanceOrder> listMaintenanceOrder);

	// All maintenance Request on a ATM
	public List<MaintenanceRequest> listMaintRequests(ATM atm, List<MaintenanceRequest> MaintenanceRequest);

	// List all Maintenance Orders in a Specific ATM
	public List<MaintenanceOrder> listMaintenance(ATM atm, List<MaintenanceOrder> listMaintenanceOrder);

	// List all Maintenance Orders of an specific type of an ATM
	public List<MaintenanceOrder> listFacilityProblems(ATM atm, List<MaintenanceOrder> listMaintenanceOrder,
			String maintenanceType);
}

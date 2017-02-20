package com.facilities.client.interfacesImpl;

import java.util.Calendar;

import com.facilities.client.interfaces.FacilityMaintenanceInterface;
import com.facilities.model.maintenance.MaintenanceRequest;
import com.facilities.model.maintenance.ServiceProvider;

public class FacilityMaintenanceInterfaceImpl implements FacilityMaintenanceInterface {

	@Override
	public boolean makeFacilityMaintRequest(MaintenanceRequest maintenanceRequest, ServiceProvider serviceProvider,
			Calendar startDate, Calendar enDate) {
		return maintenanceRequest.calculateCosts(serviceProvider, startDate, enDate);
	}

	@Override
	public Object scheduleMaintenance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object calcMaintenanceCostForFacility() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object calcProblemRateForFacility() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object calcDownTimeForFacility() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object listMaintRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object listMaintenance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object listFacilityProblems() {
		// TODO Auto-generated method stub
		return null;
	}

}

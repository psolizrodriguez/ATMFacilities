package com.facilities.client.interfaces;

public interface FacilityMaintenanceInterface {
	public Object makeFacilityMaintRequest();
	public Object scheduleMaintenance();
	public Object calcMaintenanceCostForFacility();
	public Object calcProblemRateForFacility();
	public Object calcDownTimeForFacility();
	public Object listMaintRequests();
	public Object listMaintenance();
	public Object listFacilityProblems();
}

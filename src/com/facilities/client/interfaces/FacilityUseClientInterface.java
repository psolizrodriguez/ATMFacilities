package com.facilities.client.interfaces;

public interface FacilityUseClientInterface {
	public Object isInUseDuringInterval();
	public Object assignFacilityToUse();
	public Object vacateFacility();
	public Object listInspections();
	public Object listActualUsage();
	public Object calcUsageRate();
}

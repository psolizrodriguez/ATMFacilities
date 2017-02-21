package com.facilities.client.interfacesImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.facilities.client.interfaces.FacilityMaintenanceInterface;
import com.facilities.model.atm.ATM;
import com.facilities.model.maintenance.MaintenanceCost;
import com.facilities.model.maintenance.MaintenanceRequest;
import com.facilities.model.maintenance.ServiceProvider;

public class FacilityMaintenanceInterfaceImpl implements FacilityMaintenanceInterface {

	@Override
	public boolean makeFacilityMaintRequest(MaintenanceRequest maintenanceRequest, ServiceProvider serviceProvider,
			Calendar startDate, Calendar enDate) {
		return maintenanceRequest.calculateCosts(serviceProvider, startDate, enDate);
	}

	@Override
	public boolean scheduleMaintenance(MaintenanceRequest maintenanceRequest, MaintenanceCost maintenanceCost) {
		// TODO Auto-generated method stub
		return maintenanceCost.acceptMaintenance(maintenanceRequest);
	}

	@Override
	public Double calcMaintenanceCostForFacility(ATM atm, List<MaintenanceRequest> listMaintenanceRequest) {
		Double total = 0.0;
		if (listMaintenanceRequest != null && listMaintenanceRequest.size() > 0) {
			for (MaintenanceRequest maintenanceRequest : listMaintenanceRequest) {
				if (maintenanceRequest.getMaintenanceOrder() != null && maintenanceRequest.getAtm().equals(atm)) {
					total += maintenanceRequest.getMaintenanceOrder().getMaintenanceCost().getCost();
				}
			}
		}
		return total;
	}

	@Override
	public long calcProblemRateForFacility(ATM atm, List<MaintenanceRequest> listMaintenanceRequest) {
		long total = 0;
		if (listMaintenanceRequest != null && listMaintenanceRequest.size() > 0) {
			for (MaintenanceRequest maintenanceRequest : listMaintenanceRequest) {
				if (maintenanceRequest.getMaintenanceOrder() != null && maintenanceRequest.getAtm().equals(atm)) {
					total++;
				}
			}
		}
		return total;
	}

	@Override
	public long calcDownTimeForFacility(ATM atm, List<MaintenanceRequest> listMaintenanceRequest) {
		long total = 0;
		if (listMaintenanceRequest != null && listMaintenanceRequest.size() > 0) {
			for (MaintenanceRequest maintenanceRequest : listMaintenanceRequest) {
				if (maintenanceRequest.getMaintenanceOrder() != null && maintenanceRequest.getAtm().equals(atm)) {
					total += maintenanceRequest.getMaintenanceOrder().getMaintenanceCost().getRequiredHours();
				}
			}
		}
		return total;
	}

	@Override
	public List<MaintenanceRequest> listMaintRequests(ATM atm, List<MaintenanceRequest> listMaintenanceRequest) {
		List<MaintenanceRequest> result = new ArrayList<>();
		if (listMaintenanceRequest != null && listMaintenanceRequest.size() > 0) {
			for (MaintenanceRequest maintenanceRequest : listMaintenanceRequest) {
				if (maintenanceRequest.getAtm().equals(atm)) {
					result.add(maintenanceRequest);
				}
			}
		}
		return result;

	}

	@Override
	// List all Maintenance Requests in a Specific ATM
	public List<MaintenanceRequest> listMaintenance(ATM atm, List<MaintenanceRequest> listMaintenanceRequest) {
		List<MaintenanceRequest> result = new ArrayList<>();
		if (listMaintenanceRequest != null && listMaintenanceRequest.size() > 0) {
			for (MaintenanceRequest maintenanceRequest : listMaintenanceRequest) {
				if (maintenanceRequest.isClosed() && maintenanceRequest.getAtm().equals(atm)) {
					result.add(maintenanceRequest);
				}
			}
		}
		return result;
	}

	// List all Maintenance Orders of an specific type of an ATM
	public List<MaintenanceRequest> listFacilityProblems(ATM atm, List<MaintenanceRequest> listMaintenanceRequest,
			String maintenanceType) {
		List<MaintenanceRequest> result = new ArrayList<>();
		if (listMaintenanceRequest != null && listMaintenanceRequest.size() > 0) {
			for (MaintenanceRequest maintenanceRequest : listMaintenanceRequest) {
				if (maintenanceRequest.isClosed() && maintenanceRequest.getMaintenanceType().equals(maintenanceType)) {
					result.add(maintenanceRequest);
				}
			}
		}
		return result;
	}

}

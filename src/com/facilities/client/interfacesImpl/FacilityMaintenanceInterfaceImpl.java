package com.facilities.client.interfacesImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.facilities.client.interfaces.FacilityMaintenanceInterface;
import com.facilities.model.atm.ATM;
import com.facilities.model.maintenance.MaintenanceCost;
import com.facilities.model.maintenance.MaintenanceOrder;
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
	public Double calcMaintenanceCostForFacility(ATM atm, List<MaintenanceOrder> listMaintenanceOrder) {
		Double total = 0.0;
		if (listMaintenanceOrder != null && listMaintenanceOrder.size() > 0) {
			for (MaintenanceOrder maintenanceOrder : listMaintenanceOrder) {
				if (maintenanceOrder.getMaintenanceRequest().getAtm().equals(atm)) {
					total += maintenanceOrder.getMaintenanceCost().getCost();
				}
			}
		}
		return total;
	}

	@Override
	public long calcProblemRateForFacility(ATM atm, List<MaintenanceOrder> listMaintenanceOrder) {
		long total = 0;
		if (listMaintenanceOrder != null && listMaintenanceOrder.size() > 0) {
			for (MaintenanceOrder maintenanceOrder : listMaintenanceOrder) {
				if (maintenanceOrder.getMaintenanceRequest().getAtm().equals(atm)) {
					total++;
				}
			}
		}
		return total;
	}

	@Override
	public long calcDownTimeForFacility(ATM atm, List<MaintenanceOrder> listMaintenanceOrder) {
		long total = 0;
		if (listMaintenanceOrder != null && listMaintenanceOrder.size() > 0) {
			for (MaintenanceOrder maintenanceOrder : listMaintenanceOrder) {
				if (maintenanceOrder.getMaintenanceRequest().getAtm().equals(atm)) {
					total += maintenanceOrder.getMaintenanceCost().getRequiredHours();
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
				if (maintenanceRequest.isClosed()) {
					result.add(maintenanceRequest);
				}
			}
		}
		return result;

	}

	@Override
	// List all Maintenance Orders in a Specific ATM
	public List<MaintenanceOrder> listMaintenance(ATM atm, List<MaintenanceOrder> listMaintenanceOrder) {
		List<MaintenanceOrder> result = new ArrayList<>();
		if (listMaintenanceOrder != null && listMaintenanceOrder.size() > 0) {
			for (MaintenanceOrder maintenanceOrder : listMaintenanceOrder) {
				if (maintenanceOrder.getMaintenanceRequest().getAtm().equals(atm)) {
					result.add(maintenanceOrder);
				}
			}
		}
		return result;
	}

	// List all Maintenance Orders of an specific type of an ATM
	public List<MaintenanceOrder> listFacilityProblems(ATM atm, List<MaintenanceOrder> listMaintenanceOrder,
			String maintenanceType) {
		List<MaintenanceOrder> result = new ArrayList<>();
		if (listMaintenanceOrder != null && listMaintenanceOrder.size() > 0) {
			for (MaintenanceOrder maintenanceOrder : listMaintenanceOrder) {
				if (maintenanceOrder.getMaintenanceRequest().getMaintenanceType().equals(maintenanceType)) {
					result.add(maintenanceOrder);
				}
			}
		}
		return result;
	}

}

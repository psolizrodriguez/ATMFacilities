package com.facilities.commons.utils;

import java.util.ArrayList;
import java.util.List;

import com.facilities.model.atm.ATM;
import com.facilities.model.atm.Bank;
import com.facilities.model.maintenance.Diagnostic;
import com.facilities.model.maintenance.MaintenanceRequest;
import com.facilities.model.maintenance.Repair;
import com.facilities.model.maintenance.Replenish;
import com.facilities.model.maintenance.ServiceProvider;
import com.facilities.model.maintenance.Upgrade;

public class MaintenanceOrdersLoader {

	public static List<MaintenanceRequest> getCreateMaintenanceOrdersForPNCATM(Bank pnc) {
		List<MaintenanceRequest> listMaintenanceRequest = new ArrayList<>();
		ATM atmPNC_001 = pnc.getAtms().get(0);
		ServiceProvider brinks = ServiceProviderLoader.getBrinks();
		ServiceProvider pls247 = ServiceProviderLoader.getPls247();
		System.out.println("We create a Diagnostic Maintenance Request");
		MaintenanceRequest diagnosticRequest = new Diagnostic(atmPNC_001, "First Diagnostic Maintenenance");
		listMaintenanceRequest.add(diagnosticRequest);
		System.out.println("We create a Replenish Maintenance Request");
		MaintenanceRequest replenishRequest = new Replenish(atmPNC_001, "First Replenish Maintenenance");
		listMaintenanceRequest.add(replenishRequest);
		System.out.println("We create a Repair Maintenance Request");
		MaintenanceRequest repairRequest = new Repair(atmPNC_001, "First Repair Maintenenance");
		listMaintenanceRequest.add(repairRequest);
		System.out.println("We create a Upgrade Maintenance Request");
		MaintenanceRequest upgradeRequest = new Upgrade(atmPNC_001, "First Upgrade Maintenenance");
		listMaintenanceRequest.add(upgradeRequest);
		System.out.println("Brinks Calculate Costs for all the Requests");
		diagnosticRequest.calculateCosts(brinks, CommonsUtils.getCalendar(02, 25, 2017, 2, 0, 0, 0),
				CommonsUtils.getCalendar(02, 25, 2017, 6, 0, 0, 0));
		repairRequest.calculateCosts(brinks, CommonsUtils.getCalendar(02, 26, 2017, 2, 0, 0, 0),
				CommonsUtils.getCalendar(02, 26, 2017, 6, 0, 0, 0));
		replenishRequest.calculateCosts(brinks, CommonsUtils.getCalendar(02, 27, 2017, 2, 0, 0, 0),
				CommonsUtils.getCalendar(02, 27, 2017, 6, 0, 0, 0));
		upgradeRequest.calculateCosts(brinks, CommonsUtils.getCalendar(02, 28, 2017, 2, 0, 0, 0),
				CommonsUtils.getCalendar(02, 28, 2017, 6, 0, 0, 0));
		System.out.println("PLS247 Calculate Costs for all the Requests");
		diagnosticRequest.calculateCosts(pls247, CommonsUtils.getCalendar(02, 25, 2017, 2, 0, 0, 0),
				CommonsUtils.getCalendar(02, 25, 2017, 6, 0, 0, 0));
		repairRequest.calculateCosts(pls247, CommonsUtils.getCalendar(02, 26, 2017, 2, 0, 0, 0),
				CommonsUtils.getCalendar(02, 26, 2017, 6, 0, 0, 0));
		replenishRequest.calculateCosts(pls247, CommonsUtils.getCalendar(02, 27, 2017, 2, 0, 0, 0),
				CommonsUtils.getCalendar(02, 27, 2017, 6, 0, 0, 0));
		upgradeRequest.calculateCosts(pls247, CommonsUtils.getCalendar(02, 28, 2017, 2, 0, 0, 0),
				CommonsUtils.getCalendar(02, 28, 2017, 6, 0, 0, 0));
		System.out.println("We accept all the Brinks Cost and proceed to create an order");
		diagnosticRequest.getListMaintenanceCost().get(0).acceptMaintenance(diagnosticRequest);
		replenishRequest.getListMaintenanceCost().get(0).acceptMaintenance(replenishRequest);
		repairRequest.getListMaintenanceCost().get(0).acceptMaintenance(repairRequest);
		upgradeRequest.getListMaintenanceCost().get(0).acceptMaintenance(upgradeRequest);
		return listMaintenanceRequest;
	}

}

package test.facilities.client.interfaces;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.facilities.client.interfaces.FacilityMaintenanceInterface;
import com.facilities.client.interfacesImpl.FacilityMaintenanceInterfaceImpl;
import com.facilities.commons.utils.BankLoader;
import com.facilities.commons.utils.CommonsUtils;
import com.facilities.commons.utils.MaintenanceOrdersLoader;
import com.facilities.commons.utils.ServiceProviderLoader;
import com.facilities.model.atm.ATM;
import com.facilities.model.maintenance.Diagnostic;
import com.facilities.model.maintenance.MaintenanceCost;
import com.facilities.model.maintenance.MaintenanceRequest;
import com.facilities.model.maintenance.ServiceProvider;

public class FacilityMaintenanceInterfaceImplTest {
	private FacilityMaintenanceInterface facilityMaintenanceInterface;
	private BankLoader bankLoader;
	private ServiceProviderLoader serviceProviderLoader;
	private List<MaintenanceRequest> listMaintenanceRequest;

	@Before
	public void initialize() {
		facilityMaintenanceInterface = new FacilityMaintenanceInterfaceImpl();
		bankLoader = new BankLoader();
		serviceProviderLoader = new ServiceProviderLoader();
		listMaintenanceRequest = MaintenanceOrdersLoader.getCreateMaintenanceOrdersForPNCATM(bankLoader.getBankPNC());
	}

	// Method to make a Maintenance Request(refill, repair,etc)
	/*
	 * public boolean makeFacilityMaintRequest(MaintenanceRequest maintenanceRequest, ServiceProvider serviceProvider, Calendar startDate, Calendar enDate);
	 */
	@Test
	public void makeFacilityMaintRequestTest() {
		System.out.println("@makeFacilityMaintRequestTest");
		System.out.println("We get the PNC_001 atm and create a Diagnostic Maintenance Request");
		ATM atmPNC_001 = bankLoader.getBankPNC().getAtms().get(0);
		MaintenanceRequest maintenanceRequest = new Diagnostic(atmPNC_001, "First Diagnostic Maintenenance");
		assertEquals(maintenanceRequest != null, true);
	}

	// Method to accept the Maintenance Cost and Schedule it
	/* public boolean scheduleMaintenance(MaintenanceRequest maintenanceRequest, MaintenanceCost maintenanceCost); */

	@Test
	public void scheduleMaintenanceTest() {
		System.out.println("@scheduleMaintenanceTest");
		System.out.println("We get the PNC_001 atm and create a Diagnostic Maintenance Request");
		ATM atmPNC_001 = bankLoader.getBankPNC().getAtms().get(0);
		MaintenanceRequest maintenanceRequest = new Diagnostic(atmPNC_001, "First Diagnostic Maintenenance");
		ServiceProvider brinks = serviceProviderLoader.getBrinks();
		Calendar startDate = CommonsUtils.getCalendar(02, 25, 2017, 2, 0, 0, 0);
		Calendar endDate = CommonsUtils.getCalendar(02, 25, 2017, 6, 0, 0, 0);
		System.out.println("We process the request and create the cost according to the provider Brinks");
		assertEquals(
				facilityMaintenanceInterface.makeFacilityMaintRequest(maintenanceRequest, brinks, startDate, endDate),
				true);
		System.out.println("A Maintenance Cost is generated, we compare the list size with 1");
		assertEquals(maintenanceRequest.getListMaintenanceCost().size(), 1);
		MaintenanceCost maintenanceCostBrinks = maintenanceRequest.getListMaintenanceCost().get(0);
		System.out.println("Our Maintenance Order should be null");
		assertEquals(maintenanceRequest.getMaintenanceOrder(), null);
		System.out.println("We accept the cost of Brinks and create a Maintenance Order");
		assertEquals(maintenanceCostBrinks.acceptMaintenance(maintenanceRequest), true);
		System.out.println("Our Maintenance Order should not be null");
		assertEquals(maintenanceRequest.getMaintenanceOrder() != null, true);
		System.out.println("Our Maintenance Schedule should 4 because is a Diagnostic Request");
		assertEquals(maintenanceRequest.getMaintenanceOrder().getListMaintenanceSchedule().size(), 4);
	}

	// Cost of all the maintenance in an specific ATM
	/* public Double calcMaintenanceCostForFacility(ATM atm, List<MaintenanceOrder> listMaintenanceOrder); */

	@Test
	public void calcMaintenanceCostForFacilityTest() {
		System.out.println("@calcMaintenanceCostForFacilityTest");
		ATM atmPNC_001 = bankLoader.getBankPNC().getAtms().get(0);
		System.out.println("We calculate the cost of all the maintenance that has been done to the PNC_001 ATM");
		System.out.println(
				"Teh costs are 1000, 2000, 500, 700 and the rating of Brinks is 3, so we should have a total cost of 12600");
		assertEquals((Object) facilityMaintenanceInterface.calcMaintenanceCostForFacility(atmPNC_001,
				listMaintenanceRequest), (Object) 12600.0);
	}

	// Total times and ATM has been to maintenance
	/* public long calcProblemRateForFacility(ATM atm, List<MaintenanceOrder> listMaintenanceOrder); */

	@Test
	public void calcProblemRateForFacilityTest() {

	}

	// Total hours of maintenance for facility
	/* public long calcDownTimeForFacility(ATM atm, List<MaintenanceOrder> listMaintenanceOrder); */

	@Test
	public void calcDownTimeForFacilityTest() {

	}
	// All maintenance Request on a ATM
	/* public List<MaintenanceRequest> listMaintRequests(ATM atm, List<MaintenanceRequest> MaintenanceRequest); */

	@Test
	public void listMaintRequestsTest() {

	}
	// List all Maintenance Orders in a Specific ATM
	/* public List<MaintenanceOrder> listMaintenance(ATM atm, List<MaintenanceOrder> listMaintenanceOrder); */

	@Test
	public void listMaintenanceTest() {

	}

	// List all Maintenance Orders of an specific type of an ATM
	/*
	 * public List<MaintenanceOrder> listFacilityProblems(ATM atm, List<MaintenanceOrder> listMaintenanceOrder, String maintenanceType);
	 */
	@Test
	public void listFacilityProblemsTest() {

	}
}

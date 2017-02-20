package test.facilities.client.interfaces;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import com.facilities.client.interfaces.FacilityUserInterface;
import com.facilities.client.interfacesImpl.FacilityUserInterfaceImpl;
import com.facilities.commons.utils.BankLoader;
import com.facilities.commons.utils.CommonsUtils;
import com.facilities.model.atm.ATM;

public class FacilityUserInterfaceImplTest {

	private FacilityUserInterface facilityUserInterface;
	private BankLoader bankLoader;

	@Before
	public void initialize() {
		facilityUserInterface = new FacilityUserInterfaceImpl();
		bankLoader = new BankLoader();
	}

	@Test
	public void isInUseDuringInterval() {
		ATM PNC_001 = bankLoader.getBankPNC().getAtms().get(0);
		System.out.println("@Test isInUseDuringInterval()");
		System.out.println(
				"No transactions recorded, therefore ATM was not in use from 16:30:00 01-18-2017 to 16:35:00 01-18-2017");
		Calendar fromTime = CommonsUtils.getCalendar(01, 18, 2017, 16, 30, 00);
		Calendar toTime = CommonsUtils.getCalendar(01, 18, 2017, 16, 35, 00);
		System.out.println(fromTime);
		assertEquals(facilityUserInterface.isInUseDuringInterval(PNC_001, fromTime, toTime), false);
	}

	@Test
	public void assignFacilityToUse() {
		// TODO Auto-generated method stub

	}

	@Test
	public void vacateFacility() {
		// TODO Auto-generated method stub
	}

	@Test
	public void listInspections() {
		// TODO Auto-generated method stub

	}

	@Test
	public void listActualUsage() {
		// TODO Auto-generated method stub

	}

	@Test
	public void calcUsageRate() {
		// TODO Auto-generated method stub

	}

}

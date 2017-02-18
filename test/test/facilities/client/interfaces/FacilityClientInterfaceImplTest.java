package test.facilities.client.interfaces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.facilities.client.interfaces.FacilityClientInterface;
import com.facilities.client.interfacesImpl.FacilityClientInterfaceImpl;
import com.facilities.commons.utils.ATMLoader;
import com.facilities.commons.utils.BankLoader;
import com.facilities.model.atm.ATM;
import com.facilities.model.customer.Address;

public class FacilityClientInterfaceImplTest {
	private FacilityClientInterface facilityClientInterface;
	private BankLoader bankLoader;

	@Before
	public void initialize() {
		facilityClientInterface = new FacilityClientInterfaceImpl();
		bankLoader = new BankLoader();
	}

	@Test
	public void testListFacilities() {
		testAddNewFacility();
		assertEquals(facilityClientInterface.listFacilities(bankLoader.getBankPNC()).size(),
				ATMLoader.getPNCATMList().size());
	}

	@Test
	public void testAddNewFacility() {
		ATM atm_PNC_001 = new ATM("PNC_001", 20000.0, 0.0, true,
				new Address("ADDRESS_1", "26 E Pearson St", "1", "Chicago", "IL", "60611"));
		assertNotNull(atm_PNC_001);
		assertEquals(facilityClientInterface.addNewFacility(bankLoader.getBankPNC(), atm_PNC_001), true);
		ATM atm_PNC_002 = new ATM("PNC_002", 20000.0, 0.0, true,
				new Address("ADDRESS_2", "1068 W Granville Ave", "2", "Chicago", "IL", "60660"));
		assertNotNull(atm_PNC_002);
		assertEquals(facilityClientInterface.addNewFacility(bankLoader.getBankPNC(), atm_PNC_002), true);
	}

}

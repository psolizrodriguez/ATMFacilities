package test.facilities.client.interfaces;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.facilities.client.interfaces.FacilityClientInterface;
import com.facilities.client.interfacesImpl.FacilityClientInterfaceImpl;
import com.facilities.commons.utils.ATMLoader;
import com.facilities.commons.utils.BankLoader;
import com.facilities.commons.utils.CommonsUtils;
import com.facilities.model.atm.ATM;
import com.facilities.model.atm.Bank;
import com.facilities.model.customer.Account;
import com.facilities.model.customer.Address;
import com.facilities.model.customer.Card;
import com.facilities.model.service.ATMTransaction;
import com.facilities.model.service.DepositTransaction;
import com.facilities.model.service.PINValidationTransaction;
import com.facilities.model.service.TransferTransaction;
import com.facilities.model.service.WithdrawlTransaction;

public class FacilityMaintenanceInterfaceImplTest {
	private FacilityClientInterface facilityClientInterface;
	private BankLoader bankLoader;

	@Before
	public void initialize() {
		facilityClientInterface = new FacilityClientInterfaceImpl();
		bankLoader = new BankLoader();
	}

	
}

package com.facilities.commons.utils;

import com.facilities.model.atm.Bank;

public class BankLoader {
	private Bank bankPNC;
	private Bank bankOfAmerica;
	private Bank bankCitibank;

	public BankLoader() {
		bankPNC = new Bank();
		bankOfAmerica = new Bank();
		bankCitibank = new Bank();
	}

	public Bank getBankPNC() {
		return bankPNC;
	}

	public void setBankPNC(Bank bankPNC) {
		this.bankPNC = bankPNC;
	}

	public Bank getBankOfAmerica() {
		return bankOfAmerica;
	}

	public void setBankOfAmerica(Bank bankOfAmerica) {
		this.bankOfAmerica = bankOfAmerica;
	}

	public Bank getBankCitibank() {
		return bankCitibank;
	}

	public void setBankCitibank(Bank bankCitibank) {
		this.bankCitibank = bankCitibank;
	}

}

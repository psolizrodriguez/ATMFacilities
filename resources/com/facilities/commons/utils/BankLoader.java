package com.facilities.commons.utils;

import com.facilities.model.atm.Bank;

public class BankLoader {
	private Bank bankPNC;
	private Bank bankOfAmerica;
	private Bank bankCitibank;
	private Bank chaseBank;

	public Bank getChaseBank() {
		return chaseBank;
	}

	public void setChaseBank(Bank chaseBank) {
		this.chaseBank = chaseBank;
	}

	public BankLoader() {
		bankPNC = new Bank();
		bankOfAmerica = new Bank();
		bankCitibank = new Bank();
		chaseBank = new Bank();
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

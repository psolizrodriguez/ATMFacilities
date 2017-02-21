package com.facilities.commons.utils;

import java.util.HashMap;
import java.util.List;

import com.facilities.model.atm.ATM;
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
		bankPNC.setAtms(ATMLoader.getPNCATMList());
		bankPNC.setDebitCards(CardLoader.getPNCCards());

		bankOfAmerica = new Bank();
		bankOfAmerica.setAtms(ATMLoader.getBOAATMList());
		bankOfAmerica.setDebitCards(CardLoader.getBOACards());


		bankCitibank = new Bank();
		bankCitibank.setAtms(ATMLoader.getCBATMList());
		chaseBank = new Bank();
		chaseBank.setAtms(ATMLoader.getCBATMList());
		
		
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

	public HashMap<String, List<ATM>> getBankLists(){
		HashMap<String, List<ATM>> banks = new HashMap<>();
		banks.put("PNC", bankPNC.getAtms());
		banks.put("Bank Of America", bankOfAmerica.getAtms());
		banks.put("Citi Bank", bankCitibank.getAtms());
		banks.put("CHASE Bank", chaseBank.getAtms());
		return banks;
	}

	@Override
	public String toString() {
		return "PNC,Bank Of America,Citi Bank,CHASE Bank";
	}

}

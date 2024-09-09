package com.ronit.banking;

public class Beneficiary {
	private int beneficiaryID, customerID;
	private String name, accountNumber, bankDetails;
	
	public Beneficiary(int beneficiaryID, int customerID, String name, String accountNumber, String bankDetails) {
		super();
		this.beneficiaryID = beneficiaryID;
		this.customerID = customerID;
		this.name = name;
		this.accountNumber = accountNumber;
		this.bankDetails = bankDetails;
	}

	
	
	@Override
	public String toString() {
		return "Beneficiary [beneficiaryID=" + beneficiaryID + ", customerID=" + customerID + ", name=" + name
				+ ", accountNumber=" + accountNumber + ", bankDetails=" + bankDetails + "]";
	}



	public int getBeneficiaryID() {
		return beneficiaryID;
	}

	public void setBeneficiaryID(int beneficiaryID) {
		this.beneficiaryID = beneficiaryID;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankDetails() {
		return bankDetails;
	}

	public void setBankDetails(String bankDetails) {
		this.bankDetails = bankDetails;
	}
	
	
}

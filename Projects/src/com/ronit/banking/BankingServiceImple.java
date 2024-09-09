package com.ronit.banking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.*;
public class BankingServiceImple implements BankingService{
	
	private Map<Integer, Customer> customers = new HashMap<>(); 
	private Map<Integer, Account> accounts = new HashMap<>(); 
	private Map<Integer, Transaction> transactions = new HashMap<>(); 
	private Map<Integer, Beneficiary> beneficiaries = new HashMap<>();
	
	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customers.put(customer.getCustomerID(),customer);
		
	}

	@Override
	public void addAccount(Account account) {
		// TODO Auto-generated method stub
		accounts.put(account.getAccountID(), account);
	}

	@Override
	public void addTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		transactions.put(transaction.getAccountID(), transaction);
		
		Account account = accounts.get(transaction.getAccountID());
		if(transaction.getType().equalsIgnoreCase("Deposit")) {
			account.setBalance(account.getBalance() + transaction.getAmount());
		}else if(transaction.getType().equalsIgnoreCase("Withdrawal")) {
			account.setBalance(account.getBalance() - transaction.getAmount());
		}
		Random rand = new Random();
		int a = rand.nextInt(1000);
		transaction.setTransactionID(a);
	}

	@Override
	public void addBeneficiary(Beneficiary beneficiary) {
		// TODO Auto-generated method stub
		beneficiaries.put(beneficiary.getBeneficiaryID(), beneficiary);
	}

	@Override
	public Customer findCustomerById(int id) {
		// TODO Auto-generated method stub
		return customers.get(id);
	}

	@Override
	public Account findAccountById(int id) {
		// TODO Auto-generated method stub
		return accounts.get(id);
	}

	@Override
	public Transaction findTransactionById(int id) {
		// TODO Auto-generated method stub
		return transactions.get(id);
	}

	@Override
	public Beneficiary findBeneficiaryById(int id) {
		// TODO Auto-generated method stub
		return beneficiaries.get(id);
	}

	@Override
	public Collection<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		
		return accounts.values();
	}

	@Override
	public Collection<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customers.values();
	}

	@Override
	public Collection<Transaction> getAllTransactions() {
		// TODO Auto-generated method stub
		return transactions.values();
	}

	@Override
	public Collection<Beneficiary> getAllBeneficiaries() {
		// TODO Auto-generated method stub
		return beneficiaries.values();
	}

	@Override
	public List<Account> getAccountsByCustomerId(int customerId) {
		// TODO Auto-generated method stub
		List<Account> result = new ArrayList();
		
		for(Account account : accounts.values()) {
			if(account.getCustomerID() == customerId) {
				result.add(account);
			}
		}
		
		return result;
	}

	@Override
	public List<Transaction> getTransactionsByAccountId(int accountId) {
		// TODO Auto-generated method stub
		List<Transaction> result = new ArrayList();
		
		for(Transaction transaction : transactions.values()) {
			if(transaction.getAccountID() == accountId) {
				result.add(transaction);
			}
		}
		return result;
	}

	@Override
	public List<Beneficiary> getBeneficiariesByCustomerld(int customerId) {
		// TODO Auto-generated method stub
		List<Beneficiary> result = new ArrayList();
		
		for(Beneficiary beneficiary : beneficiaries.values()) {
			if(beneficiary.getCustomerID() == customerId) {
				result.add(beneficiary);
			}
		}
		return result;
	}
	
}

package com.ronit.banking;
import java.util.*;
public class BankingSystemApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int choice;
		BankingService bankingservice = new BankingServiceImple();
		
		do {
			System.out.println("Banking System");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Account");
            System.out.println("3. Add Beneficiary");
            System.out.println("4. Add Transaction");
            System.out.println("5. Find Customer by Id");
            System.out.println("6. List all Accounts of specific Customer");
            System.out.println("7. List all Transactions of specific Account");
            System.out.println("8. List all Beneficiaries of specific Customer");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            
            choice = sc.nextInt();
            
            switch(choice) {
            case 1: 
            	System.out.println("Enter Customer details");
            	System.out.println("Customer ID:");
        		int customerID = sc.nextInt();
        		sc.nextLine();
        		System.out.println("Name:");
        		String name = sc.nextLine();
        		System.out.println("Address:");
        		String address = sc.nextLine();
        		System.out.println("Contact No.:");
        		String contact = sc.nextLine();
        		
        		Customer customer = new Customer(customerID, name, address, contact);
        		bankingservice.addCustomer(customer);
        		
        		break;
        		
            case 2:
            	System.out.println("Enter Account details");
            	System.out.println("Account ID:");
        		int accountID = sc.nextInt();
        		System.out.println("Customer ID");
        		int accountcustomerID = sc.nextInt();
        		sc.nextLine();
        		System.out.println("Account type(Savings/Current):");
        		String type = sc.nextLine();
        		System.out.println("Balance:");
        		double balance = sc.nextDouble();
        		
        		Account account = new Account(accountID, accountcustomerID, type, balance);
        		bankingservice.addAccount(account);
        		
        		break;
        	
            case 3:
            	System.out.println("Enter Beneficiary details:");
            	System.out.println("Customer ID");
        		int beneficiarycustomerID = sc.nextInt();
            	System.out.println("Beneficiary ID:");
        		int beneficiaryID = sc.nextInt();
        		sc.nextLine();
        		System.out.println("Beneficiary Name:");
        		String beneficiaryname = sc.nextLine();
        		System.out.println("Beneficiary Account No.:");
        		String accountNumber = sc.nextLine();
        		System.out.println("Beneficiary bank details:");
        		String bankDetails = sc.nextLine();
        		
        		Beneficiary beneficiary = new Beneficiary(beneficiaryID, beneficiarycustomerID, beneficiaryname, accountNumber, bankDetails);
        		bankingservice.addBeneficiary(beneficiary);
        		
        		break;
        		
            case 4:
            	System.out.println("Enter Transaction details:");
//            	System.out.println("Transaction ID:");
//            	int transactionID = sc.nextInt();
            	System.out.println("Account ID");
        		int transactionAccountID = sc.nextInt();
        		sc.nextLine();
            	System.out.println("Type(Deposit/Withdrawal):");
        		String transactionType = sc.nextLine();
        		System.out.println("Amount:");
        		double amount = sc.nextDouble();
        		
        		Transaction transaction = new Transaction(transactionAccountID, transactionType, amount);
        		bankingservice.addTransaction(transaction);
        		
        		break;
        	
            case 5:
            	System.out.println("Enter Customer ID:");
            	int custID = sc.nextInt();
            	
            	Customer foundCustomer = bankingservice.findCustomerById(custID);
            	
            	if(foundCustomer != null) {
            		System.out.println(foundCustomer);
            	}else {
            		System.out.println("Customer ID not found.");
            	}
            	break;
            	
            case 6:
            	System.out.println("Enter Customer ID:");
            	int searchCustId = sc.nextInt();
            	for (Account acc : bankingservice.getAccountsByCustomerId(searchCustId)) {
                    System.out.println(acc);
                }
//            	List<Account> foundAccounts = bankingservice.getAccountsByCustomerId(searchCustId);
//            	System.out.println(foundAccounts);
            	
            	break;
            	
            case 7:
            	System.out.println("Enter Account ID:");
            	int accountId = sc.nextInt();
            	
            	for(Transaction tr : bankingservice.getTransactionsByAccountId(accountId)) {
            		System.out.println(tr);
            	}
            	
            	break;
            	
            case 8:
            	System.out.println("Enter Customer ID:");
            	int beneficiarycustID = sc.nextInt();
            	
            	List<Beneficiary> foundBeneficiary = bankingservice.getBeneficiariesByCustomerld(beneficiarycustID);
            	System.out.println(foundBeneficiary);
            	
            	break;
            	
            case 9:
            	System.out.println("Thank you!!");
            	break;
            	
            default:
            	System.out.println("Invalid choice. Try Again.");
            	break;
            	
            }
		} while(choice!=9);
		
		sc.close();
			
	}

}

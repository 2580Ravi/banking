package demo;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		int accountNumber;
		String accountHolderName;
		String accountType;
		float balance;
		
		do {
			System.out.println("Welcome to Bank Application !!!!");
			System.out.println("1. Create Account");
			System.out.println("2. Get Balance");
			System.out.println("3. Withdraw");
			System.out.println("4. Deposit");
			System.out.println("5. Get Account Details By Account Number");
			System.out.println("6. Get Account Details By Customer name");
			System.out.println("7. Get All Account Details");
			System.out.println("8. Exit");
			System.out.println("Enter Your Choice: ");
			choice = sc.nextInt();
			switch(choice) {
			case 1 : 
				System.out.println("Enter Account Number: ");
				accountNumber = sc.nextInt();
				System.out.println("Enter Account Holder Name: ");
				accountHolderName = sc.next();
				System.out.println("Enter Account type (savings/current)");
				accountType = sc.next();
				System.out.println("Enter Initial Balance: ");
				balance = sc.nextFloat();
				try {
					BankAccount account = new BankAccount(accountNumber, accountHolderName, accountType, balance);
					int rows = BankAccountOperations.addAccount(account);
					if(rows>0) {
						System.out.println("Bank Account Created Successfully");
						System.out.println("Your Account");
					}
					
					
				} catch (LowBalanceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 2:
				System.out.println("Enter Account Number: ");
				accountNumber = sc.nextInt();
				try {
					BankAccountOperations op = new BankAccountOperations();
					balance = BankAccountOperations.getBalance(accountNumber);
					if(balance >= 0) {
						System.out.println("Balance for "+accountNumber+" is:"+balance);
					}else {
						System.out.println(accountNumber+" does Not Exist");
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				break;
			case 3 :
				System.out.println("Enter Account Number: ");
				accountNumber = sc.nextInt();
				System.out.println("Enter Amount to be Withdrawn: ");
				float withdrawlAmount = sc.nextFloat();
				BankAccountOperations.withdrawal(withdrawlAmount, accountNumber);
				break;
			case 4 :
				System.out.println("Enetr Account Number: ");
				accountNumber = sc.nextInt();
				System.out.println("Enter Amount to be Deposited: ");
				float depositAmount = sc.nextFloat();
				BankAccountOperations.deposit(depositAmount, accountNumber);
				break;
			case 5 :
				System.out.println("Enter Account Number: ");
				accountNumber = sc.nextInt();
				BankAccountOperations.getAccountInfoByAccountNumber(accountNumber);
				break;
			case 6 : 
				System.out.println("Enter Customer Name: ");
				accountHolderName = sc.next();
				BankAccountOperations.getAccountInfoByCustomerName(accountHolderName);
				break;
			case 7 :
				BankAccountOperations.getAllAccountsInfo();
				break;
			case 8 :
				System.exit(1);
			default : System.out.println("Invalid Choice");
			}
		}while(choice != 2);
	}
	
}

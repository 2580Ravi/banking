package demo;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		do {
			System.out.println("Welcome to Bank Application !!!!");
			System.out.println("1. Create Account");
			System.out.println("2. Exit");
			System.out.println("Enter Your Choice: ");
			choice = sc.nextInt();
			switch(choice) {
			case 1 : 
				System.out.println("Enter Account Number: ");
				int accountNumber = sc.nextInt();
				System.out.println("Enter Account Holder Name: ");
				String accountHolderName = sc.next();
				System.out.println("Enter Account type (savings/current)");
				String accountType = sc.next();
				System.out.println("Enter Initial Balance: ");
				float balance = sc.nextFloat();
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
			case 2 :
			
				System.exit(1);
			default : System.out.println("Invalid Choice");
			}
		}while(choice != 2);
	}
	
}

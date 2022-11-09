package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class BankAccount {
	private int accountNumber;
	private String accountHolderName;
	private String accountType;
	private float balance;
	
	 private static Logger logger=LogManager.getLogger(BankAccount.class.getName());

	    public BankAccount(int accountNumber, String accountHolderName, String accountType, float balance) throws LowBalanceException {
	        if(accountType.equalsIgnoreCase("savings")) {
	            if(balance<1000) {
	                logger.info("LowBalanceException in BankAccount Constructor for saving Account!!!!");
	                throw new LowBalanceException("Minimum balance for savings Account Must be 1000 at least");
	            }
	        }
	        else if(accountType.equalsIgnoreCase("current")) {
	            if(balance<5000) {
	                logger.info("LowBalanceException in BankAccount Constructor for Current Account!!!!");
	                throw new LowBalanceException("Minimum balance for current Account Must be 5000 at least");
	            }
	        }
	        this.accountNumber = accountNumber;
	        this.accountHolderName = accountHolderName;
	        this.accountType = accountType;
	        this.balance = balance;

	        logger.info("Bank Account Object Created Sucessfully for account number : "+accountNumber+" !!!!");
	    }
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
}
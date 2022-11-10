package demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankAccountOperations {
	
	public static int addAccount(BankAccount account) {
		int rows = 0;
		try {
			Connection con = DBConnection.getCon();
			String sql = "insert into bank_account values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, account.getAccountNumber());
			ps.setString(2, account.getAccountHolderName());
			ps.setString(3, account.getAccountType());
			ps.setFloat(4, account.getBalance());
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}
	
	public static float getBalance(int accountNumber) {
		float balance = -1;
		
		try {
			Connection con = DBConnection.getCon();
			String sql = "select balance from bank_account where acc_no = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, accountNumber);
			ResultSet rs =  ps.executeQuery();
			while(rs.next()) {
				balance = rs.getFloat(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return balance;
	}
	
	
	public static void getAccountInfoByAccountNumber(int accountNumber) {
	    try {
	         Connection con = DBConnection.getCon();
	         String sql="select * from bank_account where acc_no=?";
	         PreparedStatement ps = con.prepareStatement(sql);
	         ps.setInt(1, accountNumber);
	         ResultSet rs=ps.executeQuery();
	         while(rs.next()) {
	             System.out.println("Account Number: "+rs.getInt(1));
	             System.out.println("Customer Name: "+rs.getString(2));
	             System.out.println("Account Type: "+rs.getString(3));
	             System.out.println("Balance: "+rs.getFloat(4));
	             
	         }
	         
	     }catch (SQLException e) {
	           // TODO Auto-generated catch block
	           e.printStackTrace();
	       }
	         
	}
	public static void getAccountInfoByCustomerName(String name) {
	    try {
	         Connection con = DBConnection.getCon();
	         String sql="select * from bank_account where acc_holder_name=?";
	         PreparedStatement ps = con.prepareStatement(sql);
	         ps.setString(1, name);
	         ResultSet rs=ps.executeQuery();
	         while(rs.next()) {
	             
	             System.out.println();
	             System.out.println("Account Number: "+rs.getInt(1));
	             System.out.println("Customer Name: "+rs.getString(2));
	             System.out.println("Account Type:"+rs.getString(3));
	             System.out.println("Balance:"+rs.getFloat(4));
	             
	         }
	     }catch (SQLException e) {
	          // TODO Auto-generated catch block
	          e.printStackTrace();
	      }
	
	}
	
	public static void getAllAccountsInfo() {
	    try {
	        Connection con = DBConnection.getCon();
	         String sql="select * from bank_account ";
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs=ps.executeQuery();
	         while(rs.next()) {
	        	 System.out.println();
	             System.out.println("Account Number: "+rs.getInt(1));
	             System.out.println("Customer Name: "+rs.getString(2));
	             System.out.println("Account Type:"+rs.getString(3));
	             System.out.println("Balance:"+rs.getFloat(4));
	         }
	    }catch (SQLException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}
	
	public static int withdrawal(float balance,int accountNumber) {
	     int rowsUpdated=0;
	     float funds=0;
	     try {
	         Connection con = DBConnection.getCon();
	         String sql1="select balance from bank_account where acc_no=?";
	         String sql="update  bank_account set balance=? where acc_no=?";
	         PreparedStatement ps = con.prepareStatement(sql);
	         PreparedStatement ps1 = con.prepareStatement(sql1);
	         ps1.setInt(1,accountNumber);
	         ResultSet rs=ps1.executeQuery();
	         while(rs.next()) {
	              funds=rs.getFloat(1);
	             
	         }
	         funds=funds-balance;
	         
	         ps.setDouble(1,funds);
	            ps.setInt(2, accountNumber);
	            
	            rowsUpdated=ps.executeUpdate();
	     }catch(SQLException e) {
	         e.printStackTrace();    
	     }
	     if(rowsUpdated>0) {
	    	 System.out.println("Transaction is Successful");
	     }
	     return rowsUpdated;
	}
	
    public static int deposit(float balance,int accountNumber) {
        int rowsUpdated=0;
        float funds=0;
        try {
            Connection con = DBConnection.getCon();
            String sql1="select balance from bank_account where acc_no=?";
            String sql="update  bank_account set balance=? where acc_no=?";
            PreparedStatement ps = con.prepareStatement(sql);
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setInt(1,accountNumber);
            ResultSet rs=ps1.executeQuery();
            while(rs.next()) {
                 funds=rs.getFloat(1);
                
            }
             funds=funds+balance;
            
            ps.setDouble(1,funds);
            ps.setInt(2, accountNumber);   
            rowsUpdated=ps.executeUpdate();
        }catch(SQLException e) {
            e.printStackTrace();    
        }
        if(rowsUpdated > 0) {
        	System.out.println("Deposited Successfully");
        }
        return rowsUpdated;
    }


	
	
}

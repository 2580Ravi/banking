package demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
}

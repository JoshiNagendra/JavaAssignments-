package jdbcAssignment_3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {
	public static void updateData() throws SQLException {
		Connection connection =null;
		PreparedStatement pstmnt =null;
		System.out.println("Welcome to JDBC Application");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name to update");
		String name = sc.next();
		System.out.println("Enter the id to update the name");
		int id = sc.nextInt();
		String query ="update cricketteam set sname =? where sid =?";
		try {
			connection =JavaUtil.getConnection();
			if(connection !=null) {
				pstmnt=connection.prepareStatement(query);
				if(pstmnt!=null) {
					pstmnt.setString(1,name);
					pstmnt.setInt(2, id);
					int rowsAffec =pstmnt.executeUpdate();
					System.out.println("Rows Affected  :"+rowsAffec);
				}
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception f) {
			f.printStackTrace();
		}finally{
			if(sc!=null) {
				sc.close();
			}
			JavaUtil.closeConnection(connection, pstmnt, null);
		}
		
	}

}

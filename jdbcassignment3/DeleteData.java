package jdbcassignment3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteData {
	public static void deleteData() throws SQLException {
		Connection connection = null;
		PreparedStatement pstmnt = null;
		System.out.println("Welcome to jdbc application");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id to delete the data");
		int id = sc.nextInt();
		String query = "delete from cricketteam where sid =?";
		try {
			connection = JavaUtil.getConnection();
			if (connection != null) {
				pstmnt = connection.prepareStatement(query);
				if (pstmnt != null) {
					pstmnt.setInt(1, id);
					int rowsAffec =pstmnt.executeUpdate();
				    System.out.println("Rows Affected :"+rowsAffec);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}catch(Exception f) {
			f.printStackTrace();
		}finally {
			if(sc!=null) {
				sc.close();
				JavaUtil.closeConnection(connection, pstmnt, null);
			}
		}

	}

}

package jdbcassignment3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData {
	public static void insertData() throws SQLException {
		Connection connection = null;
		PreparedStatement pstmnt =null;
		ResultSet result = null;
		Scanner sc= new Scanner(System.in);
		System.out.println("Welcome to JDBC Application");
		System.out.println("Enter the id");
		int id = sc.nextInt();
		System.out.println("Enter the name ");
		String name = sc.next();
		System.out.println("Enter the age ");
		int age= sc.nextInt();
		System.out.println("Enter the team");
		String team = sc.next();
		String query="insert into cricketteam(`sid`,`sname`,`sage`,`steam`) values(?,?,?,?)";
		try {
			connection=JavaUtil.getConnection();
			if(connection !=null) {
				
				pstmnt =connection.prepareStatement(query);
				pstmnt.setInt(1,id);
				pstmnt.setString(2,name);
				pstmnt.setInt(3, age);
				pstmnt.setString(4, team);
			}
			if(pstmnt !=null) {
				int rowsEffected =pstmnt.executeUpdate();
				System.out.println(rowsEffected);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception f) {
			f.printStackTrace();
		}finally {
			if(sc !=null) {
				sc.close();
			}
			JavaUtil.closeConnection(connection, pstmnt, result);
		}
	}

}

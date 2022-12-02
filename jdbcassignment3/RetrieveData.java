package jdbcassignment3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetrieveData {
	public static  void retrieveData() throws SQLException {
		Connection connection =null;
		PreparedStatement pstmnt =null;
		ResultSet result = null;
		System.out.println("Welcome to JDBC Application");
		String query ="select * from cricketteam";
		try {
			connection=JavaUtil.getConnection();
			if(connection!=null) {
				pstmnt=connection.prepareStatement(query);
				if(pstmnt !=null) {
					result=pstmnt.executeQuery();
					if(result!=null) {
						while(result.next()) {
							int id =result.getInt(1);
							String name=result.getString(2);
							int age= result.getInt(3);
							String team=result.getString(4);
							System.out.println(id+"\t"+name+"\t"+age+"\t"+team);
						}
					}
				}
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception f) {
			f.printStackTrace();
		}finally {
			JavaUtil.closeConnection(connection, pstmnt, result);
		}
		
	}

}

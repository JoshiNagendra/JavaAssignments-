package jdbcAssignment_3;

import java.sql.SQLException;
import java.util.Scanner;

public class JdbcApp {
	public static void main(String[] args) throws SQLException {
		System.out.println("Welcome to JDBC Application");
		Scanner sc = new Scanner(System.in);
		System.out.println("Options listed below");
		System.out.println("1 - Insert");
		System.out.println("2 - Delete");
		System.out.println("3 - Update");
		System.out.println("4 - Read");
		System.out.println("Choose one option in int format");
		int n = sc.nextInt();
		if(n==1) {
			InsertData.insertData();
		}else if(n==2) {
			DeleteData.deleteData();
		}else if(n==3) {
			Update.updateData();
		}else if(n==4) {
			RetrieveData.retrieveData();
		}else {
			System.out.println("There is no option found tata tata bye bye");
		}
		System.out.println();
		System.out.println("Thank you have a nice day");
	}

}

package testjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class testJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 try {
	Class.forName("oracle.jdbc.OracleDriver");
	System.out.println("++++++++++DRIVER LOADED+++++++++++++");
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","system","system");
	System.out.println("++++++connected to database++++++++++++++");
} catch (ClassNotFoundException e) {

	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 
	}

}

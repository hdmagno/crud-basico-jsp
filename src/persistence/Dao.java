package persistence;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {
	
	Connection con;
	
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/aula5";
	private final String USUARIO = "root";
	private final String SENHA = "1234";
	
	public void open() throws Exception {
		con = null;
		Class.forName(DRIVER);
		con = DriverManager.getConnection(URL, USUARIO, SENHA);
	}
	
	public void close() throws Exception {
		if(con != null || !con.isClosed()) {
			con.close();
		}
	}

}

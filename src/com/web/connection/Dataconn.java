package com.web.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dataconn {

	@SuppressWarnings("exports")
	public static Connection conn() {

		Connection dm = null;

		try {
			// If I don't use the class java.sql.SQLException: No suitable driver found for jdbc:mysql://localhost:3306/
			// But if I use it, it says it is deprecated when running
			Class.forName("com.mysql.jdbc.Driver");
			dm = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/2_working_sound_pair?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"alvaro", "alvaro666");
			if (dm != null) {
				//System.out.println("Connected to the database ws_poc");
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dm;
	}

	public static void closeConn(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
				//System.out.println("Connection closed");
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
}

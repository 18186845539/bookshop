package org.ccunix.javaweb.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBManager {
	
	public static SessionFactory factory;
	
	static {
		Configuration cfg = new Configuration();
		Configuration c = cfg.configure("db.xml");
		factory= c.buildSessionFactory();
	}
	
	public static Session getSession() {
		return  factory.openSession();
	}
	
	public static Connection getConnection(){
		Connection connection = null;
		try {
			String driver="com.mysql.jdbc.Driver";
			String user="root";
			String password="123456";
			String url="jdbc:mysql://localhost:3306/db_eshop";
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return connection;
	}
	public static void close(Connection connection,Statement statement){
		try {
			if(connection!=null && !connection.isClosed()){
				connection.close();
			}
			if(statement!=null && !statement.isClosed()){
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		//System.out.println(DBManager.getConnection());
		System.out.println(DBManager.getSession());
	}
}

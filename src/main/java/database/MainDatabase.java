package database;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.tools.DeleteDbFiles;


// H2 Database Example

public class MainDatabase {

	private static final String DB_DRIVER = "org.h2.Driver";
	private static final String DB_CONNECTION = "jdbc:h2:~/database";
	private static final String DB_USER = "admin";
	private static final String DB_PASSWORD = "admin";


	//	public static void main(String[] args) throws Exception {
	//		try {
	//			// delete the H2 database named 'test' in the user home directory
	//			DeleteDbFiles.execute("~", "database", true);
	//			insertWithStatement();
	//			DeleteDbFiles.execute("~", "database", true);
	//			insertWithPreparedStatement();
	//
	//		} catch (SQLException e) {
	//			e.printStackTrace();
	//		}
	//	}

	public static void createTableLaboratoire() throws SQLException {
		Connection connection = getDBConnection();
		PreparedStatement createPreparedStatement = null;

		String CreateTable = "CREATE TABLE LABORATOIRE(id int primary key, name varchar(255) NOT NULL, mail varchar(255) NOT NULL, phoneNumber int(10) NOT NULL, password varchar(255) NOT NULL)";

		try {
			connection.setAutoCommit(false);

			createPreparedStatement = connection.prepareStatement(CreateTable);
			createPreparedStatement.executeUpdate();
			createPreparedStatement.close();
			connection.commit();
		} catch (SQLException e) {
			System.out.println("Exception Message " + e.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

	}


	public static void addLaboratoire(String name,String password, String email, int phoneNumber) throws SQLException{
		Connection connection = getDBConnection();
		String InsertQuery = "INSERT INTO LABORATOIRE" + "(id, name, mail, phoneNumber, password) values" + "(?,?,?,?,?)";
		PreparedStatement insertPreparedStatement = null;

		try {
			connection.setAutoCommit(false);

			insertPreparedStatement = connection.prepareStatement(InsertQuery);
			insertPreparedStatement.setInt(1, 1);
			insertPreparedStatement.setString(2, name);
			insertPreparedStatement.setString(3, email);
			insertPreparedStatement.setInt(4, phoneNumber);
			insertPreparedStatement.setString(5, password);
			insertPreparedStatement.executeUpdate();
			insertPreparedStatement.close();

			connection.commit();
		} catch (SQLException e) {
			System.out.println("Exception Message " + e.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

	}
	
	public static void getAllLaboratoire() throws SQLException{
		Connection connection = getDBConnection();
		String SelectQuery = "select * from LABORATOIRE";
		PreparedStatement selectPreparedStatement = null;

		try {
			connection.setAutoCommit(false);

			selectPreparedStatement = connection.prepareStatement(SelectQuery);
			ResultSet rs = selectPreparedStatement.executeQuery();
			System.out.println("H2 Database inserted through PreparedStatement");
			while (rs.next()) {
				System.out.println("Id "+rs.getInt("id")+" Name "+rs.getString("name")+" Phone "+rs.getString("phoneNumber")+" mail "+rs.getString("mail")+rs.getString("password"));
			}
			selectPreparedStatement.close();

			connection.commit();
		} catch (SQLException e) {
			System.out.println("Exception Message " + e.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

	}	

	// H2 SQL Prepared Statement Example
	//	private static void insertWithPreparedStatement() throws SQLException {
	//		Connection connection = getDBConnection();
	//		PreparedStatement createPreparedStatement = null;
	//		PreparedStatement insertPreparedStatement = null;
	//		PreparedStatement selectPreparedStatement = null;
	//
	//		String CreateQuery = "CREATE TABLE LABORATOIRE(id int primary key, name varchar(255) NOT NULL, mail varchar(255) NOT NULL, phoneNumber int(10) NOT NULL, password varchar(255) NOT NULL)";
	//		String InsertQuery = "INSERT INTO LABORATOIRE" + "(id, name, mail, phoneNumber, password) values" + "(?,?,?,?,?)";
	//		String SelectQuery = "select * from LABORATOIRE";
	//		try {
	//			connection.setAutoCommit(false);
	//
	//			createPreparedStatement = connection.prepareStatement(CreateQuery);
	//			createPreparedStatement.executeUpdate();
	//			createPreparedStatement.close();
	//
	//			insertPreparedStatement = connection.prepareStatement(InsertQuery);
	//			insertPreparedStatement.setInt(1, 1);
	//			insertPreparedStatement.setString(2, "Jose");
	//			insertPreparedStatement.executeUpdate();
	//			insertPreparedStatement.close();
	//
	//			//			selectPreparedStatement = connection.prepareStatement(SelectQuery);
	//			//			ResultSet rs = selectPreparedStatement.executeQuery();
	//			//			System.out.println("H2 Database inserted through PreparedStatement");
	//			//			while (rs.next()) {
	//			//				System.out.println("Id "+rs.getInt("id")+" Name "+rs.getString("name"));
	//			//			}
	//			//			selectPreparedStatement.close();
	//
	//			connection.commit();
	//		} catch (SQLException e) {
	//			System.out.println("Exception Message " + e.getLocalizedMessage());
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//		} finally {
	//			connection.close();
	//		}
	//	}


	private static Connection getDBConnection() {
		Connection dbConnection = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		try {
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER,
					DB_PASSWORD);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}
}



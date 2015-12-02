package database;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import metier.Atelier;
import metier.Laboratoire;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// H2 Database Example

public class MainDatabase {

	private static final String DB_DRIVER = "org.h2.Driver";
	private static final String DB_CONNECTION = "jdbc:h2:~/database";
	private static final String DB_USER = "admin";
	private static final String DB_PASSWORD = "admin";
	static Map<String,String> passwordcrypte = new HashMap<String, String>(); 

	public static void createTableLaboratoire() throws SQLException {
		Connection connection = getDBConnection();
		PreparedStatement createPreparedStatement = null;


		String CreateTable = "CREATE TABLE IF NOT EXISTS LABORATOIRE(name varchar(255) primary key, mail varchar(255) NOT NULL, phoneNumber varchar(20) NOT NULL, password varchar(255) NOT NULL)";

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

	public static void createTableAtelier() throws SQLException {
		Connection connection = getDBConnection();
		PreparedStatement createPreparedStatement = null;

		String CreateTable = "CREATE TABLE IF NOT EXISTS ATELIERS(name varchar(255) primary key, description varchar(255) NOT NULL, lieu varchar(255) NOT NULL, responsable varchar(255) NOT NULL, date varchar(255) NOT NULL, heure varchar(255) NOT NULL , nbPlace int(8) NOT NULL)";

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



	public static void addLaboratoire(String name, String email, String phoneNumber, String password) throws SQLException{
		Connection connection = getDBConnection();
		String InsertQuery = "INSERT INTO LABORATOIRE" + "(name, mail, phoneNumber, password) values" + "(?,?,?,?)";
		PreparedStatement insertPreparedStatement = null;
		String password2 = "123456";

		try{ MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(password2.getBytes());
		byte byteData[] = md.digest();
		

		//convert the byte to hex format method 1
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		}
		passwordcrypte.put(password,sb.toString());
		
		connection.setAutoCommit(false);

		insertPreparedStatement = connection.prepareStatement(InsertQuery);
		insertPreparedStatement.setString(1, name);
		insertPreparedStatement.setString(2, email);
		insertPreparedStatement.setString(3, phoneNumber);
		insertPreparedStatement.setString(4,sb.toString());
		insertPreparedStatement.executeUpdate();
		insertPreparedStatement.close();

		connection.commit();

		}
		catch (NoSuchAlgorithmException x){   System.out.println("NOT OK");
		}

		catch (SQLException e) {
			System.out.println("Exception Message " + e.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

	}

	public static void addAtelier(String name, String description, String lieu, String responsable, String date, String heure,
			int nbPlace) throws SQLException{
		Connection connection = getDBConnection();
		String InsertQuery = "INSERT INTO ATELIERS" + "(name, description, lieu, responsable, date, heure, nbPlace) values" + "(?,?,?,?,?,?,?)";
		PreparedStatement insertPreparedStatement = null;

		try {
			connection.setAutoCommit(false);

			insertPreparedStatement = connection.prepareStatement(InsertQuery);
			insertPreparedStatement.setString(1, name);
			insertPreparedStatement.setString(2, description);
			insertPreparedStatement.setString(3, lieu);
			insertPreparedStatement.setString(4, responsable);
			insertPreparedStatement.setString(5, date);
			insertPreparedStatement.setString(6, heure);
			insertPreparedStatement.setInt(7, nbPlace);
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

	public static Laboratoire getLaboratoireByName(String name) throws SQLException {
		Connection connection = getDBConnection();
		Laboratoire laboratoire;
		String SelectQuery = "select * from LABORATOIRE WHERE name = name";

		PreparedStatement selectPreparedStatement = null;
		connection.setAutoCommit(false);
		selectPreparedStatement = connection.prepareStatement(SelectQuery);
		ResultSet rs = selectPreparedStatement.executeQuery();
		rs.first();

		laboratoire = new Laboratoire(rs.getString("name"), rs.getString("mail"), rs.getString("phoneNumber"), rs.getString("password"));
		System.out.println("name :" + rs.getString("name"));
		selectPreparedStatement.close();
		connection.commit();
		connection.close();

		return laboratoire;
	}

	public static Atelier getAtelierByResponsable(String responsable) throws SQLException {
		Connection connection = getDBConnection();
		String SelectQuery = "select * from ATELIERS where responsable = responsable";
		PreparedStatement selectPreparedStatement = null;
		connection.setAutoCommit(false);
		selectPreparedStatement = connection.prepareStatement(SelectQuery);
		ResultSet rs = selectPreparedStatement.executeQuery();
		rs.first();
		Atelier atelier = new Atelier(rs.getString("name"), rs.getString("description"), rs.getString("lieu"), rs.getString("responsable") , rs.getString("date") , rs.getString("heure"), rs.getInt("nbPlace"));
		selectPreparedStatement.close();
		connection.commit();
		connection.close();

		return atelier;
	}
	
	public static void printAllLaboratoire() throws SQLException{
		Connection connection = getDBConnection();
		String SelectQuery = "select * from LABORATOIRE";
		PreparedStatement selectPreparedStatement = null;

		try {
			connection.setAutoCommit(false);

			selectPreparedStatement = connection.prepareStatement(SelectQuery);
			ResultSet rs = selectPreparedStatement.executeQuery();
			while (rs.next()) {
				System.out.println(" Name :"+rs.getString("name")+" Phone : "+rs.getString("phoneNumber")+" mail : "+rs.getString("mail")+ " password :" +rs.getString("password"));
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


public static void connexionLabo(String mail, String password) throws SQLException{
// on recupère le mot de passe	
	Connection connection = getDBConnection();
	String SelectQuery = "select* from LABORATOIRE WHERE mail = mail";
	PreparedStatement selectPreparedStatement = null;
	connection.setAutoCommit(false);
	selectPreparedStatement = connection.prepareStatement(SelectQuery);
	ResultSet rs = selectPreparedStatement.executeQuery();
	rs.first();
	System.out.println("mail :" + rs.getString("mail"));

	// on regarde dans la table de hashage
	if (passwordcrypte.get(password) != null){
	if (rs.getString("password").equals(passwordcrypte.get(password)))
	{
		
		System.out.println("Tu peux te connecter " + rs.getString("password")+" " + passwordcrypte.get(password) );
	}
	else {
		System.out.println("Tu ne peux pas te connecter |" +   rs.getString("password")+"| |" + passwordcrypte.get(password)+ "|");
	}
	}
	else {
		
	System.out.println("ADRESSE MAIL NON ENREGISTREE");
	}
	
	
}

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



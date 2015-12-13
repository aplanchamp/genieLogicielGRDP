package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import metier.Atelier;
import metier.Laboratoire;
import spark.ModelAndView;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// H2 Database Example

public class MainDatabase {

	private static final String DB_DRIVER = "org.h2.Driver";
	private static final String DB_CONNECTION = "jdbc:h2:~/database";
	private static final String DB_USER = "admin";
	private static final String DB_PASSWORD = "admin";
	static Map<String, String> passwordcrypte = new HashMap<String, String>();

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
			System.out.println("Table LABORATOIRE created");
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
			System.out.println("Table ATELIERS created");

		} catch (SQLException e) {
			System.out.println("Exception Message " + e.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

	}

	public static void dropTableLaboratoire() throws SQLException {
		Connection connection = getDBConnection();
		PreparedStatement createPreparedStatement = null;

		String DropTable = "DROP TABLE LABORATOIRE";
		try {
			connection.setAutoCommit(false);

			createPreparedStatement = connection.prepareStatement(DropTable);
			createPreparedStatement.executeUpdate();
			createPreparedStatement.close();
			connection.commit();
			System.out.println("Drop laboratoire success");

		} catch (SQLException e) {
			System.out.println("Exception Message " + e.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

	}

	public static void dropTableAteliers() throws SQLException {
		Connection connection = getDBConnection();
		PreparedStatement createPreparedStatement = null;

		String DropTable = "DROP TABLE ATELIERS";
		try {
			connection.setAutoCommit(false);

			createPreparedStatement = connection.prepareStatement(DropTable);
			createPreparedStatement.executeUpdate();
			createPreparedStatement.close();
			connection.commit();
			System.out.println("Drop ateliers success");
		} catch (SQLException e) {
			System.out.println("Exception Message " + e.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

	}

	public static void addLaboratoire(String name, String email, String phoneNumber, String password)
			throws SQLException {
		Connection connection = getDBConnection();
		String InsertQuery = "INSERT INTO LABORATOIRE" + "(name, mail, phoneNumber, password) values" + "(?,?,?,?)";
		PreparedStatement insertPreparedStatement = null;


		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte byteData[] = md.digest();

			// convert the byte to hex format method 1
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			passwordcrypte.put(password, sb.toString());

			connection.setAutoCommit(false);

			insertPreparedStatement = connection.prepareStatement(InsertQuery);
			insertPreparedStatement.setString(1, name);
			insertPreparedStatement.setString(2, email);
			insertPreparedStatement.setString(3, phoneNumber);
			insertPreparedStatement.setString(4, sb.toString());
			insertPreparedStatement.executeUpdate();
			insertPreparedStatement.close();

			connection.commit();

		} catch (NoSuchAlgorithmException x) {
			System.out.println("NOT OK");
		}

		catch (SQLException e) {
			System.out.println("Exception Message " + e.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

	}

	public static void addAtelier(String name, String description, String lieu, String responsable, String date,
			String heure, int nbPlace) throws SQLException {
		Connection connection = getDBConnection();
		String InsertQuery = "INSERT INTO ATELIERS"
				+ "(name, description, lieu, responsable, date, heure, nbPlace) values" + "(?,?,?,?,?,?,?)";
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

	public static void updateAtelier(String nameBase, String name, String description, String lieu, String responsable,
			String date, String heure, int nbPlace) throws SQLException {
		Connection connection = getDBConnection();
		String updateQuery = "UPDATE ATELIERS SET " + "(name, description, lieu, responsable, date, heure, nbPlace) = "
				+ "(\'" + name + "\', \'" + description + "\', \'" + lieu + "\', \'" + responsable + "\', \'" + date
				+ "\', \'" + heure + "\', \'" + nbPlace + "\')" + "WHERE name = \'" + nameBase + "\'";
		PreparedStatement updatePreparedStatement = null;

		try {
			connection.setAutoCommit(false);

			updatePreparedStatement = connection.prepareStatement(updateQuery);
			updatePreparedStatement.executeUpdate();
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
		String SelectQuery = "select * from LABORATOIRE WHERE name = \'" + name + "\' ";
		PreparedStatement selectPreparedStatement = null;
		connection.setAutoCommit(false);
		selectPreparedStatement = connection.prepareStatement(SelectQuery);
		ResultSet rs = selectPreparedStatement.executeQuery();
		rs.first();

		laboratoire = new Laboratoire(rs.getString("name"), rs.getString("mail"), rs.getString("phoneNumber"),
				rs.getString("password"));
		System.out.println("name :" + rs.getString("name"));
		selectPreparedStatement.close();
		connection.commit();
		connection.close();

		return laboratoire;
	}

	public static void printAllLaboratoire() throws SQLException {
		Connection connection = getDBConnection();
		String SelectQuery = "select * from LABORATOIRE";
		PreparedStatement selectPreparedStatement = null;

		try {
			connection.setAutoCommit(false);

			selectPreparedStatement = connection.prepareStatement(SelectQuery);
			ResultSet rs = selectPreparedStatement.executeQuery();
			while (rs.next()) {
				System.out.println(" Name :" + rs.getString("name") + " Phone : " + rs.getString("phoneNumber")
						+ " mail : " + rs.getString("mail") + " password :" + rs.getString("password"));
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

	public static void printAllAtelier() throws SQLException {
		Connection connection = getDBConnection();
		String SelectQuery = "select * from ATELIERS";
		PreparedStatement selectPreparedStatement = null;

		try {
			connection.setAutoCommit(false);

			selectPreparedStatement = connection.prepareStatement(SelectQuery);
			ResultSet rs = selectPreparedStatement.executeQuery();
			while (rs.next()) {
				System.out.println(
						" Name :" + rs.getString("name") + " Responsable : '" + rs.getString("responsable") + "'");
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

	public static List<Atelier> getAtelierByResponsable(String responsable) throws SQLException {
		Connection connection = getDBConnection();
		String SelectQuery = "select * from ATELIERS where responsable = \'" + responsable + "\' ";
		System.out.println(SelectQuery);
		PreparedStatement selectPreparedStatement = null;
		connection.setAutoCommit(false);
		selectPreparedStatement = connection.prepareStatement(SelectQuery); // Exception
																			// handled
																			// -
																			// no
																			// table
																			// Ateliers
																			// created
																			// yet
		System.out.println("Fonction Maindatabase.getAtelierByResponsable");
		Atelier iteratorAtelier = null;
		List<Atelier> listAtelier = new ArrayList<Atelier>();

		try {
			connection.setAutoCommit(false);
			selectPreparedStatement = connection.prepareStatement(SelectQuery);
			ResultSet rs = selectPreparedStatement.executeQuery();
			while (rs.next()) {
				iteratorAtelier = new Atelier(rs.getString("name"), rs.getString("description"), rs.getString("lieu"),
						rs.getString("responsable"), rs.getString("date"), rs.getString("heure"), rs.getInt("nbPlace"));
				listAtelier.add(iteratorAtelier);
				System.out.println(
						"Name:" + iteratorAtelier.getName() + "Responsable: " + iteratorAtelier.getResponsable());
				System.out.println(" Name :" + rs.getString("name") + " Responsable : " + rs.getString("responsable"));
			}
			selectPreparedStatement.close();

			connection.commit();

			return listAtelier;
		} catch (SQLException e) {
			System.out.println("Exception Message " + e.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Map<String, Object> attributes = new HashMap<>();
			System.out.println("Exception handled - no table Ateliers created yet");
			listAtelier = new ArrayList<Atelier>();
			listAtelier.add(new Atelier("Aucun", "Vous n'avez pas encore enregistré d'atelier", "", "", "", "", 0));
			attributes.put("ateliers", listAtelier);
			connection.close();
		}

		return null;
	}

	public static Atelier getAtelierByName(String name) throws SQLException {
		Connection connection = getDBConnection();
		String SelectQuery = "select * from ATELIERS where name = \'" + name + "\' ";
		System.out.println(SelectQuery);
		PreparedStatement selectPreparedStatement = null;
		connection.setAutoCommit(false);
		selectPreparedStatement = connection.prepareStatement(SelectQuery);

		try {
			connection.setAutoCommit(false);
			selectPreparedStatement = connection.prepareStatement(SelectQuery);
			ResultSet rs = selectPreparedStatement.executeQuery();
			Atelier myAtelier = null;
			if (rs.next()) {
				myAtelier = new Atelier(rs.getString("name"), rs.getString("description"), rs.getString("lieu"),
						rs.getString("responsable"), rs.getString("date"), rs.getString("heure"), rs.getInt("nbPlace"));
			}

			System.out.println("L'atelier trouvé contient le nom : " + rs.getString("name"));
			selectPreparedStatement.close();
			connection.commit();

			return myAtelier;
		} catch (SQLException e) {
			System.out.println("Exception Message " + e.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return null;
	}

	public static List<Atelier> getAllAtelier() throws SQLException {
		Connection connection = getDBConnection();
		String SelectQuery = "select * from ATELIERS"; // where date available
		PreparedStatement selectPreparedStatement = null;
		System.out.println("Fonction Maindatabase.getAllAtelier");
		Atelier iteratorAtelier = null;
		List<Atelier> listAtelier = new ArrayList<Atelier>();
		try {

			connection.setAutoCommit(false);
			selectPreparedStatement = connection.prepareStatement(SelectQuery);
			ResultSet rs = selectPreparedStatement.executeQuery();
			while (rs.next()) {
				iteratorAtelier = new Atelier(rs.getString("name"), rs.getString("description"), rs.getString("lieu"),
						rs.getString("responsable"), rs.getString("date"), rs.getString("heure"), rs.getInt("nbPlace"));
				listAtelier.add(iteratorAtelier);
				System.out.println(
						"Name:" + iteratorAtelier.getName() + "Responsable: " + iteratorAtelier.getResponsable());
				System.out.println(" Name :" + rs.getString("name") + " Responsable : " + rs.getString("responsable"));
			}
			selectPreparedStatement.close();

			connection.commit();

			return listAtelier;
		} catch (SQLException e) {
			System.out.println("Exception Message " + e.getLocalizedMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return null;

	}

	public static boolean connexionLabo(String mail, String password) throws SQLException {
		// on recupere le mot de passe
		Connection connection = getDBConnection();

		String SelectQuery = "select* from LABORATOIRE WHERE mail = \'" +mail+"\' ";

		PreparedStatement selectPreparedStatement = null;
		connection.setAutoCommit(false);
		selectPreparedStatement = connection.prepareStatement(SelectQuery);
		ResultSet rs = selectPreparedStatement.executeQuery();
		//rs.first();
		//rs.getString("mail");
	//	System.out.println("mail :" + rs.getString("mail") + " " + passwordcrypte.get(password));
		
		// on regarde dans la table de hashage
		if (rs.first()){
			
			//rs.first();
	//	rs.getString("mail");
			if (rs.getString("password").equals(passwordcrypte.get(password)))
			{
				// connexion possible
				System.out.println("connexion ok");
				return true;
			}
			else {
				//mauvais mot de passe
				System.out.println("mauvais password");
				return false;
			}
		}
		else {
		System.out.println("mauvaise adresse mail");
		return false;
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
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}
}

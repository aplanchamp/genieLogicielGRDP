package database;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class TestMainDatabase {

	@Test
	public void test() throws SQLException {
		MainDatabase.createTableLaboratoire();
		MainDatabase.addLaboratoire("aude", "yo", "aplanchamp@gmail.com", 0633504520);
		MainDatabase.getAllLaboratoire();
	}

}

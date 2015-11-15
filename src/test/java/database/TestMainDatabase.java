package database;

import java.sql.SQLException;

import org.h2.tools.DeleteDbFiles;
import org.junit.Test;

import metier.Laboratoire;

public class TestMainDatabase {

	@Test
	public void test() throws SQLException {
//		DeleteDbFiles.execute("~", "database", true);
//		DeleteDbFiles.execute("~", "database", true);
		MainDatabase.createTableLaboratoire();
		//MainDatabase.addLaboratoire("aude", "yo", "aplanchamp@gmail.com", 0633504520);
		MainDatabase.printAllLaboratoire();
		//Laboratoire myLab = MainDatabase.getLaboratoireByName("aude");
		//System.out.println(myLab.getName() +" "+ myLab.getTelephone() +" "+ myLab.getMail() +" "+ myLab.getPassword());

	}

}

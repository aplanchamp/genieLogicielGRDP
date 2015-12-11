package database;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.h2.tools.DeleteDbFiles;
import org.junit.Test;

import metier.Laboratoire;
import metier.Atelier;

public class TestMainDatabase {

	@Test
	public void test() throws SQLException {

		
		DeleteDbFiles.execute("~", "database", true);
		

	//	Laboratoire labVerify = new Laboratoire("aude", "aplanchamp@gmail.com", "0633504520", "test");

		Atelier atelierVerify = new Atelier("nomAtelier", "descriptionAtelier", "paris", "aude", "12/08/2015", "12:30", 40);
		
		MainDatabase.createTableLaboratoire();
		MainDatabase.createTableAtelier();
		
		MainDatabase.addLaboratoire("aude", "aplanchamp@gmail.com", "0633504520", "yo");
		MainDatabase.addAtelier("nomAtelier", "descriptionAtelier", "paris", "aude", "12/08/2015", "12:30", 40);
		MainDatabase.printAllLaboratoire();
		
		Laboratoire myLab = MainDatabase.getLaboratoireByName("aude");
		//Atelier myAtelier = MainDatabase.getAtelierByResponsable("aude");

		
		//assertEquals(myAtelier, atelierVerify);
		assertEquals(MainDatabase.connexionLabo("aplanchamp@gmail.com", "yo"),true);
		assertEquals(MainDatabase.connexionLabo("aplanchamp@gmail.com", "yoo"),false);
		assertEquals(MainDatabase.connexionLabo("aplal.cm", "yoo"),false);


	}

}

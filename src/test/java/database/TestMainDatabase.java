package database;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.h2.tools.DeleteDbFiles;
import org.junit.Test;

import metier.Laboratoire;
import metier.Atelier;

public class TestMainDatabase {

	@Test
	public void test() throws SQLException {

		
		DeleteDbFiles.execute("~", "database", true);
		
		Atelier atelierVerify = new Atelier("nouveauNom", "coucou", "paris", "aude", "12/08/2015", "12:30", "14h30", 40);
		
		MainDatabase.createTableLaboratoire();
		MainDatabase.createTableAtelier();
		
		MainDatabase.addLaboratoire("aude", "aplanchamp@gmail.com", "0633504520", "yo");
		MainDatabase.addAtelier("nomAtelier", "descriptionAtelier", "paris", "aude", "12/08/2015", "12:30", "14h30", 40);

		MainDatabase.printAllLaboratoire();
		
		Laboratoire myLab = MainDatabase.getLaboratoireByName("aude");

		MainDatabase.printAllLaboratoire();
		MainDatabase.printAllAtelier();
		MainDatabase.updateAtelier("nomAtelier", "nouveauNom", "coucou", "paris", "aude", "12/08/2015", "12:30", "14h30",  40);
		MainDatabase.printAllAtelier();
		Atelier myAtelierBis = MainDatabase.getAtelierByName("nouveauNom");
		List<Atelier> myAteliers = MainDatabase.getAtelierByResponsable("aude");


		
		assertEquals(myAteliers.get(0), atelierVerify);
		assertEquals(myAtelierBis, atelierVerify);
		assertEquals(MainDatabase.connexionLabo("aplanchamp@gmail.com", "yo"),true);
		assertEquals(MainDatabase.connexionLabo("aplanchamp@gmail.com", "yoo"),false);
		assertEquals(MainDatabase.connexionLabo("aplal.cm", "yo"),false);

		DeleteDbFiles.execute("~", "database", true);

	}

}

package org.formation.ndiaye.zoo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.formation.ndiaye.zoo.service.AnimalPOJO;
import org.formation.ndiaye.zoo.service.GazellePOJO;
import org.formation.ndiaye.zoo.stockage.DaoFichier;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DaoFichierTests {
	static DaoFichier d ;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		d = new DaoFichier();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
		d= null;
 	}


	@Test
	void testLireTous() {
		assertNotNull(		d.lireTous());
		assertEquals("Rey", d.lire(0).getNom());
	}
	@Test
	void testLire() {
		assertEquals(0,d.lire(0).getIdAnimal());
	}

	@Test
	void testModifier() {
		AnimalPOJO c ;
		c =  new AnimalPOJO();
		c.setIdAnimal(5);
		c.setCodeAnimal("Singe");
		c.setNom("Lula");
		c.setAge(20);
		c.setPoids(253.4);
		c.setY(445);
		c.setX(424);
		d.inserer(c);
		AnimalPOJO c2;
		c2 =  new AnimalPOJO();
		c2.setIdAnimal(6);
		c2.setCodeAnimal("Singe");
		c2.setNom("Hapi");
		c2.setAge(20);
		c2.setPoids(253.4);
		c2.setY(445);
		c2.setX(424);
		d.inserer(c);
		d.modifier(c.getIdAnimal(),c2);
		assertEquals(d.lire(6).getIdAnimal(), 6);
		assertEquals("Hapi", d.lire(6).getNom() );

	}
	@Test
	void testInserer() {
		AnimalPOJO c ;
		c =  new AnimalPOJO();
		c.setIdAnimal(3);
		c.setCodeAnimal("Lion");
		c.setNom("Blur");
		c.setAge(20);
		c.setPoids(253.4);
		c.setY(445);
		c.setX(424);
		d.inserer(c);
		int n = d.lireTous().size();
		assertEquals(c.getIdAnimal(), d.lire(3).getIdAnimal());
		assertEquals(c.getNom(), d.lire(3).getNom());
	}





	
	@Test
	void testEffacerAnimalPOJO() {
		
	 List<AnimalPOJO> m = d.lireTous();
	 int n = m.size();
		d.effacer(d.lire(6));
		assertEquals(n-1, d.lireTous().size());
	}


}

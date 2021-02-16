package org.formation.ndiaye.zoo;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.formation.ndiaye.zoo.service.AnimalPOJO;
import org.formation.ndiaye.zoo.stockage.Dao;
import org.formation.ndiaye.zoo.stockage.DaoFactory;
import org.formation.ndiaye.zoo.stockage.DaoMemoire;
import org.formation.ndiaye.zoo.utilitaires.Balai;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class DaoMemoireTests {
	static DaoMemoire d ;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		 d = new DaoMemoire();

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		d = null;
		Balai.balayer();
	}

	@Test
	void testInserer() {
		//int n = d.size();
		//assertTrue(d.size()==n+1);
	}

	@Test
	void testModifier() {
	}

	@Test
	void testEffacerInt() {
	}

	@Test
	void testEffacerAnimalPOJO() {
	}

	@Test
	void testLire() {
		AnimalPOJO tmp = (AnimalPOJO) d.lire(0);
		assertEquals(0, tmp.getIdAnimal());
		assertEquals(50, tmp.getX());
		assertNotNull(tmp.getCodeAnimal());
		assertNotNull((((AnimalPOJO) d.lire(1)).getCodeAnimal()));
	}

	@Test
	void testLireTous() {
		List<AnimalPOJO> l = d.lireTous();
		assertEquals(3, l.size() );
		assertEquals(1, l.get(1).getIdAnimal() );
		assertEquals(50, l.get(0).getX() );
 
	}

}

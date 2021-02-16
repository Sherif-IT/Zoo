package org.formation.ndiaye.zoo;

import static org.junit.jupiter.api.Assertions.*;

import org.formation.ndiaye.zoo.modele.Animal;
import org.formation.ndiaye.zoo.modele.Cage;
import org.formation.ndiaye.zoo.modele.Lion;
import org.formation.ndiaye.zoo.modele.technique.CagePleineException;
import org.formation.ndiaye.zoo.modele.technique.PorteException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CageTests {

	@Test
	void testCage() {
		Cage c = new Cage();
		assertEquals(0, c.getX());
		assertEquals(0, c.getY());
		assertEquals(true, c.isOuvert());
		assertFalse(c.estOccupee());
	}

	@Test
	void testCageIntInt() {
		Cage c = new Cage(1,300,500);
		assertEquals(300, c.getX());
		assertEquals(500, c.getY());
		assertEquals(true, c.isOuvert());
		assertFalse(c.estOccupee());
	}

	@Test
	void testEntrer() {
		Cage c = new Cage(1,300,500);
		Animal bete = new Lion();
		assertEquals(300, c.getX());
		assertEquals(500, c.getY());
		c.fermer();
		try {
			c.entrer(bete);
			fail("aurait du jeter une PorteException");
		} catch (PorteException e) {
			assertEquals("Problème de porte", e.getMessage());
		} catch (CagePleineException e) {
			fail("la cage ne devrait pas être pleine");
		}
		c.ouvrir();
		try {
			c.entrer(bete);
			assertTrue(c.estOccupee());
			assertEquals(true, c.isOuvert());
			c.fermer();
		} catch (PorteException e) {
			fail("n'aurait pas du jeter une PorteException");
		} catch (CagePleineException e) {
			fail("la cage ne devrait pas �tre pleine");
		}
		bete= new Lion();
		assertEquals(false, c.isOuvert());
		c.ouvrir();
		assertEquals(true, c.isOuvert());
		try {
			c.entrer(bete);
			fail("la cage devrait être pleine");
		} catch (PorteException e) {
			fail("n'aurait pas du jeter une PorteException");
		} catch (CagePleineException e) {
			assertEquals("La cage est déjà occupée", e.getMessage());
		}
	}

	@Test
	void testSortir() {
		Cage c = new Cage(1,300,500);
		Animal bete = new Lion();
		Animal sauvegarde = bete;
		assertEquals(300, c.getX());
		assertEquals(500, c.getY());
		c.ouvrir();
		try {
			c.entrer(bete);
			assertTrue(c.estOccupee());
			assertEquals(true, c.isOuvert());
			c.fermer();
		} catch (PorteException e) {
			fail("n'aurait pas du jeter une PorteException");
		} catch (CagePleineException e) {
			fail("la cage ne devrait pas �tre pleine");
		}
		try {
			bete = c.sortir();
			fail("la cage est fermée!!!!");
		} catch (PorteException e) {
			assertEquals("Problème de porte", e.getMessage());
		}
		c.ouvrir();
		bete = null;
		assertEquals(true, c.isOuvert());
		try {
			bete = c.sortir();
			assertFalse(c.estOccupee());
			assertEquals(sauvegarde, bete);
			assertEquals(true, c.isOuvert());
			c.fermer();
		} catch (PorteException e) {
			fail("n'aurait pas du jeter une PorteException");
		}
	}

	@Test
	void testOuvrir() {
		Cage c = new Cage(1,300,500);
		assertEquals(true, c.isOuvert());
		c.ouvrir();
		assertEquals(true, c.isOuvert());
		c.fermer();
		assertEquals(false, c.isOuvert());
		c.ouvrir();
		assertEquals(true, c.isOuvert());
		c.ouvrir();
		assertEquals(true, c.isOuvert());
	}

	@Test
	void testFermer() {
		Cage c = new Cage(1,300,500);
		assertEquals(true, c.isOuvert());
		c.fermer();
		assertEquals(false, c.isOuvert());
		c.fermer();
		assertEquals(false, c.isOuvert());
	}

}

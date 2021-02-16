/**
 * 
 */
package org.formation.ndiaye.zoo;

import static org.junit.jupiter.api.Assertions.*;

import org.formation.ndiaye.zoo.controleur.Manageur;
import org.formation.ndiaye.zoo.controleur.Singleton;
import org.formation.ndiaye.zoo.modele.Visiteur;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * @author sheri
 *
 */
class ManagerTests {
	
	private static Manageur m = Manageur.getInstance();
;

	@Test
	void testGetInsance() {
		Manageur s = Manageur.getInstance();
		assertEquals(s, Manageur.getInstance());
	}

	/**
	 * Test method for {@link org.formation.ndiaye.zoo.controleur.Manageur#entrer()}.
	 */
	@Test
	void testEntrer() {
		
		assertEquals(0,Visiteur.getCpteur());
		for (int i = 0; i < Visiteur.MAX*2; i++) {
			m.entrer();
			assertTrue(Visiteur.getCpteur()<= Visiteur.MAX);
		}
		assertEquals(Visiteur.MAX, Visiteur.getCpteur());
		
	}

	/**
	 * Test method for {@link org.formation.ndiaye.zoo.controleur.Manageur#sortir()}.
	 */
	@Test
	void testSortir() {
		int nb = Visiteur.getCpteur();
		//finir de remplir 
		for (int i = 0; i < Visiteur.MAX - nb; i++) {
			m.entrer();
		}
		assertEquals(Visiteur.MAX, Visiteur.getCpteur());
		nb= Visiteur.MAX;
		for (int i = 0; i < Visiteur.MAX * 2; i++) {
			m.sortir();
			if (nb > 0) {
				nb--;
			}
		}
	}

}

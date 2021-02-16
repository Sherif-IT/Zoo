package org.formation.ndiaye.zoo;

import static org.junit.jupiter.api.Assertions.*;

import org.formation.ndiaye.zoo.controleur.Singleton;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SingletonTests {

	@Test
	void testGetInsance() {
		Singleton s = Singleton.getInstance();
		assertEquals(s, Singleton.getInstance());
	}

}

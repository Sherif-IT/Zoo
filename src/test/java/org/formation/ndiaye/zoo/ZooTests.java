package org.formation.ndiaye.zoo;

import static org.junit.jupiter.api.Assertions.*;

import org.formation.ndiaye.zoo.vue.Zoo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ZooTests {

	static Zoo z;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		z = new Zoo();
	}

	@Test
	void testDevorer() {
		//lion lion
		assertEquals("un(e) Lion n'est pas mangeable",z.devorer(0, 5));
		// singe lion
		assertEquals("un(e) Lion n'est pas mangeable",z.devorer(1, 0));
		//singe vide
		assertEquals("la cage n° 2 du mangé est vide!!!!",z.devorer(1,2));
		//singe gazelle
		assertEquals("je suis un(e) Singe et je ne mange pas de Gazelle",z.devorer(1, 3));
		//lion singe
		assertEquals("un(e) Singe n'est pas mangeable",z.devorer(0,1));
		//lion vide
		assertEquals("la cage n° 2 du mangé est vide!!!!",z.devorer(0, 2));
		//lion gazelle
		assertEquals("MIAM",z.devorer(0, 3));
	}

}

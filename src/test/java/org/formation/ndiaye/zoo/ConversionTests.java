package org.formation.ndiaye.zoo;
import org.formation.ndiaye.zoo.stockage.*;
import org.formation.ndiaye.zoo.utilitaires.Conversion;
import org.formation.ndiaye.zoo.modele.Cage;
import org.formation.ndiaye.zoo.service.*;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ConversionTests {


	@Test
	void testPojoToCage() {
		Cage  cage = null;
		
		List<AnimalPOJO> aTester = null;
		aTester = DaoFactory.getInstance().getDao().lireTous();
		cage = Conversion.pojoToCage(aTester.get(0));
		assertEquals(1, cage.getCle());
		assertEquals(50, cage.getX());
		
	}

}

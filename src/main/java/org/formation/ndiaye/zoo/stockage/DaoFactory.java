/**
 * 
 */
package org.formation.ndiaye.zoo.stockage;

import org.formation.ndiaye.zoo.modele.Cage;
import org.formation.ndiaye.zoo.modele.Personne;
import org.formation.ndiaye.zoo.service.AnimalPOJO;

/**
 * @author sheri
 *
 */
public class DaoFactory {

	private static DaoFactory instance = new DaoFactory();
	/**
	 * 
	 */
	private DaoFactory() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the instance
	 */
	public static DaoFactory getInstance() {
		return instance;
	}
	public DaoFichier getDao() {
		
		return new DaoFichier();

	}
}

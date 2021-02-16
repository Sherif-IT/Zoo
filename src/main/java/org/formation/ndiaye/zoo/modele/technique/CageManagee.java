/**
 * 
 */
package org.formation.ndiaye.zoo.modele.technique;

import org.formation.ndiaye.zoo.modele.Animal;
import org.formation.ndiaye.zoo.modele.Cage;
import org.formation.ndiaye.zoo.modele.Mangeable;
import org.formation.ndiaye.zoo.service.AnimalPOJO;
import org.formation.ndiaye.zoo.stockage.Dao;
import org.formation.ndiaye.zoo.stockage.DaoMemoire;
import org.formation.ndiaye.zoo.utilitaires.Conversion;

/**
 * @author sheri
 *
 */
public class CageManagee {

	private Cage cage;
	private AnimalPOJO pojo;
	private Dao<AnimalPOJO> dao;
	/**
	 * 
	 */

	public CageManagee(Dao<AnimalPOJO> dao,AnimalPOJO pojo) {
		this.dao = dao;//modele
		this.pojo = pojo;//controleit
		cage = Conversion.pojoToCage(pojo);//vue
	}
	
	public String getInfos() {
		return cage.getInfos();
		
	}
	public void nourrir() {
		cage.nourrir();
		// changer poid s pojo selon poids cage
		/**
		if (cage.estOccupee()) {
			
		}
		**/
		dao.modifier(pojo.getIdAnimal(), pojo);
	}
	public void entrer(Animal bete) throws PorteException, CagePleineException {
		cage.entrer(bete);
		//metre a jour/changer pojo
		dao.modifier(pojo.getIdAnimal(), pojo);
	}
	public boolean estOccupee() {
	return cage.estOccupee();
	}
	public Animal sortir() throws PorteException {
		//FIXME sortir modifier return 
		dao.modifier(pojo.getIdAnimal(), pojo);
		
		return cage.sortir();

	}
	public String devorer(Mangeable bete) throws CagePleineException, BeurkException {
		//FIXME pojo +ordre
		dao.modifier(pojo.getIdAnimal(), pojo);
		return cage.devorer(bete);
	}
	public String toString() {
	return cage.toString();
	}

	public void ouvrir() {
		cage.ouvrir();
	}
	public void fermer() {
		cage.fermer();
	}
}

	


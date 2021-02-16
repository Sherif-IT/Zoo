/**
 * 
 */
package org.formation.ndiaye.zoo.stockage;
import java.util.List;
import java.util.Vector;
import org.formation.ndiaye.zoo.service.*;
import org.formation.ndiaye.zoo.modele.technique.PorteException;

/**
 * @author sheri
 *
 */
public class DaoMemoire implements Dao<AnimalPOJO> {

	private List<AnimalPOJO> lesElts ;
	/**
	 * 
	 */
	public DaoMemoire() {
		lesElts = new Vector<>();
		
		remplir();
	}
	/**
	 * permet d'initialiser les AnimalPOJOs avec les animaux dedans
	 * @throws PorteException
	 * @throws AnimalPOJOPleineException
	 */
	private void remplir() {
		AnimalPOJO c ;
		GazellePOJO gP = null;
		c =  new AnimalPOJO();
		c.setIdAnimal(0);
		c.setCodeAnimal("Lion");
		c.setNom("Rey");
		c.setAge(10);
		c.setPoids(245.2);
		c.setY(23);
		c.setX(50);
		lesElts.add(c);
		c =  new AnimalPOJO();
		c.setCodeAnimal("Singe");
		c.setNom("Marius");
		c.setAge(7);
		c.setY(774);
		c.setX(555);
		c.setPoids(42);
		c.setIdAnimal(1);
		
	
		lesElts.add(c);
		c =  new AnimalPOJO();
		c.setCodeAnimal("Gazelle");
		c.setNom("Pitorio");
		c.setAge(5);
		c.setPoids(130);
		c.setY(100);
		c.setX(340);
		gP = new GazellePOJO();
		gP.setId(1);
		gP.setIdAnimal(2);
		gP.setLgCornes(14);
		c.setGaz(gP);
		lesElts.add(c);

		
		c =  new AnimalPOJO();
		c.setCodeAnimal("Lion");
		c.setNom("Morr");
		c.setAge(7);
		c.setY(774);
		c.setX(555);
		c.setPoids(166);
		c.setIdAnimal(6);
		lesElts.add(c);
		c =  new AnimalPOJO();
		c.setCodeAnimal("Gazelle");

		c.setNom("Uraga");
		c.setAge(18);
		c.setY(554);
		c.setX(884);
		c.setPoids(80);
		gP = new GazellePOJO();
		gP.setId(1);
		gP.setIdAnimal(10);

		gP.setLgCornes(17);
		c.setGaz(gP);
		lesElts.add(c);
		}
	@Override
	public void inserer(AnimalPOJO obj) {
		lesElts.add(obj);
		
	}
	@Override
	public void modifier(int cle, AnimalPOJO obj) {
		lesElts.set(cle, obj);//lesElts.indexOf(obj)
	}
	@Override
	public void effacer(int cle) {
		lesElts.remove(cle);
	}
	@Override
	public void effacer(AnimalPOJO obj) {
		lesElts.remove(obj);		

	}
	@Override
	public AnimalPOJO lire(int cle) {
		return lesElts.get(cle);
	}
	@Override
	public List<AnimalPOJO> lireTous() {
		return  lesElts;
	}
	
}

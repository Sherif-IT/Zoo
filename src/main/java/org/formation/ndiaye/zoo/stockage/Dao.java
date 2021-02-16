/**
 * 
 */
package org.formation.ndiaye.zoo.stockage;

import java.util.List;

import org.formation.ndiaye.zoo.service.AnimalPOJO;

/**
 * @author sheri
 *
 */
public interface Dao<T> {
	public void inserer(T obj);
	public void modifier(int cle, T obj);
	public void effacer(int cle); 
	public void effacer(T obj);
	public T lire(int cle) ;
	public List<AnimalPOJO> lireTous() ;


}

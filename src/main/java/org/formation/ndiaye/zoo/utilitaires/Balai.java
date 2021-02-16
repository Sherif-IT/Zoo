/**
 * 
 */
package org.formation.ndiaye.zoo.utilitaires;

/**
 * @author sherif
 *
 */
public abstract class Balai {
	public static void balayer() {
		System.gc(); //appelle le finalizee des objets sans reference
		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

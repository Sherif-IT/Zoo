package org.formation.ndiaye.zoo.modele;

/**
 * Classe concrête représentant un visiteur du zoo.
 * Le visiteur peut être mangé par un lion par exemple.
 * Il implémente donc l'interface Mangeable
 * version 2: ajout du compteur de visiteurs
 * @author jacques
 *
 */
public final class Visiteur extends Personne implements Mangeable {

	public final static int MAX = 10;
	private static int cpteur = 0;
	
	public Visiteur() {
		cpteur++;
	}

	@Override
	public double prelever() {
		return 15;
	}

	/**
	 * @return the cpteur
	 */
	public static int getCpteur() {
		return cpteur;
	}

	@Override
	protected void finalize() throws Throwable {
		cpteur--;
		super.finalize();
	}

}

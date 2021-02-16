package org.formation.ndiaye.zoo.modele;

/**
 * Classe de base abstraite pour les êtres humains impliqués dans le zoo
 * @author jacques
 *
 */
public abstract class Personne implements EtreVivant {

	public Personne() {
	}

	@Override
	public void manger() {
	}

	@Override
	public String crier() {
		return "je fais du bruit";
	}

	@Override
	public void sauter() {
	}

	@Override
	public void courir() {
	}

	@Override
	public void dormir() {
	}

	@Override
	public String getInfos() {
		String ret = "";
		ret = String.join(" ", "je suis un(e) ",this.getClass().getSimpleName());
		return ret;
	}

}

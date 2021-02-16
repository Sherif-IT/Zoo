package org.formation.ndiaye.zoo.modele;

import java.io.Serializable;

import org.formation.ndiaye.zoo.modele.technique.BeurkException;
import org.formation.ndiaye.zoo.modele.technique.CagePleineException;
import org.formation.ndiaye.zoo.modele.technique.PorteException;

/**
 *  Une cage du zoo. 
 *  Peut être vide ou contenir un seul animal (ASSOCIATION)
 * @author j.Vincensini
 * @version 1.0
 * @since 1.0
 *
 */
public class Cage {
	/**
	 * L'associé dans la relation
	 */
	private Animal occupant;
	/**
	 * absisse de la cage (en pixels)
	 */
	private int x;
	/**
	 * ordonnée de la cage (en pixels)
	 */
	private int y;
	/**
	 * Vrai si la cage est ouverte faux autrement
	 */
	private boolean ouvert;
	/**
	 * cle de la cage identifiant unique et num�rique
	 */
	private int cle;
	
	public Cage() {
		this(0,0,0);
	}
	public Cage(int cle,int x, int y)
	{
		setCle(cle);
		setX(x);
		setY(y);
		setOuvert(true);
		occupant = null;
	}
	/**
	 * 
	 * @param a l'animal que l'on veut faire entrer
	 * @throws PorteException si la cage est fermée
	 * @throws CagePleineException  si la cage est déjà occupée
	 */
	public void entrer(Animal bete) throws PorteException, CagePleineException
	{
		if(!ouvert)
		{
			throw new PorteException();
		}
		if (estOccupee()) {
			throw new CagePleineException();
		}
		occupant = bete;
	}
	/**
	 * 
	 * @return l'animal qui était dans la cage.
	 * Si la cage est vide retourne null
	 * @throws PorteException si la cage n'est pas ouverte
	 */
	public Animal sortir()throws PorteException
	{
		Animal ret = null;
		if (!ouvert)
		{
			throw new PorteException();
		}
		ret = occupant;
		occupant = null;
		return ret;
	}
	public String devorer(Mangeable bete) throws CagePleineException, BeurkException {
		String tmp = String.join(" ", "La cage n°",Integer.toString(cle),"est vide!!!!!");
		if(!estOccupee()) {
			throw new CagePleineException(tmp);
		}
		return occupant.manger(bete);
	}
	public void nourrir() {
		if (estOccupee()) {
			occupant.manger();
		}
	}
	public String getInfos(){
		return toString();
	}
	/**
	 * permet l'ouverture de la cage
	 */
	public void ouvrir()
	{
		setOuvert(true);
	}
	/**
	 * permet la fermeture de la cage
	 */
	public void fermer()
	{
		setOuvert(false);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isOuvert() {
		return ouvert;
	}

	public void setOuvert(boolean ouvert) {
		this.ouvert = ouvert;
	}
	@Override
	public String toString() {
		String ret = null;
		ret =  String.join("", "Cage [x=", Integer.toString(x), ", y=" , Integer.toString(y),"]");
		if (occupant != null)
		{
			ret = String.join("----", ret, occupant.toString());
		}
		else
		{
			ret = String.join("----", ret, "VIDE");
		}
		return ret;
	}
	public int getCle() {
		return cle;
	}
	public void setCle(int cle) {
		this.cle = cle;
	}
	public boolean estOccupee() {
		boolean ret = true;
		if (occupant == null) { 
			ret = false;
		}
		return ret;
	}

}

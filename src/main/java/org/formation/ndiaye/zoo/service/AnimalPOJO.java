/**
 * 
 */
package org.formation.ndiaye.zoo.service;

import java.io.Serializable;

import org.formation.ndiaye.zoo.modele.Gazelle;

/**
 * @author sheri
 *
 */
public class AnimalPOJO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idAnimal;
	private String codeAnimal;
	private String nom;
	private int age;
	private double poids;
	private int x;
	private GazellePOJO gaz; 
	private int y ;
	/**
	 * 
	 */
	public AnimalPOJO() {
		setIdAnimal(0);
		setCodeAnimal(null);
		setNom(null);
		setAge(0);
		setPoids(0);
		setX(100);
		setY(100);
		
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @return the idAnimal
	 */
	public int getIdAnimal() {
		return idAnimal;
	}
	/**
	 * @return the codeAnimal
	 */
	public String getCodeAnimal() {
		return codeAnimal;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @return the poids
	 */
	public double getPoids() {
		return poids;
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param idAnimal the idAnimal to set
	 */
	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}
	/**
	 * @param codeAnimal the codeAnimal to set
	 */
	public void setCodeAnimal(String codeAnimal) {
		this.codeAnimal = codeAnimal;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @param poids the poids to set
	 */
	public void setPoids(double poids) {
		this.poids = poids;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	public GazellePOJO getGaz() {
		// TODO Auto-generated method stub
		return gaz;
	}
	/**
	 * @param gP the gaz to set
	 */
	public void setGaz(GazellePOJO gP) {
		this.gaz = gP;
	}

}

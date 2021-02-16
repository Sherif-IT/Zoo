/**
 * 
 */
package org.formation.ndiaye.zoo.service;

import java.io.Serializable;

/**
 * @author sheri
 *
 */
public class GazellePOJO implements Serializable {

	private int id;
	private int idAnimal;
	private int lgCornes;
	/**
	 * 
	 */
	public GazellePOJO() {
		setId(0);
		setIdAnimal(id);
		setLgCornes(0);
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the idAnimal
	 */
	public int getIdAnimal() {
		return idAnimal;
	}
	/**
	 * @return the lgCornes
	 */
	public int getLgCornes() {
		return lgCornes;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @param idAnimal the idAnimal to set
	 */
	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}
	/**
	 * @param lgCornes the lgCornes to set
	 */
	public void setLgCornes(int lgCornes) {
		this.lgCornes = lgCornes;
	}

}

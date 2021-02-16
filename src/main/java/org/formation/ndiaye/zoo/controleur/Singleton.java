/**
 * 
 */
package org.formation.ndiaye.zoo.controleur;

/**
 * version thread safe 
 * @author sherif
 * @startuml
 * actor util 
 * control Singleton
 *  util ->Singleton:: getInstance()
 *  util -> Singleton: <<create>>
 * @enduml
 */
public class Singleton {
	private static Singleton instance = new Singleton();
	/**
	 * 
	 */
	private Singleton() {
		// TODO Auto-generated constructor stub
	}
	public static Singleton getInstance() {
		
		return instance;
	}
	
}

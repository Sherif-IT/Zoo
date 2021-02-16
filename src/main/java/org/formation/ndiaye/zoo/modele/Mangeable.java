package org.formation.ndiaye.zoo.modele;

/**
 * Contrat pour être mangeabe par le lion.
 * @author j.vincensini
 *
 */
public interface Mangeable {
	/**
	 * Design Pattern ADAPTER
	 * @return la part du lion. soit 1/3 du poids de la proie
	 * 
	 * @startuml
	 * class A{
	 * + m1() 
	 * + m2()
	 * }
	 * note right of A::m1()
	 * Version 1 
	 * end note
	 * note right of A::m2()
	 * Version 2 fait la meme chose que m1 m2 va appeler m1
	 * end note  
	 * @enduml
	 */
	// le design pattern ADAPTER avec la méthode prelever
	public double prelever();
}

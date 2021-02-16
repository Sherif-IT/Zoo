package org.formation.ndiaye.zoo.vue;

import java.util.List;

import org.formation.ndiaye.zoo.controleur.Manageur;
import org.formation.ndiaye.zoo.modele.*;
import org.formation.ndiaye.zoo.modele.technique.BeurkException;
import org.formation.ndiaye.zoo.modele.technique.CagePleineException;
import org.formation.ndiaye.zoo.modele.technique.PorteException;

/**
 * Programme PRINCIPAL 
 * Contient le main
 * @author j.Vincensini
 * @startuml
title Séquence générale du zoo
actor utilisateur
boundary zoo
control manageur
collections Cage
entity Animal
== Initialisation ==
utilisateur -> zoo : <<create>>()
activate zoo
zoo->manageur : <<create>>()
activate manageur
loop N fois
	manageur -> Cage:: <<create(cle,x,y)
	activate Cage
	deactivate Cage
	manageur ->Animal: <<create(nom,age,poids)>>
	activate Animal
	deactivate Animal
	Cage->Animal:entrer(animal)
	activate Animal
	deactivate Animal
	Cage->Cage:fermer()
	activate Cage
	deactivate Cage
end
deactivate manageur
deactivate zoo
== Affichage ==
utilisateur ->zoo:afficher()
@enduml 
* ---------------------------------------------------
* 				CAHIER DES CHARGES Version 2
* ---------------------------------------------------
* ajout comptage des visteurs : 10 visiteurs max dans le zoo.
* Les visiteurs entrent et sortent un par un et sont anonymes.
* ils sont modelises dans le zoo par une pile LIFO.
* chaque visiteur est cree au moment ou il rentre dans le zoo
* il est detruit en sortant
* @startuml
* actor util
* boundary Zoo
* control Manageur
* collection Visiteur
* util-> Zoo:entrer()
* Zoo->Manageur:entrer()
* alt nbVisiteurs < Visiteur.MAX
* 	Manageur -> Visiteur:<<create>>()
*	note right of Visiteur : cpteur++
* end
* ==SORTIR==
* util->Zoo:sortir()
* alt nbVisiteurs > 0 
* 	Manageur ->x Visiteur:<<destroy>>()
*	note right of Visiteur : cpteur --

* end
* @enduml
 *
 */
public final class Zoo {
	/**
	 * Composition sur le manager(V1: ancienne)
	 * @startuml
	 * Zoo *-- Manageur
	 * @enduml
	 */
	//T remplacé par une dépendance grâce au singleton
	/**
	 * @startuml
	 * Zoo ..> Manageur
	 * @enduml
	 */
	//V2 private Manageur manageur;
		
	public Zoo() {	
	}
	public void afficher()
	{
		
		/*
			for (String s : Manageur.getInstance().getInfos()) {
				System.out.println(s);
			}*/
			Manageur.getInstance().getInfos().stream().forEach(s->	System.out.println(s));

	}
	/**
	 * Permet de nourrir tous les animaux du zoo
	 */
	public void nourrir ()
	{
		
			Manageur.getInstance().nourrir();
		
	}
	/**
	 * @startuml
	 * utilisateur->Zoo:devorer(mangeur,mange)
	 * activate Zoo
	 * Zoo->Manageur:devorer(mangeur,mange)
	 * activate Manageur
	 * return "résultat"
	 * @enduml
	 * @param mangeur indice de l'animal mangeur (sa cage)
	 * @param mange indice de la cage de la proie
	 * @return le texte sur ce qu'il s'est passé
	 */
	public String devorer(int mangeur, int mange)
	{
		return Manageur.getInstance().devorer(mangeur,mange);
	}
	
	public int getNbVisiteurs() {
		int n= Manageur.getInstance().getNbVisiteurs();
		return n;
	}
	/**
	 * entrer des visiteurs
	 */
	public void entrer() {
		Manageur.getInstance().entrer();
	}
	public void sortir() {
		Manageur.getInstance().sortir();
	}
	public static void main(String[] args) {
		Zoo z = null;
		z = new Zoo();
		System.out.println("à l'ouverture du zoo nous avons " + z.getNbVisiteurs() + " visiteurs ");
		
		z.afficher(); 
		
		System.out.println("on fait manger tous les animaux");
		//z.nourrir();
		System.out.println("on fait entrer 3 visiteurs");
		 z.entrer();
		z.entrer();
		z.entrer();
		System.out.println("nous avons maintenant "+ z.getNbVisiteurs() + " visiteurs");
		z.afficher();
		System.out.println("on tente de faire manger un animal par un autre");
		System.out.println(z.devorer(1,0));
		System.out.println(z.devorer(0,2));
		z.afficher();
		z.sortir();
		System.out.println("nouis avons maintenant"+ z.getNbVisiteurs() + " visiteurs");
		System.out.println("on ferme le zoo");
		
	}

}

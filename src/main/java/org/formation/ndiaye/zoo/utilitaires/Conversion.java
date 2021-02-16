 package org.formation.ndiaye.zoo.utilitaires;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.formation.ndiaye.zoo.modele.Animal;
import org.formation.ndiaye.zoo.modele.Cage;
import org.formation.ndiaye.zoo.modele.technique.CagePleineException;
import org.formation.ndiaye.zoo.modele.technique.PorteException;
import org.formation.ndiaye.zoo.service.AnimalPOJO;

public class Conversion {

	/**
	 * trandform un pojo en cage
	 * cage vide
	 * contient un lion
	 * contient une gazelle
	 * reification java reflect
	 * @param pojo
	 * @return
	 */
	  final static String MODEL = "org.formation.ndiaye.zoo.modele.";

	public Conversion() {}
		public static <T> Cage pojoToCage(AnimalPOJO pojo) {
			Class<?> desc = null;
			Constructor<?> lanimal = null;
			/**
			 * types pour retrouver le bon constructeur
			 * 
			 */
			Class<?> lesTypes[] = null;
			/**
			 * valeurs a donner au Constructor pour instancier l'objet voulu
			 */
			Object[] lesValeurs = null;

	 Cage ret = new Cage(pojo.getIdAnimal(),pojo.getX(),pojo.getY())		;
			if (pojo.getCodeAnimal() != null) {
				//taille des tableaux
				if (pojo.getCodeAnimal().equalsIgnoreCase("gazelle")) {
					lesTypes = new Class[4];
					lesValeurs = new Object[4];
					
				}
				else {
					lesTypes = new Class[3];
					lesValeurs = new Object[3];
				}
				lesTypes[0] =  String.class;
				lesTypes[1] = int.class;
				lesTypes[2] = double.class;
				lesValeurs[0] = pojo.getNom();  
					lesValeurs[1] = pojo.getAge();
				lesValeurs[2] = pojo.getPoids();
				//charger la class
				try {

					desc = Class.forName( String.join("", MODEL, pojo.getCodeAnimal()) );
					//la refrection permet une meilleure adaptabilite ici, utilise a la place du switch
					if (pojo.getCodeAnimal().equalsIgnoreCase("Gazelle")) {
						//constr a 4 params
						lesTypes[3] = int.class;
						lesValeurs[3] = pojo.getGaz().getLgCornes();
						
					}
					lanimal = desc.getConstructor(lesTypes);
					try {
						ret.entrer((Animal) lanimal.newInstance(lesValeurs));
					} catch (IllegalArgumentException | InvocationTargetException | PorteException
							| CagePleineException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						//construct a 4 param 
					
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				
			}
			return ret;
		}
	}
		
	



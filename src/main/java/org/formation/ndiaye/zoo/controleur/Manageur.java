package org.formation.ndiaye.zoo.controleur;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.formation.ndiaye.zoo.modele.Animal;
import org.formation.ndiaye.zoo.modele.Cage;
import org.formation.ndiaye.zoo.modele.Directeur;
import org.formation.ndiaye.zoo.modele.Gardien;
import org.formation.ndiaye.zoo.modele.Gazelle;
import org.formation.ndiaye.zoo.modele.Lion;
import org.formation.ndiaye.zoo.modele.Mangeable;
import org.formation.ndiaye.zoo.modele.Personne;
import org.formation.ndiaye.zoo.modele.Singe;
import org.formation.ndiaye.zoo.modele.Visiteur;
import org.formation.ndiaye.zoo.modele.technique.BeurkException;
import org.formation.ndiaye.zoo.modele.technique.CageManagee;
import org.formation.ndiaye.zoo.modele.technique.CagePleineException;
import org.formation.ndiaye.zoo.modele.technique.PorteException;
import org.formation.ndiaye.zoo.service.AnimalPOJO;
import org.formation.ndiaye.zoo.stockage.Dao;
import org.formation.ndiaye.zoo.stockage.DaoFactory;
import org.formation.ndiaye.zoo.utilitaires.Balai;
import org.formation.ndiaye.zoo.utilitaires.Conversion;
/**
 * Classe principale controleur pour le MVP.
 * 
 * @author jacques
 *
 */

 public class Manageur {
	private static Manageur instance= null;
	private List<CageManagee> lesCages;
	private Visiteur lesVisiteurs[];
	private List<Personne> lePersonnel;

	private Manageur() throws PorteException, CagePleineException {
		//tableau vide
		lesCages = new ArrayList<CageManagee>();
		lesVisiteurs = new Visiteur[Visiteur.MAX];
		lePersonnel = new ArrayList<>();
		remplir();
	}
	/**
	 * permet d'initialiser les cages avec les animaux dedans
	 * @throws PorteException
	 * @throws CagePleineException
	 */
	private void remplir() throws PorteException,CagePleineException{
		//TODO recup liste de pojo et la transforme en liste de cages
		//FIXME PASSER aux lamdas
		List<AnimalPOJO> tmp = null;
	    final Dao<AnimalPOJO> dao = DaoFactory.getInstance().getDao();
		lesCages = dao.lireTous().stream().map(c->(new CageManagee(dao, c))).collect(Collectors.toList());
		
		lePersonnel.add(new Directeur());
		lePersonnel.add(new Gardien());
		System.out.println("test "+Visiteur.MAX);
	}
	public static Manageur getInstance() {
		if (instance == null) {
			try {
				instance = new Manageur();
			} catch (PorteException | CagePleineException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return instance;
	}
	/**
	 * 
	 * @return une lisre de String contenant la description des cages (avec leut occupant s'il y en a un)
	 * 
	 */
	public ArrayList<String> getInfos(){
		ArrayList<String> ret = new ArrayList<>();
		/*
		for(CageManagee c : lesCages) {
			ret.add(c.toString());
		}
		*/
		lesCages.stream().forEach(c->ret.add(c.toString()));

		return ret;
	}
	/**
	 * Un animal essaye de dévorer un autre animal
	 * @param mangeur: indice (cle) de la cage du mangeur
	 * @param mange: indice (cle) de la cage du mangé
	 * @return une chaîne expliquant ce qui s'est passé
	 */
	public String devorer(int mangeur,int mange) {
	Animal laBeteConvoitee = null;
	String ret="";
	if (lesCages.get(mange).estOccupee()){
		lesCages.get(mange).ouvrir();
		try {
			laBeteConvoitee = lesCages.get(mange).sortir();
			if(laBeteConvoitee instanceof Mangeable) {
				ret = lesCages.get(mangeur).devorer((Mangeable)laBeteConvoitee);
				laBeteConvoitee = null;
				Balai.balayer();
			}else {
				ret= String.join(" ", "un(e)",laBeteConvoitee.getClass().getSimpleName(),"n'est pas mangeable");
				lesCages.get(mange).entrer((Animal)laBeteConvoitee);
				lesCages.get(mange).fermer();
			}
		} catch (PorteException e) {
			ret = e.getMessage();
		}
		catch (BeurkException e)
		{
			ret = e.getMessage();
			try {
				lesCages.get(mange).entrer((Animal)laBeteConvoitee);
			} catch (PorteException e1) {
				ret = String.join(" et ", ret,e1.getMessage());
			} catch (CagePleineException e1) {
				ret = String.join(" et ", ret,e1.getMessage());
			}
			lesCages.get(mange).fermer();
		} catch (CagePleineException e) {
			ret = e.getMessage();
		}
	}else {
		ret = String.join(" ", "la cage n°",Integer.toString(mange),"du mangé est vide!!!!");
	}
	return ret;
	}

	/**
	 * Methode qui nourrit tout les animaux du zoo
	 * 
	 */
	public void nourrir(){
		lesCages.stream().forEach(c->nourrir());
		//for(Cage c : lesCages) {
		//	c.nourrir();
		//}
	}
	public void entrer() {
		int v = Visiteur.getCpteur();
		if (v < Visiteur.MAX) {
			lesVisiteurs[v] = new Visiteur();
		}
	}
public void sortir() {
		if (Visiteur.getCpteur()>0) {
			lesVisiteurs[Visiteur.getCpteur()-1] = null;
			Balai.balayer();
		}
	}


public int getNbVisiteurs() {
	return Visiteur.getCpteur();
}

}

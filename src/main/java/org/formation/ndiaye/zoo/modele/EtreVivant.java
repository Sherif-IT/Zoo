package org.formation.ndiaye.zoo.modele;

import org.formation.ndiaye.zoo.modele.technique.BeurkException;
/**
 * @version 1.0	
 * @author j.Vincensini
 * Interface de base de tout le modèle...
 * C'est le contrat de base.
 */
public interface EtreVivant{
	public void manger();
	public String crier();
	@Deprecated
	public default String manger(Gazelle g) throws BeurkException{
		throw new BeurkException();
	}

	@Deprecated
	public default String manger(EtreVivant i) throws BeurkException{
		throw new BeurkException();
	}

	//à partir de JAVA 8
	public default String manger(Mangeable m) throws BeurkException
	{
		throw new BeurkException();
	}
	public void sauter();
	public void courir();
	public void dormir();
	public String getInfos();
	}

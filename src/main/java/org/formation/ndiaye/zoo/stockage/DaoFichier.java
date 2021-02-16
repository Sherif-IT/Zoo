package org.formation.ndiaye.zoo.stockage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.formation.ndiaye.zoo.service.AnimalPOJO;

public class DaoFichier implements Dao<AnimalPOJO>{

	private Path chemin;
	
	public DaoFichier() {
		chemin = Paths.get("zoo.data");
		
	}

	@Override
	public void inserer(AnimalPOJO obj) {
		List<AnimalPOJO> tmp = null;
		tmp = DaoFactory.getInstance().getDao().lireTous();
		tmp.add(obj);
		ecrire(tmp);
	}

	@Override
	public void modifier(int cle, AnimalPOJO obj) {
		List<AnimalPOJO> tmp = null;
		AnimalPOJO pojo = null;
		tmp = DaoFactory.getInstance().getDao().lireTous();
		pojo = tmp.stream().filter(a->a.getIdAnimal() == cle).findAny().get(); 
		tmp.set(tmp.indexOf(pojo), obj);
		ecrire(tmp);
		
	}

	@Override
	public void effacer(int cle) {
		List<AnimalPOJO> tmp = null;
		AnimalPOJO pojo = null;
		tmp = DaoFactory.getInstance().getDao().lireTous();
		pojo = lireTous().stream().filter(c->c.getIdAnimal()==cle ).findAny().get()  ; 
		tmp.remove(pojo);
		ecrire(tmp);
	}

	@Override
	public void effacer(AnimalPOJO obj) {
		List<AnimalPOJO> tmp = null;
		AnimalPOJO pojo = null;
		tmp = DaoFactory.getInstance().getDao().lireTous();
		pojo = tmp.stream().filter(a->a.getIdAnimal() == obj.getIdAnimal()).findAny().get(); 
		tmp.remove(pojo);
		ecrire(tmp);
	}

	@Override
	public AnimalPOJO lire(int cle) {
		
		return 	 lireTous().stream().filter(c->c.getIdAnimal()==cle ).findAny().get();
	}

	@Override
	public List<AnimalPOJO> lireTous() {
		List<AnimalPOJO> ret = null;
		ObjectInputStream fic = null;
		try {
			fic = new ObjectInputStream(Files.newInputStream(chemin));
			ret = (List<AnimalPOJO>) fic.readObject();
			fic.close();
		} catch (IOException e) {
			ret = iniEnDur();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		return ret;
	}

	private List<AnimalPOJO> iniEnDur() {
		Dao<AnimalPOJO > dao = null;
		dao = new DaoMemoire();
		ecrire( dao.lireTous());
		return dao.lireTous();
	}
	
	private void ecrire(List<AnimalPOJO> betes) {
		
	 try( ObjectOutputStream fic = new ObjectOutputStream(Files.newOutputStream(chemin)); ) {
		 fic.writeObject(betes);

	} catch (Exception e) {
		e.printStackTrace();
	}	
		
	}

	

}

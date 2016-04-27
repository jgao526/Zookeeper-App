package com.catalyst.zookeeper.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.zookeeper.daos.AnimalDAO;
import com.catalyst.zookeeper.entities.Animal;
import com.catalyst.zookeeper.entities.Enclosure;

/**
 * this class is used to set end point related to Species
 * @author jGao
 *
 */

@RestController
public class AnimalWebService {

	@Autowired
	private AnimalDAO animalDAO;
	
	/**
	 * sets the animal dao
	 * @param animalDAO
	 */
	public void setAnimalDAO(AnimalDAO animalDAO) {
		this.animalDAO = animalDAO;
	}
	
	/**
	 * use this to add new animal
	 * @param animal
	 */
	@RequestMapping(value="/animal", method = RequestMethod.POST)
	public void addAnimal(@RequestBody Animal animal) {
		String fiteredName = animal.getName().replaceAll("<", "&lt").replaceAll(">", "&gt");
		animal.setName(StringUtils.capitalize(fiteredName));
		animalDAO.addAnimal(animal);
		
	}
	
	/**
	 * use this to update a specific animal
	 * @param animal
	 */
	@RequestMapping(value="/animal", method = RequestMethod.PUT)
	public void updateAnimal(@RequestBody Animal animal) {
		String fiteredName = animal.getName().replaceAll("<", "&lt").replaceAll(">", "&gt");
		animal.setName(StringUtils.capitalize(fiteredName));
		
		String updatedName = animal.getEnclosure().getName();
		String oldName = getAnimalById(animal.getId()).getEnclosure().getName();
		
		if(!updatedName.equals(oldName)){
			animal.getEnclosure().setAnimalTotal(animal.getEnclosure().getAnimalTotal() + 1);
			Enclosure oldEnclosure = getAnimalById(animal.getId()).getEnclosure();
			oldEnclosure.setAnimalTotal(oldEnclosure.getAnimalTotal() - 1);
		}
		animalDAO.updateAnimal(animal);
	}
	
	/**
	 * use this to get a specific animal based on animal's id
	 * @param id
	 * @return Animal
	 */
	@RequestMapping(value="/animal/{id}", method = RequestMethod.GET)
	public Animal getAnimalById(@PathVariable Integer id) {
		return animalDAO.getAnimalById(id);
	}
	
	/**
	 * use this to get a list of all the animal
	 * @return List<Animal>
	 */
	@RequestMapping(value="/animal", method = RequestMethod.GET)
	public List<Animal> getAnimalList(){
		return animalDAO.getAnimalList();
	}
	
	/**
	 * use this to get a list of animals based on the enclosure id
	 * @param enclosureId
	 * @return List<Animal>
	 */
	@RequestMapping(value="/animal/enclosure/{enclosureId}", method = RequestMethod.GET)
	public List<Animal> getAnimalByEnclosureId(@PathVariable Integer enclosureId) {
		return animalDAO.getAnimalByEnclosureId(enclosureId);
	}
	
	/**
	 * use this to get a list of animals based on the species id
	 * @param speciesId
	 * @return List<Animal>
	 */
	@RequestMapping(value="/animal/species/{speciesId}", method = RequestMethod.GET)
	public List<Animal> getAnimalBySpeciesId(@PathVariable Integer speciesId) {
		return animalDAO.getAnimalBySpeciesId(speciesId);
	}
	
}

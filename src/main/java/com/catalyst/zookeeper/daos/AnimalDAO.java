package com.catalyst.zookeeper.daos;

import java.util.List;

import com.catalyst.zookeeper.entities.Animal;

/**
 * AnimalDAO interface class
 * @author jGao
 *
 */
public interface AnimalDAO {
	/**
	 * use this to add new food 
	 * @param animal
	 */
	void addAnimal(Animal animal);
	
	/**
	 * use this to update a specific animal
	 * @param animal
	 */
	void updateAnimal(Animal animal);
	
	/**
	 * use this to get a specific animal based on animal's id
	 * @param id
	 * @return Animal
	 */
	Animal getAnimalById(int id);
	
	/**
	 * use this to get a list of animal
	 * @return List<Animal>
	 */
	List<Animal> getAnimalList();
	
	/**
	 * use this to get a list of animals in the same enclosure
	 * @param enclosureId
	 * @return List<Animal>
	 */
	List<Animal> getAnimalByEnclosureId(int enclosureId);
	
	/**
	 * use this to get a list of animals based on the species id
	 * @param speciesId
	 * @return List<Animal>
	 * 
	 */
	List<Animal> getAnimalBySpeciesId(int speciesId);
}

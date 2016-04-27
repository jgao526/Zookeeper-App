package com.catalyst.zookeeper.daos;

import java.util.List;
import com.catalyst.zookeeper.entities.Species;

/**
 * SpeciesDAO interface class
 * @author jGao
 *
 */
public interface SpeciesDAO {
	/**
	 * use this to add new species 
	 * @param species
	 */
	void addSpecies(Species species);
	
	/**
	 * use this to update a specific species
	 * @param species
	 */
	void updateSpecies(Species species);
	
	/**
	 * use this to get a specific species based on species's id
	 * @param id
	 * @return Species
	 */
	Species getSpeciesById(int id);
	
	/**
	 * use this to get a list of species
	 * @return List<Species>
	 */
	List<Species> getSpeciesList();


}

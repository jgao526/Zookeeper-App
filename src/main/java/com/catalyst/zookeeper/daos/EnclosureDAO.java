package com.catalyst.zookeeper.daos;

import java.util.List;
import com.catalyst.zookeeper.entities.Enclosure;

/**
 * EnclosureDAO interface class
 * @author jGao
 *
 */

public interface EnclosureDAO {
	/**
	 * use this to add new food 
	 * @param enclosure
	 */
	void addEnclosure(Enclosure enclosure);
	
	/**
	 * use this to update a specific enclosure
	 * @param enclosure
	 */
	void updateEnclosure(Enclosure enclosure);
	
	/**
	 * use this to delete a specific enclosure based on enclosure id
	 * @param id
	 */
	void deleteEnclosureById(int id);
	
	/**
	 * use this to get a specific enclosure based on enclosure's id
	 * @param id
	 * @return Enclosure
	 */
	Enclosure getEnclosureById(int id);
	
	/**
	 * use this to get a list of enclosure
	 * @return List<enclosure>
	 */
	List<Enclosure> getEnclosureList();
	
	/**
	 * use this to get a list of enclosure based on favorite food
	 * @param favFood
	 * @return List<Enclosure>
	 */
	List<Enclosure> getEnclosureByFavFood(String favFood);
	
}

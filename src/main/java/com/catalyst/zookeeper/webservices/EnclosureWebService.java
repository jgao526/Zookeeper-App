package com.catalyst.zookeeper.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.zookeeper.daos.EnclosureDAO;
import com.catalyst.zookeeper.entities.Enclosure;

/**
 * this class is used to set end point related to enclosure
 * @author jGao
 *
 */

@RestController
public class EnclosureWebService {
	
	@Autowired
	private EnclosureDAO enclosureDAO;
	
	/**
	 * sets the enclosure dao
	 * @param enclosureDAO
	 */
	public void setEnclosureDAO(EnclosureDAO enclosureDAO) {
		this.enclosureDAO = enclosureDAO;
	}
	
	/**
	 * use this to add new enclosure
	 * @param enclosure
	 */
	@RequestMapping(value="/enclosure", method = RequestMethod.POST)
	public void addEnclosure(@RequestBody Enclosure enclosure) {
		String filteredName = enclosure.getName().replaceAll("<", "&lt").replaceAll(">", "&gt");
		String filteredCondition = enclosure.getCondition().replaceAll("<", "&lt").replaceAll(">", "&gt");
		
		
		enclosure.setName(StringUtils.capitalize(filteredName));
		enclosure.setCondition(StringUtils.capitalize(filteredCondition));
		
		enclosureDAO.addEnclosure(enclosure);
	}
	
	/**
	 * use this to update a specific enclosure
	 * @param enclosure
	 */
	@RequestMapping(value="/enclosure", method = RequestMethod.PUT)
	public void updateEnclosure(@RequestBody Enclosure enclosure) {
		String filteredName = enclosure.getName().replaceAll("<", "&lt").replaceAll(">", "&gt");
		String filteredCondition = enclosure.getCondition().replaceAll("<", "&lt").replaceAll(">", "&gt");
		
		enclosure.setName(StringUtils.capitalize(filteredName));
		enclosure.setCondition(StringUtils.capitalize(filteredCondition));
		
		enclosureDAO.updateEnclosure(enclosure);
	}
	
	/**
	 * use this to delete a specific enclosure based on enclosure id
	 * @param id
	 */
	@RequestMapping(value="/enclosure/{id}", method = RequestMethod.DELETE)
	public void deleteEnclosureById(@PathVariable Integer id) {
		enclosureDAO.deleteEnclosureById(id);
	}
	
	/**
	 * use this to get a specific enclosure based on enclosure's id
	 * @param id
	 * @return Enclosure
	 */
	@RequestMapping(value="/enclosure/{id}", method = RequestMethod.GET)
	public Enclosure getEnclosureById(@PathVariable Integer id) {
		return enclosureDAO.getEnclosureById(id);
	}
	
	/**
	 * use this to get a list of all the animal
	 * @return List<Animal>
	 */
	@RequestMapping(value="/enclosure", method = RequestMethod.GET)
	public List<Enclosure> getEnclosureList(){
		return enclosureDAO.getEnclosureList();
		
	}
	
	/**
	 * use this to get a list of enclosure based on favorite food name
	 * @param favFood
	 * @return List<Enclosure>
	 */
	@RequestMapping(value="/enclosure/favfood/{favFood}", method = RequestMethod.GET)
	public List<Enclosure> getEnclosureByFavFood(@PathVariable String favFood) {
		return enclosureDAO.getEnclosureByFavFood(favFood);
	}
}

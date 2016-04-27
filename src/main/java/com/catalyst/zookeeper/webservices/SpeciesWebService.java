package com.catalyst.zookeeper.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.catalyst.zookeeper.daos.SpeciesDAO;
import com.catalyst.zookeeper.entities.Species;


/**
 * this class is used to set end point related to Species
 * @author jGao
 *
 */

@RestController
public class SpeciesWebService {

	@Autowired
	private SpeciesDAO speciesDAO;
	
	/**
	 * sets the species dao
	 * @param speciesDAO
	 */
	public void setSpeciesDAO(SpeciesDAO speciesDAO) {
		this.speciesDAO = speciesDAO;
	}
	
	/**
	 * use this to add new species
	 * @param species
	 */
	@RequestMapping(value="/species", method = RequestMethod.POST)
	public void addSpecies(@RequestBody Species species) {
		String filteredCommonName = species.getCommonName().replaceAll("<", "&lt").replaceAll(">", "&gt");
		String filteredScientificName = species.getScientificName().replaceAll("<", "&lt").replaceAll(">", "&gt");
		String filteredInfoLink = species.getInfoLink().replaceAll("<", "&lt").replaceAll(">", "&gt");
		
		species.setCommonName(StringUtils.capitalize(filteredCommonName));
		species.setScientificName(StringUtils.capitalize(filteredScientificName));
		species.setInfoLink(filteredInfoLink);
		
		speciesDAO.addSpecies(species);
	}
	
	/**
	 * use this to update a specific species
	 * @param species
	 */
	@RequestMapping(value="/species", method = RequestMethod.PUT)
	public void updateSpecies(@RequestBody Species species) {
		String filteredCommonName = species.getCommonName().replaceAll("<", "&lt").replaceAll(">", "&gt");
		String filteredScientificName = species.getScientificName().replaceAll("<", "&lt").replaceAll(">", "&gt");
		String filteredInfoLink = species.getInfoLink().replaceAll("<", "&lt").replaceAll(">", "&gt");
		
		species.setCommonName(StringUtils.capitalize(filteredCommonName));
		species.setScientificName(StringUtils.capitalize(filteredScientificName));
		species.setInfoLink(filteredInfoLink);
		
		speciesDAO.updateSpecies(species);
	}
	
	/**
	 * use this to get a specific species based on species's id
	 * @param id
	 * @return Species
	 */
	@RequestMapping(value="/species/{id}", method = RequestMethod.GET)
	public Species getSpeciesById(@PathVariable Integer id) {
		return speciesDAO.getSpeciesById(id);
	}
	
	/**
	 * use this to get a list of all the species
	 * @return List<Species>
	 */
	@RequestMapping(value="/species", method = RequestMethod.GET)
	public List<Species> getSpeciesList(){
		return speciesDAO.getSpeciesList();
	}
	

}

package com.catalyst.zookeeper.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Animal entity class
 * @author jgao
 *
 */
@Entity
public class Animal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "speciesid")
	private Species species;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "enclosureid")
	private Enclosure enclosure;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the species
	 */
	public Species getSpecies() {
		return species;
	}

	/**
	 * @param species the species to set
	 */
	public void setSpecies(Species species) {
		this.species = species;
	}

	/**
	 * @return the enclosure
	 */
	public Enclosure getEnclosure() {
		return enclosure;
	}

	/**
	 * @param enclosure the enclosure to set
	 */
	public void setEnclosure(Enclosure enclosure) {
		this.enclosure = enclosure;
	}
}

package com.catalyst.zookeeper.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/**
 * Species entity class
 * @author jgao
 *
 */
@Entity
public class Species {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="commonname")
	private String commonName;

	@Column(name="scientificname")
	private String scientificName;
	
	@Column(name="infolink")
	private String infoLink;
	
	@ManyToOne
	@JoinColumn(name = "foodid")
	private Food food;

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
	 * @return the commonName
	 */
	public String getCommonName() {
		return commonName;
	}

	/**
	 * @param commonName the commonName to set
	 */
	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	/**
	 * @return the scientificName
	 */
	public String getScientificName() {
		return scientificName;
	}

	/**
	 * @param scientificName the scientificName to set
	 */
	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	/**
	 * @return the infoLink
	 */
	public String getInfoLink() {
		return infoLink;
	}

	/**
	 * @param infoLink the infoLink to set
	 */
	public void setInfoLink(String infoLink) {
		this.infoLink = infoLink;
	}

	/**
	 * @return the food
	 */
	public Food getFood() {
		return food;
	}

	/**
	 * @param food the food to set
	 */
	public void setFood(Food food) {
		this.food = food;
	}
}

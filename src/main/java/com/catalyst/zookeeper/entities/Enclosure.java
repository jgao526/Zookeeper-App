package com.catalyst.zookeeper.entities;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Enclosure entity class
 * @author jgao
 *
 */
@Entity
public class Enclosure {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;

	@Column(name="animaltotal")
	private int animalTotal;
	
	@Column(name="startfeedtime")
	private Date startFeedTime;
	
	@Column(name="endfeedtime")
	private Date endFeedTime;
	
	private String condition;
	

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
	 * @return the animalTotal
	 */
	public int getAnimalTotal() {
		return animalTotal;
	}

	/**
	 * @param animalTotal the animalTotal to set
	 */
	public void setAnimalTotal(int animalTotal) {
		this.animalTotal = animalTotal;
	}

	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * @param condition the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	/**
	 * @return the endFeedTime
	 */
	public Date getEndFeedTime() {
		Date clone = (Date) endFeedTime.clone();
		return clone;
		
	}

	/**
	 * @param endFeedTime the endFeedTime to set
	 */
	public void setEndFeedTime(Date endFeedTime) {
		Calendar cal = Calendar.getInstance();
		cal.setTime((Date) endFeedTime.clone());
		cal.set(2016, 0, 1);
		this.endFeedTime = cal.getTime();
	}

	/**
	 * @return the startFeedTime
	 */
	public Date getStartFeedTime() {
		Date clone = (Date) startFeedTime.clone();
		return clone;
	}

	/**
	 * @param startFeedTime the startFeedTime to set
	 */
	public void setStartFeedTime(Date startFeedTime) {
		Calendar cal = Calendar.getInstance();
		cal.setTime((Date) startFeedTime.clone());
		cal.set(2016, 0, 1);
		this.startFeedTime = cal.getTime();
	}
}

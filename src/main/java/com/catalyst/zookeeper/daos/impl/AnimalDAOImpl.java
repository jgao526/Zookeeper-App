package com.catalyst.zookeeper.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catalyst.zookeeper.daos.AnimalDAO;
import com.catalyst.zookeeper.entities.Animal;

/**
 * this class implements AnimalDAO interface
 * @author jGao
 *
 */
@Repository
@Transactional
public class AnimalDAOImpl implements AnimalDAO{

	@PersistenceContext
	private EntityManager em;
	
	/**
	 * sets the EntityManager for this class
	 * @param em
	 */
	public void setEm(EntityManager em){
		this.em = em;
	}
	
	@Override
	public void addAnimal(Animal animal) {
		em.merge(animal);
		
	}

	@Override
	public void updateAnimal(Animal animal) {
		em.merge(animal);
		
	}

	@Override
	public Animal getAnimalById(int id) {
		return em.createQuery("SELECT a FROM Animal a WHERE a.id = :id", Animal.class)
				.setParameter("id", id)
				.getSingleResult();
	}

	@Override
	public List<Animal> getAnimalList() {
		return em.createQuery("SELECT a FROM Animal a ORDER BY a.id DESC", Animal.class)
				.getResultList();
	}

	@Override
	public List<Animal> getAnimalByEnclosureId(int id) {
		return em.createQuery("SELECT a FROM Animal a WHERE a.enclosure.id = :id", Animal.class)
				.setParameter("id", id)
				.getResultList();
	}

	@Override
	public List<Animal> getAnimalBySpeciesId(int id) {
		return em.createQuery("SELECT a FROM Animal a WHERE a.species.id = :id", Animal.class)
				.setParameter("id", id)
				.getResultList();
	}

}

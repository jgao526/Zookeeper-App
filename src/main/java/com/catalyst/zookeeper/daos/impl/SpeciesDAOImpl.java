package com.catalyst.zookeeper.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catalyst.zookeeper.daos.SpeciesDAO;
import com.catalyst.zookeeper.entities.Species;

/**
 * this class implements SpeciesDAO interface
 * @author jGao
 *
 */

@Repository
@Transactional
public class SpeciesDAOImpl implements SpeciesDAO{

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
	public void addSpecies(Species species) {
		em.persist(species);
		
	}

	@Override
	public void updateSpecies(Species species) {
		em.merge(species);
		
	}

	@Override
	public Species getSpeciesById(int id) {
		return em.createQuery("SELECT s FROM Species s WHERE s.id = :id", Species.class)
				.setParameter("id", id)
				.getSingleResult();
	}

	@Override
	public List<Species> getSpeciesList() {
		return em.createQuery("SELECT s FROM Species s ORDER BY s.id DESC", Species.class)
				.getResultList();
	}

}

package com.catalyst.zookeeper.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catalyst.zookeeper.daos.EnclosureDAO;
import com.catalyst.zookeeper.entities.Enclosure;

/**
 * this class implements EnclosureDAO interface
 * @author jGao
 *
 */
@Repository
@Transactional
public class EnclosureDAOImpl implements EnclosureDAO{
	
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
	public void addEnclosure(Enclosure enclosure) {
		em.persist(enclosure);
		
	}

	@Override
	public void updateEnclosure(Enclosure enclosure) {
		em.merge(enclosure);
		
	}
	
	@Override
	public void deleteEnclosureById(int id) {
		Enclosure enclosure = getEnclosureById(id);
		em.remove(enclosure);
		
	}

	@Override
	public Enclosure getEnclosureById(int id) {
		return em.createQuery("SELECT e FROM Enclosure e WHERE e.id = :id", Enclosure.class)
				.setParameter("id", id)
				.getSingleResult();
	}

	@Override
	public List<Enclosure> getEnclosureList() {
		return em.createQuery("SELECT e FROM Enclosure e ORDER BY e.id DESC", Enclosure.class)
				.getResultList();
	}

	@Override
	public List<Enclosure> getEnclosureByFavFood(String name) {
		return em.createQuery("SELECT DISTINCT e FROM Animal a JOIN a.species s JOIN a.enclosure e WHERE LOWER(s.food.name) LIKE :name", Enclosure.class)
				.setParameter("name", '%' + name.toLowerCase() + '%')
				.getResultList();
	}

	

}

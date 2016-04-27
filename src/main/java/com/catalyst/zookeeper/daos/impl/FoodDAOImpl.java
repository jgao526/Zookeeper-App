package com.catalyst.zookeeper.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.catalyst.zookeeper.daos.FoodDAO;
import com.catalyst.zookeeper.entities.Food;
import com.catalyst.zookeeper.entities.FoodCategory;

/**
 * this class implements FoodDAO interface
 * @author jGao
 *
 */
@Repository
@Transactional
public class FoodDAOImpl implements FoodDAO{

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
	public void addFood(Food food) {
		em.persist(food);
		
	}

	@Override
	public void updateFood(Food food) {
		em.merge(food);
		
	}
	
	@Override
	public Food getFoodById(int id) {
		return em.createQuery("SELECT f FROM Food f where f.id = :id", Food.class)
				.setParameter("id", id)
				.getSingleResult();
	}

	@Override
	public List<Food> getFoodList() {
		return em.createQuery("SELECT f FROM Food f ORDER BY f.id DESC", Food.class)
				.getResultList();
	}

	@Override
	public List<FoodCategory> getFoodCategory() {
		return em.createQuery("SELECT c FROM FoodCategory c", FoodCategory.class)
				.getResultList();
	}



}

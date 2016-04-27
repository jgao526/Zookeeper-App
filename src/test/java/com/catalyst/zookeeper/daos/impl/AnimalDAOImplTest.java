package com.catalyst.zookeeper.daos.impl;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.catalyst.zookeeper.entities.Animal;

public class AnimalDAOImplTest {

	private AnimalDAOImpl dao = new AnimalDAOImpl();
	
	@Mock
	private EntityManager mockEm;
	
	@Mock
	private TypedQuery<Animal> mockAnimalQuery;
	
	@Mock
	private Animal animal;
	
	@Mock
	private List<Animal> animalList;
	
	@Before
	public void beforeEach() {
		MockitoAnnotations.initMocks(this);
		dao.setEm(mockEm);
	}
	
	@Test
	public void testAddAnimal() {
		
		dao.addAnimal(animal);
		
		verify(mockEm).merge(animal);
	}
	
	@Test
	public void testUpadateAnimal(){
		
		dao.updateAnimal(animal);
		
		verify(mockEm).merge(animal);
	}

	@Test
	public void testGetAnimalById() {
		
		when(mockEm.createQuery("SELECT a FROM Animal a WHERE a.id = :id", Animal.class)).thenReturn(mockAnimalQuery);
		
		when(mockAnimalQuery.setParameter("id", 1)).thenReturn(mockAnimalQuery);
		
		when(mockAnimalQuery.getSingleResult()).thenReturn(animal);
		
		assertEquals(animal, dao.getAnimalById(1));
	}
	
	@Test
	public void testGetAnimalList(){
		
		when(mockEm.createQuery("SELECT a FROM Animal a ORDER BY a.id DESC", Animal.class)).thenReturn(mockAnimalQuery);
		
		when(mockAnimalQuery.getResultList()).thenReturn(animalList);
		
		assertEquals(animalList, dao.getAnimalList());
	}
	
	@Test
	public void testGetAnimalByEnId() {
		
		when(mockEm.createQuery("SELECT a FROM Animal a WHERE a.enclosure.id = :id", Animal.class)).thenReturn(mockAnimalQuery);
		
		when(mockAnimalQuery.setParameter("id", 1)).thenReturn(mockAnimalQuery);
		
		when(mockAnimalQuery.getResultList()).thenReturn(animalList);
		
		assertEquals(animalList, dao.getAnimalByEnclosureId(1));
	}
	
	@Test
	public void testGetAnimalBySpeciesId() {
		
		when(mockEm.createQuery("SELECT a FROM Animal a WHERE a.species.id = :id", Animal.class)).thenReturn(mockAnimalQuery);
		
		when(mockAnimalQuery.setParameter("id", 1)).thenReturn(mockAnimalQuery);
		
		when(mockAnimalQuery.getResultList()).thenReturn(animalList);
		
		assertEquals(animalList, dao.getAnimalBySpeciesId(1));
	}
	
}

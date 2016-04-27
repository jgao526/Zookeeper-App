package com.catalyst.zookeeper.daos.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.catalyst.zookeeper.entities.Species;

public class SpeciesDAOImplTest {

	private SpeciesDAOImpl dao = new SpeciesDAOImpl();
	
	@Mock
	private EntityManager mockEm;
	
	@Mock
	private TypedQuery<Species> mockSpeciesQuery;
	
	@Mock
	private Species species;
	
	@Before
	public void beforeEach() {
		MockitoAnnotations.initMocks(this);
		dao.setEm(mockEm);
	}
	
	@Test
	public void testAddSpecies() {
		
		dao.addSpecies(species);
		
		verify(mockEm).persist(species);
	}
	
	@Test
	public void testUpadateSpecies(){
		
		dao.updateSpecies(species);
		
		verify(mockEm).merge(species);
	}

	@Test
	public void testGetSpeciesById() {
		
		when(mockEm.createQuery("SELECT s FROM Species s WHERE s.id = :id", Species.class)).thenReturn(mockSpeciesQuery);
		
		when(mockSpeciesQuery.setParameter("id", 1)).thenReturn(mockSpeciesQuery);
		
		when(mockSpeciesQuery.getSingleResult()).thenReturn(species);
		
		assertEquals(species, dao.getSpeciesById(1));
	}
	
	@Test
	public void testGetSpeciesList(){
		
		List<Species> speciesList = new ArrayList<Species>();
		
		when(mockEm.createQuery("SELECT s FROM Species s ORDER BY s.id DESC", Species.class)).thenReturn(mockSpeciesQuery);
		
		when(mockSpeciesQuery.getResultList()).thenReturn(speciesList);
		
		assertEquals(speciesList, dao.getSpeciesList());
	}

}

package com.catalyst.zookeeper.daos.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.catalyst.zookeeper.entities.Enclosure;

public class EnclosureDAOImplTest {

	private EnclosureDAOImpl dao = new EnclosureDAOImpl();
	
	@Mock
	private EntityManager mockEm;
	
	@Mock
	private TypedQuery<Enclosure> mockEnclosureQuery;
	
	@Mock
	private Enclosure enclosure;
	
	@Mock
	private List<Enclosure> enclosureList;
	
	@Before
	public void beforeEach() {
		MockitoAnnotations.initMocks(this);
		dao.setEm(mockEm);
	}
	
	@Test
	public void testAddEnclosure() {
		
		dao.addEnclosure(enclosure);
		
		verify(mockEm).persist(enclosure);
	}
	
	@Test
	public void testUpadateEnclosure(){
		
		dao.updateEnclosure(enclosure);
		
		verify(mockEm).merge(enclosure);
	}

	@Test
	public void testGetEnclosureById() {
		
		when(mockEm.createQuery("SELECT e FROM Enclosure e WHERE e.id = :id", Enclosure.class)).thenReturn(mockEnclosureQuery);
		
		when(mockEnclosureQuery.setParameter("id", 1)).thenReturn(mockEnclosureQuery);
		
		when(mockEnclosureQuery.getSingleResult()).thenReturn(enclosure);
		
		assertEquals(enclosure, dao.getEnclosureById(1));
	}
	
	@Test
	public void testGetEnclosureList(){
		
		when(mockEm.createQuery("SELECT e FROM Enclosure e ORDER BY e.id DESC", Enclosure.class)).thenReturn(mockEnclosureQuery);
		
		when(mockEnclosureQuery.getResultList()).thenReturn(enclosureList);
		
		assertEquals(enclosureList, dao.getEnclosureList());
	}
	
	@Test
	public void testDeleteEnclosureById(){
		
		when(mockEm.createQuery("SELECT e FROM Enclosure e WHERE e.id = :id", Enclosure.class)).thenReturn(mockEnclosureQuery);
		
		when(mockEnclosureQuery.setParameter("id", 1)).thenReturn(mockEnclosureQuery);
		
		when(mockEnclosureQuery.getSingleResult()).thenReturn(enclosure);
		
		dao.deleteEnclosureById(1);
		
		verify(mockEm).remove(enclosure);
	}

	@Test
	public void testGetEnclosureByFavFood() {
		
		when(mockEm.createQuery("SELECT DISTINCT e FROM Animal a JOIN a.species s JOIN "
				+ "a.enclosure e WHERE LOWER(s.food.name) LIKE :name", Enclosure.class)).thenReturn(mockEnclosureQuery);
		
		when(mockEnclosureQuery.setParameter("name", '%' + "name".toLowerCase() + '%')).thenReturn(mockEnclosureQuery);
		
		when(mockEnclosureQuery.getResultList()).thenReturn(enclosureList);
		
		assertEquals(enclosureList, dao.getEnclosureByFavFood("name"));
	}
	
}

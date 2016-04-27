package com.catalyst.zookeeper.webservices;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.catalyst.zookeeper.daos.EnclosureDAO;
import com.catalyst.zookeeper.entities.Enclosure;

public class EnclosureWebServiceTest {

	private EnclosureWebService service = new EnclosureWebService();
	
	@Mock
	private EnclosureDAO enclosureDAO;
	
	@Mock
	private Enclosure enclosure;
	
	@Mock
	private List<Enclosure> enclosureList;
	
	@Before
	public void beforeEach() {
		MockitoAnnotations.initMocks(this);
		service.setEnclosureDAO(enclosureDAO);
	}
	
	@Test
	public void testAddEnclosure() {
		
		when(enclosure.getName()).thenReturn("name");
		
		String fileredName = enclosure.getName().replaceAll("<", "&lt").replaceAll(">", "&gt");
		
		enclosure.setName(fileredName);
		
		when(enclosure.getCondition()).thenReturn("condition");
		
		String filteredCondition = enclosure.getCondition().replaceAll("<", "&lt").replaceAll(">", "&gt");
		
		enclosure.setCondition(filteredCondition);
		
		service.addEnclosure(enclosure);
		
		verify(enclosureDAO).addEnclosure(enclosure);
	}
	
	@Test
	public void testUpdateEnclosure() {
		
		when(enclosure.getName()).thenReturn("name");
		
		String fileredName = enclosure.getName().replaceAll("<", "&lt").replaceAll(">", "&gt");
		
		enclosure.setName(fileredName);
		
		when(enclosure.getCondition()).thenReturn("condition");
		
		String filteredCondition = enclosure.getCondition().replaceAll("<", "&lt").replaceAll(">", "&gt");
		
		enclosure.setCondition(filteredCondition);
		
		service.updateEnclosure(enclosure);
		
		verify(enclosureDAO).updateEnclosure(enclosure);
	}
	
	@Test
	public void testGetEnclosureById() {
		
		Enclosure expected = service.getEnclosureById(1);
		
		Enclosure actual = service.getEnclosureById(1);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testGetEnclosureList() {
		
		
		when(service.getEnclosureList()).thenReturn(enclosureList);
		
		assertEquals(enclosureList, enclosureDAO.getEnclosureList());
	}
	
	@Test
	public void testDeleteEnclosureById() {
		
		service.deleteEnclosureById(1);
		
		verify(enclosureDAO).deleteEnclosureById(1);
	}
	
	@Test
	public void testGetEnclosureByFavFood() {
		
		when(service.getEnclosureByFavFood("name")).thenReturn(enclosureList);
		
		assertEquals(enclosureList, enclosureDAO.getEnclosureByFavFood("name"));
	}

}

package com.catalyst.zookeeper.webservices;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.catalyst.zookeeper.daos.SpeciesDAO;
import com.catalyst.zookeeper.entities.Species;

public class SpeciesWebServiceTest {

	private SpeciesWebService service = new SpeciesWebService();
	
	@Mock
	private SpeciesDAO speciesDAO;
	
	@Mock
	private Species species;
	
	@Mock
	private List<Species> speciesList;
	
	@Before
	public void beforeEach() {
		MockitoAnnotations.initMocks(this);
		service.setSpeciesDAO(speciesDAO);
	}
	
	@Test
	public void testAddSpecies() {
		
		when(species.getCommonName()).thenReturn("tiger");
		
		String filteredCommonName = species.getCommonName().replaceAll("<", "&lt").replaceAll(">", "&gt");
		
		species.setCommonName(filteredCommonName);
		
		when(species.getScientificName()).thenReturn("anotherName");
		
		String filteredSN = species.getScientificName().replaceAll("<", "&lt").replaceAll(">", "&gt");
		
		species.setScientificName(filteredSN);
		
		when(species.getInfoLink()).thenReturn("link");
		
		String filteredLink = species.getInfoLink().replaceAll("<", "&lt").replaceAll(">", "&gt");
		
		species.setInfoLink(filteredLink);
		
		service.addSpecies(species);
		
		verify(speciesDAO).addSpecies(species);
	}
	
	@Test
	public void testUpdateSpecies() {
		
		when(species.getCommonName()).thenReturn("tiger");
		
		String filteredCommonName = species.getCommonName().replaceAll("<", "&lt").replaceAll(">", "&gt");
		
		species.setCommonName(filteredCommonName);
		
		when(species.getScientificName()).thenReturn("anotherName");
		
		String filteredSN = species.getScientificName().replaceAll("<", "&lt").replaceAll(">", "&gt");
		
		species.setScientificName(filteredSN);
		
		when(species.getInfoLink()).thenReturn("link");
		
		String filteredLink = species.getInfoLink().replaceAll("<", "&lt").replaceAll(">", "&gt");
		
		species.setInfoLink(filteredLink);
		
		service.updateSpecies(species);
		
		verify(speciesDAO).updateSpecies(species);
	}
	
	@Test
	public void testGetSpeciesById() {
		
		Species expected = service.getSpeciesById(1);
		
		Species actual = service.getSpeciesById(1);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testGetSpeciesList() {
		
		when(service.getSpeciesList()).thenReturn(speciesList);
		
		assertEquals(speciesList, speciesDAO.getSpeciesList());
	}



}

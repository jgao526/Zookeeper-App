package com.catalyst.zookeeper.webservices;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.catalyst.zookeeper.daos.AnimalDAO;
import com.catalyst.zookeeper.entities.Animal;
import com.catalyst.zookeeper.entities.Enclosure;

public class AnimalWebServiceTest {

	private AnimalWebService service = new AnimalWebService();
	
	@Mock
	private AnimalDAO mockDAO;
	
	@Mock
	private List<Animal> animalList;
	
	@Mock
	private Animal animal;
	
	@Mock
	private Animal oldAnimal;
	
	@Mock
	private Enclosure enclosure;

	@Mock
	private Enclosure oldEnclosure;
	
	@Before
	public void beforeEach() {
		MockitoAnnotations.initMocks(this);
		service.setAnimalDAO(mockDAO);
	}
	
	@Test
	public void testAddAnimal() {
		
		when(animal.getName()).thenReturn("name");
		
		String fileredName = animal.getName().replaceAll("<", "&lt").replaceAll(">", "&gt");
		
		animal.setName(fileredName);
		
		service.addAnimal(animal);
		
		verify(mockDAO).addAnimal(animal);
	}
	
	@Test
	public void testUpdateAnimalEnclosureNotEqual() {
		animal.setId(1);
		
		enclosure.setAnimalTotal(2);
		
		when(animal.getName()).thenReturn("name");
		
		String fileredName = animal.getName().replaceAll("<", "&lt").replaceAll(">", "&gt");
		
		animal.setName(fileredName);
		
		when(animal.getEnclosure()).thenReturn(enclosure);
		
		when(enclosure.getName()).thenReturn("newName");
		
		when(service.getAnimalById(animal.getId())).thenReturn(oldAnimal);
		
		when(oldAnimal.getEnclosure()).thenReturn(oldEnclosure);
		
		when(oldEnclosure.getName()).thenReturn("oldName");

		service.updateAnimal(animal);

		verify(mockDAO).updateAnimal(animal);

	}
	
	@Test
	public void testUpdateAnimalEnclosureEqual() {
		animal.setId(1);
		
		enclosure.setAnimalTotal(2);
		
		when(animal.getName()).thenReturn("name");
		
		String fileredName = animal.getName().replaceAll("<", "&lt").replaceAll(">", "&gt");
		
		animal.setName(fileredName);
		
		when(animal.getEnclosure()).thenReturn(enclosure);
		
		when(enclosure.getName()).thenReturn("newName");
		
		when(service.getAnimalById(animal.getId())).thenReturn(oldAnimal);
		
		when(oldAnimal.getEnclosure()).thenReturn(oldEnclosure);
		
		when(oldEnclosure.getName()).thenReturn("newName");

		service.updateAnimal(animal);

		verify(mockDAO).updateAnimal(animal);

	}
	
	@Test
	public void testGetAnimalById() {
		
		Animal expected = service.getAnimalById(1);
		
		Animal actual = service.getAnimalById(1);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testGetAnimalList() {
		
		when(service.getAnimalList()).thenReturn(animalList);
		
		assertEquals(animalList, mockDAO.getAnimalList());
	}
	
	@Test
	public void testGetAnimalByEnId() {
		
		when(service.getAnimalByEnclosureId(1)).thenReturn(animalList);
		
		assertEquals(animalList, mockDAO.getAnimalByEnclosureId(1));
	}
	
	@Test
	public void testGetAnimalBySpeciesId() {
		
		when(service.getAnimalBySpeciesId(1)).thenReturn(animalList);
		
		assertEquals(animalList, mockDAO.getAnimalBySpeciesId(1));
	}
}

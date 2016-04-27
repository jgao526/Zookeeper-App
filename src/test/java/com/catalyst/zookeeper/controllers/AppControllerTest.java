package com.catalyst.zookeeper.controllers;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppControllerTest {
	AppController controller = new AppController();
	
	@Test
	public void indexHappyTest() {
		
		String expectedPath = "/index.html";
		
		assertEquals(expectedPath, controller.index());
	}

}
